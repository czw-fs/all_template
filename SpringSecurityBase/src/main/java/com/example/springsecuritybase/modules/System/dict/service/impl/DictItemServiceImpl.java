package com.example.springsecuritybase.modules.System.dict.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.dict.convert.DictItemConvert;
import com.example.springsecuritybase.modules.System.dict.mapper.DictItemMapper;
import com.example.springsecuritybase.modules.System.dict.mapper.DictMapper;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.DictItem;
import com.example.springsecuritybase.modules.System.dict.service.DictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {


    private final DictMapper dictMapper;
    private final DictItemConvert dictItemConvert;
    private final DictItemMapper dictItemMapper;

    @Override
    public void create(DictItemDto dto) {
        DictItem  dictItem = dictItemConvert.dtoToEntity(dto);
        dictItemMapper.insert(dictItem);
    }

    @Override
    public void update(DictItemDto dto) {
        DictItem  dictItem = dictItemConvert.dtoToEntity(dto);
        dictItemMapper.updateById(dictItem);
    }

    @Override
    public DictItemDto getOneById(Long id) {
        DictItem dictItem = dictItemMapper.selectById(id);
        DictItemDto dto = dictItemConvert.entityToDto(dictItem);
        return dto;
    }

    @Override
    public List<DictItemDto> getList(DictItemSearchDto dto) {
        List<DictItem> dictItemList = dictItemMapper.getList(dto);
        List<DictItemDto> dictItemDtoList = dictItemConvert.entityListToDtoList(dictItemList);
        return dictItemDtoList;
    }

}
