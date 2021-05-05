<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <title>Users list</title>
    <meta content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>
<c:import url="header.html" />
<table class="styled-table">
    <caption><h1>Users list</h1></caption>
    <thead>
    <tr>
        <th>No</th>
        <th>id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.users}" varStatus="counter">
        <tr class="active-row">
            <td>${counter.count}</td>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td><a href="/delete/user?userId=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/newUser.jsp">
<button>New User</button>
</form>
</body>
<p>${UserService}</p>
</html>