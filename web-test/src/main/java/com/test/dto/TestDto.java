package com.test.dto;

import org.springframework.stereotype.Component;

@Component
public class TestDto {

    private String msg;

    private Integer count ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTag() {
        return "<h2 style='color:red'>THIS IS HEAD</h2>";
    }
}
