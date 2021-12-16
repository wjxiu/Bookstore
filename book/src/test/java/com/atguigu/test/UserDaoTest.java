package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-10-17 18:05
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin = userDao.queryUserByUsername("wujinxiu3");
        System.out.println(admin);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin = userDao.queryUserByUsernameAndPassword("admin","admin");
        System.out.println(admin);
    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User wujinxiu = new User( "wujinxiu3", "1234562", "1qwe@qq.com");
        int i = userDao.saveUser(wujinxiu);
        System.out.println(i);
    }
    @Test
    public void test(){
        System.out.println(35%4);
    }
}