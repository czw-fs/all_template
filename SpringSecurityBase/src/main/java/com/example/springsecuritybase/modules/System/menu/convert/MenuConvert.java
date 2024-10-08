package com.example.springsecuritybase.modules.System.menu.convert;

import com.example.springsecuritybase.modules.System.menu.model.dto.CreateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.UpdateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import com.example.springsecuritybase.modules.System.menu.model.vo.MenuVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuConvert {

    @InheritConfiguration
    Menu createMenuDtoToEntity(CreateMenuDto menuDto);

    @InheritConfiguration
    Menu updateMenuDtoToEntity(UpdateMenuDto menuDto);

    @InheritConfiguration
    MenuVo entityToMenuVo(Menu menu);

    @InheritConfiguration
    List<MenuVo> entityListToDtoList(List<Menu> menuList);
}
