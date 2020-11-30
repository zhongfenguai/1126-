package com.msgsys.service;

import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 16:50
 * 描述:
 */
public interface UserService {
    //注册
    int register(User user);

    //登录
    User login(User user);

    int insert(User user);

    int update(User user);

    int delete(Integer id);

    List<User> queryAll();

    User queryUserById(Integer id);

    User queryUserByEmail(String email);

    User queryUserByUsername(String usernmae);

}
