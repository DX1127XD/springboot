<%--
  Created by IntelliJ IDEA.
  User: 杜旋
  Date: 2021/6/16
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>请确认</title>
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="lib/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<center>
    <h1>查询结果</h1></center>
<div class="col-sm-4"></div>
<div class="col-md-4">
    <form  action="SaveServlet" method="get">
    <div id="id" class="input-group">
        <span class="input-group-addon">id<i class="icon-envelope"></i></span>
        <div  class="form-control"><%= session.getAttribute("id")  %><br></div>
    </div><br>
    <div id="name" class="input-group">
        <span class="input-group-addon">姓名<i class="icon-envelope"></i></span>
        <div  class="form-control"><%= session.getAttribute("name")  %></div>
    </div><br>
    <div id="telephone" class="input-group">
        <span class="input-group-addon">电话<i class="icon-envelope"></i></span>
        <div  class="form-control"><%= request.getAttribute("telephone")  %></div>
    </div><br>

    <div id="address" class="input-group">
        <span class="input-group-addon">地址<i class="icon-envelope"></i></span>
        <div  class="form-control"><%= session.getAttribute("address")  %> </div>
    </div><br>
    <div id="dept" class="input-group">
        <span class="input-group-addon">部门<i class="icon-envelope"></i></span>
        <dept  class="form-control"><%= session.getAttribute("dept")  %></dept>
    </div><br>
        <input id="submit" name="submit"  type="submit" value="返回" class="btn btn-block btn-success">
    </form>


</div>
</body>
</html>
