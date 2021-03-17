<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
    <style>
        <%@include file="/css/authorization.css" %>
    </style>
</head>

<body>
<form action="Controller" method="get">
    <h1 title="Authorization form">Authorization</h1>
    <div class="group">
        <label for ="">Login:</label>
        <input type="text" name="login">
    </div>
    <div class="group">
        <label for ="">Password:</label>
        <input type="password" name="password">
    </div>
    <div class="group">
        <center><button type="submit" name="command" value="authorization">Sign in</button></center>
    </div>
    <div class="group">
        <c:out value="${message}"/>
    </div>
</form>
</body>
</html>