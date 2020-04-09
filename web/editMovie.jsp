<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${movie.title} Edition</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <form action="editMovie" method="post">
                        <input type="hidden" name="idCinemaToBack" value="${idCinema}"/>
                        <button class="waves-effect btn-flat waves-red white-text"
                                style="height: 64px"><i
                                class="material-icons">arrow_back</i></button>
                    </form>
                </li>
            </ul>
            <a href="" class="brand-logo center"><i class="material-icons">movie</i>${movie.title} Edition</a>
        </div>
    </nav>
</div>
<div class="container">
    <h4>Edit the movie :</h4>
    <div class="row">
        <form class="col s12" action="editMovie" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="titleInput"></label><input placeholder="${movie.title}" id="titleInput" type="text"
                                                           name="title" class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="startingDateInput"></label><input placeholder="Starting Date" id="startingDateInput"
                                                                  type="date" name="startingDate"
                                                                  class="validate" value="${startingDateValue}">
                </div>
                <div class="input-field col s3">
                    <label for="endingDateInput"></label><input placeholder="Ending Date" id="endingDateInput"
                                                                type="date" name="endingDate"
                                                                class="validate" value="${endingDateValue}">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light green darken-1" type="submit" name="action"
                            value="Update">Update
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
