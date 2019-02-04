package com.yjy.jdbc.test;

import com.yjy.jdbc.util.JDBCUtil;

import java.sql.*;

/**
 * Created by YJY on 2018/9/25.
 */
public class jdbctest {
    public static void main(String[] args) {
        Connection con= JDBCUtil.getConnection();
        try {
            PreparedStatement st=con.prepareStatement("select * from person");
            ResultSetMetaData metaData = st.getMetaData();
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }

}
