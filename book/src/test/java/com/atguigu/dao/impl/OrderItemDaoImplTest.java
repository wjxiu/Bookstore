package com.atguigu.dao.impl;

import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-12-03 21:34
 */
public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
//        OrderItem aa = new OrderItem(2, "aa", new BigDecimal(12), 1, new BigDecimal(1), "1");
        OrderItem aa = new OrderItem(2, "aa", new BigDecimal(12), 1, new BigDecimal(1), "1");
        orderItemDao.saveOrderItem(aa,1);
    }

    @Test
    public void queryOrderDetailByOrderId() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        System.out.println(orderItemDao.queryOrderDetailByOrderId("1"));

    }

    @Test
    public void testSaveOrderItem() {
    }

    @Test
    public void testQueryOrderDetailByOrderId() {
    }
}