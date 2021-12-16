package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.Status;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-12-02 13:25
 */
public class OrderDaoImplTest {
    OrderDaoImpl orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Long date1 = new Date().getTime();
        Order order = new Order("3", new Date(), new BigDecimal(11), Status.DELIVERY, 1);
        orderDao.saveOrder(order);
    }

    @Test
    public void queryOrders() {
        ArrayList<Order> list =  orderDao.queryOrders();
        System.out.println(list);
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("1", 999);
    }

    @Test
    public void queryOrderByUserId() {
        System.out.println(orderDao.queryOrderByUserId(1));
    }
}