<%--
  Created by IntelliJ IDEA.
  User: FengJun
  Date: 2020/11/29
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
    <%String msg= (String) request.getAttribute("msg");%>
</head>
<body>
<%=msg%>
</body>
</html>
