package com.example.springsecuritybase.modules.System.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getList(@Param("dto") MenuSearchDto dto);

    Set<String> getMenusByRoleIds(@Param("roleIds") Set<Long> roleIds);
}
