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

-- DROP TABLE IF EXISTS quartz_job;
CREATE TABLE IF NOT EXISTS sys_job
(
    id                int8        NOT NULL,
    job_name          VARCHAR(64) NOT NULL,
    job_group         VARCHAR(64) NOT NULL,
    bean_name         VARCHAR(64) NOT NULL,
    trigger_name      VARCHAR(64) NOT NULL,
    trigger_group     VARCHAR(64) NOT NULL,
    repeat_interval   int8        NOT NULL,
    times_triggered   int8        NOT NULL,
    cron_expression   VARCHAR(16) NOT NULL,
    time_zone_id      VARCHAR(16) NOT NULL,
    trigger_state     VARCHAR(16) NOT NULL,
    is_deleted        INT2,
    gmt_create        timestamp   NOT NULL,
    gmt_modified      timestamp   NOT NULL,
    gmt_create_name   VARCHAR(64) NOT NULL,
    gmt_modified_name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS sys_job_log
(
    id                int8 NOT NULL,
    job_name          VARCHAR(64) NOT NULL,
    bean_name         VARCHAR(64) NOT NULL,
    method_name       VARCHAR(64) NOT NULL,
    params            VARCHAR(64) NOT NULL,
    cron_expression   VARCHAR(64) NOT NULL,
    execute_time      int8 NOT NULL,
    success           int2 NOT NULL,
    exception_detail  text NOT NULL,
    last_execute_time timestamp    NOT NULL,
    create_time       timestamp    NOT NULL
);