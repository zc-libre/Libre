-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '更新时间',
	gmt_create_id BIGINT (15) NOT NULL COMMENT '创建人id',
	gmt_create_name VARCHAR (50) NOT NULL COMMENT '创建人',
	gmt_modified_id BIGINT (15) NOT NULL COMMENT '更新人id',
	gmt_modified_name VARCHAR (50) NOT NULL COMMENT '更新人',
	is_deleted INT (11) NOT NULL COMMENT '0删除 1未删除',
	username VARCHAR (50) NOT NULL COMMENT '账户',
	`password` VARCHAR (50) NOT NULL COMMENT '密码',
	role_id BIGINT (15) NOT NULL COMMENT '角色id',
	dept_id BIGINT (15) NOT NULL COMMENT '部门id',
	nick_name VARCHAR (50) NOT NULL COMMENT '昵称',
	avatar VARCHAR (50) NOT NULL COMMENT '头像',
	phone VARCHAR (50) NOT NULL COMMENT '电话',
	email VARCHAR (50) NOT NULL COMMENT '邮件',
	gender INT (11) NOT NULL COMMENT '性别',
	`status` INT (11) NOT NULL COMMENT '状态',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_user';
