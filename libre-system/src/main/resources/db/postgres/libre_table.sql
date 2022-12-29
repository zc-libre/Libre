CREATE TABLE IF NOT EXISTS sys_user
(
    id                int8,
    username          varchar(64),
    password          varchar(512),
    role_id           int8,
    dept_id           int8,
    nick_name         varchar(64),
    avatar            varchar(64),
    phone             varchar(64),
    email             varchar(64),
    gender            int2 NULL DEFAULT 0,
    enabled           int2 NULL DEFAULT 0,
    locked            int2 NULL DEFAULT 1,
    is_admin          int2 NULL DEFAULT 0,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        int2
);

CREATE TABLE IF NOT EXISTS sys_role
(
    id                int8,
    role_name         varchar(50),
    parent_id         int8,
    status            int2,
    permission        varchar(64),
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        int2
);

CREATE TABLE IF NOT EXISTS sys_menu
(
    id                int8,
    parent_id         int8,
    title             varchar(64),
    name              varchar(64),
    seq               int4,
    path              varchar(256),
    permission        varchar(64),
    component         varchar(64),
    icon              varchar(64),
    is_frame          int2,
    type              int2,
    cache             int2,
    hidden            int2,
    status            int2,
    remark            varchar(512),
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        int2
);

CREATE TABLE IF NOT EXISTS sys_user_role
(
    id                int8,
    user_id           int8,
    role_id           int8,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64)
);

CREATE TABLE IF NOT EXISTS sys_role_menu
(
    id                int8,
    role_id           int8,
    menu_id           int8,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64)
);