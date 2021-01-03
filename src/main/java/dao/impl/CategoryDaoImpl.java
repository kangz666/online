package dao.impl;

import dao.CategoryDao;
import entry.Category;
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
public class CategoryDaoImpl implements CategoryDao {
    private Connection conn = null;

    public CategoryDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Category c) {
        boolean flag = false;
        String sql = "insert into category_table values(?,?)";
        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, c.getCategory_number());
            pstm.setString(2, c.getCategory_name());

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

    public Category select(String number){
        Category c=new Category();
        String sql = "select * from category_table where category_number = ?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, number);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                c.setCategory_number((resultSet.getString("category_number").trim()));
                c.setCategory_name(resultSet.getString("category_name").trim());
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
