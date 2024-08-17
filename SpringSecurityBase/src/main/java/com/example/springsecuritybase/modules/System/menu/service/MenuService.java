package com.example.springsecuritybase.modules.System.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;


public interface MenuService extends IService<Menu> {
    void create(MenuDto menuDto);
}
