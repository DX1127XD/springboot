<%--
  Created by IntelliJ IDEA.
  User: 杜旋
  Date: 2021/6/23
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="lib/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="col-sm-4"></div>
<div id="form_text" class="col-md-4">
    <center>
        <h2>修改信息</h2>

    </center>
    <form  action="RegistServlet" method="post">

        <p>
        </p><div id="div-id" class="input-group">
        <span class="input-group-addon" id="sizing-addon1">id</span>
        <input required id="id" type="text" class="form-control" lable="" name="id">
    </div>
        <p>
        <p>
        </p><div id="div-user_name" class="input-group">
        <span class="input-group-addon" id="sizing-addon2">username</span>
        <input required id="user_name" type="text" class="form-control" placeholder="Username" name="username">
    </div>
        <p>
        </p><div id="div-user_telephone" class="input-group">
        <span class="input-group-addon" id="sizing-addon3">telephone</span>
        <input required id="user_telephone" type="text" class="form-control" placeholder="telephone" name="telephone">
    </div>
        <p>
        </p><div id="div-user_address" class="input-group">
        <span class="input-group-addon" id="sizing-addon4">address</span>
        <input required id="user_address" type="text" class="form-control" placeholder="address" name="address">
    </div>
        <p>
        </p><div id="div-user_dept" class="input-group">
        <span class="input-group-addon" id="sizing-addon5">dept</span>
        <input required id="user_dept" type="text" class="form-control" placeholder="dept" name="dept">
    </div>
        <p>
        <p></p>

        <input id="submit" name="submit"  type="submit" value="提 交" class="btn btn-block btn-success">

        <button type="button"  onclick="javascript:location.reload()"class="btn btn-xs btn-primary">重置</button>
    </form>
</body>
<style>

</style>
</html>
