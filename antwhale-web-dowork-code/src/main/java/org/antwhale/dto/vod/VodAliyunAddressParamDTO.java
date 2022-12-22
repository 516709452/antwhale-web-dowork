package org.antwhale.dto.vod;

import lombok.Data;

/**
 * @Author: 何欢
 * @Date: 2022/12/2017:11
 * @Description: https://help.aliyun.com/document_detail/436555.html
 */
@Data
public class VodAliyunAddressParamDTO {
    //音/视频ID
    private String videoId;

    //媒体流格式。多个格式之间使用半角逗号（,）分隔。支持格式:具体参考官网
    private String formats;

    //播放地址过期时间。单位：秒。
    private Long authTimeout;

    //输出地址类型:oss：回源地址。cdn（默认）：加速地址。
    private String outputType;

    //媒体流类型。多个用半角逗号（,）分隔。支持类型：video：视频。audio：音频。
    //默认获取所有类型的流。
    private String streamType;

    //CDN二次鉴权参数。为JSON字符串。当开启了CDN二次鉴权功能时，可通过该参数设置鉴权URL的uid和rand
    private String reAuthInfo;

    //视频流清晰度。多个用半角逗号（,）分隔
    private String definition;

    //返回数据类型。取值
    private String resultType;

    //播放自定义设置。为JSON字符串，支持指定域名播放设置
    private String playConfig;

    //获取弹幕蒙版数据URL地址，取值：danmu 只有当outputType取值为cdn时才会生效
    private String additionType;
}
