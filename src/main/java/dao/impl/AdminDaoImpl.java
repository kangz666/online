package dao.impl;

import dao.AdminDao;
import entry.Admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kangz
 * @date 2020-12-26
 */
public class AdminDaoImpl implements AdminDao {
    private Connection conn = null;

    public AdminDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public boolean insert(Admin a) {

        boolean flag = false;
        String sql = "insert into admin_table values(?,?,?,?)";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, a.getAdmin_number());
            pstm.setString(2, a.getAdmin_password());
            pstm.setString(3, a.getAdmin_name());
            pstm.setString(4, a.getAdmin_phone());

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
    @Override
    public boolean update_password(String s, String update_t) {
        boolean flag = false;
        String sql = "update admin_table set admin_password=? where admin_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2, s);
            pstm.setString(1, update_t);

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
    @Override
    public boolean delete(Admin a) {
        boolean flag = false;
        String sql = "delete from admin_table where admin_number = ?";
        PreparedStatement pstm = null;
        try {
            //语句对象
            pstm = this.conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, a.getAdmin_number());
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
    @Override
    public boolean login(String number,String password){
        boolean flag=false;
        String sql = "select * from admin_table where admin_number = ? and admin_password= ?";

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
