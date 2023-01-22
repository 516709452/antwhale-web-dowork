package org.antwhale.bpo.aliyun.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.antwhale.bpo.aliyun.OssBPO;
import org.antwhale.code.AliyunOssAccountEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utils.AliyunUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: 何欢
 * @Date: 2022/12/115:07
 * @Description:
 */
@Service
public class OssBPOImpl implements OssBPO {
    String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    @Override
    public Map<String, String> upLoadOssCourse(MultipartFile file) {
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String dir = "course/" + format + "/";

        return getRespMap(dir);
    }

    @Override
    public Map<String, String> upLoadOssUserAvatar(MultipartFile file) {
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String dir = "avatar/user/" + format + "/";

        return getRespMap(dir);
    }

    @Override
    public Map<String, String> upLoadOssTeacherAvatar(MultipartFile file) {
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String dir = "avatar/teacher/" + format + "/";

        return getRespMap(dir);
    }

    /**
     * @author 何欢
     * @Date 10:09 2022/12/11
     * @Description 访问阿里云Oss获取签名
     **/
    private Map<String, String> getRespMap(String dir) {
        OSS ossClient = AliyunUtils.getOssClient();
        Map<String, String> respMap = new LinkedHashMap<>();
        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData;
        try {
            binaryData = postPolicy.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("向Oss服务器发送数据失败");
        }
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);


        respMap.put("accessid", AliyunOssAccountEnum.getAccessKeyID.getValue());
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", AliyunOssAccountEnum.getHost.getValue());
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        return respMap;
    }
}
