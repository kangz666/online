package dao.impl;

import dao.UserDao;
import entry.Order;
import entry.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class UserDaoImpl implements UserDao {
    private Connection conn = null;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(User u) {
        boolean flag = false;
        String sql = "insert into user_table values(?,?,?,?,?,?,?,?)";
        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, u.getUser_number());
            pstm.setString(2, u.getUser_name());
            pstm.setString(3, u.getUser_password());
            pstm.setString(4, u.getUser_id());
            pstm.setString(5, u.getUser_address());
            pstm.setString(6, u.getUser_phone());
            pstm.setString(7, u.getUser_email());
            pstm.setString(8, u.getUser_qq());
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

    public boolean delete(User u) {
        boolean flag = false;
        String sql = "delete from user_table where user_number = ?";
        PreparedStatement pstm = null;
        try {
            //语句对象
            pstm = this.conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, u.getUser_number());
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

    public User select(String s) {
        User u = new User();
        String sql = "select * from user_table where user_number = ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, s);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                u.setUser_number(resultSet.getString("user_number").trim());
                u.setUser_name(resultSet.getString("user_name").trim());
                u.setUser_password(resultSet.getString("user_password").trim());
                u.setUser_id(resultSet.getString("user_id").trim());
                u.setUser_address(resultSet.getString("user_address").trim());
                u.setUser_phone(resultSet.getString("user_phone").trim());
                u.setUser_email(resultSet.getString("user_email").trim());
                u.setUser_qq(resultSet.getString("user_qq").trim());
            }else {
                u=null;
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

        return u;
    }

    /**
     * 修改信息
     */
    public boolean update_password(String s, String update) {

        boolean flag = false;
        String sql = "update user_table set user_password=? where user_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2, s);
            pstm.setString(1, update);

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

    public boolean login(String number,String password){
       boolean flag=false;
        String sql = "select * from user_table where user_number = ? and user_password= ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, number);
            pstm.setString(2,password);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                flag=true;
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
}