<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Internship Sign In & Sign Up Form a Responsive Widget Template :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2 class="sub-agileits-w3layouts">注册</h2>
        <form action="/user/register" method="post" >
            <input type="text" name="user_name" placeholder="用户名" required="" />
            <input type="password" name="password" placeholder="密码" required="" />
            <input type="password" name="rePassword" placeholder="确认密码" required=""/>
            <label><input type="radio" name="sex" value="男">男</label>
             <label><input type="radio" name="sex" value="女">女</label>
            <input type="text" name="age" max="150" min="0" placeholder="年龄">
            <input type="text" name="email" placeholder="邮箱地址">
            <input type="text" name="address" placeholder="所在地">
            <input type="text" name="qq_id" placeholder="QQ"/>
            <input type="text" id="captcha" name="captcha" class="text" maxlength="10" placeholder="输入验证码"/>
            <img id="captchaImage" src="/user/captcha"/>
            <div class="submit-w3l">
                <input type="submit" value="注册">
            </div>
        </form>
    </div>
</div>
<script>
    $('#captchaImage').click(function()
    {   //后面加入时间戳作为参数，timestamp=" + (new Date()).valueOf()。加入这个参数就可以实现重新访问后台方法。否则是无法刷新图像的。
        $('#captchaImage').attr("src", "captcha.form?timestamp=" + (new Date()).valueOf());
    });
    var msg = '${error}';
    if(msg!=null && typeof (msg)=='undefined' ){
        alert(msg);
    }
</script>
</body>
</html>