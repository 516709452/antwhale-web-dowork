package utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.teaopenapi.models.Config;
import org.antwhale.code.AliyunOssAccountEnum;
import org.antwhale.code.AliyunVodAccountEnum;

/**
 * @Author: 何欢
 * @Date: 2022/9/2819:12
 * @Description:
 */
public class AliyunUtils {

    /**
     * @author 何欢
     * @Date 11:57 2022/12/11
     * @Description 获取OSSClient实例
     **/
    public static OSS getOssClient() {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = AliyunOssAccountEnum.getEndpoint.getValue();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = AliyunOssAccountEnum.getAccessKeyID.getValue();
        String accessKeySecret = AliyunOssAccountEnum.getAccessKeySecret.getValue();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    /**
     * @author 何欢
     * @Date 22:04 2022/12/17
     * @Description 获取VodClient实例
     **/
    public static com.aliyun.vod20170321.Client getAcsClient() throws Exception {
        String regionId = AliyunVodAccountEnum.getRegionId.getValue();  // 点播服务接入地域
        String accessKeyId = AliyunVodAccountEnum.getAccessKeyID.getValue();
        String accessKeySecret = AliyunVodAccountEnum.getAccessKeySecret.getValue();
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "vod.cn-beijing.aliyuncs.com";
        return new com.aliyun.vod20170321.Client(config);
    }
}
