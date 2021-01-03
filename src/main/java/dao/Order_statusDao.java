package dao;


import entry.Order;
import entry.Order_status;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public interface Order_statusDao {
    /**
     * 增加
     */
    public abstract boolean insert(Order_status os);
    /**
     * 修改状态
     */
    public abstract boolean update_status(Order_status os, String update_status);

    public abstract Order_status select(String number);
}
