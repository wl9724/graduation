package com.dlmu.graduation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录响应类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

	private int id;
	
	private boolean loginstatus;
	
}
