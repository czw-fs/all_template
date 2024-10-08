package com.example.springsecuritybase.modules.System.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecuritybase.modules.System.role.model.dto.RoleSearchDto;
import com.example.springsecuritybase.modules.System.role.model.entities.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectList(@Param("dto") RoleSearchDto roleSearchDto);

    List<Role> getRolesByUserId(@Param("userId") Long userId);

    Set<String> getRoleCodesByUserId(@Param("userId") Long userId);
}
