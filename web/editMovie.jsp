<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit movie</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <a href="../${pageContext.request.contextPath}" class="brand-logo center"><i
                    class="material-icons">movie</i></a>
        </div>
    </nav>
</div>
<div class="container">
    <h2>Edit the movie :</h2>
    <div class="row">
        <form class="col s12" action="editMovie" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="titleInput"></label><input placeholder="${movie.title}" id="titleInput" type="text" name="title" class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="startingDateInput"></label><input placeholder="Starting Date" id="startingDateInput" type="date" name="startingDate"
                                                                  class="validate" value="${startingDateValue}">
                </div>
                <div class="input-field col s3">
                    <label for="endingDateInput"></label><input placeholder="Ending Date" id="endingDateInput" type="date" name="endingDate"
                                                                class="validate" value="${endingDateValue}">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light blue darken-4" type="submit" name="action"
                            value="Update">Update
                        <i class="material-icons right">edit</i>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
