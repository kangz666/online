<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.InformationDao" %>
<%@ page import="dao.impl.InformationDaoIpml" %>
<%@ page import="dao.CategoryDao" %>
<%@ page import="dao.impl.CategoryDaoImpl" %>
<%@ page import="entry.Information" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entry.Category" %>
<%@ page import="dao.CartDao" %>
<%@ page import="dao.impl.CartDaoImpl" %>
<%@ page import="entry.Cart" %><%--
  Created by IntelliJ IDEA.
  User: Lengths
  Date: 2021/1/1
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <script>
        function delete_cart(n,price,name,sum) {
            //alert(name);
                window.location.href = "CartServlet?method=delete&information_number=" + n + "&name=" + name + "&sum=" + sum;

        }
        function order(n,price,name,sum) {
           // alert(name);
                var gg= confirm("请支付" +price + "元");

                if(gg){
                    window.location.href = "OrderServlet?method=order&information_number=" + n + "&name=" + name + "&sum=" + price;

                }else{
                    confirm("取消购买");
                }


        }
    </script>
<div class="content column">
    <div class="header">

        <h1 id="type">商品列表</h1>
        <a href="index.jsp?name=<%=request.getParameter("name")%>" style="float: right">首页</a>
        <table border="0" style=" margin-left:300px ">
            <tr>
                <td width="100" number="select">立即购买</td>
                <td width="100" number="select">删除</td>
                <td width="100" name="price">商品编号</td>
                <td width="100" number="title">商品名称</td>
                <td width="100" name="price">商品总价</td>
                <td width="100" age="sum">数量</td>

            </tr>
            <%
                int t=0;

                DatabaseConnection dbc = new DatabaseConnection();
                Connection conn = dbc.getConnection();
                CartDao cd=new CartDaoImpl(conn);

                String name = request.getParameter("name");
                //String name = (String) request.getAttribute("name");

                ArrayList<Cart> cd_list = cd.select(name);
                for (Cart c : cd_list) {
                    {
            %>
            <tr>
                <td width="100">

                <button style="background-color: white;border: 0px" onclick="order('<%=c.getInformation_number() %>','<%=c.getMoney() %>','<%=request.getParameter("name")%>','<%=c.getSum()%>')")> <img
                        src="picture/rejected-order.jpg" width="32px" ; height="32px" ; alt=""></button>
            </td>
                <td width="100">

                    <button style="background-color: white;border: 0px" onclick="delete_cart('<%=c.getInformation_number() %>','<%=c.getMoney() %>','<%=request.getParameter("name")%>','<%=c.getSum()%>')")> <img
                            src="picture/ashbin.jpg" width="32px" ; height="32px" ; alt=""></button>
                </td>
                <td width="120"><%=c.getInformation_number()%>
                </td>
                <td width="100"><%=c.getInformation_name() %>
                </td>
                <td width="100"><%=c.getMoney()%>
                </td>
                <td width="100"><%=c.getSum()%>
                </td>

            </tr>
            <%
                    }

                }
            %>
        </table>
    </div>
</div>
</div>
</body>
</html>
