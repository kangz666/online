package controller;

import dao.UserDao;
import entry.User;
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
 * @date 2020-12-29
 */
@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //请求参数
        String number = request.getParameter("number");
        String password=request.getParameter("password");
        String name= request.getParameter("name");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String id=request.getParameter("id");
        String email= request.getParameter("email");
        String qq = request.getParameter("qq");

        //注册存档
        DatabaseConnection dbc=new DatabaseConnection();
        Connection conn=dbc.getConnection();
        UserDao ud =new UserDaoImpl(conn);

        User b1=ud.select(number);
        if(b1 == null){
            //用户不存在，可以注册
            User u =new User();
            u.setUser_id(id);
            u.setUser_name(name);
            u.setUser_password(password);
            u.setUser_number(number);
            u.setUser_address(address);
            u.setUser_email(email);
            u.setUser_phone(phone);
            u.setUser_qq(qq);
            boolean b=ud.insert(u);
            if(b){
                //注册成功
                out.print("<script type='text/javascript'>");
                out.print("alert('注册成功，请重新登陆！');");
                out.print("window.location='first.html'");
                out.print("</script>");
            }else{
                //注册失败
                out.print("<script type='text/javascript'>");
                out.print("alert('注册失败，请重新输入！');");
                out.print("window.location='second.html'");
                out.print("</script>");
            }
        }else {
            //用户已存在
            //注册失败
            out.print("<script type='text/javascript'>");
            out.print("alert('注册失败，已存在该用户，请重新输入！');");
            out.print("window.location='second.html'");
            out.print("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
