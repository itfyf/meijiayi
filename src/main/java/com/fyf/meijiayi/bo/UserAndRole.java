package com.fyf.meijiayi.bo;

import java.io.Serializable;

public class UserAndRole implements Serializable {

    private int id;
    private String usercode;
    private String username;
    private int gender;
    private String address;
    private String phone;
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getUsercode() {
        return usercode;
    }

    public String getUsername() {
        return username;
    }

    public int getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getRolename() {
        return rolename;
    }


    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
