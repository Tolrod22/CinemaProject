<%--
  Created by IntelliJ IDEA.
  User: zefzf
  Date: 02/04/2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>This is a test page for redirection</h1>
<%
    out.println(request.getParameter("message"));
%>
</body>
</html>
