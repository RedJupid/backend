package com.xd.demo.modules.sys.mapper;

import com.xd.demo.modules.sys.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xd.demo.modules.sys.entity.MenuTree;

import java.util.List;

/**
* <p>
    * 菜单表 Mapper 接口
    * </p>
*
* @author xd
* @since 2020-01-03
*/
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuTree> selectMenuTree();

}
