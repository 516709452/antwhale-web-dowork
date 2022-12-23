package org.antwhale.dto.vod;

import lombok.Data;

/**
 * @Author: 何欢
 * @Date: 2022/12/2319:11
 * @Description: 得到阿里云视频播放凭证入参
 */
@Data
public class VodAliyunPalyAuthParamDTO {
    //视频Id
    private String vodId;
}
