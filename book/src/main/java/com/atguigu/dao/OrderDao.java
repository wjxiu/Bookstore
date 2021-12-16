package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiu
 * @create 2021-11-28 16:41
 */
public interface OrderDao {
   public void saveOrder(Order order);
   public ArrayList<Order> queryOrders();
   public Integer changeOrderStatus(String orderId,Integer status);
   public HashMap<String,Order>  queryOrderByUserId(Integer userId);
}
