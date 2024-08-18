-- auto Generated on 2024-08-18
-- DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
	create_time DATETIME COMMENT '创建时间',
	create_by BIGINT COMMENT '创建人',
	update_time DATETIME COMMENT '修改时间',
	update_by BIGINT COMMENT '修改人',
	is_deleted BIT (1) COMMENT '是否删除 0：否 1：是',
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	username VARCHAR (255) COMMENT '用户名',
	`password` VARCHAR (255) COMMENT '密码',
	gender VARCHAR (255) COMMENT '性别',
	avatar VARCHAR (255) COMMENT '头像',
	mobile VARCHAR (255) COMMENT '电话',
	email VARCHAR (255) COMMENT '邮箱',
	`status` VARCHAR (255) COMMENT '状态',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_user';
