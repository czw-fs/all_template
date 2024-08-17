package com.example.springsecuritybase.modules.System.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictItemService extends IService<DictItem> {
    void create(DictItemDto dto);

    void update(DictItemDto dto);

    DictItemDto getOneById(@Param("id") Long id);

    List<DictItemDto> getList(DictItemSearchDto dto);
}
