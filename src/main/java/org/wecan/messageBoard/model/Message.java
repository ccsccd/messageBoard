package org.wecan.messageBoard.model;

import java.util.List;

public class Message {
    private int id;
    private String username;
    private String text;
    private int pid;
    private String createTime;
    private String updateTime;
    private int userId;
    private List<Message> childContent;

    public Message() {
    }

    public Message(String username, String text, int pid,int userId) {
        this.username = username;
        this.text = text;
        this.pid = pid;
        this.userId = userId;
    }

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Message> getChildContent() {
        return childContent;
    }

    public void setChildContent(List<Message> childContent) {
        this.childContent = childContent;
    }
}
