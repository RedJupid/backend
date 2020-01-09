package com.xd.demo.modules.sys.service;

import com.xd.demo.modules.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* <p>
    * 角色菜单关联表 服务类
    * </p>
*
* @author xd
* @since 2020-01-09
*/
public interface IRoleMenuService extends IService<RoleMenu> {
    List<RoleMenu> selectByRoleId(Integer roleId);
}
