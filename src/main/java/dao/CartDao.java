package dao;

import entry.Cart;
import entry.Order;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public interface CartDao {
    /**
     * 增加
     */
    public abstract boolean insert(Cart cart);
    /**
     * 删除
     */
    public abstract boolean delete(Cart cart);
    /**
     * 修改
     */
    public abstract boolean update_sum(Cart c, int update_t);
    /**
     * 查询
     * @return
     */
    public abstract ArrayList<Cart> select(String user_number);
}
