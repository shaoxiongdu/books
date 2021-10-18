package cn.shaoxiongdu.service.impl;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.bean.Page;
import cn.shaoxiongdu.dao.BookDao;
import cn.shaoxiongdu.dao.impl.BookDaoImpl;
import cn.shaoxiongdu.service.BookService;

import java.util.List;
import java.util.Random;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        book.setImgPath("https://picsum.photos/id/"+new Random().nextInt(1000) +"/200/300");
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

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {

        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);

        //设置总记录条数
        Long totalCount = bookDao.queryTotalCount();
        page.setTotalCount(totalCount);

        //设置总页码
        long totalPageNo = totalCount / pageSize;
        if(totalCount % pageSize != 0){
            totalPageNo = totalPageNo+1;
        }
        page.setTotalPageNo(totalPageNo);

        //检查参数
        if(pageNo > totalPageNo || pageNo < 1){
            pageNo = 1;
        }
        //默认为5
        if(pageSize > 1000 || pageSize < 1){
            pageSize = 5;
        }

        //设置当前页记录
        Integer begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForLimit(begin,pageSize);
        page.setItems(items);
        return page;
    }
}
