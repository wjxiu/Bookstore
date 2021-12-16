package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author xiu
 * @create 2021-10-17 16:41
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null说明没有该用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息，用于登录验证
     * @param username 用户名
     * @param password 用户密码
     * @return 如果返回null说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);
}
