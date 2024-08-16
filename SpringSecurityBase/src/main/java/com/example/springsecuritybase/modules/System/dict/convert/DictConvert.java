package com.example.springsecuritybase.modules.System.dict.convert;

import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DictConvert {

    Dict dictDtoToDict(DictDto dictDto);

    /**
     * 处理继承
     * @param dict
     * @return
     */
    @InheritInverseConfiguration
    DictDto dictToDictDto(Dict dict);

    List<DictDto> dictListToDictDtoList(List<Dict> dictList);
}
