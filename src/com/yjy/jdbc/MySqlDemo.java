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
            String str = "select * from blog";
            rs = st.executeQuery(str);
            while (rs.next()) {
                int id = rs.getInt("blog_id");
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, st, con);
        }
    }
}
