package com.atguigu.service.impl;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-12-03 22:09
 */
public class OrderServiceImplTest {
    OrderServiceImpl orderService=new OrderServiceImpl();
    OrderItemDaoImpl itemDao=new OrderItemDaoImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        orderService.createOrder(cart,1);
    }

    @Test
    public void myOrders() {
        HashMap<String, Order> stringOrderHashMap = orderService.myOrders(1);
        System.out.println(stringOrderHashMap);
    }

    @Test
    public void orderDetails() {
        ArrayList<OrderItem> hashMap = orderService.orderDetails("1");
        System.out.println(hashMap);
    }

    @Test
    public void allOrders() {
        ArrayList<Order> list = orderService.allOrders();
        System.out.println(list);
    }

    @Test
    public void sendOrder() {
        System.out.println(orderService.sendOrder("222"));
    }
    @Test
    public void receiveOrder() {
        System.out.println(orderService.receiveOrder("3"));
    }


}