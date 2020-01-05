package com.xd.demo.common.enumclass;

public enum MenuEnum {

    MENU(0,"菜单"),
    BUTTON(1,"按钮");

    private Integer code;

    private String name;

    MenuEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
