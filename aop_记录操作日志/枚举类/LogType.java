package com.prcvalve.module.basic.model.entity;

import com.prcvalve.module.project.model.entity.ProcessType;

public enum LogType {
    LOGIN,//登录操作日志
    BUSINESS,//业务操作日志
    SYSTEM;//系统操作日志

    public static String getName(LogType type) {
        return switch (type) {
            case LOGIN -> "登录操作日志";
            case BUSINESS -> "业务操作日志";
            case SYSTEM -> "系统操作日志";
            default -> "未知";
        };
    }
}
