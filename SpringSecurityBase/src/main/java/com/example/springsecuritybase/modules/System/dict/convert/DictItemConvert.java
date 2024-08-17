package com.example.springsecuritybase.modules.System.dict.convert;

import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DictItemConvert {

    @InheritConfiguration
    DictItem dtoToEntity(DictItemDto dto);

    @InheritConfiguration
    DictItemDto entityToDto(DictItem dictItem);

    @InheritConfiguration
    List<DictItemDto> entityListToDtoList(List<DictItem> dictItemList);
}
