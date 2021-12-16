package com.atguigu.web;

import com.atguigu.pojo.*;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @author xiu
 * @create 2021-12-03 22:39
 */
@WebServlet("/orderservlet")
public class OrderServlet extends BaseServlet {
    // 购物车里边的书籍id和数量组成的集合
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    private OrderServiceImpl orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        String orderid = orderService.createOrder(cart, user.getId());
//     这里将购物车的的书籍的id和数量保存起来，发货方法需要用到这个集合
        List<CartItems> items = cart.getItems();
        for (int i = 0; i < items.size(); i++) {
            CartItems cartItems = items.get(i);
            Integer id = cartItems.getId();
            Integer count = cartItems.getCount();
            hashMap.put(id, count);
        }
        cart.clear();
        session.setAttribute("orderid", orderid);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 我的订单列表
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void myOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
//        这里返回的是map所以，排不排序都一样
        HashMap<String, Order> map = orderService.myOrders(user.getId());
        session.setAttribute("myorders", map);
        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    /**
     * 订单详情
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderid = req.getParameter("orderid");
        ArrayList<OrderItem> list = orderService.orderDetails(orderid);
        req.setAttribute("orderdetails", list);
        req.getRequestDispatcher("/pages/order/orderdetail.jsp").forward(req, resp);
    }

    /**
     * 查看所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Order> orders = orderService.allOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    /**
     * 发货
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        String orderid = req.getParameter("orderid");
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
//         遍历拿到bookid
            Integer bookid = iterator.next().getKey();
            // 遍历拿到book数量
            Integer count = hashMap.get(bookid);
            Book book = bookService.queryBookById(bookid);
//            分别对销量和库存设置
            book.setSaleds(book.getSaleds() + count);
            book.setStock(book.getStock() - count);
//            更新书籍信息
            bookService.updateBook(book);
        }
        orderService.sendOrder(orderid);
        resp.sendRedirect(req.getContextPath() + "/orderservlet?action=allOrders");

    }

    /**
     * 收货
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderid = req.getParameter("orderid");
        orderService.receiveOrder(orderid);
        resp.sendRedirect(req.getContextPath() + "/orderservlet?action=allOrders");
    }
}
