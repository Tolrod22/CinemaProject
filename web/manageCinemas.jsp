<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cinemas management</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <a href="../${pageContext.request.contextPath}"><i
                            class="material-icons">arrow_back</i></a>
                </li>
            </ul>
            <a href="" class="brand-logo center"><i
                    class="material-icons">movie</i>Cinemas Management</a>
        </div>
    </nav>
</div>
<div class="container">
    <h4>Add a cinema :</h4>
    <div class="row">
        <form class="col s12" action="manageCinemas" method="post">
            <div class="row">
                <div class="input-field col s2">
                    <label for="nameInput"></label><input placeholder="Name" id="nameInput" type="text"
                                                          name="cinemaName" class="validate">
                </div>
                <div class="input-field col s6">
                    <label for="addressInput"></label><input placeholder="Address" id="addressInput" type="text"
                                                             name="cinemaAddress" class="validate">
                </div>
                <div class="input-field col s2">
                    <label for="postalCodeInput"></label><input placeholder="Postal code" id="postalCodeInput"
                                                                type="number" name="cinemaPostalCode"
                                                                maxlength="5"
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

    <h4>Cinema list :</h4>
    <table class="responsive-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Postal code</th>
            <th>Employees</th>
            <th>Movies</th>
            <th>Actions</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cinemas}" var="cinema">
            <tr>
                <td>${cinema.name}</td>
                <td>${cinema.address}</td>
                <td>${cinema.postalCode}</td>
                <td>${cinema.employees.size()}</td>
                <td>${cinema.movies.size()}</td>
                <td>
                    <form action="manageCinemas" method="post">
                        <input type="hidden" name="idCinemaToManage" value="${cinema.idCinema}"/>
                        <button class="btn-floating btn-large waves-effect waves-light blue darken-4"><i
                                class="material-icons">more</i></button>
                    </form>
                </td>
                <td>
                    <form action="manageCinemas" method="post">
                        <input type="hidden" name="idCinemaToDelete" value="${cinema.idCinema}"/>
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