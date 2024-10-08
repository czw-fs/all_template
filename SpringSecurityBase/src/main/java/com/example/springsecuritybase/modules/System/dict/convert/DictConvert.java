package com.example.springsecuritybase.modules.System.dict.convert;

import com.example.springsecuritybase.modules.System.dict.model.dto.CreateDictDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.UpdateDictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.model.vo.DictVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DictConvert {


    /**
     * 处理继承
     */
    @InheritConfiguration
    Dict createDictDToEntity(CreateDictDto dictDto);

    @InheritConfiguration
    Dict updateDictDToEntity(UpdateDictDto dictDto);

    @InheritConfiguration
    DictVo dictToDictVo(Dict dict);

    @InheritConfiguration
    List<DictVo> dictListToDictVoList(List<Dict> dictList);
}
