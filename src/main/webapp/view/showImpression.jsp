<%--
  Created by IntelliJ IDEA.
  User: 万民
  Date: 2018/5/31
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/site.css">
    <script src="../js/chat.js"></script><%--封装的发送信息的js--%>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script scr="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body style="background: url(../images/night.jpg)">
<h2 class="content-row-title">好友印象</h2>
<div class="flex-demo" >
    <div class="flex-item"><span contenteditable="true">漂亮</span></div>
    <div class="flex-item"><span contenteditable="true">学霸</span></div>
    <div class="flex-item"><span contenteditable="true">知识分子</span></div>
    <div class="flex-item"><span contenteditable="true">有为青年</span></div>
    <div class="flex-item"><span contenteditable="true">比人家的孩子</span></div>
    <div class="flex-item"><span contenteditable="true">学生</span></div>
    <div class="flex-item"><span contenteditable="true">社会人</span></div>
</div>
<button type="button" class="btn btn-success" id="addToChat">加入群发组</button>
</body>
<script>
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };
    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    $("#addToChat").click(function(){
        var t = $(this).html();
        $(this).html((t == "加入群发组")?"取消群发":"加入群发组");
        if($(this).hasClass("btn btn-success")){
            $(this).removeClass("btn btn-success");
            $(this).addClass("btn btn-danger");
        }else {
            $(this).removeClass("btn btn-danger");
            $(this).addClass("btn btn-success");
        }
        if(t == "加入群发组") {
            to.push(<%=request.getParameter("ID")%>);
        }else{
            to.remove(<%=request.getParameter("ID")%>);
        }
    });
</script>
</html>
