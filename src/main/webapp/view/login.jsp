<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Internship Sign In & Sign Up Form a Responsive Widget Template :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="top-buttons-agileinfo">
    <a href="/view/websocketDemo.jsp"  class="active">登录</a><a href="/view/signup.jsp">注册</a>
</div>
<h1>登录聊天室
</h1>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">登录</h2>
        <form action="/user/login" method="post">
            <input type="email" name="email" placeholder="邮箱" required="" />
            <input type="password" name="password" placeholder="密码" required="" />
            <div class="submit-w3l">
                <input type="submit" value="登录">
            </div>
            <p class="p-bottom-w3ls"><a href="/view/signup.jsp">点击注册</a></p>
        </form>
    </div>
</div>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script>
    var msg = '${error}';
    if(msg!=null && typeof (msg)=='undefined' ){
        alert(msg);
    }
</script>
</body>
</html>