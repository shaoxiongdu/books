package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.bean.Page;

import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(Integer pageNo, Integer pageSize);
}
