package cn.shaoxiongdu.dao.impl;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.dao.BookDao;
import cn.shaoxiongdu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-16 | 10:32
 */
public class BookDaoImpl implements BookDao {

    private QueryRunner queryRunner = new QueryRunner();

    private Connection connection = C3P0Utils.getConnection();

    @Override
    public int addBook(Book book) {

        String sql = "INSERT INTO book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) VALUES (?,?,?,?,?,?)";

        int update = 0;
        try {
            update = queryRunner.update(connection, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getSales(), book.getImgPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;

    }

    @Override
    public int deleteBookById(Integer id) {

        String sql = "DELETE FROM book WHERE id = ?";

        int update = 0;
        try {
            update = queryRunner.update(C3P0Utils.getConnection(), sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;

    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE book SET name=?,author=?,price=?,sales=?,stock=?,img_path=? WHERE id = ?";
        int update = 0;
        try {
            update = queryRunner.update(connection, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(),book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT id, name,author,price,sales,stock,img_path imgPath FROM book WHERE id = ?";
        Book book = null;
        try {
            book = queryRunner.query(connection, sql,new BeanHandler<>(Book.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT id, name,author,price,sales,stock,img_path imgPath FROM book";
        List<Book> books = null;
        try {
            books = queryRunner.query(connection, sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Long queryTotalCount() {
        String sql = "SELECT COUNT(*) FROM book";
        Long totalCount = null;
        try {
            totalCount = (Long) queryRunner.query(connection, sql, new ScalarHandler());
        } catch (SQLException e) {
        }
        return totalCount;
    }

    @Override
    public List<Book> queryForLimit(Integer begin, Integer pageSize) {
        String sql = "SELECT id, name,author,price,sales,stock,img_path imgPath FROM book LIMIT ?,?";
        List<Book> bookList = null;
        try {
            bookList = queryRunner.query(connection, sql, new BeanListHandler<>(Book.class), begin, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
