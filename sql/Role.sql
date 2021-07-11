
-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '更新时间',
	gmt_create_id BIGINT (15) NOT NULL COMMENT '创建人id',
	gmt_create_name VARCHAR (50) NOT NULL COMMENT '创建人',
	gmt_modified_id BIGINT (15) NOT NULL COMMENT '更新人id',
	gmt_modified_name VARCHAR (50) NOT NULL COMMENT '更新人',
	is_deleted INT (11) NOT NULL COMMENT '0删除 1未删除',
	role_name VARCHAR (50) NOT NULL COMMENT '角色名',
	parent_id BIGINT (15) NOT NULL COMMENT '父id',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_role';
