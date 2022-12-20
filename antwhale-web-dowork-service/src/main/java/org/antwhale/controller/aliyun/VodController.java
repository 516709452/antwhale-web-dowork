package org.antwhale.controller.aliyun;

import com.aliyun.vod20170321.models.GetVideoListResponse;
import com.aliyun.vod20170321.models.SearchMediaResponse;
import com.antwhale.framework.code.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.antwhale.bpo.aliyun.VodBPO;
import org.antwhale.dto.VodResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: 何欢
 * @Date: 2022/11/230:38
 * @Description: 阿里云Vod控制器
 */
@Slf4j
@RestController
@RequestMapping("/vod")
public class VodController {
    @Autowired
    private VodBPO vodBPO;

    /**
     * @author 何欢
     * @Date 16:35 2022/12/17
     * @Description 查询阿里云视频请求
     **/
    @PostMapping("/queryVodAliyun")
    public ResultVo queryVodAliyun() throws Exception {
        SearchMediaResponse searchMediaResponse = vodBPO.queryVodAliyun();
        return ResultVo.ok(searchMediaResponse);
    }

    /**
     * @author 何欢
     * @Date 22:02 2022/12/19
     * @Description 查看阿里云视频源文件信息
     **/
    @PostMapping("/queryVodAliyunOriginal")
    public ResultVo queryVodAliyunOriginal(@RequestBody Map<String,Object> paramMap) throws Exception {
        GetVideoListResponse getVideoListResponse = vodBPO.queryVodAliyunOriginal(paramMap);
        return ResultVo.ok(getVideoListResponse);
    }
}
