package com.example.springsecuritybase.modules.System.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.dict.model.dto.CreateDictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.UpdateDictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.vo.DictItemVo;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictItemService extends IService<DictItem> {
    void create(CreateDictItemDto dto);

    void update(UpdateDictItemDto dto);

    DictItemVo getOneById(@Param("id") Long id);

    List<DictItemVo> getList(DictItemSearchDto dto);
}
