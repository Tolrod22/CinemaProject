<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie creation page</title>
</head>
<body>
<form action="movieCreation" method="post">
    <input type="text" name="title" placeholder="Title"/>
    <input type="date" name="startingDate"/>
    <input type="date" name="endingDate"/>
    <input type="submit" value="Create"/>
</form>

</body>
</html>