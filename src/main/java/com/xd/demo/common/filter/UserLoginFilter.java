package com.xd.demo.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.xd.demo.common.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;

public class UserLoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = SecurityUtils.getSubject();

        if(null != subject){
            if(subject.isRemembered()){
                return true;
            }
            if(subject.isAuthenticated()){
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Result res = Result.error("请先登录");
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.write(JSONObject.toJSONString(res));
        return false;
    }
}
