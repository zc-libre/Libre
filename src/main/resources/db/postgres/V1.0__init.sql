create table sys_user
(
    id                bigint,
    username          varchar(64),
    password          varchar(512),
    nick_name         varchar(64),
    avatar            varchar(64),
    phone             varchar(64),
    email             varchar(64),
    gender            smallint default 0,
    enabled           smallint default 0,
    locked            smallint default 1,
    is_admin          smallint default 0,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        smallint default 0
);


create table sys_role
(
    id                bigint,
    role_name         varchar(50),
    parent_id         bigint,
    status            smallint default 1,
    permission        varchar(64),
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        smallint default 0,
    seq               integer
);



create table sys_user_role
(
    id                bigint,
    user_id           bigint,
    role_id           bigint,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64)
);



create table sys_role_menu
(
    id                bigint,
    role_id           bigint,
    menu_id           bigint,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64)
);


create table sys_job
(
    id                bigint      not null
        primary key,
    job_name          varchar(64) not null,
    bean_name         varchar(64) not null,
    cron_expression   varchar(16) not null,
    is_deleted        smallint default 0,
    gmt_create        timestamp   not null,
    gmt_modified      timestamp   not null,
    gmt_create_name   varchar(64) not null,
    gmt_modified_name varchar(64) not null,
    params            text,
    job_status        smallint,
    method_name       varchar(64)
);



create table sys_job_log
(
    id                bigint   not null
        primary key,
    job_name          varchar(64),
    bean_name         varchar(64),
    method_name       varchar(64),
    params            varchar(64),
    cron_expression   varchar(64),
    execute_time      bigint,
    success           smallint not null,
    exception_detail  text,
    last_execute_time timestamp,
    create_time       timestamp
);


create table sys_log
(
    id             bigint not null
        primary key,
    user_id        bigint,
    username       varchar(64),
    log_type       varchar(512),
    description    varchar(128),
    params         text,
    data           text,
    success        smallint,
    class_method   varchar(128),
    stack_trace    text,
    request_ip     varchar(512),
    request_time   integer,
    os             varchar(512),
    browser        varchar(512),
    address        varchar(255),
    gmt_create     timestamp,
    app_name       varchar(64),
    request_method varchar(256),
    class_name     varchar(256),
    file_name      varchar(256),
    method_name    varchar(256),
    line_number    varchar(8),
    exception_name varchar(256),
    message        text,
    seq            integer
);


create index sys_log_gmt_create_index
    on sys_log (gmt_create desc);

create index sys_log_success_index
    on sys_log (success);

create index sys_log_log_type_index
    on sys_log (log_type);


create table sys_menu
(
    id                bigint not null
        constraint sys_menu_bak_pkey
            primary key,
    parent_id         bigint,
    title             varchar(64),
    name              varchar(64),
    seq               integer,
    path              varchar(128),
    permission        varchar(64),
    component         varchar(64),
    icon              varchar(64),
    is_frame          integer  default 0,
    type              integer,
    cache             integer,
    hidden            integer,
    status            integer  default 1,
    gmt_create_name   varchar(64),
    gmt_create        timestamp,
    gmt_modified_name varchar(64),
    gmt_modified      timestamp,
    remark            varchar(255),
    is_deleted        smallint default 0
);


create table sys_dict_info
(
    id                bigint not null
        primary key,
    seq               smallint,
    label             varchar(64),
    value             varchar(255),
    type              varchar(64),
    css_class         varchar(255),
    list_class        varchar(128),
    is_default        smallint,
    status            smallint,
    gmt_create_name   varchar(64),
    gmt_create        timestamp,
    gmt_modified_name varchar(64),
    gmt_modified      timestamp,
    remark            varchar(255)
);

create table sys_dict
(
    id                bigint not null
        primary key,
    name              varchar(64),
    description       varchar(64),
    status            smallint,
    gmt_create_name   varchar(64),
    gmt_create        timestamp,
    gmt_modified_name varchar(64),
    gmt_modified      timestamp,
    remark            varchar(255)
);

create table sys_file
(
    id                bigint not null
        constraint sys_file_pk
            primary key,
    real_name         varchar(512),
    name              varchar(512),
    suffix            varchar(64),
    path              varchar(512),
    save_type         integer,
    size              bigint,
    gmt_create        timestamp,
    gmt_modified      timestamp,
    gmt_create_name   varchar(64),
    gmt_modified_name varchar(64),
    is_deleted        integer default 0
);

