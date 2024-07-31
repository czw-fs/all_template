package com.prcvalve.module.basic.model.entity;

public enum OperationType {
    CREATE,//新增
    UPDATE,//修改
    REMOVE,//删除
    READ,//读取
    LOGIN,//登录
    FOLLOW,//更进
    APPROVAL,//审批
    OPERATE,//操作
    NONE;//未知

    public static String getName(OperationType type) {
        return switch (type) {
            case CREATE -> "新增";
            case UPDATE -> "修改";
            case REMOVE -> "删除";
            case READ -> "读取";
            case LOGIN -> "登录";
            default -> "未知";
        };
    }
}
