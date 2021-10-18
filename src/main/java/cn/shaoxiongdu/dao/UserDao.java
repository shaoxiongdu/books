package cn.shaoxiongdu.dao;

import cn.shaoxiongdu.bean.User;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-14 | 15:49
 */
public interface UserDao {

    /**
     * 通过账号查询用户
     * @param user
     * @return
     */
    public User queryByAccount(User user);

    /**
     * 通过账号密码查询
     * @param user
     * @return
     */
    public User queryByAccountAndPassword(User user);

    /**
     * 插入用户
     * @param user
     * @return
     */
    public int insert(User user);

}
