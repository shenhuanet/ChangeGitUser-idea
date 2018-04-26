package com.shenhua.idea.plugin.changegituser.etc;

import com.google.gson.annotations.SerializedName;

/**
 * gitBean
 * Created by shenhua on 2018/4/25.
 */
public class GitBean {

    @SerializedName("name")
    private String username;
    @SerializedName("email")
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

    @Override
    public String toString() {
        return username + " -- " + userEmail;
    }
}
