package com.fyf.meijiayi.bo;

import java.io.Serializable;

public class UserPass implements Serializable {
    private String uid;
    private String oldpassword;
    private String newpassword;

    public String getUid() {
        return uid;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
