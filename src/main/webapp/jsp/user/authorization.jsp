<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" type="text/css" href="../../css/authorization.css">
</head>

<body>
    <div id="auth">
        <form action="Controller" method="post">
            <label for="login">login</label>
            <input type="text" login="login" placeholder="Enter login" id="login"><br><br>

            <label for="password">password</label>
            <input type="password" password="password" placeholder="Enter password" id="password"><br><br>

            <input type="submit" button_1="submit" id="submit">
        </form>
    </div>
</body>
</html>