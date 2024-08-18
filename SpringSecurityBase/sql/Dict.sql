-- auto Generated on 2024-08-18
-- DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict(
	create_time DATETIME NOT NULL COMMENT '创建时间',
	create_by BIGINT NOT NULL COMMENT '创建人',
	update_time DATETIME NOT NULL COMMENT '修改时间',
	update_by BIGINT NOT NULL COMMENT '修改人',
	is_deleted BIT (1) NOT NULL COMMENT '是否删除 0：否 1：是',
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR (255) NOT NULL COMMENT '名称',
	code VARCHAR (255) NOT NULL COMMENT '唯一编码',
	`status` VARCHAR (255) NOT NULL COMMENT '状态',
	remark VARCHAR (255) NOT NULL COMMENT '说明',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_dict';
