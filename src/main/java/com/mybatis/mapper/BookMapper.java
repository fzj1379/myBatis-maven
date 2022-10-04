package com.mybatis.mapper;

import com.mybatis.pojo.Book;

public interface BookMapper {
    Book findBookByISBN(int isbn);
    Book findBookByName(String name);
}
