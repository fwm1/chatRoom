<%--
  Created by IntelliJ IDEA.
  User: 万民
  Date: 2018/6/3
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史消息</title>
</head>
<body>
<form class="navbar-form navbar-left" method="post" action="/message/download/">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="输入好友名" name="user_name">
    </div>
    <button type="submit" class="btn btn-primary">下载</button>
</form>
</body>
</html>
