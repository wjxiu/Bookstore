package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * 一个业务一个方法
 * @author xiu
 * @create 2021-10-17 22:14
 */
public interface UserService {
    /**
     * 注册用户业务
     * @param user
     */
    public void regisetUser(User user);

    /**
     * 登录业务
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 校验用户名是否可用
     * @param username
     * @return  true表示用户名已经存在，false表示用户名不存在，可用
     */
    public boolean existUser(String username);
}
