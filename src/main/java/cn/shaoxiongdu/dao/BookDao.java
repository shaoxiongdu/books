package cn.shaoxiongdu.dao;

import cn.shaoxiongdu.bean.Book;

import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-16 | 10:31
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Long queryTotalCount();

    List<Book> queryForLimit(Integer begin, Integer pageSize);
}
