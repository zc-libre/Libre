package com.libre.framework.security.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.libre.security.pojo.Oauth2ClientDetails;

import java.io.Serializable;

/**
 * @author: Libre
 * @Date: 2023/1/29 12:02 AM
 */
@TableName("sys_client_details")
public class SysOauth2ClientDetails extends Oauth2ClientDetails implements Serializable {

}
