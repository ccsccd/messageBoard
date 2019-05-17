package org.wecan.messageBoard.model;

import java.util.List;

public class Message {
    private int id;
    private String username;
    private String text;
    private int pid;
    private List<Message> childContent;

    public Message() {
    }

    public Message(String username, String text, int pid) {
        this.username = username;
        this.text = text;
        this.pid = pid;
    }

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public void setChildContent(List<Message> childList) {
        this.childContent = childList;
    }

    public List<Message> getChildContent() {
        return childContent;
    }

    public int getPid() {
        return pid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
