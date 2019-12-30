package com.xd.demo.modules.sys.controller;

import com.xd.demo.common.util.Result;
import com.xd.demo.modules.sys.entity.User;
import com.xd.demo.modules.sys.service.IUserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"用户登录登出接口"})
public class LoginController {
    
    @Autowired
    IUserService userService;
    
    @PostMapping("/login")
    public Result login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return Result.success("登录成功");
        }catch (UnknownAccountException e){
            return Result.error("用户名不存在");
        }catch (IncorrectCredentialsException e){
            return Result.error("密码错误");
        }
    }

    @GetMapping("/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.success("登出成功");
    }

    @PostMapping("/register")
    public Result register(String username, String password){
        User user = new User();
        user.setUsername(username);
        String hashAlgorithmName = "MD5";
        Object credentials = password;
//        Object salt = ByteSource.Util.bytes("test");
        Object salt = null;
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        user.setPassword(result.toString());
        boolean flag = userService.save(user);
        if (flag){
            return Result.success("注册成功");
        }else{
            return Result.error("注册失败");
        }
    }

}
