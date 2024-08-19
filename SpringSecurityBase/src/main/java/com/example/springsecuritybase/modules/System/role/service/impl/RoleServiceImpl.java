package com.example.springsecuritybase.modules.System.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.role.mapper.RoleMapper;
import com.example.springsecuritybase.modules.System.role.model.entities.Role;
import com.example.springsecuritybase.modules.System.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;


    @Override
    public void create(CreateRoleDto createRoleDto) {

    }
}
