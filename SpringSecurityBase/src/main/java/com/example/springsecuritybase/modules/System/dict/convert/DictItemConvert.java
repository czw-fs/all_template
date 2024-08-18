package com.example.springsecuritybase.modules.System.dict.convert;

import com.example.springsecuritybase.modules.System.dict.model.dto.CreateDictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.UpdateDictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.vo.DictItemVo;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DictItemConvert {

    @InheritConfiguration
    DictItem createDictItemDtoToEntity(CreateDictItemDto dto);

    @InheritConfiguration
    DictItem updateDictItemDtoToEntity(UpdateDictItemDto dto);

    @InheritConfiguration
    DictItemVo entityToDictItemVo(DictItem dictItem);

    @InheritConfiguration
    List<DictItemVo> entityListToDictItemVoList(List<DictItem> dictItemList);
}
