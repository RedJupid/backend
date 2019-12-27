package com.xd.demo.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    private List<String> anon;

    private List<String> authc;

    public List<String> getAuthc() {
        return authc;
    }

    public void setAuthc(List<String> authc) {
        this.authc = authc;
    }

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
