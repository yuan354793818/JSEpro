package com.test.service;

import com.test.dao.TestDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class TestService {

    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public TestService(TestDao testDao) {
        System.out.println("test service create inject testDao");
        this.testDao = testDao;
    }

    public TestService() {

    }
    @PostConstruct
    private void init() {
        System.out.println("test service init");
    }

    @PreDestroy
    private void destory() {
        System.out.println("test service destory");
    }
}
