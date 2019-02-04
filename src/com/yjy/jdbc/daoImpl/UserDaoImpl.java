package com.yjy.jdbc.daoImpl;

import com.yjy.jdbc.dao.UserDao;
import com.yjy.jdbc.util.JDBCUtil;
import com.yjy.jdbc.util.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by YJY on 2018/9/26.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        Connection conn=null;
        Statement st=null;
        ResultSet rt=null;
        List<User> list=new ArrayList<>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String str="select * from person";
            rt=st.executeQuery(str);
            while (rt.next()){

                int id=rt.getInt("id");
                String name=rt.getString("name");
                String psword=rt.getString("password");
                list.add(new User(id,name,psword));
                System.out.println(id+"  "+name+"   "+psword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rt,st,conn);
        }
        return list;

    }

    public User login(String name, String psword) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtil.getConnection();
            String str="select * from person WHERE name=? AND password=?";
            ps=conn.prepareStatement(str);
            ps.setString(1,name);
            ps.setString(2,psword);
            rs=ps.executeQuery();
          if(rs.next()){
              int id=rs.getInt("id");
              String name1=rs.getString("name");
              String psword1=rs.getString("password");
              System.out.println("success");
              return new User(id,name,psword);
          }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs,ps,conn);
        }
        System.out.println("fail");
        return  null;

    }

    @Override
    public int update(int id, String name, String password) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtil.getConnection();
            String str="UPDATE  person SET name=?,password=? WHERE id=?";
            ps=conn.prepareStatement(str);
            ps.setString(1,name);
            ps.setString(2,password);
            ps.setInt(3,id);
            int rt=ps.executeUpdate();
            if(rt>0){
                System.out.println("success");
                return rt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null,ps,conn);
        }
        System.out.println("fail");
        return 0;
    }

    @Override
    public int delete(String name, String psword) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtil.getConnection();
            String str="DELETE FROM  person WHERE name =? AND password=?";
            ps=conn.prepareStatement(str);
            ps.setString(1,name);
            ps.setString(2,psword);
            int rt=ps.executeUpdate();
            if(rt>0){
                System.out.println("success");
                return rt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null,ps,conn);
        }
        System.out.println("fail");
        return 0;
    }

    @Override
    public int insert(String name, String psword) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtil.getConnection();
            String str="INSERT INTO  person (name,password) VALUES (?,?)";
            ps=conn.prepareStatement(str);
            ps.setString(1,name);
            ps.setString(2,psword);
            int rt=ps.executeUpdate();
            if(rt>0){
                System.out.println("success");
                return rt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null,ps,conn);
        }
        System.out.println("fail");
        return 0;

    }

    /*@Override
    public boolean login(String name, String psword) {
        Connection conn=null;
        Statement st=null;
        ResultSet rt=null;
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            //String str="select * from person WHERE name='"+name+"'";
            String str="select * from person WHERE name='"+name+"'AND password='"+psword+"'";
            rt=st.executeQuery(str);
            StringBuffer sb=new StringBuffer();
            while (rt.next()){
                String getPswd=rt.getString("password");
                if(Objects.equals(getPswd,psword)){
                    System.out.println("success");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rt,st,conn);
        }
        System.out.println("fail");
        return  false;

    }*/
}
