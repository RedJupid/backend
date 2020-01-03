package com.xd.demo.modules.sys.service;

import com.xd.demo.modules.sys.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.demo.modules.sys.entity.MenuTree;

import java.util.List;

/**
* <p>
    * 菜单表 服务类
    * </p>
*
* @author xd
* @since 2020-01-03
*/
public interface IMenuService extends IService<Menu> {
    List<MenuTree> selectMenuTree();
}
