package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.Status;
import com.atguigu.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiu
 * @create 2021-11-28 16:58
 */
public class OrderDaoImpl implements OrderDao {
  private  DBUtil dbUtil = new DBUtil();
    {
        dbUtil.getConnection();
    }

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,total_money,status,user_id) values(?,?,?,?,?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(order.getCreateTime().getTime());
//        这里的日期转为固定格式的字符串，就可以直接存进去了,这里的状态也要转为Integer
        dbUtil.executeUpdate(sql, new Object[]{order.getOrderId(), format , order.getPrice(),order.getStatus().getStatus(), order.getUserId()});
    }

    @Override
    public ArrayList<Order> queryOrders() {
        String sql = "SELECT t.*\n" +
                "      FROM book.t_order t\n" +
                "      ORDER BY create_time desc ";
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[]{});
        ArrayList<Order> orders = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                String order_id = resultSet.getString("order_id");
                Date create_time = resultSet.getDate("create_time");
                BigDecimal total_money = resultSet.getBigDecimal("total_money");
                int status = resultSet.getInt("status");
                Status status2 = IntegerToStatus(status);
                int user_id = resultSet.getInt("user_id");
                Order order = new Order(order_id, create_time, total_money, status2, user_id);
                orders.add(order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  orders;
    }

    /**
     * 将Integer转为Status的对象
     * @param status
     * @return 有对应的返回对应的，没有默认为Status.UNSHIPPED
     */
    private Status IntegerToStatus(int status) {
        Status status1 = null;
        switch (status){
            case 0:
                status1=Status.UNSHIPPED;
                break;
            case 1:
                status1=Status.DELIVERY;
                break;
            case 2:
                status1=Status.RECEIVE;
                break;
            default:
                status1=Status.UNSHIPPED;
        }
        return status1;
    }

    /**
     * 改变订单状态
     * @param orderId 订单id
     * @param status 改变后的 status
     */
    @Override
    public Integer changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set status=?  where order_id=?";
        return  dbUtil.executeUpdate(sql, new Object[]{status,orderId});
    }

    /**
     * 根据userid查询订单
     * @param userId userid值
     * @return 有返回订单，无返回null
     */
    @Override
    public HashMap<String, Order> queryOrderByUserId(Integer userId) {
        String sql = "select * from t_order where user_id=? order by create_time desc";
        Order order=null;
        HashMap<String, Order> map = new HashMap<>();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[]{String.valueOf(userId)});
        while (true) {
            try {
                if (!resultSet.next()) break;
                String order_id = resultSet.getString("order_id");
                Date create_time = resultSet.getDate("create_time");
                BigDecimal total_money = resultSet.getBigDecimal("total_money");
                int status = resultSet.getInt("status");
                int user_id = resultSet.getInt("user_id");
//                这里将Integer转为Status的状态
                Status status1 = IntegerToStatus(status);
                order = new Order(order_id, create_time, total_money, status1, user_id);

                 map.put(order_id, order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  map;
    }
}
