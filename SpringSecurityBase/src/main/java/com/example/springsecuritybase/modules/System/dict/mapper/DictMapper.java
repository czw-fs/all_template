package com.example.springsecuritybase.modules.System.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.model.vo.DictVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
    List<Dict> getPage(@Param("dto") DictSearchDto dto, Page<DictVo> page);
}
