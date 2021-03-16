<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>registration</title>
    <style>
        <%@include file="/css/registration.css"%>
    </style>
</head>

<body>
    <form action="Controller" method="post">
        <h1 title="Registration form">Registration</h1>
        <div class="group">
            <label for="">Name:</label>
            <input type="text" name="name">
        </div>
        <div class="group">
            <label for="">Surname:</label>
            <input type="text" name="surname">
        </div>
        <div class="group">
            <label for="">Phone number:</label>
            <input type="tel" name="phoneNumber">
        </div>
        <div class="group">
            <label for="">Login:</label>
            <input type="text" name="login">
        </div>
        <div class="group">
            <label for="">Password:</label>
            <input type="password" name="password_1">
        </div>
        <div class="group">
            <label for="">Repeat password:</label>
            <input type="password" name="password_2">
        </div>
        <div class="group">
            <label for="">Birth date:</label>
            <input type="text" name="birthDate">
        </div>
        <div class="group">
            <label for="">Passport number:</label>
            <input type="text" name="passportNumber">
        </div>
        <div class="group">
            <center><button type="submit" name="command" value="registration">Registration</button></center>
        </div>
        <div class="group">
            <c:out value="${message}"/>
        </div>
    </form>
</body>
</html>
