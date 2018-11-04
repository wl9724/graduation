package com.dlmu.graduation.controller;

import com.dlmu.graduation.model.InformationRequest;
import com.dlmu.graduation.model.InformationResponse;
import com.dlmu.graduation.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取用户信息
 */
@Controller
public class InformationController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "getInformation" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody InformationResponse gInformationResponse(@RequestBody InformationRequest informationRequest) {

        return usersService.getInformation(informationRequest);

    }


}