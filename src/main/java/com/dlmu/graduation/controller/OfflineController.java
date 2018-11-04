package com.dlmu.graduation.controller;

import com.dlmu.graduation.model.OfflineRequest;
import com.dlmu.graduation.model.OfflineResponse;
import com.dlmu.graduation.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 下线
 */
@Controller
public class OfflineController {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "offline", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody OfflineResponse offline(@RequestBody OfflineRequest offlineRequest) {

        return usersService.offline(offlineRequest);
    }

}