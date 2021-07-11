-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role(
	user_id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '用户id',
	role_id BIGINT (15) NOT NULL COMMENT '角色id',
	PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_user_role';
