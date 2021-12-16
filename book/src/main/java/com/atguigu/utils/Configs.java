package com.atguigu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件操作类
 * @author xiu
 * @create 2021-10-08 20:01
 */
public class Configs {
   private static Properties properties;
    static {
         properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Code\\javaweb\\book\\src\\main\\java\\com\\atguigu\\utils\\MySqlConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getValue(String key){
        return properties.get(key).toString();
    }

    public static void main(String[] args) {
        System.out.println(Configs.getValue("username"));
        System.out.println(Configs.getValue("pwd"));
    }
}
