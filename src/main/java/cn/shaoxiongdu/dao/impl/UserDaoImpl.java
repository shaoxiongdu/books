package cn.shaoxiongdu.dao.impl;

import cn.shaoxiongdu.bean.User;
import cn.shaoxiongdu.dao.UserDao;
import cn.shaoxiongdu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-14 | 15:49
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner();

    private Connection connection = C3P0Utils.getConnection();

    @Override
    public User queryByAccount(User user) {
        String sql = "SELECT * FROM user WHERE account = ?";
        User result = null;
        try {
            result = queryRunner.query(connection,sql,new BeanHandler<>(User.class),user.getAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User queryByAccountAndPassword(User user) {
        String sql = "SELECT * FROM user WHERE account = ? AND password = ?";
        User result = null;
        try {
            result = queryRunner.query(connection,sql,new BeanHandler<>(User.class),user.getAccount(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO  user (account, password, email) VALUES (?,?,?)";
        int result = -1;
        try {
            result = queryRunner.update(connection,sql,user.getAccount(),user.getPassword(),user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
