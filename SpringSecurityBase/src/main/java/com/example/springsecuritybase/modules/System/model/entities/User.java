package com.example.springsecuritybase.modules.System.model.entities;

import com.baomidou.mybatisplus.annotation.*;

@TableName("sys_user")
public class User {
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
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String creatorId;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updaterId;
    /**
     * 是否删除 0：否 1：是
     */
    @TableLogic
    private Boolean isDelete;
}
