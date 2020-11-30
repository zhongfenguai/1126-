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
    Message message = (Message) request.getAttribute("message");
    User user= (User) request.getAttribute("user");
%>
<div class="wrapper">
    <div class="header">
        <div class="menu">
            <span>当前用户：<%=user.getUsername()%></span><span></span>
            <span><a href="send.jsp">发送消息</a><a href="logout.jsp">退出</a></span>
        </div>
    </div>
    <div class="clear"></div>
    <div class="content">
        <div class="content-top">
            <span>标题：<%=message.getmTitle()%></span>
            <span>来自：<%=user.getUsername()%></span>
            <span>时间：<%=message.getCreateTime()%></span>
        </div>

        <div class="content-body">

            <%=message.getmContent()%>
        </div>

    </div>
</div>
</body>
</html>
