package com.xd.demo.modules.sys.controller;


import com.xd.demo.common.controller.BaseController;
import com.xd.demo.common.util.Result;
import com.xd.demo.modules.sys.entity.User;
import com.xd.demo.modules.sys.service.IUserService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xd
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/sys/user")
@Api(value = "用户控制器",tags={"用户操作接口"})
public class UserController extends BaseController<User> {

    @Autowired
    IUserService userService;

    @GetMapping("/test")
    @RequiresRoles(value = {"admin"})
    public Result test(){
        return Result.success("test");
    }

    @GetMapping("/getByUsername")
    public Result getByUsername(String username){
        User user = userService.selectByUsername(username);
        return Result.success(user);
    }

}
