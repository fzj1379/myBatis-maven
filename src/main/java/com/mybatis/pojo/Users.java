package com.mybatis.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Users {
    private int uid;
    private String uname;
    private String upass;
}
