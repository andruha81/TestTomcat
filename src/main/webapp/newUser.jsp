<!DOCTYPE html>
<html lang="en">

<head>
    <title>New User</title>
    <meta content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>
<jsp:include page="header.html" />

<form action="/user/new" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName">
    <br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName">
    <br>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age">
    <br>
    <label for="login">Login:</label>
    <input type="text" id="login" name="login">
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <br>
    <input type="submit">
</form>
</body>
</html>