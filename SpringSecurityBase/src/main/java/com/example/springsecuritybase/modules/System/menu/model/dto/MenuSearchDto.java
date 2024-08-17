package com.example.springsecuritybase.modules.System.menu.model.dto;

import com.example.springsecuritybase.modules.System.menu.model.enums.MenuDisplay;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MenuSearchDto {

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单类型
     */
    private String type;

    /**
     * 是否展示
     */
    private MenuDisplay display;
}
