package com.prcvalve.common.annotation;

import com.prcvalve.module.basic.model.entity.LogType;
import com.prcvalve.module.basic.model.entity.OperationTopic;
import com.prcvalve.module.basic.model.entity.OperationType;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {

    /**
     * 操作日志类型
     */
    LogType logType() default LogType.BUSINESS;

    /**
     * 操作主题
     */
    OperationTopic operationTopic() default OperationTopic.NONE ;

    /**
     * 业务操作类型
     * @return
     */
    OperationType operationType() default OperationType.OPERATE;

    /**
     * 操作内容
     * @return
     */
    String content() default "";
}