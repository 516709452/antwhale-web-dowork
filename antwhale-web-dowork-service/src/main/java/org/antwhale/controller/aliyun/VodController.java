package org.antwhale.controller.aliyun;

import com.aliyun.vod20170321.models.GetPlayInfoResponse;
import com.aliyun.vod20170321.models.GetVideoListResponse;
import com.aliyun.vod20170321.models.GetVideoPlayAuthResponse;
import com.aliyun.vod20170321.models.SearchMediaResponse;
import com.antwhale.framework.code.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.antwhale.bpo.aliyun.VodBPO;
import org.antwhale.dto.vod.VodAliyunAddressParamDTO;
import org.antwhale.dto.vod.VodAliyunPalyAuthParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/queryVodAliyun")
    public ResultVo queryVodAliyun(@RequestParam("videoSourceId") String videoSourceId) throws Exception {
        SearchMediaResponse searchMediaResponse = vodBPO.queryVodAliyun(videoSourceId);
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

    /**
    *@author 何欢
    *@Date 17:05 2022/12/20
    *@Description 得到阿里云播放地址
    **/
    @PostMapping("/queryVodAliyunAddress")
    public ResultVo queryVodAliyunAddress(@RequestBody VodAliyunAddressParamDTO vodAliyunAddressParamDTO) throws Exception {
        GetPlayInfoResponse getVideoListResponse = vodBPO.queryVodAliyunAddress(vodAliyunAddressParamDTO);
        return ResultVo.ok(getVideoListResponse);
    }

    /**
    *@author 何欢
    *@Date 19:09 2022/12/23
    *@Description 得到阿里云视频播放凭证
    **/
    @PostMapping("/queryVodAliyunPalyAuth")
    public ResultVo queryVodAliyunPalyAuth(@RequestBody VodAliyunPalyAuthParamDTO vodAliyunAddressParamDTO) throws Exception {
        GetVideoPlayAuthResponse getVideoPlayAuthResponse = vodBPO.queryVodAliyunPalyAuth(vodAliyunAddressParamDTO);
        return ResultVo.ok(getVideoPlayAuthResponse);
    }
}
