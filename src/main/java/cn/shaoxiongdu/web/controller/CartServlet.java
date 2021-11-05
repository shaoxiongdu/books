package cn.shaoxiongdu.web.controller;

import cn.shaoxiongdu.bean.Book;
import cn.shaoxiongdu.bean.Cart;
import cn.shaoxiongdu.bean.CartItem;
import cn.shaoxiongdu.service.BookService;
import cn.shaoxiongdu.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 基于session的购物车
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 14:15
 */
@WebServlet("/cartServlet")

public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //书籍id
        String bookId = req.getParameter("bookId");

        //获取书籍信息
        Book book = bookService.queryBookById(Integer.valueOf(bookId));

        //购物车元素
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        req.getSession().setAttribute("lastName",book.getName());
        req.setAttribute("page",bookService.page(1,16));
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //书籍id
        String bookId = req.getParameter("bookId");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(Integer.valueOf(bookId));
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
    }

    public void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");
    }
}
