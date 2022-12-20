package org.antwhale.dto;

import lombok.Data;
import com.aliyun.vod20170321.models.*;

/**
 * @Author: 何欢
 * @Date: 2022/12/1922:45
 * @Description:
 */
@Data
public class VodResultDTO {
    private SearchMediaResponse searchMediaResponse;
    private GetVideoListResponse getVideoListResponse;
}
