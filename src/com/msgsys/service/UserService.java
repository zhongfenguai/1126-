package com.msgsys.service;

import com.msgsys.entity.User;

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

}
