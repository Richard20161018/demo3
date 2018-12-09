package com.example.demo3.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @auther: wangchengdong
 * @date: 2018/12/7 18:21
 * @description:
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private T data;
    public static final String CODE_SUCCESS = "0000";
    public static final String CODE_FAILURE = "9999";

    public Response() {
        this("9999", "");
    }

    public Response(String code, String msg) {
        this(code, msg, null);
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
