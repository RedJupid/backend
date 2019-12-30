package com.xd.demo.modules.sys.mapper;

import com.xd.demo.modules.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* <p>
    * 用户表 Mapper 接口
    * </p>
*
* @author xd
* @since 2019-12-19
*/
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
