package com.xd.demo.modules.sys.mapper;

import com.xd.demo.modules.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* <p>
    * 角色菜单关联表 Mapper 接口
    * </p>
*
* @author xd
* @since 2020-01-09
*/
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    List<RoleMenu> selectByRoleId(Integer roleId);
}
