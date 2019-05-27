package com.test.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
    public TestDao() {
        System.out.println("dao init");
    }
}
