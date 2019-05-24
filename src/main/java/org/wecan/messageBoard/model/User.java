package org.wecan.messageBoard.model;

public class User {
    private int id;
    private String username;
    private String eMail;
    private String password;
    private String createTime;
    private String updateTime;

    public User() {
    }

    public User(String eMail, String password) {
        this.eMail = eMail;
        this.password = password;
    }

    public User(String username, String eMail, String password) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;
    }

    public User(int id, String username, String eMail, String createTime) {
        this.id = id;
        this.username = username;
        this.eMail = eMail;
        this.createTime = createTime;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
