<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="entry.User" %><%--
  Created by IntelliJ IDEA.
  User: Lengths
  Date: 2021/1/2
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
</head>
<body>
        <h1 id="type">我的信息</h1>

<%--        会员 会员帐号，真实姓名，密码，身份证号，地址，电话，Email，QQ--%>
        <table border="0" style=" margin-left:300px ">
            <tr>
                <td width="100" number="delete">会员帐号</td>
                <td width="100" name="order_number">真实姓名</td>
                <td width="100" name="information">密码</td>
                <td width="100" number="name">身份证号</td>
                <td width="100" name="price">地址</td>
                <td width="100" age="user_name">电话</td>
                <td width="100" age="phone">Email</td>
                <td width="100" age="QQ">QQ</td>

            </tr>
            <%
                int t=0;

                DatabaseConnection dbc = new DatabaseConnection();
                Connection conn = dbc.getConnection();
                UserDao ud =new UserDaoImpl(conn);
                String name = request.getParameter("name");
                //String name = (String) request.getAttribute("name");
                //订单编号，订单商品编号，商品总价，买家编号，收货人姓名，收货地址，联系方式，状态编号
                User user = ud.select(name);

            %>
            <tr>

                <td width="150"><%=user.getUser_number()%>
                </td>
                <td width="120"><%=user.getUser_name()%>
                </td>
                <td width="120"><%=user.getUser_password()%>
                </td>
                <td width="120"><%=user.getUser_id()%>
                </td>

                <td width="100"><%=user.getUser_address() %>
                </td>
                <td width="100"><%=user.getUser_phone()%>
                </td>
                <td width="140"><%=user.getUser_email()%>
                </td>
                <td width="120"><%=user.getUser_qq()%>
                </td>
            </tr>

        </table>
        <a href="index.jsp?name=<%=request.getParameter("name")%>" style="float: right">首页</a>
</body>
</html>
