package cn.shaoxiongdu.dao;

import cn.shaoxiongdu.bean.OrderItem;

import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 16:39
 */
public interface OrderItemDao {

    public int add(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
