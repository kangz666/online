<%@ page import="dao.CategoryDao" %>
<%@ page import="dao.InformationDao" %>
<%@ page import="entry.Category" %>
<%@ page import="entry.Information" %>
<%@ page import="dao.impl.CategoryDaoImpl" %>
<%@ page import="dao.impl.InformationDaoIpml" %>
<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理商品</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <style>
        /* 这是在将段落进行首行缩进 */
        p {
            text-indent: 2em;

            vertical-align: auto;
        }

        * {
            box-sizing: border-box;
            margin: 0px;
            padding: 0px;
        }

        .header {
            background-color: cornsilk;
            text-align: center;
            color: crimson;
            padding: 5px;
        }

        .footer {
            background-color: darkgreen;
            text-align: end;
            color: white;
            padding: 5px;
        }

        /* 这是对头部页标签规划 */
        .topmenu {
            list-style-type: none;
            /*取消列表类型*/
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: rgb(117, 112, 117);

        }

        .topmenu li {
            font-size: larger;
            float: left;
            /*以最左边显示*/

        }

        .topmenu li input {
            /* 对链接进行调整 */
            text-decoration: none;
            display: inline-block;
            color: white;
            text-align: center;
            padding: 30px;

        }

        .topmenu li input:hover {
            /* 鼠标进入链接点击区域更换背景颜色 */
            background-color: rgb(18, 224, 97);
        }

        .topmenu li input:focus {
            /* 显示主页以特殊的背景颜色显示 */
            color: white;
            background-color: tomato;
        }

        .column {
            float: left;
            padding: 15px;
        }

        /* 清除浮动 */
        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }

        /*右边的部分所占比例  */
        .content {
            width: 90%;
        }

        .sidemenu {
            width: 10%;
            text-align: center;
        }

        .sidemenu ul {
            list-style-type: none;
            margin-top: 50px;
            padding: 0;

        }

        .sidemenu ul a {
            margin-bottom: 4px;
            text-decoration: none;
            display: grid;
            padding: 8px;
            background-color: #eee;
            color: #666;
        }

        .sidemenu ul input {
            margin-bottom: 4px;
            text-decoration: none;
            display: grid;
            padding: 8px;
            background-color: #666;
            color: #eee;
            width: 123px;
            height: 36px;
            border: 0px;
        }

        .sidemenu ul a:hover {
            background-color: turquoise;
        }

        .sidemenu ul input:hover {
            background-color: turquoise;
        }

        .sidemenu li a.active {
            background-color: #008CBA;
            color: white;
        }

    </style>

</head>
<body>

<div style="background-color: antiquewhite;">
    <ul class="topmenu">
        <li><input type="button" name="phone" value="手机" onclick="location='/shopping/Manager.jsp?type=手机'"></li>
        <li><input type="button" name="computer" value="电脑" onclick="location='/shopping/Manager.jsp?type=电脑'"></li>
        <li><input type="button" name="iPad" value="平板" onclick="location='/shopping/Manager.jsp?type=平板'"></li>
        <li><input type="button" name="lives" value="生活日用" onclick="location='/shopping/Manager.jsp?type=生活日用'"></li>
        <li><input style="margin-left: 1046px" type="button" name="exit" value="退出" onclick="location='/shopping/managerfirst.jsp'"></li>

    </ul>
</div>
<script>
    function deleteFunction(n) {

        window.location.href = "ManagermentServlet?method=delete&number=" + n;
    }

    function updateFunction(n) {
        var sum = prompt("请输入修改的数量");
        if (sum != null) {
            window.location.href = "ManagermentServlet?method=update&sum=" + sum + "&number=" + n;
        }
    }
</script>
<!-- 躯干左边部分 -->
<div class="clearfix">
    <div class="column sidemenu">
        <ul>
            <li><a href="add.html">添加</a></li>
            <li><a href="manager_order.jsp">管理订单</a></li>
        </ul>

    </div>
    <!-- 右边的部分显示 -->
    <div class="content column">
        <div class="header">

            <h1 id="type">商品列表</h1>

            <table border="0" style=" margin-left:300px ">
                <tr>
                    <td width="100" number="select">删除</td>
                    <td width="100" number="select">修改</td>
                    <td width="100" number="title">商品名称</td>
                    <td width="10" age="title_number">商品编号</td>
                    <td width="100" name="price">商品单价</td>
                    <td width="100" age="number">类别编号</td>
                    <td width="100" age="title">类商品别</td>
                    <td width="100" age="sum">商品数量</td>
                    <td width="120" age="text">商品描述</td>
                    <td width="120" age="picture">商品图片</td>
                </tr>
                <%
                    int t = 0;
                    DatabaseConnection dbc = new DatabaseConnection();
                    Connection conn = dbc.getConnection();
                    InformationDao id = new InformationDaoIpml(conn);
                    CategoryDao cd = new CategoryDaoImpl(conn);

                    String type = request.getParameter("type");
                    if (type == null) {
                        type = "手机";
                    }
                    ArrayList<Information> id_list = id.select_category(type);

                    for (Information i : id_list) {
                        {
                            Category c = cd.select(i.getCategory_number());
                %>
                <tr>
                    <td width="100">

                        <button style=" background-color: cornsilk;width: 32px;height: 32px;margin-right: 15px"
                                onclick="deleteFunction(<%=i.getInformation_number()%>)"><img
                                src="picture/ashbin.jpg" width="32px" ; height="32px" ; alt=""></button>
                    </td>
                    <td width="100">
                        <button style=" background-color: cornsilk;    width: 32px;height: 32px;"
                                onclick="updateFunction(<%=i.getInformation_number()%>)">
                            <img src="picture/edit.jpg" width="32px" ; height="32px" ; alt=""></button>

                    </td>
                    <td width="100"><%=i.getInformation_name() %>
                    </td>
                    <td width="100"><%=i.getInformation_number() %>
                    </td>
                    <td width="100"><%=i.getInformation_price() %>
                    </td>
                    <td width="100"><%=i.getCategory_number()%>
                    </td>
                    <td width="100"><%=c.getCategory_name()%>
                    </td>
                    <td width="100"><%=i.getInformation_sum() %>
                    </td>
                    <td width="120"><%=i.getInformation_text()%>
                    </td>
                    <td width="120"><img width="100px" height="100px"
                                         src="${pageContext.request.contextPath}/picture/<%=i.getInformation_picture() %>"
                                         alt=""></td>
                </tr>
                <%
                        }

                    }
                %>
            </table>
        </div>
    </div>
</div>
<!-- 底部显示 -->
<div class="footer">
    <p style="text-align: center;">版本1.01.03</p>
    <p style="text-align: right;">开发时间：2020年12月29日22:05:59</p>
</div>

</body>
</html>