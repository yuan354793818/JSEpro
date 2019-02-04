package com.yjy.jdbc.test;

import com.yjy.jdbc.dao.UserDao;
import com.yjy.jdbc.daoImpl.UserDaoImpl;
import org.junit.Test;

/**
 * Created by YJY on 2018/9/26.
 */
public class TestDaoImpl {
    @Test
    public void testFindAll(){
        UserDao userDao=new UserDaoImpl();
        userDao.findAll();

    }
    @Test
    public void testLogin(){
        UserDao userDao=new UserDaoImpl();
        userDao.login("yjy","88");
    }
    @Test
    public void testInsert(){
        UserDao userDao=new UserDaoImpl();
        userDao.insert("mmmm","8822");
    }
    @Test
    public void testDelete(){
        UserDao userDao=new UserDaoImpl();
        userDao.delete("43","34");
    }
    @Test
    public void testUpdate(){
        UserDao userDao=new UserDaoImpl();
        userDao.update(14,"gffd","1111");
    }

}
