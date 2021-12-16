package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiu
 * @create 2021-11-17 22:37
 */
@WebServlet("/client/bookservlet")
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        Integer pageno = Webutils.StringToInteger(pageNo, 1);
        Page<Book> pages = bookService.pages(pageno, Page.PAGE_SIZE);
        pages.setUrl("/client/bookservlet?action=page");
        req.setAttribute("page", pages);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    public void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = Webutils.StringToInteger(req.getParameter("pageNo"), 1);
        Integer min = Webutils.StringToInteger(req.getParameter("min"), 0);
        Integer max = Webutils.StringToInteger(req.getParameter("max"), Integer.MAX_VALUE);
        Integer pageSize = Webutils.StringToInteger(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> bookPage = bookService.pageByPrice(pageNo, pageSize, min, max);
        bookPage.setUrl("/client/bookservlet?action=pageByPrice");
        req.setAttribute("page", bookPage);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}