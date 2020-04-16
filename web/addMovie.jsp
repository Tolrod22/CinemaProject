<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${cinema.name} Add movie</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <form action="addMovie" method="post">
                        <input type="hidden" name="idCinemaToBack" value="${cinema.idCinema}"/>
                        <button class="waves-effect btn-flat waves-red white-text"
                                style="height: 64px"><i
                                class="material-icons">arrow_back</i></button>
                    </form>
                </li>
            </ul>
            <a href="" class="brand-logo center"><i class="material-icons">movie</i>${cinema.name} Add movie</a>
        </div>
    </nav>
</div>
<div class="container">
    <h4>Add a movie :</h4>
    <div class="row">
        <form class="col s12" action="addMovie" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="titleInput"></label><input placeholder="Name" id="titleInput" type="text" name="title"
                                                           class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="startingDateInput"></label><input placeholder="Starting Date" id="startingDateInput"
                                                                  type="date" name="startingDate"
                                                                  class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="endingDateInput"></label><input placeholder="Ending Date" id="endingDateInput"
                                                                type="date" name="endingDate"
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
    <h4>Search for an existing movie :</h4>
    <div class="row">
        <form class="col s12" action="addMovie" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="titleSearch"></label>
                    <input placeholder="Name" id="titleSearch" type="text" name="titleSearch"
                           class="validate">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light green darken-1" type="submit" name="action"
                            value="Search">Search
                        <i class="material-icons right">Search</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.startingDate}</td>
            <td>${movie.endingDate}</td>
            <td>${movie.tickets.size()}</td>
            <td>${movie.cinemas.size()}</td>
            <td>
                <form action="addMovie" method="post">
                    <input type="hidden" name="movieToAddFromSearch" value="${movie.idMovie}"/>
                    <button class="btn waves-effect waves-light green darken-1" type="submit" name="action"
                            value="add">Add
                        <i class="material-icons right">add</i>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</div>
</body>
</html>
