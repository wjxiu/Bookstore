package com.atguigu.utils;

import com.atguigu.utils.Configs;

import java.sql.*;

/**
 * @author xiu
 * @create 2021-10-08 20:10
 */
public class DBUtil {
    private Connection conn=null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;

    /**
     * 获得连接
     * @return 返回连接
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection() {
        String driver = Configs.getValue("driver");
        String url = Configs.getValue("url");
        String username = Configs.getValue("username");
        String pwd = Configs.getValue("pwd");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * 执行预编译sql语句
     * 命令种类为增删改
     * @param sql 待执行预编译sql语句
     * @param para 为占位符设置参数
     * @return 结果集
     */
    public ResultSet executeQuery(String sql,String[]para) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            if (para!=null) {
                for (int i=0;i<para.length;i++) {
                    preparedStatement.setString(i+1,para[i]);
                }
                 resultSet = preparedStatement.executeQuery();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    /**
     *
     * @param sql 待执行预编译sql语句
     * @param para 为占位符设置参数
     * @return 修改的结果 两种情况： 返回1为成功，返回0为失败
     */
    public int executeUpdate(String sql,Object[]para){
        int result=0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            if (para != null) {
                for (int i = 0; i < para.length; i++) {
                    preparedStatement.setString(i + 1, String.valueOf(para[i]));
                }
                 result = preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }
    public void closeAll()  {
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (conn!=null){
                conn.close();
            }
            System.out.println("关闭成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
