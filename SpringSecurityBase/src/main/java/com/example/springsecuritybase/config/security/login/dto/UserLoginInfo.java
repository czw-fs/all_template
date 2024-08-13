package com.example.springsecuritybase.config.security.login.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginInfo {

    private String sessionId; // 会话id，全局唯一
    private Long userId;
    private String nickname; // 昵称
    private String roleId;
    private Long expiredTime; // 过期时间
}
