package com.xd.demo.modules.sys.service.impl;

import com.xd.demo.modules.sys.entity.User;
import com.xd.demo.modules.sys.mapper.UserMapper;
import com.xd.demo.modules.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* <p>
    * 用户表 服务实现类
    * </p>
*
* @author xd
* @since 2019-12-19
*/
@Service
    public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    }
