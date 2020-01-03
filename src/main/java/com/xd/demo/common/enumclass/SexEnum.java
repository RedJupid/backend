package com.xd.demo.common.enumclass;

public enum SexEnum {
    GIRL(0, "男"),
    BOY(1,"女"),
    SECRET(2,"保密");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
