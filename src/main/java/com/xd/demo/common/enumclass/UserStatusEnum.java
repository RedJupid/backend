package com.xd.demo.common.enumclass;

public enum UserStatusEnum {

    USABLE(1, "可用"),
    UNUSABLE(0, "已禁用");

    private int code;
    private String name;

    UserStatusEnum(int code, String name) {
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
