package com.msgsys.service;

import com.msgsys.entity.Message;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 18:56
 * 描述:
 */
public interface MessageService {
    //根据收信人id 查询邮件
    List<Message> queryMessageByToUid(Integer id);
    //根据收信人的id查询邮件
    Message queryMessageByid(Integer id);
}
