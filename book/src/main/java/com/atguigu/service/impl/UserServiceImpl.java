package com.atguigu.service.impl;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 * @author xiu
 * @create 2021-10-17 22:19
 */
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public void regisetUser(User user) {
         userDao.saveUser(user);
    }

    /**
     *
     * @param user
     * @return 如果返回null说明用户名或密码错误，反之亦然
     */
    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 查看用户名是否存在
     * @param user
     * @return 存在返回true,不存在返回false
     */
    @Override
    public boolean existUser(String user) {
        if (userDao.queryUserByUsername(user)==null){
            return false;
        }
        return true;
    }
}
