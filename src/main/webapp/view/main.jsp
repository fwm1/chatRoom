<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fwm.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>聊天大厅</title>
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <%--<script type="text/javascript" src="../js/websocket.js"></script>--%>
    <script type="text/javascript" src="../js/jquery.nicescroll.min.js"></script><!--右侧的滚动条-->
    <link href="../css/reset.css" rel="stylesheet" type="text/css">
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <script>
        $(document).ready(
            function () {
                $("#col-r").niceScroll({
                    cursorwidth: "10px",
                    horizrailenabled: false
                });
            }
        );
    </script>
</head>
<body>

<%--<%
    List<User> friends  = (List<User>) request.getAttribute("friends");
    pageContext.setAttribute("friends", friends);
%>--%>
<%--<form method="post" action="index.html" id="form2">--%>
    <div id="header">
        <div class="main-nav">
            <ul>
                <li class="current"><a href="/user/main" class="current">大厅</a></li>
                <li class="nav-reply"><a href="../view/history.jsp">历史消息</a></li>
            </ul>
        </div>
        <div style="display: none">
            <input type="submit" name="ctl00$Top$LogOut" value="Button" id="Top_LogOut">
        </div>
    </div>
    <div>
        <div id="col-l">
            <div class="col-l-t">
                <div class="content">
                    <div class="bubble" id="Chat">
                        <div class="msg clearfix">
                            <div class="user-assistant"> </div>
                            <span class="triangle"></span>
                            <div class="article">
                                <p>您好，欢迎登录聊天大厅。</p><p>请文明发言</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-l-b">
                <div class="faq-input-content">
                    <textarea name="textfield" class="input" id="faqInput" placeholder="To: 世界..." autocomplete="off" onkeydown="checkEnter(event)"></textarea>
                    <input type="button" class="btn" value="发送" id="send_bt" onclick="ChatSendClient()" >
                    <div class="input-count"><span id="textCount"></span></div>
                </div>
            </div>
        </div>

        <div id="col-r" tabindex="0" style="overflow-y: hidden; outline: none;" >
            <div class="container-fluid">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <button type="button" class="btn btn-default btn-sm">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 好友列表
                                    </button>
                                </a>
                            </h4>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal" style="float: right">
                                <span class="badge">${asks.size()}</span>
                                <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                                好友请求
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">好友请求: </h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-hover">
                                                <c:forEach items="${asks}" var="a">
                                                    <tr>
                                                        <td class="from">${a.from}</td>
                                                        <td>${a.time}</td>
                                                        <td><button type="button" class="btn btn-success agreeFriend">同意</button></td>
                                                        <td><button type="button" class="btn btn-success refuse">拒绝</button></td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <ul class="reply-main">
                                    <c:forEach items="${friends}" var="f" >
                                        <li>
                                            <div  id="slider">
                                                <a  style="display: inline-block" tabindex="0" class="user_info" role="button" data-toggle="popover" data-placement="bottom"
                                                   data-trigger="focus" title="好友信息" data-html="true"
                                                   data-content="邮箱:${f.email}<br>性别:${f.sex}<br>年龄:${f.age}<br>所在地:${f.address}<br>好友标签:${f.impressions}"><img src="http://q1.qlogo.cn/g?b=qq&nk=${f.qq_id}&s=40" style="display: inline"><h2 class="user_name" style="display:inline;">${f.user_name}</h2><span class="badge">0</span></a>
                                                <br>
                                                <button type="button" class="btn btn-success btn-sm private_chat">私聊</button>

                                                <button class="btn btn-primary btn-sm addImpression" type="button" data-toggle="collapse"  data-target=".collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                    添加标签
                                                </button>
                                                <div class="collapse collapseExample">
                                                    <div class="well">
                                                        <form class="navbar-form navbar-left" method="post" action="/user/addImpression">
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" placeholder="输入标签" name="impression">
                                                                <input type="hidden" value="${f.user_name}" name="user_name"/>
                                                            </div>
                                                            <button type="submit" class="btn btn-primary">Add</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal2">
                                添加好友
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel2">输入好友ID: </h4>
                                        </div>

                                            <div class="modal-body">
                                                <form class="navbar-form navbar-left" method="post" id="form1">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="输入好友名称" name="user_name">
                                                    </div>
                                                </form>
                                            </div>

                                        <div class="modal-footer">
                                            <table class="table table-hover" id="table1">
                                            </table>
                                            <button type="button" class="btn btn-primary" onclick="findUser()">查找</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

