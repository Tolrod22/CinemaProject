<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>-</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>,${employee.age}</td>
            <td>,${employee.salary}</td>
                <%--            TODO ajouter bouton de suppression et de modification--%>
        </tr>
    </c:forEach>
</table>

<br>
<h3>Manage your movies and tickets :</h3>
<form action="management" method="post">
    <input type="hidden" name="movieAddTo" value="${cinema.idCinema}"/>
    <input type="submit" value="Add movie"/>
</form>
<table>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>-</td>
            <td>${movie.title}</td>
            <td>${movie.startingDate} to ${movie.endingDate}</td>
                <%--            TODO modifier le format des dates--%>
                <%--            TODO afficher le nombre de ticket--%>
            <td>
                <form action="management" method="post">
                    <input type="hidden" name="ticketToAdd" value="${movie.idMovie}"/>
                    <input type="submit" value="Add tickets"/>
                </form>
            </td>
            <td>
                <form action="management" method="post">
                    <input type="hidden" name="movieToDelete" value="${movie.idMovie}"/>
                    <input type="submit" value="Remove"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
