package com.example.springsecuritybase.modules.System.model.entities;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springsecuritybase.modules.System.model.enums.Gender;
import com.example.springsecuritybase.modules.System.model.enums.UserStatus;
import com.example.springsecuritybase.modules.common.model.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态
     */
    private UserStatus status;

}
