package com.atguigu.service.impl;

import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiu
 * @create 2021-12-03 21:59
 */
public class OrderServiceImpl implements OrderService {
  private  OrderDaoImpl orderDao=new OrderDaoImpl();
   private OrderItemDaoImpl itemDao=new OrderItemDaoImpl();

    /**
     * 保存订单到数据库，并且将订单号作为返回值
     *         时间戳作为order_id(临时的)
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String s = String.valueOf(new Date().getTime());
        Order order = new Order(s, new Date(),
                BigDecimal.valueOf(cart.getTotalPrice()), Status.UNSHIPPED, userId);
        orderDao.saveOrder(order);
        List<CartItems> items = cart.getItems();
        System.out.println(items);
        for (int i = 0; i < items.size(); i++) {
            CartItems cartItems = items.get(i);
            OrderItem orderItem = new OrderItem(cartItems.getId(),cartItems.getName(), BigDecimal.valueOf(cartItems.getPrice()), cartItems.getCount(), BigDecimal.valueOf(cartItems.getTotalPrice()), s);
            itemDao.saveOrderItem(orderItem,userId);
            System.out.println(orderItem);
        }
        return s;
    }

    /**
     *客户查找我的订单
     * @param userid
     * @return 键
     */
    @Override
    public HashMap<String, Order> myOrders(Integer userid) {
        return orderDao.queryOrderByUserId(userid);
    }

    /**
     * 根据订单id查找该订单的订单项
     * @param orderid
     * @return 该订单的订单项的集合
     */
    @Override
    public ArrayList<OrderItem> orderDetails(String orderid) {
        return itemDao.queryOrderDetailByOrderId(orderid);
    }

    /**
     * 列出所有订单
     * @return 订单集合
     */
    @Override
    public ArrayList<Order> allOrders() {
        return orderDao.queryOrders();
    }

    /**
     * 根据orderid修改订单的状态为发货
     * @param orderid
     * @return 发货状态
     */
    @Override
    public Integer sendOrder(String orderid) {
      return  orderDao.changeOrderStatus(orderid,1);
    }

    /**
     * 根据orderid修改订单的状态为收货
     * @param orderid
     * @return 发货状态
     */
    @Override
    public Integer receiveOrder(String orderid) {
      return  orderDao.changeOrderStatus(orderid,2);
    }
}
