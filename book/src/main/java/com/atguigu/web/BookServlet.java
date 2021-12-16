package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xiu
 * @create 2021-11-11 20:49
 */
@WebServlet("/manager/bookservlet")
public class BookServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

//        1.获取请求的参数 封装为book对象
        Book book = Webutils.copyParameterToBean(req.getParameterMap(), new Book());
//          调用添加图书功能
        bookService.addBook(book);
        String pageNo = req.getParameter("pageNo");
//        这里要重定向，如果是请求转发的话，刷新后还能提交，因为刷新后浏览器会提交最后一次请求
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo="+pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer integer = Webutils.StringToInteger(id, 0);
        bookService.deleteBookById(integer);
        String pageNo = req.getParameter("pageNo");
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo="+pageNo);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = Webutils.copyParameterToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        String pageNo = req.getParameter("pageNo");
        resp.sendRedirect(req.getContextPath() + "/manager/bookservlet?action=page&pageNo="+pageNo);

    }

    //    显示列表到网页上
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    public void getbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer integer = Webutils.StringToInteger(id, 0);
        Book book = bookService.queryBookById(integer);
        req.setAttribute("querybook", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    /**
     * 进行分页操作，将分页后的结果保存到request域中
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        Integer pageno = Webutils.StringToInteger(pageNo, 1);
        Page<Book> pages = bookService.pages(pageno , Page.PAGE_SIZE);
        pages.setUrl("/manager/bookservlet?action=page");
        req.setAttribute("page", pages);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}

