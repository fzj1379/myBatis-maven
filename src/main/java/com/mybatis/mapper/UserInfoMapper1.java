package com.mybatis.mapper;

import com.mybatis.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper1 {
    UserInfo findUserInfoById(int id);

    UserInfo queryUserInfoById(int i);

    UserInfo findUserInfoByUserName(String userName);

    List<UserInfo> findUserInfoByUserName2(String userName);

    List<UserInfo> findUserInfoByCondition(UserInfo ui);
}
