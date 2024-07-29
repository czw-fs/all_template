package com.prcvalve.module.basic.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OperationLog implements Serializable {
    @Serial
    private static final long serialVersionUID = 777565364817769068L;
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 操作日志类型
     */
    private LogType logType;
    /**
     * 操作主题
     */
    private OperationTopic operationTopic;

    /**
     * 业务操作类型
     */
    private OperationType operationType;

    /**
     * 操作内容
     */
    private String operationContent;

    /**
     * 操作调用方法
     */
    private String operationMethod;

    /**
     * 操作调用方法传递参数
     */
    private String operationParams;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;
    /**
     * 操作者ID
     */
    private Long operatorId;
    /**
     * 操作者IP地址
     */
    private String operatorRemoteAddress;
    /**
     * 逻辑删除标志
     */
    private boolean deleted;
}
