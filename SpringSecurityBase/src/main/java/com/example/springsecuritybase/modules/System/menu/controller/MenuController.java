package com.example.springsecuritybase.modules.System.menu.controller;

import com.example.springsecuritybase.modules.System.menu.model.dto.MenuDto;
import com.example.springsecuritybase.modules.System.menu.service.MenuService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/create")
    public Result<Void> create(@RequestBody MenuDto menuDto){
        menuService.create(menuDto);
        return Result.success();
    }

    @PutMapping("/update")
    public String update(@RequestBody MenuDto menuDto){
        return "menu list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        return "menu list";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "menu list";
    }

}
