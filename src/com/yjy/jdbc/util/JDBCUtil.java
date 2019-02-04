package com.yjy.jdbc.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Created by YJY on 2018/9/25.
 */
public class JDBCUtil {

    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    static {
        InputStream is = null;
        try {
          //String path =Thread.currentThread().getContextClassLoader().getResource  ("jdbc/jdbc.properties").getPath();

            is =JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties ppt = new Properties();
            ppt.load(is);             //11111111111111111111111
            driverClass = ppt.getProperty("driverClass");
            url = ppt.getProperty("url");
            name = ppt.getProperty("name");
            password = ppt.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static Connection getConnection() {
        Connection con = null;
        try {

            Class.forName(driverClass);
            con = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void release(ResultSet rs, Statement st, Connection con) {
        closeRs(rs);
        closeSt(st);
        closeCon(con);
    }


    public static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }
    }

    public static void closeSt(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            st = null;
        }
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null;
        }
    }
}
