package com.example.springsecuritybase.modules.System.menu.controller;

import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.service.MenuService;
import com.example.springsecuritybase.modules.common.model.Result;
import com.example.springsecuritybase.modules.common.validation.group.CreateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Validated
public class MenuController {

    private final MenuService menuService;

    /**
     * 新增菜单
     * @param menuDto
     * @return
     */
    @PostMapping("/create")
    public Result<Void> create(@RequestBody @Validated(CreateGroup.class) MenuDto menuDto) {
        menuService.create(menuDto);
        return Result.success();
    }

    /**
     * 修改菜单
     * @param menuDto
     * @return
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody @Validated MenuDto menuDto) {
        menuService.update(menuDto);
        return Result.success();
    }

    /**
     * 查询菜单
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<MenuDto> getById(@PathVariable("id")Long id) {
        MenuDto menuDto = menuService.getOneById(id);
        return Result.success(menuDto);
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.success();
    }

    /**
     * 删除菜单
     * @return
     */
    @GetMapping("/list")
    public Result<List<MenuDto>> getList(MenuSearchDto dto) {
        List<MenuDto> menuDtoList = menuService.getList(dto);
        return Result.success(menuDtoList);
    }

}
