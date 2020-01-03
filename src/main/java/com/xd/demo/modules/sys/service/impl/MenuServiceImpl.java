package com.xd.demo.modules.sys.service.impl;

import com.xd.demo.modules.sys.entity.Menu;
import com.xd.demo.modules.sys.entity.MenuTree;
import com.xd.demo.modules.sys.mapper.MenuMapper;
import com.xd.demo.modules.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* <p>
    * 菜单表 服务实现类
    * </p>
*
* @author xd
* @since 2020-01-03
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<MenuTree> selectMenuTree() {
        return baseMapper.selectMenuTree();
    }
}
