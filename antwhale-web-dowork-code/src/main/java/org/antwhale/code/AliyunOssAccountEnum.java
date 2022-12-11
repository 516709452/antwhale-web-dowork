package org.antwhale.code;

/**
 * @Author: 何欢
 * @Date: 2022/12/1111:54
 * @Description:
 */
public enum AliyunOssAccountEnum {
    getAccessKeyID("LTAI5t9cNpGrok6uFUdrT1GQ"),
    getAccessKeySecret("YQDNRujUqZCfC4gREtldYXmu7ENrZp"),
    getEndpoint("oss-cn-beijing.aliyuncs.com"),
    getHost("https://antwhalebucket.oss-cn-beijing.aliyuncs.com"),
    getCallbackUrl("https://192.168.0.0:8030");

    private String value;

    AliyunOssAccountEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
