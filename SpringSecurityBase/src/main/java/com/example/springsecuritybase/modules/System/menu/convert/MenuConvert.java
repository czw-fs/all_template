package com.example.springsecuritybase.modules.System.menu.convert;

import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuConvert {

    @InheritConfiguration
    Menu dtoToEntity(MenuDto menuDto);

    @InheritConfiguration
    MenuDto entityToDto(Menu menu);

    @InheritConfiguration
    List<MenuDto> entityListToDtoList(List<Menu> menuList);
}
