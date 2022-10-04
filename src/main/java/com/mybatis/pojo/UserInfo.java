package com.mybatis.pojo;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String sex;
    private String address;
    private String email;
    private String regDate;
    private int states;
}
