package controller;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
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
 * @date 2020-12-29
 */
@WebServlet(urlPatterns = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    public ManagerServlet() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //请求参数
        String number = request.getParameter("number");
        String password=request.getParameter("password");
        //登录验证
        DatabaseConnection dbc=new DatabaseConnection();
        Connection conn=dbc.getConnection();
        AdminDao ad =new AdminDaoImpl(conn);
        boolean b= ad.login(number,password);
        if( b==true ){
            response.sendRedirect("Manager.jsp");
        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('密码或者用户名错误，请重新输入！');");
            out.print("window.location='managerfirst.html'");
            out.print("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
