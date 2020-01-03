package com.xd.demo.modules.sys.controller;


import com.xd.demo.common.controller.BaseController;
import com.xd.demo.common.util.Result;
import com.xd.demo.modules.sys.entity.Menu;
import com.xd.demo.modules.sys.entity.MenuTree;
import com.xd.demo.modules.sys.service.IMenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author xd
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/sys/menu")
@Api(tags={"菜单接口"})
public class MenuController extends BaseController<Menu> {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/getTree")
    public Result getTree(){
        List<MenuTree> list = menuService.selectMenuTree();
        List<MenuTree> parentMenu = getMenuByParentId(list, 0);
        adjustMenu(parentMenu, list);
        return Result.success(parentMenu);
    }

    public List<MenuTree> getMenuByParentId(List<MenuTree> list, Integer parentId){
        List<MenuTree> l = new ArrayList<>();
        for (MenuTree m : list){
            if (m.getParentId()==parentId){
                l.add(m);
            }
        }
        return l;
    }

    public List<MenuTree> adjustMenu(List<MenuTree> parentMenu,List<MenuTree> allMenu){
        for (MenuTree m : parentMenu){
            List<MenuTree> children = getMenuByParentId(allMenu, m.getId());
            if (children !=null && children.size()>0){
                m.setChildren(children);
                adjustMenu(children, allMenu);
            }
        }
        return parentMenu;
    }

}
