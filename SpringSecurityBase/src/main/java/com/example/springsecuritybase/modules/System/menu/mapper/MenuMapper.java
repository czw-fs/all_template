package com.example.springsecuritybase.modules.System.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getList(@Param("dto") MenuSearchDto dto);
}
