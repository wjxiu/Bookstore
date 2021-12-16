package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xiu
 * @create 2021-10-17 16:49
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User queryUserByUsername(String username)  {
        String sql="select * from t_user where username=?";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        String[] strings = new String[]{username};
        ResultSet resultSet = dbUtil.executeQuery(sql, strings);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username1=  resultSet.getString(2);
                String password=  resultSet.getString(3);
                String email=  resultSet.getString(4);
                return  new User(id,username1,password,email);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select * from t_user where username=? and password=?";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        String[] strings = new String[]{username,password};
        ResultSet resultSet = dbUtil.executeQuery(sql, strings);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username1=  resultSet.getString(2);
                String password1=  resultSet.getString(3);
                String email=  resultSet.getString(4);
                return  new User(id,username1,password1,email);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int saveUser(User user) {
        String sql="INSERT INTO  t_user (username,`password`,email)" +
                " VALUES(?,?,?);";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        String[] strings = new String[]{user.getUsername(),user.getPassword(),user.getEmail()};
        return dbUtil.executeUpdate(sql, strings);
    }
}
