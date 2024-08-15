package com.example.springsecuritybase.modules.System.dict.controller;


import com.example.springsecuritybase.modules.System.dict.model.dto.DictDto;
import com.example.springsecuritybase.modules.System.dict.model.entities.Dict;
import com.example.springsecuritybase.modules.System.dict.service.DictService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dict")
public class DictController {

    private final DictService dictService;

    @PostMapping("/create")
    public Result<Void> create(@RequestBody DictDto dictDto) {
        dictService.create(dictDto);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<Void> update(@RequestBody DictDto dictDto) {
        dictService.update(dictDto);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<DictDto> getById(@PathVariable("id")  Long id) {
        DictDto dictDto = dictService.getOneById(id);
        return Result.success(dictDto);
    }

    @DeleteMapping("/{id}")
    public Result<Dict> deleteById(@PathVariable("id") Long id) {
        dictService.removeById(id);
        return Result.success();
    }
}
