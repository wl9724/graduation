package com.dlmu.graduation.model;

import lombok.Data;

/**
 * 获取用户信息响应类
 */
@Data
public class InformationResponse {

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

}