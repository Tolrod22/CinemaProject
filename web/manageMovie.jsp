<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${movie.title} Management</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <form action="manageMovie" method="post">
                        <input type="hidden" name="idCinemaToBack" value="${cinema}"/>
                        <button class="waves-effect btn-flat waves-red white-text"
                                style="height: 64px"><i
                                class="material-icons">arrow_back</i></button>
                    </form>
                </li>
            </ul>
            <a href="" class="brand-logo center"><i class="material-icons">movie</i>${movie.title} Management</a>
        </div>
    </nav>
</div>
<div class="container">
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
                    <button class="btn waves-effect waves-light green darken-1" type="submit" name="action"
                            value="Create">Create
                        <i class="material-icons right">send</i>
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
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td>${ticket.idTicket}</td>
                <td>${ticket.price}</td>
                <td>${ticket.endValidation}</td>
                <td>
                    <form action="manageMovie" method="post">
                        <input type="hidden" name="idTicketToRemove" value="${ticket.idTicket}"/>
                        <button class="btn-floating btn-large waves-effect waves-light red darken-4"><i
                                class="material-icons">delete</i></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>