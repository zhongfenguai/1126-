package com.msgsys.dao;

import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 15:51
 * 描述:
 */
public interface UserDao {
    int insert(User user);
    int update(User user);
    int delete(Integer id);
    List<User> queryAll();
    User queryUserById(Integer id);
    User queryUserByNameAndPassword(User user);
}
