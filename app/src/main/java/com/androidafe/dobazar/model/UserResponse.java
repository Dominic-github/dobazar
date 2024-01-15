package com.androidafe.dobazar.model;

public class UserResponse {
    private int code;
    private String msg;

    private int id;

    public UserResponse(int id,int code, String msg) {
        this.id = id;
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
