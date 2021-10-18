package cn.shaoxiongdu.service.impl;

import cn.shaoxiongdu.bean.User;
import cn.shaoxiongdu.dao.UserDao;
import cn.shaoxiongdu.dao.impl.UserDaoImpl;
import cn.shaoxiongdu.service.UserService;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-14 | 15:49
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    /**
     * 返回true标识存在 不可用 返回false标识不存在 可用
     * @param account
     * @return
     */
    @Override
    public boolean existAccount(String account) {
        return userDao.queryByAccount(new User(0,account,null,null)) != null;
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User QueryByAccountAndPassword(User user) {
        return userDao.queryByAccountAndPassword(user);
    }
}
