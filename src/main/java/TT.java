import dao.*;
import entry.Order;
import dao.impl.*;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @author kangz
 * @date 2020-12-28
 */
public class TT {
    public static void main(String[] args) {
        DatabaseConnection dbc = new DatabaseConnection();
        Connection conn = dbc.getConnection();
        OrderDao od = new OrderDaoImpl(conn);
        Order_statusDao osd = new Order_statusDaoImpl(conn);
        InformationDao id = new InformationDaoIpml(conn);
        ArrayList<Order> od_list = od.select_name("102030");
        for (Order c : od_list) {
            {


                System.out.println(c.toString());
            }

        }
    }
}