package cn.shaoxiongdu.dao;

import cn.shaoxiongdu.bean.Order;

import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 16:39
 */
public interface OrderDao {

    public int addOrder(Order order);

    public List<Order> queryOrders();

    public void changeOrderStatus(String orderId,String status);

    public Order queryOrderByOrderId(String orderId);

    public List<Order> queryOrderByUserId(Integer userId);

}
