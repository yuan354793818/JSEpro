package com.yjy.jdbc.dao;

import com.yjy.jdbc.util.User;

import java.util.List;

/**
 * Created by YJY on 2018/9/26.
 */
public interface UserDao {
    /**
     * 查询整个表
     */
    public List<User> findAll();
    /**
     * user login vertification
     */
    public User login(String name, String psword);
    public int insert(String name, String psword);
    public int delete(String name, String psword);
    public int update(int id, String name,String pasword);
}
