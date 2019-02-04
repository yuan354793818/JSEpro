package com.test.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;
}
