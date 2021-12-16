package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author xiu
 * @create 2021-10-30 20:29
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public List<Book> queryBooks();

    public Book queryByBookId(Integer id) throws Exception;

    public Integer queryForTotalCount();

    public List<Book> queryForItems(Integer begin, Integer pagesize);
    public Integer queryForPageTotalCount(Integer min, Integer max);
    public List<Book> queryForPageItems(Integer begin,Integer size,Integer min,Integer max);
}