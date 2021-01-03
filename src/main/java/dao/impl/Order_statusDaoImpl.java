package dao.impl;

import dao.Order_statusDao;
import entry.Order;
import entry.Order_status;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public class Order_statusDaoImpl implements Order_statusDao {
    private Connection conn=null;

    public Order_statusDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Order_status os) {
        boolean flag = false;
        String sql = "insert into order_status_table values(?,?)";
        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2, os.getOrder_status());
            pstm.setString(1, os.getStatus_number());

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

    public boolean update_status(Order_status os, String update_status) {
        boolean flag = false;
        String sql = "update order_status_table set order_status= ?  where status_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2,os.getStatus_number());
            pstm.setString(1,update_status);

            //执行操作
            int updated = pstm.executeUpdate();
            if (updated == 1) {
                flag = true;
            }
        } catch (SQLException e) {
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

    public Order_status select(String number){
        Order_status c =new Order_status();
        String sql = "select * from order_status_table where status_number = ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, number);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                c.setStatus_number((resultSet.getString("status_number").trim()));
                c.setOrder_status(resultSet.getString(2).trim());
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
        return c;
    }

}
