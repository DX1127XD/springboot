<%--
  Created by IntelliJ IDEA.
  User: 杜旋
  Date: 2021/6/20
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <!-- 使用Edge最新的浏览器的渲染方式 -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
        width: 默认宽度与设备的宽度相同
        initial-scale: 初始的缩放比，为1:1 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>用户信息管理系统</title>

        <!-- 1. 导入CSS的全局样式 -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
        <script src="lib/js/jquery-3.4.1.min.js"></script>
        <!-- 3. 导入bootstrap的js文件 -->
        <script src="web/lib/bootstrap/js/bootstrap.min.js"></script>
        <style type="text/css">
            table{
                border: solid #C7C7C7
                border-collapse: separate;
                border-spacing: 0;
                width:800px;

            }


            /*给左边第一个th设置左上边框圆角*/
            table  th:first-child {
                border-top-left-radius: 15px;
            }
            /*给左边/最后一个th设置右上边框圆角*/
            table  th:last-child {
                border-top-right-radius: 15px;
            }
            /*给底部的tfoot的第一个td设置左下圆角*/
            table  tr:first-child td:last-child {
                border-bottom-left-radius: 15px;
            }
            /*给tfoot的最后一个td设置右下圆角*/
            table tfoot td:last-child td:last-child {
                border-bottom-right-radius: 15px;
            }
            td, th {
                text-align: center;

            }
            td{
                color: white;
            }
            body{
                background-image:url("picture/img1.jpg");
            }
        </style>

        <script>
            function deleteUser(id){
                //用户安全提示
                if(confirm("您确定要删除吗？")){
                    //访问路径
                    location.href="${pageContext.request.contextPath}/delSelectedServlet?id="+id;
                }
            }


        </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/CURD.jsp" method="post">
            <div class="form-group">
                <label for="exampleInputName2">编号</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
            </div>

            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/registe.jsp">添加联系人</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="2" class="table " frame="void" >
            <tr class="success">
                <th>编号</th>
                <th>姓名</th>
                <th>电话</th>
                <th>地址</th>
                <th>部门</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${sessionScope.customer}" var="customer" varStatus="s">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.telephone}</td>
                    <td>${customer.address}</td>
                    <td>${customer.dept}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/update.jsp?id=${customer.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${customer.id});">删除</a></td>
                </tr>

            </c:forEach>


        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    </a>
                </li>







            </ul>
        </nav>


    </div>


</div>


</body>

</html>
<%--
<style>
    body{
        background: url(picture/img1.jpg);
    }
    td{
        color: white;
    }
    h3{
        color: white;
    }
    label{
        color: white;
    }
    span{
        color: white;
    }
</style>--%>
