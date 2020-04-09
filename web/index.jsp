<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EJB Cinema Project</title>
    <link rel="stylesheet" href="css/materialize.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-4">
            <a href="../${pageContext.request.contextPath}" class="brand-logo center"><i
                    class="material-icons">movie</i>EJBCineManager</a>
        </div>
    </nav>
</div>
<div class="container">
    <h2>Welcome on EJBCineManager</h2>
    <h4>Please click on this button to start using the application</h4>
    <a class="btn waves-effect waves-light blue darken-4" href="${pageContext.request.contextPath}/manageCinemas">Get
        started</a>
</div>
</body>
</html>
