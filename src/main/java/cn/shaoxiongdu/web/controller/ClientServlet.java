package cn.shaoxiongdu.web.controller;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.bean.Page;
import cn.shaoxiongdu.service.BookService;
import cn.shaoxiongdu.service.impl.BookServiceImpl;
import cn.shaoxiongdu.utils.FormatUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 9:18
 */
@WebServlet("/clientServlet")
public class ClientServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("page",bookService.page(1,16));

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pageSize = FormatUtils.string2Integer(req.getParameter("pageSize"),16);
        Integer pageNo = FormatUtils.string2Integer(req.getParameter("pageNo"),1);

        Page<Book> page = bookService.page(pageNo,pageSize);

        req.setAttribute("page",page);

        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
