package cn.shaoxiongdu.web.controller;

import cn.shaoxiongdu.bean.Cart;
import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.bean.OrderItem;
import cn.shaoxiongdu.bean.User;
import cn.shaoxiongdu.service.OrderService;
import cn.shaoxiongdu.service.impl.OrderServiceImpl;
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
 * @date: 2021-10-18 | 16:29
 */
@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet{

    //订单模块业务实现类
    OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从会话作用域对象获取购物车实体对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //清除会话中的购物车对象
        req.getSession().removeAttribute("cart");

        //获取当前用户ID
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        Integer userId = loginUser.getId();

        //返回创建好的订单
        Order order = orderService.createOrder(cart, userId);

        req.setAttribute("order",order);

        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
    }

    /**
     * 查询全部
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orderList",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    /**
     * 查询全部
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showOrdersByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取当前用户ID
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        Integer userId = loginUser.getId();

        //通过用户ID查询订单
        List<Order> orders = orderService.queryOrderByUserId(userId);

        req.setAttribute("orderList",orders);

        //请求转发到订单列表页面
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);

    }

    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        req.setAttribute("message","订单【"+orderId+"】发货成功!");
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showAllOrders");
    }

    /**
     * 显示订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderId = req.getParameter("orderId");

        //订单详情
        Order order = orderService.showOrderDetails(orderId);

        //订单元素列表
        List<OrderItem> orderItems = orderService.queryOrderItemsByOrderId(orderId);

        req.setAttribute("order",order);
        req.setAttribute("orderItems",orderItems);

        //请求转发到订单详情页面
        req.getRequestDispatcher("pages/order/order_detal.jsp").forward(req,resp);

    }

    /**
     * 签收订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiverOrder(orderId);
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showOrdersByUserId");
    }
}
