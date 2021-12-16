package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-10-17 22:29
 */
public class UserServiceTest {
    UserServiceImpl userDao = new UserServiceImpl();
    @Test
    public void regisetUser() {
//        userDao.regisetUser(new User("wujinxiu5", "1234566","122@qq.cm"));
    }

    @Test
    public void login() {
//        userDao.login(new User("wu1jinxhhhhiu5", "123456hh6","122@qq.cm") );


    }

    @Test
    public void existUser() {
//        System.out.println(userDao.existUser("wujinxiu"));
    }
}