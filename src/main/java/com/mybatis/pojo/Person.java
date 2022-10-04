package com.mybatis.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private int id;
    private String name;
    private int age;
    private String sex;
    //关连属性
    private IdCard idcard;
}
