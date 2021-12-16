package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.utils.DBUtil;
import org.junit.runner.manipulation.Ordering;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiu
 * @create 2021-12-02 16:21
 */
public class OrderItemDaoImpl {
    public void saveOrderItem(OrderItem item,Integer userid) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        String sql = "insert into t_order_item(name,price,total_money,count,order_id)values(?,?,?,?,?)";
        dbUtil.executeUpdate(sql, new Object[]{ item.getName(), item.getPrice(), item.getTotalPrice(), item.getCount(), item.getOrderId()});
    }
    public ArrayList<OrderItem> queryOrderDetailByOrderId(String orderid) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        String sql = "select * from t_order_item where order_id=?";
        String[] strings = new String[]{String.valueOf(orderid)};
        ResultSet resultSet = dbUtil.executeQuery(sql, strings);
        ArrayList<OrderItem> orders = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal totalMoney = resultSet.getBigDecimal("total_money");
                int count = resultSet.getInt("count");
                String order_id = resultSet.getString("order_id");
                OrderItem order = new OrderItem(id, name, price, count, totalMoney, order_id);
                orders.add(order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return orders;

    }
}