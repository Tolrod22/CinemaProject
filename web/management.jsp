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
    <title>Management</title>
</head>
<body>
<h1>${cinema.name} management center</h1>
<h3>Manage your employees :</h3>
<form action="management" method="post">
    <input type="hidden" name="employeeAddTo" value="${cinema.idCinema}"/>
    <input type="submit" value="Add employee"/>
</form>

<br><h3>Manage your movies :</h3>

<br><h3>Manage your movie's tickets :</h3>

</body>
</html>
