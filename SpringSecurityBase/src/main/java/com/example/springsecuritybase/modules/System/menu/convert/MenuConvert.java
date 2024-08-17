package com.example.springsecuritybase.modules.System.menu.convert;

import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface MenuConvert {

    @InheritInverseConfiguration
    Menu dtoToEntity(MenuDto menuDto);

}
