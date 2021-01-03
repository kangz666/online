package dao;

import entry.Order;
import entry.User;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-26
 */
public interface UserDao{
    /**
     * 创建自己的账户
     * @param
     */
    public abstract boolean insert(User u);

    /**
     * 注销账户
     */
    public abstract boolean delete(User u);

    /**
     * 查询账户信息
     * @return
     */
    public abstract User select(String s);
    /**
     * 修改用户信息
     */
    public abstract boolean update_password(String s, String update);
    /**
     * 登录查询
     * @return 是否查询到该用户
     */
    public abstract boolean login(String number,String password);
}
