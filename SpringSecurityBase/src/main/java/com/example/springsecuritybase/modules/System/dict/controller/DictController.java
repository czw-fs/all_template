package com.example.springsecuritybase.modules.System.dict.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.dto.DictSearchDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.service.DictService;
import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.modules.common.validation.group.CreateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
public class DictController {

    private final DictService dictService;

    /**
     * 新增字典
     * @param dictDto
     * @return
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody @Validated({CreateGroup.class}) DictDto dictDto) {
        dictService.create(dictDto);
        return Result.success();
    }

    /**
     * 更新字典
     * @param dictDto
     * @return
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody DictDto dictDto) {
        dictService.update(dictDto);
        return Result.success();
    }

    /**
     * 根据id获取字典
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<DictDto> getById(@PathVariable("id")  Long id) {
        DictDto dictDto = dictService.getOneById(id);
        return Result.success(dictDto);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Dict> deleteById(@PathVariable("id") Long id) {
        dictService.removeById(id);
        return Result.success();
    }

    /**
     * 分页查询
     * @param searchDto
     * @return
     */
    @GetMapping("/page")
    public Result<Page<DictDto>> page(@Validated DictSearchDto searchDto) {
        Page<DictDto> page = dictService.getPage(searchDto);
        return Result.success(page);
    }
}
