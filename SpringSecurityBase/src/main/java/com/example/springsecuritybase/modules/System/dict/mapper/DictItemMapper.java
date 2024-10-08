package com.example.springsecuritybase.modules.System.dict.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItem> {
    List<DictItem> getList(@Param("dto") DictItemSearchDto dto);
}
