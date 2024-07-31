CREATE TABLE `operation_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `log_type` varchar(255) NOT NULL COMMENT '操作日志类型',
  `operation_topic` varchar(255) NOT NULL COMMENT '操作主题',
  `operation_type` varchar(255) NOT NULL COMMENT '业务操作类型',
  `operation_content` varchar(1024) NOT NULL COMMENT '操作内容',
  `operation_method` varchar(255) DEFAULT NULL COMMENT '操作调用方法',
  `operation_params` text COMMENT '操作调用方法传递参数',
  `operation_time` datetime NOT NULL COMMENT '操作时间',
  `operator_id` bigint DEFAULT NULL COMMENT '操作者ID',
  `operator_remote_address` varchar(255) DEFAULT NULL COMMENT '操作者IP地址',
  `deleted` bit(1) NOT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志';