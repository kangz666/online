<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dao.InformationDao" %>
<%@ page import="dao.impl.InformationDaoIpml" %>
<%@ page import="dao.CategoryDao" %>
<%@ page import="dao.impl.CategoryDaoImpl" %>
<%@ page import="entry.Information" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entry.Category" %>
<%@ page import="javafx.scene.image.PixelFormat" %>
<%@page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>生活中心</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <style>
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
    </style>
</head>
<body><!------------------------------head------------------------------>
<%
    String username= (String) request.getSession().getAttribute("name");
    request.setAttribute("username",username);
%>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="picture/家.png"/></a></h1>
            <div class="fr clearfix" id="top1">
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：手机"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="User.jsp?name=${username}"><img src="picture/grzx.png"/></a><a href="Cart.jsp?name=${username}"><img src="picture/gwc.png"/></a>
                    <a href="Order.jsp?name=${username}"><img src="picture/rejected-order.jpg"/></a></div>
            </div>
        </div>

        <ul class="clearfix" id="bott">
            <li><a href="index.jsp?name=${username}">首页</a></li>
            <li><a href="#">电子商品</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a>

                        <dl  onclick="location='/shopping/index.jsp?type=手机&name=${username}'">
                            <dt><img src="https://img.pconline.com.cn/images/product/1124/1124166/blue_sn8.jpg"/></dt>
                            <dd>手机</dd>
                        </dl>
                    </a><a>
                        <dl onclick="location='/shopping/index.jsp?type=电脑&name=${username}'">
                            <dt><img src="https://img11.360buyimg.com/n1/jfs/t1/122252/10/18075/47832/5fab07f7Ea3138df8/4150b3b0a6b37c2a.jpg"/></dt>
                            <dd>电脑</dd>
                        </dl>
                    </a><a>
                        <dl onclick="location='/shopping/index.jsp?type=平板&name=${username}'">
                            <dt><img src="https://img10.360buyimg.com/n1/s450x450_jfs/t1/152006/7/3839/70867/5f992e7fE138ac70c/b10658dac061f4e8.jpg"/></dt>
                            <dd>平板</dd>
                        </dl>
                    </a>

                    </div>
                </div>
            </li>
            <li>
                <a onclick="location='/shopping/index.jsp?type=生活用品&name=${username}'" >生活用品</a>
            </li>

        </ul>
    </div>
</div><!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img width="600px" height="740px" src="https://img12.360buyimg.com/pop/s1180x940_jfs/t1/154217/27/11584/91867/5fe5b1ebEddf6d44e/2bff46e30b94fd71.jpg.webp"/></div>
            </li>
            <li>
                <div class="slide"><img width="600px" height="740px" src="https://img10.360buyimg.com/babel/s1180x940_jfs/t1/153574/37/11525/282567/5fe59d38Ec36e1b2a/7a2c9a5abce65594.jpg.webp"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix"><a onclick="location='/shopping/index.jsp?type=手机&name=${username}'"><img src="https://img.pconline.com.cn/images/product/1124/1124166/blue_sn8.jpg"/></a><a onclick="location='/shopping/index.jsp?type=电脑&name=${username}'"><img
            src="https://img11.360buyimg.com/n1/jfs/t1/122252/10/18075/47832/5fab07f7Ea3138df8/4150b3b0a6b37c2a.jpg"/></a><a onclick="location='/shopping/index.jsp?type=平板&name=${username}'"><img src="https://img10.360buyimg.com/n1/s450x450_jfs/t1/152006/7/3839/70867/5f992e7fE138ac70c/b10658dac061f4e8.jpg"/></a></div>
</div><!------------------------------news------------------------------>
<div style="clear: both"></div>

<script>
    function cartFunction(n,name) {
        var sum = prompt("请输入购买的数量");
        //alert(name);
        if (sum != null) {
            window.location.href = "CartServlet?method=cart&information_number=" + n + "&sum=" + sum + "&name=" + name;
        }
    }
    function orderFunction(information_number,price,name) {
        //alert(name);
        var sum = prompt("请输入购买的数量");
        if (sum != null) {
           var gg= confirm("请支付" + parseInt(sum) * parseInt(price) + "元");

            if(gg){
                window.location.href = "OrderServlet?method=order&information_number=" +information_number+"&name="+name+"&sum="+parseInt(sum) * parseInt(price);
            }else{
                confirm("取消购买");
            }
        }

    }
