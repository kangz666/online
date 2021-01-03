package dao;


import entry.Category;
import entry.Order;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public interface CategoryDao {
    /**
     * 增加
     */
    public abstract boolean insert(Category c);
    /**
     * 查找
     * @return
     */
    public abstract Category select(String number);
}
