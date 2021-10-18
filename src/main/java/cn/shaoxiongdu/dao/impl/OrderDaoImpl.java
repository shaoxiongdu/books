package cn.shaoxiongdu.dao.impl;

import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.dao.OrderDao;
import cn.shaoxiongdu.utils.C3P0Utils;
import com.mchange.v2.c3p0.cfg.C3P0Config;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 订单持久层实现类
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 16:59
 */
public class OrderDaoImpl implements OrderDao {

    private QueryRunner queryRunner = new QueryRunner();

    private Connection connection = C3P0Utils.getConnection();

    /**
     * 添加订单
     * @param order
     * @return
     */
    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO `order`(order_id, create_time, price, status, user_id) VALUES(?,?,?,?,?)";
        try {
            int update = queryRunner.update(connection,sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询所有订单
     * @return
     */
    @Override
    public List<Order> queryOrders() {
        String sql = "SELECT order_id orderId,create_time createTime,price,status,user_id userId FROM `order`";
        try {
            List<Order> query = queryRunner.query(connection,sql, new BeanListHandler<>(Order.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeOrderStatus(String orderId, String status) {
        String sql = "UPDATE `order` SET status = ? WHERE order_id = ?";
        try{
            queryRunner.update(connection,sql,status,orderId);
        }catch (Exception e){
        }
    }

    @Override
    public Order queryOrderByOrderId(String orderId) {
        String sql = "SELECT order_id orderId,create_time createTime,price,status,user_id userId FROM `order` WHERE order_id = ?";
        try {
            Order query = queryRunner.query(connection,sql, new BeanHandler<>(Order.class),orderId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "SELECT order_id orderId,create_time createTime,price,status,user_id userId FROM `order` WHERE user_id = ?";
        try {
            List<Order> query = queryRunner.query(connection,sql, new BeanListHandler<>(Order.class),userId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
