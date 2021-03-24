<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/css/main_page.css" %>
    </style>
</head>

<body>
    <div class="main-container">
        <form class="header" action="Controller" method="get">
            <button class="button_group_logout" type="submit" name = "command" value="logout">Log Out</button>
            <button class="button_group_prof_page" type="submit" name="command" value="loadprofilepage">Profile</button>
        </form>

        <form class="header" action="Controller" method="post">
            <div class="button_group" role="group" aria-label="Basic example">
                <button class="button_group_sign_in" type="submit" name = "command" value="loadauthorizationpage">Sign In</button>
                <button class="button_group_sign_up" type="submit" name = "command" value="loadregistrationpage">Sign Up</button>
            </div>
        </form>
        <div class="label_group">
            <c:out value="${user.userName}"/>
        </div>
    </div>
</body>
</html>
