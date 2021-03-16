<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href=../../css/main_page.css">

</head>
<body>
<form class="header" action="Controller" method="post">
    <div class="main-container">
        <nav class="navbar navbar-light">
            <form class="header" action="Controller" method="post">
                <div class="btn-group buttons" role ="grop" aria-label="Basic Example">
                    <button class="btn btn-primary sign-in" type="submit" name="command" value="loadauthpage">Sign in</button>
                    <button class="btn btn-primary sign-up" type="submit" name = "command" value="loadregistrationpage">Sign up</button>
                </div>
            </form>
        </nav>
    </div>
</form>
</body>
</html>
