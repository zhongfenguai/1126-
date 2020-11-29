<%@ page import="com.msgsys.entity.Message" %>
<%@ page import="com.msgsys.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css" rel="stylesheet">
        body {
            margin: 0px;
            padding: 0px;

        }

        ul li {
            list-style-type: none;
            margin-bottom: 10px;
            border-bottom: 1px aliceblue dashed;
        }

        .wrapper {
            width: 800px;
            font-size: 14px;
            border: 1px black solid;
        }

        .wrapper .menu {
            width: 100%;
            float: right;
            background-color: aliceblue;
            padding: 10px;
        }

        .wrapper .menu span {
            margin-left: 5px;
        }

        .wrapper .menu span a {
            text-decoration: none;
            margin-left: 15px;
            color: cornflowerblue;
        }

        .wrapper div {
            padding: 5px;
            margin: 5px;
        }

        .rfloat {
            float: right;
        }

        .red {
            color: red;
        }

        .clear {
            clear: both;
        }

        ul li span {
            margin-right: 5px;
        }

        .bordstyle {
            font-weight: bolder;
        }

        .content {
            border: 1px gainsboro solid;
            background-color: azure;
        }

        .content-top span {
            margin-right: 10px;
        }

    </style>
</head>
<body>
<%
    //    Message message = (Message) request.getAttribute("message");
    User user = (User) session.getAttribute("user");
%>
<div class="wrapper">
    <div class="header">
        <div class="menu">
            <span>当前用户：<%=user.getUsername()%></span><span></span>
            <span><a href="#">发送消息</a><a href="logout.jsp">退出</a></span>
        </div>
    </div>
    <div class="clear"></div>
    <div class="content">
        <form action="message.do">
            <input type="hidden" name="action" value="send"/>
            <div class="content-top">
                <span>标题：<input name="mtitle" type="text"/> </span>  <br/>
                <span>发至邮件地址：<input name="email" type="text"/> </span>
                <span></span>
            </div>

            <div class="content-body">
                消息内容：
                <textarea rows="20" cols="50" name="mcontent"></textarea>
            </div>
            <button type="submit">发送</button>
        </form>


    </div>
</div>
</body>
</html>
