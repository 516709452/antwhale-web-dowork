package org.antwhale.code;

/**
 * @Author: 何欢
 * @Date: 2022/12/1718:29
 * @Description:
 */
public enum AliyunVodAccountEnum {
    getAccessKeyID("LTAI5tQB6vbp5tJGt6RoX9Gq"),
    getAccessKeySecret("WUSoKjNFOlIbwaqYW0xokMSoG8owi2"),
    getRegionId("oss-cn-shanghai");

    private String value;

    AliyunVodAccountEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
