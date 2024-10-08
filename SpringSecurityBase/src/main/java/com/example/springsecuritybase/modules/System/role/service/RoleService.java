package com.example.springsecuritybase.modules.System.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecuritybase.modules.System.role.model.dto.CreateRoleDto;
import com.example.springsecuritybase.modules.System.role.model.dto.RoleSearchDto;
import com.example.springsecuritybase.modules.System.role.model.dto.UpdateRoleDto;
import com.example.springsecuritybase.modules.System.role.model.entities.Role;
import com.example.springsecuritybase.modules.System.role.model.vo.RoleVo;

import java.util.List;

public interface RoleService extends IService<Role> {
    void create(CreateRoleDto createRoleDto);

    void update(UpdateRoleDto updateRoleDto);

    RoleVo getOneById(Long id);

    void delete(Long id);

    List<RoleVo> getList(RoleSearchDto roleSearchDto);
}
