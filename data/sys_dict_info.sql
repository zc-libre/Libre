INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '性别男');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '性别女');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (3, 1, '显示', '0', 'sys_show_hide', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '显示菜单');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (4, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '隐藏菜单');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (5, 1, '启用', '0', 'sys_normal_disable', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '正常状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (6, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '停用状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (9, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '默认分组');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (10, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '系统分组');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (11, 1, '是', '1', 'sys_yes_no', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '系统默认是');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (12, 2, '否', '0', 'sys_yes_no', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '系统默认否');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (13, 1, '通知', '1', 'sys_notice_type', '', 'warning', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '通知');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (14, 2, '公告', '2', 'sys_notice_type', '', 'success', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '公告');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (15, 1, '正常', '0', 'sys_notice_status', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '正常状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (16, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '关闭状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (17, 1, '新增', '1', 'sys_oper_type', '', 'info', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '新增操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (18, 2, '修改', '2', 'sys_oper_type', '', 'info', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '修改操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (19, 3, '删除', '3', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '删除操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (20, 4, '授权', '4', 'sys_oper_type', '', 'primary', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '授权操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (21, 5, '导出', '5', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '导出操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (22, 6, '导入', '6', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '导入操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (23, 7, '强退', '7', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '强退操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (24, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '生成操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (25, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '清空操作');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (26, 1, '成功', '0', 'sys_common_status', '', 'primary', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '正常状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (27, 2, '失败', '1', 'sys_common_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '停用状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (28, 1, '停用', '0', 'sys_common_enabled', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '停用状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (29, 2, '启用', '1', 'sys_common_enabled', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '启用状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (7, 1, '正常', '0', 'sys_job_status', '', 'primary', 1, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '正常状态');
INSERT INTO public.sys_dict_info (id, seq, label, value, type, css_class, list_class, is_default, status,
                                  gmt_create_name, gmt_create, gmt_modified_name, gmt_modified, remark)
VALUES (8, 2, '暂停', '1', 'sys_job_status', '', 'danger', 0, 0, 'admin', '2018-03-16 11:33:00.000000', 'admin',
        '2018-03-16 11:33:00.000000', '停用状态');
