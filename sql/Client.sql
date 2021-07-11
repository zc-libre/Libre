
-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_client;
CREATE TABLE sys_client(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '更新时间',
	gmt_create_id BIGINT (15) NOT NULL COMMENT '创建人id',
	gmt_create_name VARCHAR (50) NOT NULL COMMENT '创建人',
	gmt_modified_id BIGINT (15) NOT NULL COMMENT '更新人id',
	gmt_modified_name VARCHAR (50) NOT NULL COMMENT '更新人',
	is_deleted INT (11) NOT NULL COMMENT '0删除 1未删除',
	client_id VARCHAR (50) NOT NULL COMMENT '客户端id',
	client_secret VARCHAR (50) NOT NULL COMMENT '客户端密钥',
	resource_ids VARCHAR (50) NOT NULL COMMENT '资源集合',
	`scope` VARCHAR (50) NOT NULL COMMENT '授权范围',
	authorized_grant_types VARCHAR (50) NOT NULL COMMENT '授权类型',
	web_server_redirect_uri VARCHAR (50) NOT NULL COMMENT '回调地址',
	authorities VARCHAR (50) NOT NULL COMMENT '权限',
	access_token_validity INT (11) NOT NULL COMMENT '令牌过期秒数',
	refresh_token_validity INT (11) NOT NULL COMMENT '刷新令牌过期秒数',
	additional_information VARCHAR (50) NOT NULL COMMENT '附加说明',
	autoapprove VARCHAR (50) NOT NULL COMMENT '自动授权',
	`status` INT (11) NOT NULL COMMENT '状态',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_client';
