<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${employee.name} Edition</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <form action="editEmployee" method="post">
                        <input type="hidden" name="idCinemaToBack" value="${idCinema}"/>
                        <button class="waves-effect btn-flat waves-red white-text"
                                style="height: 64px"><i
                                class="material-icons">arrow_back</i></button>
                    </form>
                </li>
            </ul>
            <a href="" class="brand-logo center"><i class="material-icons">movie</i>${employee.name} Edition</a>
        </div>
    </nav>
</div>
<div class="container">
    <h4>Edit the employee :</h4>
    <div class="row">
        <form class="col s12" action="editEmployee" method="post">
            <div class="row">
                <div class="input-field col s4">
                    <label for="nameInput"></label><input placeholder="${employee.name}" id="nameInput" type="text"
                                                          name="name"
                                                          class="validate">
                </div>
                <div class="input-field col s3">
                    <label for="surnameInput"></label><input placeholder="${employee.surname}" id="surnameInput"
                                                             type="text"
                                                             name="surname"
                                                             class="validate">
                </div>
                <div class="input-field col s1">
                    <label for="ageInput"></label><input placeholder="${employee.age}" id="ageInput" type="number"
                                                         name="age"
                                                         maxlength="3" min="16"
                                                         class="validate">
                </div>
                <div class="input-field col s2">
                    <label for="salaryInput"></label><input placeholder="${employee.salary}" id="salaryInput"
                                                            type="number"
                                                            name="salary" maxlength="6"
                                                            min="0"
                                                            class="validate">
                </div>
                <div class="input-field col s2">
                    <button class="btn waves-effect waves-light green darken-1" type="submit" name="action"
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