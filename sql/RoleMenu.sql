
-- auto Generated on 2021-07-11
DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu(
	role_id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'roleId',
	menu_id BIGINT (15) NOT NULL COMMENT 'menuId',
	PRIMARY KEY (role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_role_menu';
