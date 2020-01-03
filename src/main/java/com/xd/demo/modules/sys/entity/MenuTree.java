package com.xd.demo.modules.sys.entity;

import lombok.Data;

import java.util.List;


@Data
public class MenuTree extends Menu{

    private String title;

    private String key;

    private List<MenuTree> children;

    public String getTitle() {
        return super.getName();
    }

    public String getKey() {
        return super.getName();
    }
}
