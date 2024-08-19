package com.example.springsecuritybase.modules.System.role.convert;

import com.example.springsecuritybase.modules.System.role.model.dto.CreateRoleDto;
import com.example.springsecuritybase.modules.System.role.model.dto.UpdateRoleDto;
import com.example.springsecuritybase.modules.System.role.model.entities.Role;
import com.example.springsecuritybase.modules.System.role.model.vo.RoleVo;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleConvert {


    @InheritConfiguration
    Role createRoleDtoToEntity(CreateRoleDto createRoleDto);

    @InheritConfiguration
    Role updateRoleDtoToEntity(UpdateRoleDto updateRoleDto);

    @InheritConfiguration
    RoleVo entityToRoleVo(Role role);

    @InheritConfiguration
    List<CurUserRolesVo> entityListToRoleVoList(List<Role> roleList);
}
