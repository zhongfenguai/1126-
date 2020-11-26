package com.msgsys.dao;

import com.msgsys.entity.Message;
import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 15:51
 * 描述:
 */
public interface MessageDao {
    int insert(Message message);

    int update(Message message);

    int delete(Integer id);

    List<Message> queryAll();

    Message queryMessageById(Integer id);

    //根据收信人id 查询邮件
    List<Message> queryMessageByToUid(Integer id);

}
