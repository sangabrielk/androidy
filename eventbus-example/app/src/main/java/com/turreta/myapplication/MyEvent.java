package com.turreta.myapplication;

public class MyEvent {
    private int code;
    private String from;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MyEvent(int code, String from, String data) {
        this.code = code;
        this.from = from;
        this.data = data;
    }
}