</script>

    <!-- 右边的部分显示 -->
    <div class="content column">
        <div class="header">

            <h1 id="type">商品列表</h1>

            <table border="0" style=" margin-left:300px ">
                <tr>
                    <td width="100" number="select">立即购买</td>
                    <td width="100" number="select">加入购物车</td>
                    <td width="100" number="title">商品名称</td>
                    <td width="100" name="price">商品单价</td>
                    <td width="100" age="title">类商品别</td>
                    <td width="100" age="sum">商品数量</td>
                    <td width="120" age="text">商品描述</td>
                    <td width="120" age="picture">商品图片</td>
                </tr>
                <%
                    int t=0;
                    DatabaseConnection dbc = new DatabaseConnection();
                    Connection conn = dbc.getConnection();
                    InformationDao id = new InformationDaoIpml(conn);
                    CategoryDao cd = new CategoryDaoImpl(conn);
                    String type = request.getParameter("type");
                    if(type ==null){
                        type="手机";
                    }
                    String name = (String) request.getSession().getAttribute("name");

                    ArrayList<Information> id_list = id.select_category(type);
                    for (Information i : id_list) {
                        {
                            Category c = cd.select(i.getCategory_number());
                %>
                <tr>
                    <td width="100">

                        <button style="  background-color: cornsilk;width: 32px;height: 32px;margin-right: 15px;" onclick="orderFunction('<%=i.getInformation_number()%>','<%=i.getInformation_price() %>',${username})"> <img
                                src="picture/rejected-order.jpg" width="32px" ; height="32px" ; alt=""></button>
                    </td>
                    <td width="100">

                        <button style="  background-color: cornsilk;width: 32px;height: 32px;margin-right: 15px;" onclick="cartFunction('<%=i.getInformation_number() %>',${username})" > <img
                            src="picture/add-cart.jpg" width="32px" ; height="32px" ; alt=""></button>
                    </td>
                    <td width="100"><%=i.getInformation_name() %>
                    </td>
                    <td width="100"><%=i.getInformation_price() %>
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

<!--返回顶部-->
<div style="background-color: #232F3E; color: white; ">
    <div>
        <div style="display: inline-block; width: 30%;">
            <div style="text-align: center;margin-bottom: 70px;">
                关于我们
            </div>
            <div style="margin: 10px 120px;">

               <p style="text-align: center;">发展出口业务，<br></p>
               <p style="text-align: center;">拓展全球市场，<br></p>
               <p style="text-align: center;"> 打造国际品牌。<br></p>
               <p style="text-align: center;">帮助买家提供购买生活起居，<br></p>



            </div>
        </div>
        <div style="display: inline-block;  width: 20%;">
            <div style="text-align: center;margin-bottom: 80px;"> 联系我们</div>
            <div style="text-align: center;margin-bottom: 30px;">联系买家支持 </div>
            <div style="text-align: center;">区域跨境电商园</div>

        </div>
        <div style="display: inline-block;  width: 25%;">
            <div style="text-align: center;margin-bottom: 30px;">关住LIVES微信</div>
            <div style="text-align: center;"><img
                    src="picture/二维码lives.png"
                    style="width:120px ; height:120px" alt="微信号"></div>
        </div>
        <div style="display: inline-block;  width: 20%;">
            <div style="text-align: center;margin-bottom: 30px;">下载官方APP</div>
            <div style="text-align: center;"><img
                    src="picture/二维码lives.png" alt="APP"
                    style="width:120px ; height:120px" ></div>
        </div>

    </div>
    <hr />
    <!-- 最底部 -->
    <div>
        <div><img
                src="picture/交货-2.png"
                alt="图标" style="width:110px ; height:50px" ></div>
        <div style="text-align: end;">
            <p>© 2020, lives Services China. All Rights Reserved. An lives Company</p>
        </div>
    </div>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>