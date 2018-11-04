package com.dlmu.graduation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import com.dlmu.graduation.model.LoginRequest;
import com.dlmu.graduation.model.LoginResponse;
import com.dlmu.graduation.service.UsersService;

/**
 * 登录
 */
@Controller
@Slf4j
public class LoginController {

	@Autowired
	UsersService usersService;
	
	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody LoginResponse login(@RequestBody LoginRequest loginRequest) {
		
		log.info("request content: " + loginRequest);

		LoginResponse login = usersService.login(loginRequest);
		
		return login;
	}
	
}
