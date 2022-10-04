package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private int isbn;
    private String name;
    private String kind;
}
