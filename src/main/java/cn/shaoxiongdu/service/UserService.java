package cn.shaoxiongdu.service;

import cn.shaoxiongdu.bean.User;

/**
 * @description:
 * @author: shaoxiongdu <email@shaoxiongdu.cn>
 * @date: 2021-10-14 | 15:49
 */
public interface UserService {

    /**
     * 判断账号是否存在
     * @param account
     * @return
     */
    public boolean existAccount(String account);

    /**
     * 插入用户
     * @param user
     * @return
     */
    public int insert(User user);

    public User QueryByAccountAndPassword(User user);

}
