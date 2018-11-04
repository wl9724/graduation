package com.dlmu.graduation.model;

import lombok.Data;

/**
 * 登录请求类
 */
@Data
public class LoginRequest {

	private String username;
	
	private String password;
	
}
