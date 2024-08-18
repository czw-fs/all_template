package com.example.springsecuritybase.modules.System.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.menu.model.dto.CreateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.UpdateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import com.example.springsecuritybase.modules.System.menu.model.vo.MenuVo;

import java.util.List;


public interface MenuService extends IService<Menu> {
    void create(CreateMenuDto menuDto);

    void update(UpdateMenuDto menuDto);

    MenuVo getOneById(Long id);

    List<MenuVo> getList(MenuSearchDto dto);
}