insert into sys_user (id, username, password, nick_name, avatar, phone, email, gender, enabled, locked, is_admin, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name, is_deleted)
values  (1, 'admin', '$2a$10$nSTyJiH6jRyRUWgL7O.9cuDWZGYSwLskoXfKHNistSsrM3r8YsW4C', 'libre', null, '15191910116', 'zc150622@gmail.com', 0, 1, 0, 1, '2022-09-04 16:57:54.000000', '2023-01-02 01:02:23.838880', 'admin', 'System', 0),
        (1611456101490913282, 'test', '$2a$10$TU.AL75s.jfd7U4GT84px.t7p6oVqxqAoWvL9I7VQnLGGuMAqkjCu', 'test', null, '15191910116', 'test@gmail.com', 1, 1, 0, 0, '2023-01-07 04:14:08.660456', '2023-01-24 03:26:49.311136', 'admin', 'admin', 0);

insert into sys_user_role (id, user_id, role_id, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name)
values  (1, 1, 1, null, null, null, null),
        (null, 1611456101490913282, 1611451973884768257, null, null, null, null);

insert into sys_role (id, role_name, parent_id, status, permission, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name, is_deleted, seq)
values  (1, '超级管理员', 0, 1, 'admin', '2022-09-04 18:21:02.000000', '2023-01-07 23:25:43.696156', 'admin', 'admin', 0, 1),
        (1611451973884768257, 'test', null, 1, 'test', '2023-01-07 03:57:44.000000', '2023-01-07 23:25:50.336602', 'admin', 'admin', 0, 2);

