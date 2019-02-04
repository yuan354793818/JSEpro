package com.yjy.jdbc.test;

import com.yjy.jdbc.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by YJY on 2018/9/25.
 */
public class jdbctestTest {
    @Test
    public void insertTest(){
        Connection con= JDBCUtil.getConnection();
        try {
            Statement st=con.createStatement();
            String query="INSERT  INTO  person (name,phnum) VALUE ('kjkl',889)";
            int rs = st.executeUpdate(query);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
    @Test
    public void updateTest(){
        Connection con= JDBCUtil.getConnection();
        try {
            Statement st=con.createStatement();
            String query="UPDATE  person SET name='yjyyy' WHERE phnum=88";
            int rs = st.executeUpdate(query);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
    @Test
    public void deleteTest(){
        Connection con= JDBCUtil.getConnection();
        try {
            Statement st=con.createStatement();
            String query="DELETE FROM person WHERE phnum=5445";
            int rs = st.executeUpdate(query);
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}