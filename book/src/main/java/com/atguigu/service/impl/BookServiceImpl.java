package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xiu
 * @create 2021-11-07 22:07
 */
public class BookServiceImpl implements BookService {
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);

    }

    /**
     * 根据id查找书
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {
        try {
            Book book = bookDao.queryByBookId(id);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 列出所有的书籍
     * @return
     */
    @Override
    public List<Book> queryBooks() {
        List<Book> books = bookDao.queryBooks();
        return books;
    }


    /**
     * 处理分页数据，就是解决 总记录数，总页码，当前页数据
     * //    其实就是调dao层的方法，但是有些数据需要处理，这就是这一层做的事情
     * @param pageNo 第几页
     * @param pageSize 每页多少个数据，默认是4个
     * @return
     */
    @Override
    public Page<Book> pages(Integer pageNo, Integer pageSize) {
        Page<Book> bookPage = new Page<>();
//        这是总记录数
        Integer count = bookDao.queryForTotalCount();
        bookPage.setPageTotalCount(count);
//        总页码数
        int pagecount = count / pageSize;
        if (count % pageSize>0){
            pagecount++;
        }
        bookPage.setPageTotal(pagecount);
//        数据检查
        if (pageNo<1){
            pageNo=1;
        }
        if (pageNo>bookPage.getPageTotal()){
            pageNo=bookPage.getPageTotal();
        }
        int begin=(pageNo-1)*pageSize;
        bookPage.setItems(bookDao.queryForItems(begin,pageSize));
        bookPage.setPageSize(pageSize);
        bookPage.setPageNo(pageNo);
        return bookPage;
    }

    /**
     * 根据价格进行分页
     * @param pageNo 第几页
     * @param pageSize 每页多少个数据，默认是4个
     * @param min 最小价格
     * @param max 最大价格
     * @return
     */
    public Page<Book> pageByPrice(Integer pageNo,Integer pageSize,Integer min,Integer max){
        Page<Book> bookPage = new Page<>();
//        总记录数
        Integer count = bookDao.queryForPageTotalCount(min, max);

        List<Book> books = bookDao.queryForPageItems((pageNo-1)*pageSize, pageSize, min, max);
        //        当前页数据
        int pagecount = count / pageSize;
        if (count % pageSize>0){
            pagecount++;
        }
        bookPage.setPageTotal(pagecount);
//        数据检查
        if (pageNo<1){
            pageNo=1;
        }
        if (pageNo>bookPage.getPageTotal()){
            pageNo=bookPage.getPageTotal();
        }
        bookPage.setItems(books);
        bookPage.setPageTotalCount(count);
        bookPage.setPageNo(pageNo);
        bookPage.setPageSize(pageSize);
        return bookPage;

    }
}
