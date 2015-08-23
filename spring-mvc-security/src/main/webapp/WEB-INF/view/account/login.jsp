<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet" />
        <title>Login page</title>
    </head>
    <body>
        <h1>Login form!</h1>
        <form method="POST">
            <p> Username: <input name="username" /> </p>
            <p> Password: <input name="password" type="password" /> </p>
            <p>  <input type="submit" value="Login" /> </p>
        </form>
    </body>
</html>
