package com.prcvalve.module.basic.model.entity;

public enum OperationTopic {
    USER_LOGIN,//用户登录
    PREPARED_CLIENT,//客户商机
    OFFICIAL_CLIENT,//商业客户
    AFTER_SALE,//售后报表
    PAYMENT_RECORD_CLiENT,//续费表
    QUOTATION_FORM,//业务报价单
    PRODUCTION_ORDER,//业务订单
    CORPORATE_CONTRACT,//合同
    SUPPORT_ORDER,//服务工单
    WORK_PROJECT,//工作项目
    WORK_TASK, //工作任务
    WORK_REPORT, //工作报表
    BRIEFING,//工作简报
    FOCUS_TASK,//关注
    NONE;

    public static String getName(OperationTopic type) {
        return switch (type) {
            case USER_LOGIN -> "用户登录";
            case PREPARED_CLIENT -> "客户商机";
            case OFFICIAL_CLIENT -> "商业客户";
            case QUOTATION_FORM -> "周报";
            case PRODUCTION_ORDER -> "业务订单";
            case SUPPORT_ORDER -> "服务工单";
            case WORK_PROJECT -> "工作项目";
            case WORK_TASK -> "工作任务";
            case WORK_REPORT -> "工作报表";
            default -> "未知";
        };
    }
}
