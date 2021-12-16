package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.utils.DBUtil;
import com.atguigu.utils.Webutils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiu
 * @create 2021-10-30 20:32
 */
public class BookDaoImpl implements BookDao {
   private String sql;
    @Override
    public int addBook(Book book) {
        sql="INSERT INTO t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) VALUES(?,?,?,?,?,?);";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        int i = dbUtil.executeUpdate(sql, new Object[]{book.getName(), book.getAuthor()
                , book.getPrice(),
                String.valueOf(book.getSaleds()), String.valueOf(book.getStock()), book.getImg_path()});
        return i;
    }

    @Override
    public int deleteBookById(Integer id) {
        sql="delete from t_book where id=?;";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        int i = dbUtil.executeUpdate(sql, new String[]{String.valueOf(id)});
        return i;
    }

    @Override
    public int updateBook(Book book) {
        sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        int i = dbUtil.executeUpdate(sql,
                new Object[]{String.valueOf(book.getName()),
                        book.getAuthor(), String.valueOf(book.getPrice()),
                        String.valueOf(book.getSaleds()), String.valueOf(book.getStock()), book.getImg_path(),
                        book.getId()});
        return i;
    }

    @Override
    public List<Book> queryBooks() {
        sql="select * from t_book ";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        ArrayList<Book> arrayList = new ArrayList<>();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[]{});
            try {
                while (resultSet.next()) {
                    String string = resultSet.getString(1);
                    int i = Integer.parseInt(string);
                    String string1 = resultSet.getString(2);
                    String string2 = resultSet.getString(3);
                    String string3 = resultSet.getString(4);
                    String string4 = resultSet.getString(5);
                    String string5 = resultSet.getString(6);
                    String string6 = resultSet.getString(7);
                    Integer integer = Integer.valueOf(string4);
                    Integer integer1 = Integer.valueOf(string5);
                    Book book = new Book(i, string1, string2, new BigDecimal(string3), integer, integer1, string6);
                    arrayList.add(book);
                }
                return arrayList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;


    }

    @Override
    public Book queryByBookId(Integer id) throws Exception {
        sql="select * from t_book where id=?";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[]{String.valueOf(id)});
        while (resultSet.next()){
            String string = resultSet.getString(1);
            int i = Integer.parseInt(string);
            String string1 = resultSet.getString(2);
            String string2 = resultSet.getString(3);
            String string3 = resultSet.getString(4);
            String string4 = resultSet.getString(5);
            String string5 = resultSet.getString(6);
            String string6 = resultSet.getString(7);
            Integer integer = Integer.valueOf(string4);
            Integer integer1 = Integer.valueOf(string5);
            Book book = new Book(i, string1, string2, new BigDecimal(string3), integer, integer1, string6);
            return book;
        }
        return null;
    }

    @Override
    public Integer queryForTotalCount() {
        sql="select count(*) from t_book ";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[0]);
        String string="";
            try {
                while (resultSet.next()){
                    string = resultSet.getString(1);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        return  Webutils.StringToInteger(string, 0);
    }

    @Override
    public List<Book> queryForItems(Integer begin,Integer pagesize) {
        sql="select * from t_book limit "+begin+","+pagesize;
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[0]);
        ArrayList<Book> arrayList = new ArrayList<>();
        Book book;
        try {
                while (resultSet.next()) {
                    String string = resultSet.getString(1);
                    int i = Integer.parseInt(string);
                    String string1 = resultSet.getString(2);
                    String string2 = resultSet.getString(3);
                    String string3 = resultSet.getString(4);
                    String string4 = resultSet.getString(5);
                    String string5 = resultSet.getString(6);
                    String string6 = resultSet.getString(7);
                    Integer integer = Integer.valueOf(string4);
                    Integer integer1 = Integer.valueOf(string5);
                     book = new Book(i, string1, string2, new BigDecimal(string3), integer, integer1, string6);
                    arrayList.add(book);
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
    public Integer queryForPageTotalCount(Integer min, Integer max){
        sql="select count(*) from t_book where price between "+min +" and "+max +" order by price desc ";
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();
        ResultSet resultSet = dbUtil.executeQuery(sql, new String[0]);
        ArrayList<Book> arrayList = new ArrayList<>();
        Integer integer=0;
            try {
                while (resultSet.next()) {
                    String string = resultSet.getString(1);
                     integer = Webutils.StringToInteger(string, 0);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return integer;
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer size, Integer min, Integer max) {
        sql="select * from t_book where price between " +min+" and "+max +" order by price asc "+" limit "+begin+" , "+ size;
        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();

        ResultSet resultSet = dbUtil.executeQuery(sql,
                new String[0]);
        ArrayList<Book> arrayList = new ArrayList<>();
        Book book;
        try {
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                int i = Integer.parseInt(string);
                String string1 = resultSet.getString(2);
                String string2 = resultSet.getString(3);
                String string3 = resultSet.getString(4);
                String string4 = resultSet.getString(5);
                String string5 = resultSet.getString(6);
                String string6 = resultSet.getString(7);
                Integer integer = Integer.valueOf(string4);
                Integer integer1 = Integer.valueOf(string5);
                book = new Book(i, string1, string2, new BigDecimal(string3), integer, integer1, string6);
                arrayList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
}
