package org.antwhale.controller.aliyun;

import com.antwhale.framework.code.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.antwhale.bpo.aliyun.OssBPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: 何欢
 * @Date: 2022/12/115:05
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/oss")
public class OssController {
    @Autowired
    private OssBPO ossBPO;

    /**
     *@author 何欢
     *@Date 5:01 2022/12/11
     *@Description 视频课程图片上传
     **/
    @PostMapping("/upLoadOssCourse")
    public ResultVo upLoadOssCourse(MultipartFile file) {
        Map<String, String> resultMap = ossBPO.upLoadOssCourse(file);
        return ResultVo.ok(resultMap);
    }

    /**
    *@author 何欢
    *@Date 10:07 2022/12/11
    *@Description 用户头像上传
    **/
    @PostMapping("/upLoadOssUserAvatar")
    public ResultVo upLoadOssUserAvatar(MultipartFile file) {
        Map<String, String> resultMap = ossBPO.upLoadOssUserAvatar(file);
        return ResultVo.ok(resultMap);
    }
}
