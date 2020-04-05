<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${movie.title} : Management</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <a href="../${pageContext.request.contextPath}" class="brand-logo center"><i
                    class="material-icons">movie</i>${cinema.name}</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li>
                    <form action="manageCinema" method="post">
                        <input type="hidden" name="idCinemaToEdit" value="${cinema.idCinema}"/>
                        <button class="waves-effect waves-light blue darken-4"><i
                                class="material-icons">edit</i></button>

                    </form>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
