package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-11-07 22:11
 */
public class BookServiceTest {
    private BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        Book book = new Book(2, "a", "a", new BigDecimal(12), 12, 12, "aaa");
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(2);

    }

    @Test
    public void updateBook() {
        Book book = new Book(2, "b", "a", new BigDecimal(12), 12, 12, "aaa");

        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        System.out.println(books);
    }
    @Test
    public void pages() {
        Page<Book> pages = bookService.pages(1, 4);
        System.out.println("aaa");
    }
}