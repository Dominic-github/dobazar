package com.androidafe.dobazar.model;

public class UserResponse {

    private int id;
    private int code;
    private String msg;

    public UserResponse(int code, String msg, int id) {
        this.code = code;
        this.msg = msg;
        this.id = id;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {this.id = id;}
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
