package cn.shaoxiongdu.web.controller;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.bean.Page;
import cn.shaoxiongdu.bean.User;
import cn.shaoxiongdu.service.BookService;
import cn.shaoxiongdu.service.impl.BookServiceImpl;
import cn.shaoxiongdu.utils.FormatUtils;
import cn.shaoxiongdu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-16 | 10:57
 */
@WebServlet("/bookServlet")
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = WebUtils.param2Bean(new Book(), req.getParameterMap());

        bookService.addBook(book);
        //重定向到图书列表
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page");
    }

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageSize = FormatUtils.string2Integer(req.getParameter("pageSize"),5);
        Integer pageNo = FormatUtils.string2Integer(req.getParameter("pageNo"),1);

        Page<Book> page = bookService.page(pageNo,pageSize);

        req.setAttribute("page",page);

        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    public void editSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = WebUtils.param2Bean(new Book(), req.getParameterMap());

        if(book.getId() == 0){
            bookService.addBook(book);
        }
        bookService.updateBook(book);
        //重定向到图书列表
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page");
    }

    public void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        req.setAttribute("bookList", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        bookService.deleteBookById(Integer.valueOf(id));

        //重定向到图书列表
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page");
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Book book = bookService.queryBookById(Integer.valueOf(id));

        req.setAttribute("book",book);
        //请求转发到图书编辑
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

}
