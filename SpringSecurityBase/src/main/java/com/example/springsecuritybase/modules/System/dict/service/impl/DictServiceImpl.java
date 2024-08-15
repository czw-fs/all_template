package com.example.springsecuritybase.modules.System.dict.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.dict.convert.DictConvert;
import com.example.springsecuritybase.modules.System.dict.mapper.DictMapper;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private final DictConvert dictConvert;
    private final DictMapper dictMapper;

    @Override
    public void create(DictDto dictDto) {
        Dict dict = dictConvert.dictDtoToDict(dictDto);
        dictMapper.insert(dict);
    }

    @Override
    public void update(DictDto dictDto) {
        Dict dict = dictConvert.dictDtoToDict(dictDto);
        dictMapper.updateById(dict);
    }

    @Override
    public DictDto getOneById(Long id) {
        Dict dict = dictMapper.selectById(id);
        DictDto dictDto = dictConvert.dictToDictDto(dict);
        return dictDto;
    }
}
