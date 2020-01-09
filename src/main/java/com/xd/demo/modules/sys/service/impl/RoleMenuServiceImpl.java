package com.xd.demo.modules.sys.service.impl;

import com.xd.demo.modules.sys.entity.RoleMenu;
import com.xd.demo.modules.sys.mapper.RoleMenuMapper;
import com.xd.demo.modules.sys.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
    * 角色菜单关联表 服务实现类
    * </p>
*
* @author xd
* @since 2020-01-09
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Override
    public List<RoleMenu> selectByRoleId(Integer roleId) {
        return baseMapper.selectByRoleId(roleId);
    }
}
