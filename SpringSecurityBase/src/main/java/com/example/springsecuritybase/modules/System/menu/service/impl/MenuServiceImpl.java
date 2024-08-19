package com.example.springsecuritybase.modules.System.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.menu.convert.MenuConvert;
import com.example.springsecuritybase.modules.System.menu.mapper.MenuMapper;
import com.example.springsecuritybase.modules.System.menu.model.dto.CreateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.UpdateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import com.example.springsecuritybase.modules.System.menu.model.vo.MenuVo;
import com.example.springsecuritybase.modules.System.menu.model.vo.RouteVO;
import com.example.springsecuritybase.modules.System.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    private final MenuMapper menuMapper;
    private final MenuConvert menuConvert;

    @Override
    public List<RouteVO> getRoutes() {
//        List<>menuMapper.getRootMenu(SystemConstants.MENU_ROOT_ID);
        return null;
    }

    @Override
    public void create(CreateMenuDto menuDto) {
        Menu menu = menuConvert.createMenuDtoToEntity(menuDto);
        menuMapper.insert(menu);
    }

    @Override
    public void update(UpdateMenuDto menuDto) {
        Menu menu = menuConvert.updateMenuDtoToEntity(menuDto);
        menuMapper.updateById(menu);
    }

    @Override
    public MenuVo getOneById(Long id) {
        Menu menu = menuMapper.selectById(id);
        MenuVo menuDto = menuConvert.entityToMenuVo(menu);
        return menuDto;
    }

    @Override
    public List<MenuVo> getList(MenuSearchDto dto) {
        List<Menu> menuList = menuMapper.getList(dto);
        List<MenuVo> menuDtos = menuConvert.entityListToDtoList(menuList);
        return menuDtos;
    }
}
