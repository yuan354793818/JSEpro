package com.yjy.jdbc;

import com.yjy.jdbc.util.JDBCUtil;

import java.sql.*;

/**
 * Created by YJY on 2018/9/25.
 */
public class MySqlDemo {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            st = con.createStatement();
            String str = "select * from person";
            rs = st.executeQuery(str);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                System.out.println(id + " " + name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, st, con);
        }
    }
}
