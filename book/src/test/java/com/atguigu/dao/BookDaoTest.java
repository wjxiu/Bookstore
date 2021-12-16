package com.atguigu.dao;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-11-13 14:36
 */
public class BookDaoTest {
    BookDao bookDao=new BookDaoImpl();
    @Test
    public void queryForTotalCount() {
        Integer count = bookDao.queryForTotalCount();
        System.out.println(count);

    }

    @Test
    public void queryForItems() {
        List<Book> books = bookDao.queryForItems(1, 4);
        System.out.println(books);
    }

    @Test
    public void queryForPageTotalCount() {
        Integer i = bookDao.queryForPageTotalCount(12, 130);
        System.out.println(i);
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(1, 2, 12, 130);
        System.out.println(books);
    }
}