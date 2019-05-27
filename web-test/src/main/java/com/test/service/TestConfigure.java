package com.test.service;

import com.test.dao.TestDao;
import org.springframework.context.annotation.Bean;

//@Configuration
public class TestConfigure {
    @Bean
    public TestService testService(TestDao testDao){

        return new TestService(testDao);

       /* TestService testService = new TestService();
        testService.setTestDao(testDao);
        return testService;*/
    }
    @Bean
    TestDao testDao() {
        return new TestDao();
    }
}
