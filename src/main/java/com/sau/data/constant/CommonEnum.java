package com.sau.data.constant;

import lombok.AllArgsConstructor;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 14:00 2020/12/12
 * @Modified By:
 */
@AllArgsConstructor
public enum CommonEnum implements BaseInfoInterface{

    SUCCESS("200", "成功"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!")
    ;

    /** 状态码 */
    private String resultCode;

    /** 状态描述 */
    private String resultMsg;

    @Override
    public String getCode() {
        return resultCode;
    }

    @Override
    public String getMessage() {
        return resultMsg;
    }
}
