package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiu
 * @create 2021-12-02 16:13
 */
public interface OrderService {
     public String createOrder(Cart cart, Integer userId);
     public HashMap myOrders(Integer userid);
     public ArrayList<OrderItem> orderDetails(String orderid);
     public ArrayList<Order> allOrders();
     public Integer sendOrder(String orderid);
     public Integer receiveOrder(String orderid);
}