<script src="../js/jquery.input.count.js"></script><!--限制输入字数-->
<script src="../js/jquery.pageslide.js"></script><%--滑出子页面--%>

<div id="pageslide" style="display: none;"></div>
<script>
    $(".slider").pageslide({ direction: "left", modal: "true" });
    /*初始化模态框*/
    $('[data-toggle="popover"]').popover();
    //鼠标移入移除显示提示框
    $(".user_info").on({
        mouseover:function(){
            $(this).popover('show');
        },
        mouseout:function(){
            $(this).popover('hide');
        }
    });

    //关闭模态框后清除原来的信息
    $('#myModal2').on('hide.bs.modal',function(){
        $('#table1').find('tr').remove();
    });
    function findUser() {
        $('#table1').find('tr').remove();
        $.ajax({
            type:'POST',
            dataType:'JSON',
            url:'/user/findUser',
            data:$("#form1").serialize(),
            success:function(result){
                var str = JSON.stringify(result);
                var json = $.parseJSON(str);
                for(var i=0;i<json.length;i++){
                    $("#table1").append('<tr><td class="nametd">'+json[i].user_name+'</td>' +
                        '<td class="addFriend"><button type="button" class="btn btn-success">加为好友</button></td>' +
                        '</tr>' + '<tr ><td>'+json[i].sex+'</td></tr>' + '<tr ><td>'+json[i].age+'</td></tr><tr><td>'+json[i].address+'</td></tr>' +
                        '<tr ><td>'+json[i].email+'</td></tr>');
                }
            }
        });
    }
    //jquery选取动态生成的元素并绑定事件
    $("#table1").on('click', '.addFriend', function(){
        var friend_name = $(this).parents("tr").find(".nametd").text();
        $.ajax({
            url: '/user/ask/'+friend_name,
            data:{},
            scriptCharset:'utf-8',
            success:function(result){
                alert(result);
            }
        });
    });

    $(".agreeFriend").click(function () {
        var from_ = $(this).parents("tr").find(".from").text();
        alert(from_);
        $(this).parents("tr").hide();
        $.ajax({
            url: '/user/agree/'+from_,
            data:{},
            scriptCharset:'utf-8',
            success:function(result){
                alert(result);
            }
        });
    });
    $(".refuse").click(function () {
        var from = $(this).parents("tr").find(".from").text();
        $(this).parents("tr").hide();
        $.ajax({
            url: '/user/refuse/'+from,
            data:{},
            scriptCharset:'utf-8',
            success:function(result){
            }
        });
    });

