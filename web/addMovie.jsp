<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add movie</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<nav>
    <div class="nav-wrapper blue darken-4">
        <a href="" class="brand-logo center"><i class="material-icons">movie</i>EJBCineManager</a>
    </div>
</nav>
<div class="container">
    <h2>Add a movie :</h2>
    <div class="row">
        <form class="col s12" action="addMovie" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="titleInput"></label><input placeholder="Name" id="titleInput" type="text" name="title" class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="startingDateInput"></label><input placeholder="Starting Date" id="startingDateInput" type="date" name="startingDate"
                                                                  class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="endingDateInput"></label><input placeholder="Ending Date" id="endingDateInput" type="date" name="endingDate"
                                                                class="validate">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light blue darken-4" type="submit" name="action"
                            value="Create">Create
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
