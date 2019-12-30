package com.xd.demo.config;

import com.xd.demo.modules.sys.entity.User;
import com.xd.demo.modules.sys.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行授权逻辑");
        Set<String> roles = new HashSet<>();
        roles.add("adminnn");
        AuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.selectByUsername(username);
        if (user == null){
            throw new UnknownAccountException("用户不存在");
        }
        if (user.getStatus()==0){
            throw new LockedAccountException("用户被锁定");
        }
        //1). principal:认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象
        Object principal = user.getUsername();
        //2). credentials:密码
        Object credentials = user.getPassword();
        //3). realmName: 当前realm对象的name. 调用父类的getName()方法即可
        String realmName = getName();
        //4). 盐值。
//        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, salt, realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
        return info;
    }

}
