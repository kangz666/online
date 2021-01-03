package dao.impl;

import dao.CartDao;
import entry.Cart;
import entry.Order;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public class CartDaoImpl implements CartDao {
    private Connection conn = null;

    public CartDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Cart c) {
        boolean flag = false;
        String sql = "insert into cart_table values(?,?,?,?,?,?)";
        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, c.getInformation_number());
            pstm.setString(2, c.getInformation_name());
            pstm.setString(3, c.getUser_number());
            pstm.setFloat(4,  c.getInformation_price());
            pstm.setInt(5, c.getSum());
            pstm.setFloat(6, c.getMoney());

            // 执行操作
            int executeUpdate = pstm.executeUpdate();
            if (executeUpdate == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            pstm.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(Cart c) {
        boolean flag = false;
        String sql = "delete from cart_table where information_number = ?";
        PreparedStatement pstm = null;
        try {
            //语句对象
            pstm = this.conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, c.getInformation_number());
            // 执行操作
            int executeUpdate = pstm.executeUpdate();
            if (executeUpdate == 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pstm.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 返回
        return flag;
    }

    public boolean update_sum(Cart c, int update_t) {
        boolean flag = false;
        String sql = "update cart_table set money=? ,sum=?  where information_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(3,c.getInformation_number());
            pstm.setInt(2, update_t);
            pstm.setFloat(1, update_t*c.getMoney());

            //执行操作
            int updated = pstm.executeUpdate();
            if (updated == 1) {
                flag = true;
            }
        } catch (
                SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            pstm.close();

        } catch (
                SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Cart> select(String user_number){
        //返回该用户的所有的购物车的商品
        ArrayList<Cart> ac_list= new ArrayList<Cart>();

        String sql = "select * from cart_table where user_number = ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, user_number);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                Cart c = new Cart();
                c.setInformation_number(resultSet.getString("information_number").trim());
                c.setInformation_name(resultSet.getString("information_name").trim());
                c.setUser_number(resultSet.getString("user_number").trim());
                c.setInformation_price(resultSet.getFloat("information_price"));
                c.setSum(resultSet.getInt("sum"));
                c.setMoney(resultSet.getFloat("money"));
                ac_list.add(c);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            pstm.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ac_list;
    }
}
