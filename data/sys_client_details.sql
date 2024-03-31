INSERT INTO public.sys_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types,
                                       web_server_redirect_uri, authorities, access_token_validity,
                                       refresh_token_validity, additional_information, autoapprove, create_time,
                                       update_time, create_by, update_by, id)
VALUES ('test', null, 'test', 'server', 'password,refresh_token', null, null, 43200, 2592001, null, 'true', null, null,
        null, null, 1);
