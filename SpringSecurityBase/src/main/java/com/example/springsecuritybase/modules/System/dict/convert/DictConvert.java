package com.example.springsecuritybase.modules.System.dict.convert;

import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import org.mapstruct.Mapper;

@Mapper
public interface DictConvert {

    Dict dictDtoToDict(DictDto dictDto);

    DictDto dictToDictDto(Dict dict);
}
