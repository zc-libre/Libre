-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_user_post;
CREATE TABLE sys_user_post(
	user_id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '用户id',
	post_id BIGINT (15) NOT NULL COMMENT '岗位id',
	PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_user_post';
