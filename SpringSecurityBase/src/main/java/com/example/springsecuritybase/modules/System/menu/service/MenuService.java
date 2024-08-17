package com.example.springsecuritybase.modules.System.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;

import java.util.List;


public interface MenuService extends IService<Menu> {
    void create(MenuDto menuDto);

    void update(MenuDto menuDto);

    MenuDto getOneById(Long id);

    List<MenuDto> getList(MenuSearchDto dto);
}
