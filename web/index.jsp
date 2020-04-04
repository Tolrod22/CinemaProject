<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Home</title>
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
    <h2>Welcome on EJBCineManager</h2>
    <h4>Please click on this button to start using the application</h4>
    <a class="btn waves-effect waves-light blue darken-4" href="${pageContext.request.contextPath}/manageCinemas">Get started</a>
</div>
</body>
</html>
