package dao.impl;

import dao.InformationDao;
import entry.Information;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-27
 */
public class InformationDaoIpml implements InformationDao {
    private Connection conn=null;

    public InformationDaoIpml(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Information i) {
        boolean flag = false;
        String sql = "insert into information_table values(?,?,?,?,?,?,?)";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            //商品信息表（商品编号，商品名称，类别编号，数量，单价，图片，描述）
            pstm.setString(1, i.getInformation_number());
            pstm.setString(2, i.getInformation_name());
            pstm.setString(3, i.getCategory_number());
            pstm.setInt(4, i.getInformation_sum());
            pstm.setFloat(5, i.getInformation_price());
            pstm.setString(6, i.getInformation_picture());
            pstm.setString(7, i.getInformation_text());

            // 执行操作
            int executeUpdate = pstm.executeUpdate();
            if (executeUpdate == 1) {
//                DatabaseConnection dbc = new DatabaseConnection();
//                Connection conn = dbc.getConnection();
//                 CategoryDao cd =new CategoryDaoImpl(conn);
//                    switch (i.getCategory_number()){
//                        case "A11":{
//                            cd.insert(new Category(i.getCategory_number(),"手机"));
//                            break;
//                        }
//                        case "A22":{
//                            cd.insert(new Category(i.getCategory_number(),"电脑"));
//                            break;
//                        }
//                        case "A33":{
//                            cd.insert(new Category(i.getCategory_number(),"平板"));
//                            break;
//                        }
//                        default:{
//                            cd.insert(new Category(i.getCategory_number(),"生活用品"));
//                            break;
//                        }
//                    }
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

    public boolean delete(Information i) {
        boolean flag = false;
        String sql = "delete from information_table where information_number = ?";
        PreparedStatement pstm = null;
        try {
            //语句对象
            pstm = this.conn.prepareStatement(sql);
            //设置占位符
            pstm.setString(1, i.getInformation_number());
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

    public boolean update_sum(Information i, int update_sum) {
        boolean flag = false;
        String sql = "update information_table set information_sum= ?  where information_number = ?";
        // 创建语句对象
        PreparedStatement pstm = null;
        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(2,i.getInformation_number());
            pstm.setInt(1, i.getInformation_sum()+update_sum);

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

    public ArrayList<Information> select_category(String category) {
        //相同类别的商品
        ArrayList<Information> in_list= new ArrayList<Information>();

        String sql = "select * from information_table where category_number = (select category_number from category_table where category_name = ?)";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            // 设置占位符
            pstm.setString(1, category);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                //商品信息表（商品编号，商品名称，类别编号，数量，单价，图片，描述）
                Information i = new Information();
                i.setInformation_number(resultSet.getString("information_number").trim());
                i.setInformation_name(resultSet.getString("information_name").trim());
                i.setCategory_number(resultSet.getString("category_number").trim());
                i.setInformation_price(resultSet.getFloat("information_price"));
                i.setInformation_sum(resultSet.getInt("information_sum"));
                i.setInformation_picture(resultSet.getString("information_picture"));
                i.setInformation_text(resultSet.getString("information_text"));
                in_list.add(i);
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

        return in_list;
    }

    public ArrayList<Information> select() {
        //返回该用户的所有的购物车的商品
        ArrayList<Information> in_list= new ArrayList<Information>();

        String sql = "select * from information_table ";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);

            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                //商品信息表（商品编号，商品名称，类别编号，数量，单价，图片，描述）
                Information i = new Information();
                i.setInformation_number(resultSet.getString("information_number").trim());
                i.setInformation_name(resultSet.getString("information_name").trim());
                i.setCategory_number(resultSet.getString("category_number").trim());
                i.setInformation_price(resultSet.getFloat("information_price"));
                i.setInformation_sum(resultSet.getInt("information_sum"));
                i.setInformation_picture(resultSet.getString("information_picture"));
                i.setInformation_text(resultSet.getString("information_text"));
                in_list.add(i);
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

        return in_list;
    }
    public Information select_info(String number) {
        Information i = new Information();
        String sql = "select * from information_table where information_number=?";

        // 创建语句对象
        PreparedStatement pstm = null;

        try {
            pstm = this.conn.prepareStatement(sql);
            pstm.setString(1,number);
            // 执行操作
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                //商品信息表（商品编号，商品名称，类别编号，数量，单价，图片，描述）

                i.setInformation_number(resultSet.getString("information_number").trim());
                i.setInformation_name(resultSet.getString("information_name").trim());
                i.setCategory_number(resultSet.getString("category_number").trim());
                i.setInformation_price(resultSet.getFloat("information_price"));
                i.setInformation_sum(resultSet.getInt("information_sum"));
                i.setInformation_picture(resultSet.getString("information_picture"));
                i.setInformation_text(resultSet.getString("information_text"));

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

        return i;
    }
}
