<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <title>Login page</title>
    <meta content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>

<jsp:include page="header.html" />

<form action="login" method="post">
    <c:choose>
        <c:when test="${requestScope.isLogged != null && requestScope.isLogged.equals('false')}">
            <h3><em>Login FAILED.</em> Please try again</h3>
        </c:when>
        <c:otherwise>
            <h3>Enter login and password</h3>
        </c:otherwise>
    </c:choose>

    <label for="login">Login</label> <br>
    <input type="text" id="login" name="login"> <br>

    <label for="password">Password</label> <br>
    <input type="password" id="password" name="password"> <br>

    <input type="submit" value="login">
</form>
</body>
</html>
