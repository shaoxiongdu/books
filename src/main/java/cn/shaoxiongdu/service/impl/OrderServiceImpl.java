package cn.shaoxiongdu.service.impl;

import cn.shaoxiongdu.bean.*;
import cn.shaoxiongdu.dao.OrderDao;
import cn.shaoxiongdu.dao.OrderItemDao;
import cn.shaoxiongdu.dao.impl.OrderDaoImpl;
import cn.shaoxiongdu.dao.impl.OrderItemDaoImpl;
import cn.shaoxiongdu.service.BookService;
import cn.shaoxiongdu.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 17:42
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    BookService bookService = new BookServiceImpl();


    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public Order createOrder(Cart cart, Integer userId) {

        //生成订单号
        UUID uuid = UUID.randomUUID();

        //循环存储购物车元素
        for(Map.Entry<Integer,CartItem> entry : cart.getItems().entrySet()){
            //购物车元素
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem();

            //设置商品ID
            orderItem.setId(cartItem.getId());

            //设置商品名称
            orderItem.setName(cartItem.getName());

            //设置订单号
            orderItem.setOrderId(uuid.toString());

            //单价
            orderItem.setPrice(cartItem.getPrice());

            //总价
            orderItem.setTotalPrice(cartItem.getTotalPrice());

            //数量
            orderItem.setCount(cartItem.getCount());

            //更新书籍表
            Book book = bookService.queryBookById(cartItem.getId());
            //销量增加
            book.setSales(book.getSales() + cartItem.getCount());
            //库存减少
            book.setStock(book.getStock() - cartItem.getCount());

            bookService.updateBook(book);

            //持久化
            orderItemDao.add(orderItem);

        }

        //持久化订单
        Order order = new Order();
        //设置订单号
        order.setOrderId(uuid.toString());

        //创建时间
        order.setCreateTime(new Date());

        //总价
        order.setPrice(cart.getTotalPrice());

        //用户ID
        order.setUserId(userId);

        //订单状态
        order.setStatus("已下单");

        orderDao.addOrder(order);

        return order;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,"已发货");
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {

        return orderDao.queryOrderByUserId(userId);

    }
    @Override
    public Order showOrderDetails(String orderId) {
        return orderDao.queryOrderByOrderId(orderId);
    }

    @Override
    public void receiverOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,"已签收");
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId(orderId);
        return orderItems;
    }
}
