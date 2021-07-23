package com.prince.mall.util;
/**
 * Project mall <br\>
 * Package com.prince.mall.util <br\>
 * <p>
 * Description : 用户请求的响应状态码枚举对象 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 1:56
 */
public enum RespCode {

    SUCCESS(200, "SUCCESS"),

    ERROR(500, "FAILED"),

    SYSTEM_ERROR(501, "SYSTEM_ERROR");

    private Integer code;

    private String message;

    RespCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    RespCode() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
