package com.xd.demo.modules.sys.controller;


import com.xd.demo.common.controller.BaseController;
import com.xd.demo.modules.sys.entity.User;
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
public class UserController extends BaseController<User> {

}
