package controller;

import dao.CartDao;
import dao.InformationDao;
import dao.OrderDao;
import dao.UserDao;
import entry.Cart;
import entry.Information;
import entry.Order;
import entry.User;
import dao.impl.CartDaoImpl;
import dao.impl.InformationDaoIpml;
import dao.impl.OrderDaoImpl;
import dao.impl.UserDaoImpl;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * @author kangz
 * @date 2020-12-31
 */
@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    public OrderServlet() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //请求参数
        String method = request.getParameter("method");
        String  information_number = request.getParameter("information_number");
        String order_number = request.getParameter("order_number");
        String sum= request.getParameter("sum");
        String cname = request.getParameter("name");

        if(method.equals("order")){
            DatabaseConnection dbc=new DatabaseConnection();
            Connection conn=dbc.getConnection();
            //查询用户信息
            User u =new User();
            UserDao ud= new UserDaoImpl(conn);
            User select = ud.select(cname);
            //查询商品信息
            InformationDao id = new InformationDaoIpml(conn);
            Information info = id.select_info(information_number);
            //订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
            Order o=new Order();
            o.setOrder_number(String.valueOf(System.currentTimeMillis()));
            o.setInformation_number(information_number);
            o.setUser_number(cname);
            o.setGoods_price(sum);
            o.setUser_name(select.getUser_name());
            o.setUser_address(select.getUser_address());
            o.setUser_phone(select.getUser_phone());
            o.setStatus_number("1");

            OrderDao od=new OrderDaoImpl(conn);


                boolean insert = od.insert(o);
                if( insert==true ){
                    response.sendRedirect("/shopping/Order.jsp?name="+cname);
                }else{
                    response.sendRedirect("/shopping/Order.jsp?name="+cname);
                }
            }


        if(method.equals("delete")){
            DatabaseConnection dbc1=new DatabaseConnection();
            Connection conn1=dbc1.getConnection();
            CartDao cd=new CartDaoImpl(conn1);

            Cart c=new Cart();
            c.setInformation_number(information_number);
            cd.delete(c);

            OrderDao od1=new OrderDaoImpl(conn1);
            Order o1=new Order();
            o1.setOrder_number(order_number);

            if(od1.delete(o1)){

                response.sendRedirect("/shopping/Order.jsp?name="+cname);
            }

        }

        //确定收货
        if(method.equals("update")){
            DatabaseConnection dbc2=new DatabaseConnection();
            Connection conn2=dbc2.getConnection();

            OrderDao od2=new OrderDaoImpl(conn2);
            Order o2=new Order();
            o2.setOrder_number(order_number);

            if(od2.update_status(o2,"3")){
//                out.print("<script>");
////                out.print("alert('成功收货！');");
////                String sub1="window.location='Order.jsp'?name="+cname;
////                out.print(sub1);
//                out.print("history.back(-1)");
//                out.print("</script>");
                response.sendRedirect("/shopping/Order.jsp?name="+cname);
            }
        }

        //管理员修改的操作
        //退货处理
        if(method.equals("out")){
            DatabaseConnection dbc2=new DatabaseConnection();
            Connection conn2=dbc2.getConnection();

            OrderDao od2=new OrderDaoImpl(conn2);
            Order o2=new Order();
            o2.setOrder_number(order_number);

            if(od2.update_status(o2,"5")){

                response.sendRedirect("/shopping/manager_order.jsp");
            }
        }

        //发货处理
        if(method.equals("up")){
        DatabaseConnection dbc2=new DatabaseConnection();
        Connection conn2=dbc2.getConnection();

        OrderDao od2=new OrderDaoImpl(conn2);
        Order o2=new Order();
        o2.setOrder_number(order_number);

        if(od2.update_status(o2,"4")){
            response.sendRedirect("/shopping/manager_order.jsp");
        }
    }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