</script>
<script>
    $().ready(function(){
        var to = null;
        $(".private_chat").click(function(){
            to = $(this).prev().prev().find('h2').text();
            $("#faqInput").attr('placeholder', 'To:'+to+'...');
            //清空聊天窗口内容
            $("#Chat").empty();
            //var count = $(this).prev().find('.badge').text();
            $(this).prev().prev().find('.badge').text(0);
            //清空后ajax的内容无法添加？？？
            //$(".col-l-t").html("");
            $.ajax({
                url: '/message/listHistory/'+to,
                data:{},
                scriptCharset:'utf-8',
                success:function(result){
                    var str = JSON.stringify(result);
                    var json = $.parseJSON(str);
                    $.each(json, function(index, val){
                        var time = val.time;
                        var body = val.body;
                        var sender = val.from;
                        var el = document.getElementById('Chat');
                        el.innerHTML += "<div class='msg clearfix'><div class='user-assistant'></div><span class='triangle right'></span><div class='article'>" +sender+"<p style='font-size: smaller'>" + time + "</p>" +"</br>"+ body + "</div></div>";
                        $(".slider").pageslide({ direction: "left" });
                    });
                }
            });
        });
        var userId = '<%=session.getAttribute("user_name")%>';
        var websocket = null;
        var url = "ws://localhost:8080/ws/"+userId;
        websocket = new WebSocket(url);
        function sendMessage(text) {
            websocket.send(text);
        }
        //连接成功建立的回调方法
        websocket.onopen = function () {
        }
        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            var jsonObj = JSON.parse(event.data);
            var sender = jsonObj.from;
            var receiver = jsonObj.to;
            if(typeof (receiver)=='undefined'|| to == sender){
                showMessage(event);
            }else{
                $(".user_name").each(function(){
                    var user_name = $(this).text();
                    if(sender == user_name){
                        //jquery将text()转换成数字类型 ‘+’
                        var num = +$(this).next().text();
                        num++;
                        $(this).next().text(num);
                    }
                });
            }
        };
        function showMessage(message){
            var jsonObj = JSON.parse(message.data);
            var time = jsonObj.time;
            var body = jsonObj.body;
            var sender = jsonObj.from;
            var el = document.getElementById('Chat');
            //el.innerHTML +=
            el.innerHTML += "<div class='msg clearfix'><div class='user-assistant'></div><span class='triangle right'></span><div class='article'>" +sender+"<p style='font-size: smaller'>" + time + "</p>" +"</br>"+ body + "</div></div>";
            $(".slider").pageslide({ direction: "left" });
        }
        //连接发生错误的回调方法
        websocket.onerror = function () {
            alert("WebSocket连接发生错误");
        };

        //连接关闭的回调方法
        websocket.onclose = function () {
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            websocket.close();
        }

        function checkEnter(e) {
            var et = e || window.event;
            var keycode = et.charCode || et.keyCode;
            if (keycode == 13) {
                if (window.event)
                    window.event.returnValue = false;
                else
                    e.preventDefault(); //for firefox
            }
        }
        $(document).ready(function() {
            //focusblur
            jQuery.focusblur = function (focusid) {
                var focusblurid = $(focusid);
                var defval = focusblurid.val();
                focusblurid.focus(function () {
                    var thisval = $(this).val();
                    if (thisval == defval) {
                        $(this).val("");
                    }
                });
                focusblurid.blur(function () {
                    var thisval = $(this).val();
                    if (thisval == "") {
                        $(this).val(defval);
                    }
                });
            };
            /*下面是调用方法*/
            $.focusblur("#faqInput");
        });
        function ChatSendClient() {
            var s = document.getElementById('faqInput');
            var str = s.value;
            var message={
                'to': to,
                'body':str
            }
            if (s.value == "") {
                return;
            }
            s.value = "";
            ClientChat(message.body);
            sendMessage(JSON.stringify(message));
        }
        function ClientChat(str) {
            var el = document.getElementById('Chat');
            el.innerHTML += "<div class='msg fr'><span class='triangle right'></span><div class='article'><xmp>" + str + "</xmp></div></div>";
            $('.col-l-t').animate({ scrollTop: document.getElementById('Chat').scrollHeight + 'px' });
        }

        document.onkeydown = function(event) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode == 13) { // enter 键
                e.preventDefault();
                ChatSendClient();
            }
        }
    });
</script>
<script type="text/javascript" src="../js/jquery.number.js"></script>

<div id="ascrail2000" class="nicescroll-rails nicescroll-rails-vr" style="width: 12px; z-index: auto; cursor: default; position: absolute; top: 95px; left: 1428px; height: 326px; opacity: 0;">
    <div class="nicescroll-cursors" style="position: relative; top: 0px; float: right; width: 10px; height: 132px; border: 1px solid rgb(255, 255, 255); border-radius: 5px; background-color: rgb(66, 66, 66); background-clip: padding-box;"></div>
</div>

</body>
</html>
