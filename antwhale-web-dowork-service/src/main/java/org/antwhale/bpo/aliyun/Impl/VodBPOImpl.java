package org.antwhale.bpo.aliyun.Impl;

import com.aliyun.vod20170321.Client;
import com.aliyun.vod20170321.models.*;
import com.antwhale.framework.utils.CommonUtils;
import org.antwhale.bpo.aliyun.VodBPO;
import org.antwhale.dto.VodResultDTO;
import org.springframework.stereotype.Service;
import utils.AliyunUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: 何欢
 * @Date: 2022/12/1716:36
 * @Description:
 */
@Service
public class VodBPOImpl implements VodBPO {
    /**
     * @author 何欢
     * @Date 16:35 2022/12/17
     * @Description 阿里云视频上传前置请求
     **/
    @Override
    public SearchMediaResponse queryVodAliyun() throws Exception {
        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        Client client = AliyunUtils.getAcsClient();
        SearchMediaRequest searchMediaRequest = getsearchMediaRequest();
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        // 复制代码运行请自行打印 API 的返回值
        SearchMediaResponse searchMediaResponse = client.searchMediaWithOptions(searchMediaRequest, runtime);
        return searchMediaResponse;
    }

    /**
     * @author 何欢
     * @Date 22:02 2022/12/19
     * @Description 查看阿里云视频源文件信息
     **/
    @Override
    public GetVideoListResponse queryVodAliyunOriginal(Map<String, Object> paramMap) throws Exception {
        Client client = AliyunUtils.getAcsClient();
        GetVideoListRequest getVideoListRequest = new GetVideoListRequest();
        getVideoListRequest.setCateId(CommonUtils.getLongValue(paramMap.get("cateId")));
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        // 复制代码运行请自行打印 API 的返回值
        GetVideoListResponse videoListWithOptions = client.getVideoListWithOptions(getVideoListRequest, runtime);
        return videoListWithOptions;
    }

    /**
     * @author 何欢
     * @Date 18:34 2022/12/19
     * @Description 获取阿里云媒体查询入参
     **/
    private SearchMediaRequest getsearchMediaRequest() {
        String Fileds = "Title,Description,CateName,CoverURL,URL,StorageLocation";
        SearchMediaRequest searchMediaRequest = new SearchMediaRequest();
        searchMediaRequest.setSearchType("video");
        searchMediaRequest.setFields(Fileds);
        return searchMediaRequest;
    }
}
