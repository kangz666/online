package controller;

import dao.CategoryDao;
import dao.InformationDao;
import entry.Category;
import entry.Information;
import dao.impl.CategoryDaoImpl;
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
 * @date 2020-12-30
 */
@WebServlet(urlPatterns = "/ManagermentServlet")
public class ManagermentServlet extends HttpServlet {

    public ManagermentServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        //请求参数
        String method = request.getParameter("method");
        String number = request.getParameter("number");
        String sum = request.getParameter("sum");
        System.out.println(method+number+sum);
        if(sum==null){
            sum="0";
        }
        if(method.equals("delete")){
            DatabaseConnection dbc=new DatabaseConnection();
            Connection conn=dbc.getConnection();
            InformationDao id =new InformationDaoIpml(conn);
            Information i =new Information();
            i.setInformation_number(number);
            Information info = id.select_info(number);
            CategoryDao c= new CategoryDaoImpl(conn);
            Category select = c.select(info.getCategory_number());

            if(id.delete(i)){
                out.print("<script type='text/javascript'>");
                out.print("alert('删除成功！');");
                out.print("window.location='Manager.jsp?type=手机'");
                out.print("</script>");
            }else{
                out.print("<script type='text/javascript'>");
                out.print("alert('删除失败！');");
                out.print("window.location='Manager.jsp?type=手机'");
                out.print("</script>");
            }
        }
        if(method.equals("update")){

            DatabaseConnection dbc=new DatabaseConnection();
            Connection conn=dbc.getConnection();
            InformationDao id =new InformationDaoIpml(conn);
            Information i =new Information();

            i.setInformation_number(number);
            Information info = id.select_info(number);
            CategoryDao c= new CategoryDaoImpl(conn);
            Category select = c.select(info.getCategory_number());
                if(id.update_sum(i,Integer.valueOf(sum))){
                    out.print("<script type='text/javascript'>");
                    if(sum=="0"){
                        out.print("alert('更新取消！');");
                    }else {
                        out.print("alert('更新成功！');");
                    }
                    out.print("window.location='Manager.jsp?type="+select.getCategory_name()+"'");
                    out.print("</script>");
                }else{
                    out.print("<script type='text/javascript'>");
                    out.print("alert('更新失败！');");
                    out.print("window.location='Manager.jsp?type="+select.getCategory_name()+"'");
                    out.print("</script>");
                }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
