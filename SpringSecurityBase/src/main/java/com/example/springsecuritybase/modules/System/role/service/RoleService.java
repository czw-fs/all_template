package com.example.springsecuritybase.modules.System.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.role.model.entities.Role;

public interface RoleService extends IService<Role> {
    void create(CreateRoleDto createRoleDto);
}
