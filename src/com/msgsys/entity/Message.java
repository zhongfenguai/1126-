package com.msgsys.entity;

import java.sql.Timestamp;

/**
 * 作者：chenbingfeng
 * 日期: 2020/11/26 15:42
 * 描述:
 */
public class Message {
    private Integer id;
    private Integer fromUid;
    private Integer toUid;
    private String mTitle;
    private String mContent;
    private Integer readFlag;
    private String createTime;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", mTitle='" + mTitle + '\'' +
                ", mContent='" + mContent + '\'' +
                ", readFlag=" + readFlag +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Message(Integer fromUid, Integer toUid, String mTitle, String mContent, Integer readFlag, String createTime) {
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.readFlag = readFlag;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Message() {
    }

    public Message(Integer id, Integer fromUid, Integer toUid, String mTitle, String mContent, Integer readFlag, String createTime) {
        this.id = id;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.readFlag = readFlag;
        this.createTime = createTime;
    }
}