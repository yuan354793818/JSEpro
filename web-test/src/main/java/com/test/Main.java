package com.test;

import com.alibaba.fastjson.JSON;
import hacksys.HackSystem;
import org.junit.Test;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(HackSystem.class.getClassLoader());
        HackSystem.getBufferString();
    }

    @Test
    public void test1() {
        String json = "{\"name\":\"test\"}";
        JSON.parseObject(json, HashMap.class);
    }
}
