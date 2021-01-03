package dao;


import entry.Order;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-28
 */
public interface OrderDao {
    /**
     * 增加订单
     */
    public abstract boolean insert(Order o);
    /**
     * 删除订单
     */
    public abstract boolean delete(Order o);
    /**
     * 修改订单，处理
     */
    public abstract boolean update_status(Order o, String update_status);
    /**
     * 查询用户自己的订单
     */
    public abstract ArrayList<Order> select(String user_number);
    /**
     *
     */
    public abstract ArrayList<Order> select_name(String status);
    /**
     * 查询所有订单,并按时间先后排序
     */
    public abstract ArrayList<Order> select_all();


}
