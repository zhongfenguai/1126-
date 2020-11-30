<%@ page import="com.msgsys.entity.Message" %>
<%@ page import="com.msgsys.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#ajaxBtn").click(function () {
                //获取富文本编辑器内容
                // alert(editor.txt.html());
                $.ajax({
                    url: "http://localhost:8066/msgsys/message.do",
                    data: { action: "send",
                        mtitle: $("#mtitle").val(),
                        email: $("#email").val(),
                        mcontent: editor.txt.html()
                    },
                    type: "GET",
                    dataType: "text",
                    success: function (data) {
                        alert(data);
                    }
                });
            });
        });
    </script>
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
        <form>
            <%--<input type="hidden" name="action" value="send"/>--%>
            <div class="content-top">
                <span>标题：<input name="mtitle" id="mtitle" type="text"/> </span> <br/>
                <span>发至邮件地址：<input name="email" id="email" type="text"/> </span>
                <span></span>
            </div>
            消息内容：
            <div class="content-body">
                <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
            </div>
            <button id="ajaxBtn" type="button">发送</button>
            <%--<button id="ajaxBtn">提交</button>--%>
            <%--<br/>--%>
            <%--<div id="msg"></div>--%>
            <%--<textarea rows="20" cols="50" name="mcontent"></textarea>--%>
        </form>
        <script type="text/javascript" src="https://unpkg.com/wangeditor/dist/wangEditor.min.js"></script>
        <script type="text/javascript">
            const E = window.wangEditor;
            const editor = new E('.content-body');
            // 或者 const editor = new E( document.getElementById('div1') )
            // 配置 server 接口地址
            editor.config.uploadImgServer = 'http://localhost:8066/msgsys/imgUpload';
            editor.create();
        </script>

    </div>
</div>
</body>
</html>
