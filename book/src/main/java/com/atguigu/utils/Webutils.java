package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xiu
 * @create 2021-10-28 20:09
 */
public class Webutils {
    private int i;

    /**
     *把map的值注入到javabean的属性
     * @param map
     * @param user
     * @return
     */
    public static <T> T  copyParameterToBean(Map map, T user){
        try {
            //注入操作
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static Integer StringToInteger(String s ,Integer defult){
        try {
            int i = Integer.parseInt(s);
            return i;
        } catch (NumberFormatException ignored) {
        }
        return defult;

    }
}
