package com.dlmu.graduation.controller;

import com.dlmu.graduation.model.RegisterRequest;
import com.dlmu.graduation.model.RegisterResponse;
import com.dlmu.graduation.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *注册 
 */
@Controller
public class RegisterController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody RegisterResponse register(@RequestBody RegisterRequest registerRequest) {

        return usersService.register(registerRequest);
    } 

}