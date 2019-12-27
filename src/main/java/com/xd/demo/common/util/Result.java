package com.xd.demo.common.util;


public class Result {

    private Integer code;

    private String msg;

    private Object data;

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(200, "success", data);
    }

    public static Result success(String msg){
        return new Result(200, msg, null);
    }

    public static Result success(String msg, Object data){
        return new Result(200, msg, data);
    }

    public static Result error(String msg){
        return new Result(400, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
