package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItems;
import com.atguigu.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author xiu
 * @create 2021-11-20 11:35
 */
@WebServlet("/cartservlet")
public class CartServlet extends BaseServlet{
    Cart cart=new Cart();
    protected void addItem(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Integer id = Webutils.StringToInteger(req.getParameter("id"), 0);
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        CartItems c = new CartItems(id, name, 1, price);
//        将这个商品添加到集合中
        cart.addItem(c);
        req.getSession().setAttribute("cart", cart);
//        回到原来的地址
        resp.sendRedirect(req.getHeader("Referer"));
//        将最后添加的商品添加到session中，并且回显在首页中
        req.getSession().setAttribute("LastName", c.getName());
    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String id = req.getParameter("id");
        Integer  integer= Webutils.StringToInteger(id, 0);
        cart.deleteItem(integer);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        cart.clear();
        //        回到原来的地址
        resp.sendRedirect(req.getHeader("Referer"));

    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id=0;
        int count=0;
        cart.updateCount(id, count);

    }
    protected void cart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }


    }
