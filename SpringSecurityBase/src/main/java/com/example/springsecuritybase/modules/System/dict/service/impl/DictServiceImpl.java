package com.example.springsecuritybase.modules.System.dict.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.dict.convert.DictConvert;
import com.example.springsecuritybase.modules.System.dict.mapper.DictMapper;
import com.example.springsecuritybase.modules.System.dict.model.dto.CreateDictDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.UpdateDictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.model.vo.DictVo;
import com.example.springsecuritybase.modules.System.dict.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private final DictConvert dictConvert;
    private final DictMapper dictMapper;

    @Override
    public void create(CreateDictDto dictDto) {
        Dict dict = dictConvert.createDictDToEntity(dictDto);
        dictMapper.insert(dict);
    }

    @Override
    public void update(UpdateDictDto dictDto) {
        Dict dict = dictConvert.updateDictDToEntity(dictDto);
        dictMapper.updateById(dict);
    }

    @Override
    public DictVo getOneById(Long id) {
        Dict dict = dictMapper.selectById(id);
        DictVo dictVo = dictConvert.dictToDictVo(dict);
        return dictVo;
    }

    @Override
    public Page<DictVo> getPage(DictSearchDto dto) {
        Page<DictVo> page = new Page<>(dto.getPageNum(),dto.getPageSize());
        List<Dict> dictList = dictMapper.getPage(dto, page);

        List<DictVo> dictVoList = dictConvert.dictListToDictVoList(dictList);
        page.setRecords(dictVoList);
        return page;
    }
}
