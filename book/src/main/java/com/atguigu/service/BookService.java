package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xiu
 * @create 2021-11-07 22:05
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Page<Book> pages(Integer integer, Integer integer1);
    public Page<Book> pageByPrice(Integer pageNo,Integer pageSize,Integer min,Integer max);

    }