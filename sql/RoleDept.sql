
-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_role_dept;
CREATE TABLE sys_role_dept(
	role_id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '角色id',
	dept_id BIGINT (15) NOT NULL COMMENT '部门id',
	PRIMARY KEY (role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_role_dept';
