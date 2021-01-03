package controller;

import dao.UserDao;
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
 * @date 2020-12-28
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //请求参数
        String number = request.getParameter("number");
        String password=request.getParameter("password");
        String method = request.getParameter("method");
        String user_number = request.getParameter("user_number");
        String user_password = request.getParameter("user_password");
        //登录验证
        DatabaseConnection dbc=new DatabaseConnection();
        Connection conn=dbc.getConnection();
        UserDao ud =new UserDaoImpl(conn);

        if(method.equals("login")){
            boolean b= ud.login(number,password);
            if( b==true ){
//                response.sendRedirect("index.jsp");
                request.getSession().setAttribute("name",number);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                out.print("<script type='text/javascript'>");
                out.print("alert('密码或者用户名错误，请重新输入！');");
                out.print("window.location='first.html'");
                out.print("</script>");
            }
        }
       if(method.equals("update")){
           boolean b = ud.update_password(user_number, user_password);
           if(b){
               out.print("<script type='text/javascript'>");
               out.print("alert('修改成功，请重新输入！');");
               out.print("window.location='first.html'");
               out.print("</script>");
           }
       }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
