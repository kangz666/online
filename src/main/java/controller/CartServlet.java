package controller;

import dao.CartDao;
import dao.InformationDao;
import entry.Cart;
import entry.Information;
import dao.impl.CartDaoImpl;
import dao.impl.InformationDaoIpml;
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
@WebServlet(urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    public CartServlet() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out=response.getWriter();
        //请求参数
        String method = request.getParameter("method");
        String number = request.getParameter("information_number");
        String sum= request.getParameter("sum");
        String cname = request.getParameter("name");
            //查询商品信息
        DatabaseConnection dbc=new DatabaseConnection();
        Connection conn=dbc.getConnection();
        InformationDao id = new InformationDaoIpml(conn);
        Information info = id.select_info(number);

        Cart c=new Cart();
        c.setInformation_number(number);
        c.setInformation_name(info.getInformation_name());
        c.setInformation_price(info.getInformation_price());
        c.setSum(Integer.valueOf(sum));
        c.setInformation_name(info.getInformation_name());
        c.setMoney(Integer.parseInt(sum)*info.getInformation_price());
        c.setUser_number(cname);

        CartDao cd=new CartDaoImpl(conn);
        if(method.equals("cart")){
            boolean insert = cd.insert(c);
            if(insert){
                response.sendRedirect("/shopping/Cart.jsp?name="+cname);

            }else{
                response.sendRedirect("/shopping/Cart.jsp?name="+cname);
            }
        }


        if(method.equals("delete")){

            DatabaseConnection dbc1=new DatabaseConnection();
            Connection conn1=dbc1.getConnection();
            CartDao cd1=new CartDaoImpl(conn1);
            if(cd1.delete(c)){
                response.sendRedirect("/shopping/Cart.jsp?name="+cname);

            }else{

                response.sendRedirect("/shopping/Cart.jsp?name="+cname);
            }



        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
