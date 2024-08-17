package com.example.springsecuritybase.modules.System.dict.controller;

import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictItemSearchDto;
import com.example.springsecuritybase.modules.System.dict.service.DictItemService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DictItemController {

    private final DictItemService dictItemService;

    /**
     * 新增字典项
     * @param dto
     * @return
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody DictItemDto dto) {
        dictItemService.create(dto);
        return Result.success();
    }

    /**
     * 修改字典项
     * @param dto
     * @return
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody DictItemDto dto) {
        dictItemService.update(dto);
        return Result.success();
    }

    /**
     * 查询字典项
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DictItemDto> getById(@PathVariable("id") Long id) {
        DictItemDto dto = dictItemService.getOneById(id);
        return Result.success(dto);
    }

    /**
     * 删除字典项
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Void> deleteById(@PathVariable("id") Long id) {
        dictItemService.removeById(id);
        return Result.success();
    }

    /**
     * 查询字典项列表
     * @param dto
     * @return
     */
    @GetMapping("/list")
    public Result<List<DictItemDto>> getList(DictItemSearchDto dto) {
        List<DictItemDto> result = dictItemService.getList(dto);
        return Result.success(result);
    }
}