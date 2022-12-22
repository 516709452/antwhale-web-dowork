package org.antwhale.bpo.aliyun;

import com.aliyun.vod20170321.models.GetPlayInfoResponse;
import com.aliyun.vod20170321.models.GetVideoListResponse;
import com.aliyun.vod20170321.models.SearchMediaResponse;
import org.antwhale.dto.vod.VodAliyunAddressParamDTO;

import java.util.Map;

/**
 * @Author: 何欢
 * @Date: 2022/12/1716:36
 * @Description:
 */
public interface VodBPO {
    /**
     *@author 何欢
     *@Date 16:35 2022/12/17
     *@Description 阿里云视频上传前置请求
     **/
    SearchMediaResponse queryVodAliyun(String videoSourceId) throws Exception;

    /**
     *@author 何欢
     *@Date 22:02 2022/12/19
     *@Description 查看阿里云视频源文件信息
     **/
    GetVideoListResponse queryVodAliyunOriginal(Map<String,Object> paramMap) throws Exception;

    /**
    *@author 何欢
    *@Date 17:05 2022/12/20
    *@Description 得到阿里云播放地址
    **/
    GetPlayInfoResponse queryVodAliyunAddress(VodAliyunAddressParamDTO vodAliyunAddressParamDTO) throws Exception;
}
