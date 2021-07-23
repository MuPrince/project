package com.prince.mall.util;

import java.io.Serializable;

/**
 * Project mall <br\>
 * Package com.prince.mall.util <br\>
 * <p>
 * Description : 用于封装响应用户请求信息的对象 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 1:56
 */
public class RespResult<T> implements Serializable {

    /**
     * 响应数据的结果集
     */
    private T data;

    /**
     * 响应的状态码
     */
    private Integer code;

    /**
     * 响应的消息
     */
    private String message;

    public RespResult() {
    }

    public RespResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespResult(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public RespResult(RespCode respCode) {
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    public RespResult(T data, RespCode respCode) {
        this.data = data;
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
    }

    public static RespResult ok() {
        return new RespResult(RespCode.SUCCESS);
    }

    public static RespResult ok(Object data) {
        return new RespResult(data, RespCode.SUCCESS);
    }

    public static RespResult error() {
        return new RespResult(RespCode.ERROR);
    }

    public static RespResult error(RespCode respCode) {
        return new RespResult(respCode);
    }

    public static RespResult error(String message) {
        return new RespResult(RespCode.ERROR.getCode(), message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
