<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${cinema.name} : add employee</title>
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
                        <button class="btn-floating btn-large waves-effect waves-light blue darken-4"><i
                                class="material-icons">edit</i></button>

                    </form>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <h2>Add an employee :</h2>
    <div class="row">
        <form class="col s12" action="addEmployee" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="nameInput"></label><input placeholder="Name" id="nameInput" type="text" name="name"
                                                          class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="surnameInput"></label><input placeholder="Surname" id="surnameInput" type="text"
                                                             name="surname"
                                                             class="validate">
                </div>
                <div class="input-field col s1">
                    <label for="ageInput"></label><input placeholder="Age" id="ageInput" type="number" name="age"
                                                         maxlength="3" min="16"
                                                         class="validate">
                </div>
                <div class="input-field col s2">
                    <label for="salaryInput"></label><input placeholder="Salary" id="salaryInput" type="number"
                                                            name="salary" maxlength="6"
                                                            min="0"
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