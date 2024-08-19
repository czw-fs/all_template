package com.example.springsecuritybase.modules.System.role.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.management.relation.RoleStatus;

@Data
@Accessors(chain = true)
public class CreateRoleDto {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private RoleStatus status;

}
