package com.example.springsecuritybase.modules.System.dict.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;

public interface DictService extends IService<Dict> {
    void create(DictDto dictDto);

    void update(DictDto dictDto);

    DictDto getOneById(Long id);

    Page<DictDto> getPage(DictSearchDto searchDto);
}
