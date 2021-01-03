package controller;

import dao.InformationDao;
import entry.Information;
import dao.impl.InformationDaoIpml;
import utils.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * @author kangz
 * @date 2020-12-29
 */
@WebServlet(urlPatterns = "/ManagerAddServlet")
@MultipartConfig
public class ManagerAddServlet extends HttpServlet {
    public ManagerAddServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String informatian_name=request.getParameter("informatian_name");
        String informatian_number=request.getParameter("informatian_number");
        String category_number=request.getParameter("category_number");
        String price=request.getParameter("price");
        String sum=request.getParameter("sum");
        String text=request.getParameter("text");
//        上传图片
        Part part=request.getPart("picture");

        String filename= part.getSubmittedFileName();
       //防止重名
        String newfilename=System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
        String filepath=getServletContext().getRealPath("/picture");
        File f=new File(filepath);
        if(!f.exists()){
            f.mkdirs();
        }
        part.write(filepath+"/"+newfilename);

        Information i=new Information();
//
        i.setInformation_number(informatian_number);
        i.setInformation_name(informatian_name);
        i.setCategory_number(category_number);
        i.setInformation_price(Float.valueOf(price));
        i.setInformation_sum(Integer.valueOf(sum));
        i.setInformation_picture(newfilename);
        i.setInformation_text(text);
//        更新数据库
        DatabaseConnection dbc=new DatabaseConnection();
        Connection conn=dbc.getConnection();
        InformationDao id = new InformationDaoIpml(conn);
        if(id.insert(i)){
            response.sendRedirect("Manager.jsp");
        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('数据库添加错误');");
            out.print("window.location='add.html'");
            out.print("</script>");
        }
//        Info info =null;
//        request.setAttribute("info",info);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
