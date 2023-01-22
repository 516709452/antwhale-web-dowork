package org.antwhale.bpo.aliyun;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: 何欢
 * @Date: 2022/12/115:07
 * @Description:
 */
public interface OssBPO {
    /**
     *@author 何欢
     *@Date 5:01 2022/12/11
     *@Description 图片上传
     **/
    Map<String, String> upLoadOssCourse(MultipartFile file);

    /**
     *@author 何欢
     *@Date 5:01 2022/12/11
     *@Description 图片上传
     **/
    Map<String, String> upLoadOssUserAvatar(MultipartFile file);

    /**
     *@author 何欢
     *@Date 5:01 2022/12/11
     *@Description 图片上传
     **/
    Map<String, String> upLoadOssTeacherAvatar(MultipartFile file);
}
