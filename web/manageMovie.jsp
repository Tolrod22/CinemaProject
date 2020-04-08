<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Movie management</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<nav>
    <div class="nav-wrapper blue darken-4">
        <a href="../${pageContext.request.contextPath}" class="brand-logo center"><i class="material-icons">movie</i>EJBCineManager</a>
    </div>
</nav>
<div class="container">
    <h2>${movie.title} Management</h2>
    <h4>Add tickets :</h4>
    <div class="row">
        <form class="col s12" action="manageMovie" method="post">
            <div class="row">
                <div class="input-field col s2">
                    <label for="priceInput"></label><input placeholder="Price" id="priceInput" type="number" step="0.01"
                                                          name="price" class="validate">
                </div>
                <div class="input-field col s6">
                    <label for="dateInput"></label><input placeholder="EndValidation" id="dateInput" type="date"
                                                             name="endValidation" class="validate">
                </div>
                <div class="input-field col s2">
                    <label for="numberInput"></label><input placeholder="Number of tickets" id="numberInput"
                                                                type="number" name="number"
                                                                class="validate">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light blue darken-4" type="submit" name="action"
                            value="Create">Create
                        <i class="material-icons right">add</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <h4>Ticket list :</h4>
    <table class="responsive-table">
        <thead>
        <tr>
            <th>Ticket number</th>
            <th>Price</th>
            <th>End validation date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td>${ticket.idTicket}</td>
                <td>${ticket.price}</td>
                <td>${ticket.endValidation}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>