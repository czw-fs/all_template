-- auto Generated on 2024-08-18
-- DROP TABLE IF EXISTS sys_dict_item;
CREATE TABLE sys_dict_item(
	create_time DATETIME COMMENT '创建时间',
	create_by BIGINT (15) COMMENT '创建人',
	update_time DATETIME COMMENT '修改时间',
	update_by BIGINT COMMENT '修改人',
	is_deleted BIT (1) COMMENT '是否删除 0：否 1：是',
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
	dict_id BIGINT COMMENT '字典id',
	`name` VARCHAR (255) COMMENT '字典展示名称',
	`value` VARCHAR (255) COMMENT '字典值',
	`status` VARCHAR (255) COMMENT '状态',
	sort INT COMMENT '排序：降序排',
	remark VARCHAR (255) COMMENT '说明',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_dict_item';
