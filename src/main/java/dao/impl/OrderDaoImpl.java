package dao.impl;

import dao.OrderDao;
import entry.Order;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-28
 */
public class OrderDaoImpl implements OrderDao {
    private Connection conn=null;

    public OrderDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Order o) {
        boolean flag = false;
        String sql = "insert into order_table values(?,?,?,?,?,?,?,?)";
        // 创建语句对象
        PreparedStatement pstm = null;
//    订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, o.getOrder_number());
            pstm.setString(2, o.getInformation_number());
            pstm.setString(3, o.getGoods_price());
            pstm.setString(4, o.getUser_number());
            pstm.setString(5, o.getUser_name());
            pstm.setString(6, o.getUser_address());
            pstm.setString(7, o.getUser_phone());
            pstm.setString(8,o.getStatus_number());

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

    public boolean delete(Order o) {
        boolean flag = false;
        String sql = "delete from order_table where order_number = ?";
        PreparedStatement pstm = null;
        try {
            //语句对象
            pstm = this.conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, o.getOrder_number());
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

    public boolean update_status(Order o,String update_status) {
        boolean flag = false;
        String sql = "update order_table set status_number= ?  where order_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2,o.getOrder_number());
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

    public ArrayList<Order> select(String user_number) {
        ArrayList<Order> od_list= new ArrayList<Order>();

        String sql = "select * from order_table where user_number = ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, user_number);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                //    订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
                Order o = new Order();
                o.setOrder_number(resultSet.getString("order_number").trim());
                o.setInformation_number(resultSet.getString("information_number").trim());
                o.setGoods_price(resultSet.getString("goods_price").trim());
                o.setUser_number(resultSet.getString("user_number").trim());
                o.setUser_name(resultSet.getString("user_name").trim());
                o.setUser_address(resultSet.getString("user_address").trim());
                o.setUser_phone(resultSet.getString("user_phone").trim());
                o.setStatus_number(resultSet.getString("status_number").trim());
                od_list.add(o);
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

        return od_list;
    }

    public ArrayList<Order> select_name(String name) {

        ArrayList<Order> od_list= new ArrayList<Order>();

        String sql = "select * from order_table where user_number= ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, name);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                //    订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
                Order o = new Order();
                o.setOrder_number(resultSet.getString("order_number").trim());
                o.setInformation_number(resultSet.getString("information_number").trim());
                o.setGoods_price(resultSet.getString("goods_price").trim());
                o.setUser_number(resultSet.getString("user_number").trim());
                o.setUser_name(resultSet.getString("user_name").trim());
                o.setUser_address(resultSet.getString("user_address").trim());
                o.setUser_phone(resultSet.getString("user_phone").trim());
                o.setStatus_number(resultSet.getString("status_number").trim());
                od_list.add(o);
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

        return od_list;
    }

    public ArrayList<Order> select_all() {
        ArrayList<Order> od_list= new ArrayList<Order>();

        String sql = "select * from order_table order by order_number desc";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                //    订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
                Order o = new Order();
                o.setOrder_number(resultSet.getString("order_number").trim());
                o.setInformation_number(resultSet.getString("information_number").trim());
                o.setGoods_price(resultSet.getString("goods_price").trim());
                o.setUser_number(resultSet.getString("user_number").trim());
                o.setUser_name(resultSet.getString("user_name").trim());
                o.setUser_address(resultSet.getString("user_address").trim());
                o.setUser_phone(resultSet.getString("user_phone").trim());
                o.setStatus_number(resultSet.getString("status_number").trim());
                od_list.add(o);
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

        return od_list;
    }
}
