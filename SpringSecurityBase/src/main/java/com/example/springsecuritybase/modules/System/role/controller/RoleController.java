package com.example.springsecuritybase.modules.System.role.controller;

import com.example.springsecuritybase.modules.System.role.service.RoleService;
import com.example.springsecuritybase.modules.common.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @RequestMapping("/create")
    public Result<Void> create(CreateRoleDto createRoleDto) {
        roleService.create(createRoleDto);
        return Result.success();
    }

    @RequestMapping("/update")
    public Result<Void> update() {
        roleService.update();
        return Result.success();
    }

    @RequestMapping("/{id}")
    public Result<Void> getById(@PathVariable("id") Long id) {
        roleService.getOneById();
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result<Void> delete() {
        roleService.delete();
        return Result.success();
    }

    @RequestMapping("/list")
    public Result<List<Void>> getList() {
        roleService.getList();
        return Result.success();
    }

}
