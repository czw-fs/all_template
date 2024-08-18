-- auto Generated on 2024-08-18
-- DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
	create_time DATETIME COMMENT '创建时间',
	create_by BIGINT COMMENT '创建人',
	update_time DATETIME COMMENT '修改时间',
	update_by BIGINT COMMENT '修改人',
	is_deleted BIT (1) COMMENT '是否删除 0：否 1：是',
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	parent_id BIGINT COMMENT '父id',
	`name` VARCHAR (255) COMMENT '菜单名称',
	`type` VARCHAR (255) COMMENT '菜单类型',
	router_name VARCHAR (255) COMMENT '路由名称',
	route_path VARCHAR (255) COMMENT '路由路径',
	component_path VARCHAR (50) COMMENT '组件路径',
	permission VARCHAR (50) COMMENT '【按钮】权限标识',
	display VARCHAR (50) COMMENT '是否展示',
	sort INT (11) COMMENT '排序',
	icon VARCHAR (50) COMMENT '菜单图标',
	redirect VARCHAR (50) COMMENT '跳转路径',
	params VARCHAR (50) COMMENT '路由参数',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_menu';
