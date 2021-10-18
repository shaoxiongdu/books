package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.Cart;
import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.bean.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 16:31
 */
public interface OrderService {

    /**
     * 创建订单
     */
    public Order createOrder(Cart cart,Integer userId);
    /**
     * 查询全部
     */
    public List<Order> showAllOrders();
    /**
     * 发货
     */
    public void sendOrder(String orderId);
    /**
     * 通过用户ID查询订单列表
     */
    public List<Order> queryOrderByUserId(Integer userId);
    /**
     * 显示订单详情
     */
    public Order showOrderDetails(String orderId);

    /**
     * 签收订单
     */
    public void receiverOrder(String orderId);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
