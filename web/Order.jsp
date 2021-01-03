<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.OrderDao" %>
<%@ page import="dao.impl.OrderDaoImpl" %>
<%@ page import="entry.Order" %>
<%@ page import="entry.Order_status" %>
<%@ page import="dao.Order_statusDao" %>
<%@ page import="dao.impl.Order_statusDaoImpl" %>
<%@ page import="entry.Information" %>
<%@ page import="dao.InformationDao" %>
<%@ page import="dao.impl.InformationDaoIpml" %><%--
  Created by IntelliJ IDEA.
  User: Lengths
  Date: 2021/1/1
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
</head>
<body>
<script>
    function delete_order(order_number,name,information_number) {
        //alert(information_number);
        var gg= confirm("确定是否删除");
        if(gg){
            window.location.href ="OrderServlet?method=delete&order_number=" + order_number+"&name="+name+"&information_number="+information_number;
        }else{
            confirm("取消删除");
        }


    }
    function order(order_number,name) {
        // alert(order_number);
        var gg= confirm("是否确定收货");
        if(gg){
            window.location.href = "OrderServlet?method=update&order_number=" + order_number+"&name="+name;
        }else{
            confirm("取消收货确定");
        }
    }

</script>
<div class="content column">
    <div class="header">

        <h1 id="type">订单列表</h1>
        <a href="index.jsp?name=<%=request.getParameter("name")%>" style="float: right">首页</a>
        <table border="0" style=" margin-left:300px ">
            <tr>
                <%--                //订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号--%>
                <td width="100" number="delete">删除订单</td>
                <td width="100" number="delete">确认订单</td>
                <td width="100" name="order_number">订单编号</td>
                <td width="100" name="information">商品编号</td>
                <td width="100" number="name">商品名称</td>
                <td width="100" name="price">商品总价</td>
                <td width="100" age="user_name">收货人姓名</td>
                <td width="100" age="address">收货地址</td>
                <td width="100" age="phone">联系方式</td>
                <td width="100" age="status">状态</td>

            </tr>
            <%
                int t=0;

                DatabaseConnection dbc = new DatabaseConnection();
                Connection conn = dbc.getConnection();
                OrderDao od=new OrderDaoImpl(conn);
                Order_statusDao osd= new Order_statusDaoImpl(conn);
                InformationDao id= new InformationDaoIpml(conn);
                String name = request.getParameter("name");
                //订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
                ArrayList<Order> od_list = od.select_name(name);
                for (Order c : od_list) {
                    {
                        Order_status os = osd.select(c.getStatus_number());
                        Information i= id.select_info(c.getInformation_number());
            %>
            <tr>
                <td width="100">
                    <button style="background-color: white;border: 0px" onclick="delete_order('<%=c.getOrder_number()%>','<%=request.getParameter("name")%>','<%=i.getInformation_number()%>')")> <img
                            src="picture/减少.png" width="32px" ; height="32px" ; alt=""></button>
                </td>
                <td width="100">
                    <button style="background-color: white;border: 0px" onclick="order('<%=c.getOrder_number()%>','<%=request.getParameter("name")%>')")> <img
                            src="picture/成功.png" width="32px" ; height="32px" ; alt=""></button>
                </td>
                <td width="150"><%=c.getOrder_number()%>
                </td>
                <td width="120"><%=c.getInformation_number()%>
                </td>
                <td width="120"><%=i.getInformation_name()%>
                </td>
                <td width="120"><%=c.getGoods_price()%>
                </td>

                <td width="100"><%=c.getUser_name() %>
                </td>
                <td width="100"><%=c.getUser_address()%>
                </td>
                <td width="140"><%=c.getUser_phone()%>
                </td>
                <td width="120"><%=os.getOrder_status()%>
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
