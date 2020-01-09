package com.xd.demo.modules.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.demo.common.util.Result;
import com.xd.demo.modules.sys.entity.Menu;
import com.xd.demo.modules.sys.entity.Role;
import com.xd.demo.modules.sys.entity.RoleMenu;
import com.xd.demo.modules.sys.service.IMenuService;
import com.xd.demo.modules.sys.service.IRoleMenuService;
import com.xd.demo.modules.sys.service.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author xd
 * @since 2020-01-09
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    @Autowired
    IMenuService menuService;

    @Autowired
    IRoleMenuService roleMenuService;

    @GetMapping("/getByPage")
    public Result getByPage(Integer current, Integer size, String name){
        QueryWrapper<Role> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)){
            qw.like("name","%"+name+"%");
        }
        Page<Role> roles = new Page<>();
        roles.setCurrent(current);
        roles.setSize(size);
        IPage<Role> page = roleService.page(roles, qw);
        return Result.success(page);
    }

    @PutMapping("/updateRoleMenu")
    public Result updateRoleMenu(@RequestParam Integer roleId, @RequestParam List<Integer> ids){
        List<Menu> allMenu = menuService.list();
        Set<Integer> setIds = new HashSet<>();
        for (Integer id:ids){
            setIds.add(id);
        }
        for (Integer id: ids){
            List<Integer> parentIds = new ArrayList<>();
            getParentIds(id, allMenu, parentIds);
            for (Integer iid: parentIds){
                setIds.add(iid);
            }
        }
        List<RoleMenu> rms = roleMenuService.selectByRoleId(roleId);
        List<RoleMenu> roleMenusAdd = new ArrayList<>();
        List<Integer> roleMenusMove = new ArrayList<>();
        for (Integer id : setIds){
            if (isMenuNeedAdd(id,rms)){
                RoleMenu rm = new RoleMenu();
                rm.setRoleId(roleId);
                rm.setMenuId(id);
                roleMenusAdd.add(rm);
            }
        }
        for (RoleMenu rm: rms){
            if (isMenuNeedMove(rm.getMenuId(),setIds)){
                roleMenusMove.add(rm.getId());
            }
        }
        if (roleMenusAdd !=null && roleMenusAdd.size()>0){
            roleMenuService.saveBatch(roleMenusAdd);
        }
        if (roleMenusMove !=null && roleMenusMove.size()>0){
            roleMenuService.removeByIds(roleMenusMove);
        }
        return Result.success("操作成功");
    }

    public boolean isMenuNeedAdd(Integer menuId, List<RoleMenu> rms){
        for (RoleMenu rm: rms){
            if (rm.getMenuId() == menuId){
                return false;
            }
        }
        return true;
    }

    public boolean isMenuNeedMove(Integer menuId,Set<Integer> ids){
        for (Integer id: ids){
            if (id == menuId){
                return false;
            }
        }
        return true;
    }

    //找到所有父亲的id
    public void getParentIds(Integer id,List<Menu> menus,List<Integer> result){
        for (Menu m:menus){
            if (m.getId() == id){
                if (m.getParentId() !=0 ){
                    result.add(m.getParentId());
                    getParentIds(m.getParentId(), menus, result);
                }
            }
        }
    }

}
