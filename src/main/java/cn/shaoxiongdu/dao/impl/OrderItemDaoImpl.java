package cn.shaoxiongdu.dao.impl;

import cn.shaoxiongdu.bean.Order;
import cn.shaoxiongdu.bean.OrderItem;
import cn.shaoxiongdu.dao.OrderItemDao;
import cn.shaoxiongdu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-18 | 17:32
 */
public class OrderItemDaoImpl implements OrderItemDao {

    private QueryRunner queryRunner = new QueryRunner();

    private Connection connection = C3P0Utils.getConnection();

    @Override
    public int add(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item`(name,count,price,total_price,order_id) VALUES(?,?,?,?,?)";
        try {
            int update = queryRunner.update(connection,sql, orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {

        String sql = "SELECT id, name, count, price, total_price totalPrice, order_id orderId FROM `order_item` WHERE order_id = ?";
        try {
            List<OrderItem> query = queryRunner.query(connection,sql, new BeanListHandler<>(OrderItem.class),orderId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
