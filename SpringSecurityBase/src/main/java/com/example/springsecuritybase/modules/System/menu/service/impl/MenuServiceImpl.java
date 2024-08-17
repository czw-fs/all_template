package com.example.springsecuritybase.modules.System.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.menu.convert.MenuConvert;
import com.example.springsecuritybase.modules.System.menu.mapper.MenuMapper;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import com.example.springsecuritybase.modules.System.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    private final MenuMapper menuMapper;
    private final MenuConvert menuConvert;

    @Override
    public void create(MenuDto menuDto) {
        Menu menu = menuConvert.dtoToEntity(menuDto);
        menuMapper.insert(menu);
    }
}
