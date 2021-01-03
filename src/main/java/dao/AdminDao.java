package dao;


import entry.Admin;

/**
 * @author kangz
 * @date 2020-12-26
 */
public interface AdminDao{
    /**
     * 增加管理员
     * @param a
     * @return
     */
    public abstract boolean insert(Admin a);

    /**
     * 修改信息
     * @param s
     * @param update_t
     * @return
     */
    public abstract boolean update_password(String s, String update_t);

    /**
     * 删除
     * @param a
     * @return
     */
    public abstract boolean delete(Admin a);

    /**
     *
     * @param number
     * @param password
     * @return
     */
    public abstract boolean login(String number,String password);
}