insert into sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache, hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark, is_deleted)
values  (100, 1, '用户管理', 'User', 1, 'user', 'system:user:list', 'system/user/index', 'user', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '用户管理菜单', 0),
        (1025, 104, '岗位导出', null, 5, '', 'system:post:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.602904', '', 1),
        (1617469563878924290, 3, '开放接口', null, null, 'api', null, 'tools/openapi/chat/index', 'codeConsole', 0, 1, 0, 0, 1, 'admin', '2023-01-23 18:29:29.817761', 'admin', '2023-01-23 18:37:25.173382', null, 0),
        (101, 1, '角色管理', null, 2, 'role', 'system:role:list', 'system/role/index', 'peoples', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '角色管理菜单', 0),
        (102, 1, '菜单管理', null, 3, 'menu', 'system:menu:list', 'system/menu/index', 'tree-table', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '菜单管理菜单', 0),
        (103, 1, '部门管理', null, 4, 'dept', 'system:dept:list', 'system/dept/index', 'dept', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.592920', '部门管理菜单', 1),
        (104, 1, '岗位管理', null, 5, 'post', 'system:post:list', 'system/post/index', 'tree', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.595933', '岗位管理菜单', 1),
        (1611783348483567617, 1, '任务调度', null, null, 'job', null, 'system/jobs/index', 'Steve-Jobs', 0, 1, 0, 0, 1, 'admin', '2023-01-08 01:54:30.426195', 'admin', '2023-01-08 02:55:00.748465', null, 0),
        (105, 1, '字典管理', null, 6, 'dict', 'system:dict:list', 'system/dict/index', 'dictionary', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '字典管理菜单', 0),
        (106, 1, '参数设置', null, 7, 'config', 'system:config:list', 'system/config/index', 'edit', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '参数设置菜单', 0),
        (107, 1, '通知公告', null, 8, 'notice', 'system:notice:list', 'system/notice/index', 'message', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通知公告菜单', 0),
        (109, 2, 'token管理', null, 1, 'online', 'monitor:token:list', 'monitor/token/index', 'Steve-Jobs', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '在线用户菜单', 0),
        (111, 2, 'SQL监控', null, 3, 'druid', 'monitor:druid:list', 'monitor/druid/index', 'sqlMonitor', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '数据监控菜单', 0),
        (112, 2, '服务监控', null, 4, 'server', 'monitor:server:list', 'monitor/server/index', 'server', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '服务监控菜单', 0),
        (113, 2, 'redis监控', null, 4, 'redis', 'monitor:redis:list', 'monitor/redis/index', 'server', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '服务监控菜单', 0),
        (114, 3, '表单构建', null, 1, 'build', 'tool:build:list', 'tools/build/index', 'dev', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '表单构建菜单', 0),
        (115, 3, '系统接口', null, 3, 'swagger', 'tool:swagger:list', 'tools/swagger/index', 'swagger', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统接口菜单', 0),
        (500, 2, '操作日志', 'Log', 1, 'logs', 'monitor:operlog:list', 'monitor/log/index', 'log', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '操作日志菜单', 0),
        (501, 2, '异常日志', 'ErrorLog', 2, 'errorLog', 'monitor:logininfor:list', 'monitor/log/errorLog', 'error', 0, 1, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '登录日志菜单', 0),
        (1001, 100, '用户查询', null, 1, '', 'system:user:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1002, 100, '用户新增', null, 2, '', 'system:user:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1003, 100, '用户修改', null, 3, '', 'system:user:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1004, 100, '用户删除', null, 4, '', 'system:user:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1005, 100, '用户导出', null, 5, '', 'system:user:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1006, 100, '用户导入', null, 6, '', 'system:user:import', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1007, 100, '重置密码', null, 7, '', 'system:user:resetPwd', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1008, 101, '角色查询', null, 1, '', 'system:role:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1009, 101, '角色新增', null, 2, '', 'system:role:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1010, 101, '角色修改', null, 3, '', 'system:role:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1011, 101, '角色删除', null, 4, '', 'system:role:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1012, 101, '角色导出', null, 5, '', 'system:role:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1013, 102, '菜单查询', null, 1, '', 'system:menu:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1014, 102, '菜单新增', null, 2, '', 'system:menu:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1015, 102, '菜单修改', null, 3, '', 'system:menu:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1016, 102, '菜单删除', null, 4, '', 'system:menu:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1026, 105, '字典查询', null, 1, '#', 'system:dict:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1027, 105, '字典新增', null, 2, '#', 'system:dict:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1028, 105, '字典修改', null, 3, '#', 'system:dict:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1029, 105, '字典删除', null, 4, '#', 'system:dict:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1030, 105, '字典导出', null, 5, '#', 'system:dict:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1031, 106, '参数查询', null, 1, '#', 'system:config:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1032, 106, '参数新增', null, 2, '#', 'system:config:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1033, 106, '参数修改', null, 3, '#', 'system:config:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1034, 106, '参数删除', null, 4, '#', 'system:config:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1035, 106, '参数导出', null, 5, '#', 'system:config:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1036, 107, '公告查询', null, 1, '#', 'system:notice:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1037, 107, '公告新增', null, 2, '#', 'system:notice:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1038, 107, '公告修改', null, 3, '#', 'system:notice:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1039, 107, '公告删除', null, 4, '#', 'system:notice:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1040, 500, '操作查询', null, 1, '#', 'system:logs:info:list', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1041, 500, '操作删除', null, 2, '#', 'system:logs:info:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1042, 500, '操作导出', null, 4, '#', 'system:logs:info:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1043, 501, '异常查询', null, 1, '#', 'system:logs:error:list', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1044, 501, '异常删除', null, 2, '#', 'system:logs:error:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1045, 501, '异常导出', null, 3, '#', 'system:logs:error:export', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1046, 109, '在线查询', null, 1, '#', 'monitor:online:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1047, 109, '批量强退', null, 2, '#', 'monitor:online:batchLogout', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (1048, 109, '单条强退', null, 3, '#', 'monitor:online:forceLogout', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0),
        (4, 0, '如梦官网', null, 4, 'https://www.dreamlu.net', '', null, 'international', 1, 0, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:39.383072', '若依官网地址', 1),
        (1017, 103, '部门查询', null, 1, '', 'system:dept:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.593473', '', 1),
        (1018, 103, '部门新增', null, 2, '', 'system:dept:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.593908', '', 1),
        (3, 0, '系统工具', null, 3, '/tool', '', 'Layout', 'sys-tools', 0, 0, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统工具目录', 0),
        (1, 0, '系统管理', null, 1, '/system', '', 'Layout', 'system', 0, 0, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统管理目录', 0),
        (2, 0, '系统监控', null, 2, '/monitor', '', 'Layout', 'monitor', 0, 0, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统监控目录', 0),
        (1019, 103, '部门修改', null, 3, '', 'system:dept:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.594414', '', 1),
        (1020, 103, '部门删除', null, 4, '', 'system:dept:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.595057', '', 1),
        (1021, 104, '岗位查询', null, 1, '', 'system:post:query', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.598777', '', 1),
        (1022, 104, '岗位新增', null, 2, '', 'system:post:add', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.600671', '', 1),
        (1023, 104, '岗位修改', null, 3, '', 'system:post:edit', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.601647', '', 1),
        (1024, 104, '岗位删除', null, 4, '', 'system:post:del', '', '#', 0, 2, 0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.602383', '', 1);

insert into sys_role_menu (id, role_id, menu_id, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name)
values  (1617470662732046338, 1, 3, null, null, null, null),
        (1617470662757212161, 1, 1617469563878924290, null, null, null, null),
        (1617470662757212162, 1, 114, null, null, null, null),
        (1617470662757212163, 1, 115, null, null, null, null),
        (1617470662761406466, 1, 1, null, null, null, null),
        (1617470662761406467, 1, 100, null, null, null, null),
        (1617470662761406468, 1, 101, null, null, null, null),
        (1617470662765600770, 1, 102, null, null, null, null),
        (1617470662769795073, 1, 1611783348483567617, null, null, null, null),
        (1617470662769795074, 1, 105, null, null, null, null),
        (1617470662769795075, 1, 106, null, null, null, null),
        (1617470662773989378, 1, 107, null, null, null, null),
        (1617470662773989379, 1, 2, null, null, null, null),
        (1617470662773989380, 1, 109, null, null, null, null),
        (1617470662778183682, 1, 1046, null, null, null, null),
        (1617470662778183683, 1, 1047, null, null, null, null),
        (1617470662782377985, 1, 1048, null, null, null, null),
        (1617470662782377986, 1, 111, null, null, null, null),
        (1617470662786572290, 1, 112, null, null, null, null),
        (1617470662786572291, 1, 113, null, null, null, null),
        (1617470662786572292, 1, 500, null, null, null, null),
        (1617470662790766594, 1, 501, null, null, null, null);

insert into sys_dict (id, name, description, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
values  (1, 'sys_user_sex', '用户性别', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '用户性别列表'),
        (2, 'sys_show_hide', '菜单状态', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '菜单状态列表'),
        (3, 'sys_normal_disable', '系统开关', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统开关列表'),
        (4, 'sys_job_status', '任务状态', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '任务状态列表'),
        (5, 'sys_job_group', '任务分组', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '任务分组列表'),
        (6, 'sys_yes_no', '系统是否', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统是否列表'),
        (7, 'sys_notice_type', '通知类型', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通知类型列表'),
        (8, 'sys_notice_status', '通知状态', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通知状态列表'),
        (9, 'sys_oper_type', '操作类型', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '操作类型列表'),
        (10, 'sys_common_status', '系统状态', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '登录状态列表'),
        (11, 'sys_common_enabled', '启用状态', 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通用启用状态');

insert into sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
values  (1, 1, '男', '0', 'sys_user_sex', '', '', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '性别男'),
        (2, 2, '女', '1', 'sys_user_sex', '', '', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '性别女'),
        (3, 1, '显示', '0', 'sys_show_hide', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '显示菜单'),
        (4, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '隐藏菜单'),
        (5, 1, '启用', '0', 'sys_normal_disable', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '正常状态'),
        (6, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '停用状态'),
        (9, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '默认分组'),
        (10, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统分组'),
        (11, 1, '是', '1', 'sys_yes_no', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统默认是'),
        (12, 2, '否', '0', 'sys_yes_no', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统默认否'),
        (13, 1, '通知', '1', 'sys_notice_type', '', 'warning', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通知'),
        (14, 2, '公告', '2', 'sys_notice_type', '', 'success', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '公告'),
        (15, 1, '正常', '0', 'sys_notice_status', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '正常状态'),
        (16, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '关闭状态'),
        (17, 1, '新增', '1', 'sys_oper_type', '', 'info', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '新增操作'),
        (18, 2, '修改', '2', 'sys_oper_type', '', 'info', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '修改操作'),
        (19, 3, '删除', '3', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '删除操作'),
        (20, 4, '授权', '4', 'sys_oper_type', '', 'primary', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '授权操作'),
        (21, 5, '导出', '5', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '导出操作'),
        (22, 6, '导入', '6', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '导入操作'),
        (23, 7, '强退', '7', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '强退操作'),
        (24, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '生成操作'),
        (25, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '清空操作'),
        (26, 1, '成功', '0', 'sys_common_status', '', 'primary', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '正常状态'),
        (27, 2, '失败', '1', 'sys_common_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '停用状态'),
        (28, 1, '停用', '0', 'sys_common_enabled', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '停用状态'),
        (29, 2, '启用', '1', 'sys_common_enabled', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '启用状态'),
        (7, 1, '正常', '0', 'sys_job_status', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '正常状态'),
        (8, 2, '暂停', '1', 'sys_job_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '停用状态');



