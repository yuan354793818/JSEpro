package com.yjy.jdbc;

import com.yjy.jdbc.util.JDBCUtil;

import java.sql.*;

public class BatchInsert {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st = null;


        try {
            con = JDBCUtil.getConnection();
            st = con.prepareStatement("insert into person(name,password) values(?,?)");
            for (int i = 0; i < 10; i++) {
                st.setString(1,"yyy"+i);
                st.setString(2,"12345");
                st.addBatch();
            }

            st.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

        }
    }
}
