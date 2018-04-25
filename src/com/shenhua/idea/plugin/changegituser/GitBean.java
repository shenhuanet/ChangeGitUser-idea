package com.shenhua.idea.plugin.changegituser;

/**
 * Created by Administrator on 2018/4/25.
 */
public class GitBean {

    private String username;
    private String userEmail;

    public GitBean(String username, String userEmail) {
        this.username = username;
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
