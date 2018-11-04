package com.dlmu.graduation.controller;

import com.dlmu.graduation.model.UpdateRequest;
import com.dlmu.graduation.model.UpdateResponse;
import com.dlmu.graduation.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 修改用户信息
 */
@Controller
public class UpdateController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody UpdateResponse update(@RequestBody UpdateRequest updateRequest) {
        
        return usersService.update(updateRequest);
    }
}