package com.example.springsecuritybase.modules.System.user.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 *  当前登录用户信息及权限
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {

    private Long id;

    private String username;

    private String avatar;

    private List<String> role;

    private List<String> permissions;


}