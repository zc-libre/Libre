INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (100, 1, '用户管理', 'User', 1, 'user', 'system:user:list', 'system/user/index', 'user', 0, 1, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '用户管理菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1025, 104, '岗位导出', null, 5, '', 'system:post:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.602904', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1617469563878924290, 3, '开放接口', null, null, 'api', null, 'tools/openapi/chat/index', 'codeConsole', 0, 1, 0,
        0, 1, 'admin', '2023-01-23 18:29:29.817761', 'admin', '2023-01-23 18:37:25.173382', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (101, 1, '角色管理', null, 2, 'role', 'system:role:list', 'system/role/index', 'peoples', 0, 1, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '角色管理菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (102, 1, '菜单管理', null, 3, 'menu', 'system:menu:list', 'system/menu/index', 'tree-table', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '菜单管理菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (103, 1, '部门管理', null, 4, 'dept', 'system:dept:list', 'system/dept/index', 'dept', 0, 1, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.592920', '部门管理菜单', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (104, 1, '岗位管理', null, 5, 'post', 'system:post:list', 'system/post/index', 'tree', 0, 1, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.595933', '岗位管理菜单', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1611783348483567617, 1, '任务调度', null, null, 'job', null, 'system/jobs/index', 'Steve-Jobs', 0, 1, 0, 0, 1,
        'admin', '2023-01-08 01:54:30.426195', 'admin', '2023-01-08 02:55:00.748465', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (105, 1, '字典管理', null, 6, 'dict', 'system:dict:list', 'system/dict/index', 'dictionary', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '字典管理菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (106, 1, '参数设置', null, 7, 'config', 'system:config:list', 'system/config/index', 'edit', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '参数设置菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (107, 1, '通知公告', null, 8, 'notice', 'system:notice:list', 'system/notice/index', 'message', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '通知公告菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (109, 2, 'token管理', null, 1, 'online', 'monitor:token:list', 'monitor/token/index', 'Steve-Jobs', 0, 1, 0, 0,
        1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '在线用户菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (111, 2, 'SQL监控', null, 3, 'druid', 'monitor:druid:list', 'monitor/druid/index', 'sqlMonitor', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '数据监控菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (112, 2, '服务监控', null, 4, 'server', 'monitor:server:list', 'monitor/server/index', 'server', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '服务监控菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (113, 2, 'redis监控', null, 4, 'redis', 'monitor:redis:list', 'monitor/redis/index', 'server', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '服务监控菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (114, 3, '表单构建', null, 1, 'build', 'tool:build:list', 'tools/build/index', 'dev', 0, 1, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '表单构建菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (115, 3, '系统接口', null, 3, 'swagger', 'tool:swagger:list', 'tools/swagger/index', 'swagger', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统接口菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (500, 2, '操作日志', 'Log', 1, 'logs', 'monitor:operlog:list', 'monitor/log/index', 'log', 0, 1, 0, 0, 1,
        'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '操作日志菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (501, 2, '异常日志', 'ErrorLog', 2, 'errorLog', 'monitor:logininfor:list', 'monitor/log/errorLog', 'error', 0, 1,
        0, 0, 1, 'admin', '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '登录日志菜单', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1001, 100, '用户查询', null, 1, '', 'system:user:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1002, 100, '用户新增', null, 2, '', 'system:user:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1003, 100, '用户修改', null, 3, '', 'system:user:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1004, 100, '用户删除', null, 4, '', 'system:user:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1005, 100, '用户导出', null, 5, '', 'system:user:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1006, 100, '用户导入', null, 6, '', 'system:user:import', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1007, 100, '重置密码', null, 7, '', 'system:user:resetPwd', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1008, 101, '角色查询', null, 1, '', 'system:role:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1009, 101, '角色新增', null, 2, '', 'system:role:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1010, 101, '角色修改', null, 3, '', 'system:role:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1011, 101, '角色删除', null, 4, '', 'system:role:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1012, 101, '角色导出', null, 5, '', 'system:role:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1013, 102, '菜单查询', null, 1, '', 'system:menu:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1014, 102, '菜单新增', null, 2, '', 'system:menu:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1015, 102, '菜单修改', null, 3, '', 'system:menu:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1016, 102, '菜单删除', null, 4, '', 'system:menu:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1026, 105, '字典查询', null, 1, '#', 'system:dict:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1027, 105, '字典新增', null, 2, '#', 'system:dict:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1028, 105, '字典修改', null, 3, '#', 'system:dict:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1029, 105, '字典删除', null, 4, '#', 'system:dict:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1030, 105, '字典导出', null, 5, '#', 'system:dict:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1031, 106, '参数查询', null, 1, '#', 'system:config:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1032, 106, '参数新增', null, 2, '#', 'system:config:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1033, 106, '参数修改', null, 3, '#', 'system:config:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1034, 106, '参数删除', null, 4, '#', 'system:config:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1035, 106, '参数导出', null, 5, '#', 'system:config:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1036, 107, '公告查询', null, 1, '#', 'system:notice:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1037, 107, '公告新增', null, 2, '#', 'system:notice:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1038, 107, '公告修改', null, 3, '#', 'system:notice:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1039, 107, '公告删除', null, 4, '#', 'system:notice:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1040, 500, '操作查询', null, 1, '#', 'system:logs:info:list', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1041, 500, '操作删除', null, 2, '#', 'system:logs:info:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1042, 500, '操作导出', null, 4, '#', 'system:logs:info:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1043, 501, '异常查询', null, 1, '#', 'system:logs:error:list', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1044, 501, '异常删除', null, 2, '#', 'system:logs:error:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1045, 501, '异常导出', null, 3, '#', 'system:logs:error:export', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1046, 109, '在线查询', null, 1, '#', 'monitor:online:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1047, 109, '批量强退', null, 2, '#', 'monitor:online:batchLogout', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1048, 109, '单条强退', null, 3, '#', 'monitor:online:forceLogout', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (4, 0, '如梦官网', null, 4, 'https://www.dreamlu.net', '', null, 'international', 1, 0, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:39.383072', '若依官网地址', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1017, 103, '部门查询', null, 1, '', 'system:dept:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.593473', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1018, 103, '部门新增', null, 2, '', 'system:dept:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.593908', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (3, 0, '系统工具', null, 3, '/tool', '', 'Layout', 'sys-tools', 0, 0, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统工具目录', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1, 0, '系统管理', null, 1, '/system', '', 'Layout', 'system', 0, 0, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统管理目录', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (2, 0, '系统监控', null, 2, '/monitor', '', 'Layout', 'monitor', 0, 0, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2018-03-16 11:33:00.000000', '系统监控目录', 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1019, 103, '部门修改', null, 3, '', 'system:dept:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.594414', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1020, 103, '部门删除', null, 4, '', 'system:dept:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.595057', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1021, 104, '岗位查询', null, 1, '', 'system:post:query', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.598777', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1022, 104, '岗位新增', null, 2, '', 'system:post:add', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.600671', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1023, 104, '岗位修改', null, 3, '', 'system:post:edit', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.601647', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1024, 104, '岗位删除', null, 4, '', 'system:post:del', '', '#', 0, 2, 0, 0, 1, 'admin',
        '2018-03-16 11:33:00.000000', 'admin', '2023-01-07 03:29:57.602383', '', 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1718167076935421954, 0, '博客管理', null, null, '/blog', null, null, 'app', 0, 0, 0, 0, 1, 'admin',
        '2023-10-28 15:25:27.800145', 'admin', '2023-10-28 15:25:27.800198', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1715991292925739010, 0, '文章管理', null, null, '/article', null, 'blog/article/ArticleEdit', 'backup', 0, 1, 0,
        0, 1, 'admin', '2023-10-22 15:19:40.467871', 'admin', '2023-10-28 15:36:57.847575', null, 1);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1718169901463621634, 1718167076935421954, '分类管理', null, null, '/blog/category', null,
        'blog/category/Category', 'database', 0, 1, 0, 0, 1, 'admin', '2023-10-28 15:36:41.220020', 'admin',
        '2023-10-28 15:38:21.917350', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1718215962454401025, 1718167076935421954, '标签管理', null, null, '/blog/tag', null, 'blog/tag/Tag', 'backup',
        0, 1, 0, 0, 1, 'admin', '2023-10-28 18:39:43.016404', 'admin', '2023-10-28 18:39:43.017571', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1732763281111683073, 1718167076935421954, '文章列表', null, null, '/blog/article', null, 'blog/article/Article',
        'app', 0, 1, 0, 0, 1, 'admin', '2023-12-07 22:05:34.060836', 'admin', '2023-12-08 23:44:19.766874', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1718170260370214914, 1718167076935421954, '文章管理', null, null, '/blog/articleEdit', null,
        'blog/article/ArticleEdit', 'app', 0, 1, 0, 0, 1, 'admin', '2023-10-28 15:38:06.790078', 'admin',
        '2023-12-08 23:44:30.760892', null, 0);
INSERT INTO public.sys_menu (id, parent_id, title, name, seq, path, permission, component, icon, is_frame, type, cache,
                             hidden, status, gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark,
                             is_deleted)
VALUES (1750190652307664897, 3, '文件管理', null, null, '/tool/file', null, 'tools/storage/index', 'chain', 0, 1, 0, 0,
        1, 'admin', '2024-01-25 00:15:43.138381', 'admin', '2024-01-25 00:16:42.510627', null, 0);
