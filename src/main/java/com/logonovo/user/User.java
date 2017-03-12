package com.logonovo.user;

import java.io.Serializable;

/**
 * Created by logonovo on 2017/3/11.
 */
public class User implements Serializable {

    private String userName;
    private long id;

    public User(String userName, long id) {
        this.userName = userName;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
