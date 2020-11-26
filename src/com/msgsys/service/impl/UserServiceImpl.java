package com.msgsys.service.impl;

import com.msgsys.dao.UserDao;
import com.msgsys.dao.impl.UserDaoImpl;
import com.msgsys.entity.User;
import com.msgsys.service.UserService;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 16:55
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public int register(User user) {
        return userDao.insert(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
