
-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '更新时间',
	gmt_create_id BIGINT (15) NOT NULL COMMENT '创建人id',
	gmt_create_name VARCHAR (50) NOT NULL COMMENT '创建人',
	gmt_modified_id BIGINT (15) NOT NULL COMMENT '更新人id',
	gmt_modified_name VARCHAR (50) NOT NULL COMMENT '更新人',
	is_deleted INT (11) NOT NULL COMMENT '0删除 1未删除',
	parent_id BIGINT (15) NOT NULL COMMENT '父菜单ID',
	title VARCHAR (50) NOT NULL COMMENT '菜单标题',
	`name` VARCHAR (50) NOT NULL COMMENT '菜单名称',
	seq INT (11) NOT NULL COMMENT '显示顺序',
	`path` VARCHAR (50) NOT NULL COMMENT '路由地址',
	permission VARCHAR (50) NOT NULL COMMENT '权限标识',
	component VARCHAR (50) NOT NULL COMMENT '组件路径',
	icon VARCHAR (50) NOT NULL COMMENT '菜单图标',
	is_frame TINYINT (3) NOT NULL COMMENT '是否为外链（0否 1是）',
	`type` INT (11) NOT NULL COMMENT '菜单类型（0目录 1菜单 2按钮）',
	`cache` TINYINT (3) NOT NULL COMMENT '缓存（0否 1是）',
	hidden TINYINT (3) NOT NULL COMMENT '显示状态（0显示，1隐藏）',
	`status` INT (11) NOT NULL COMMENT '菜单状态（0正常 1停用）',
	remark VARCHAR (50) NOT NULL COMMENT '备注',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_menu';
