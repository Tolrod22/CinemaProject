<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cinema Management</title>
</head>
<body>
<h1>Cinema Management</h1>

<h2>Choose the cinema to manage are add a new one</h2>
<br>
<h2>Add a cinema :</h2>
<form action="cinemaCreation" method="post">
    <input id="nameInput" type="text" name="name" placeholder="Name"/>
    <input id="addressInput" type="text" name="address" placeholder="Address"/>
    <input id="postalCodeInput" type="number" name="postalCode" placeholder="PostalCode"/>
    <input type="submit" value="Create"/>
</form>
<br>
<br>
<h2>Cinema list :</h2>
<table>
    <c:forEach items="${cinemas}" var="cine">
        <tr>
            <td>${cine.name}</td>
            <td>${cine.address}</td>
            <td>${cine.postalCode}</td>
                <%--            ajouter le nombre d'employé--%>
            <td>
                <form action="cinemaCreation" method="post">
                    <input type="hidden" name="idCinema" value="${cine.idCinema}"/>
                    <input type="submit" value="Manage"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>