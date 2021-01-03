package dao;



import entry.Information;

import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public interface InformationDao {
    /**
     * 增加
     */
    public abstract boolean insert(Information i);
    /**
     * 删除
     */
    public abstract boolean delete(Information i);
    /**
     * 修改商品的存货多少
     */
    public abstract boolean update_sum(Information i, int update_sum);
    /**
     * 查询相同类别_名称的商品
     */
    public abstract ArrayList<Information> select_category(String category);
    /**
     * 查询全部商品
     */
    public abstract ArrayList<Information> select();
    public abstract Information select_info(String number);
}
