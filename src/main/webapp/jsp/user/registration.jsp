<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
    <div id="reg">
        <form action="Controller" method="post">
            <label for="firstname">firstname</label>
            <input type="text" firstname="firstname" placeholder="Enter first name" id="firstname"><br><br>

            <label for="lastname">lastname</label>
            <input type="text" lastname="lastname" placeholder="Enter last name" id="lastname"><br><br>

            <label for="phoneNumber">phoneNumber</label>
            <input type="phoneNumber" phoneNumber="phoneNumber" placeholder="Enter phone number" id="phoneNumber"><br><br>

            <label for="login">login</label>
            <input type="text" login="login" placeholder="Enter login" id="login"><br><br>

            <label for="password_1">password</label>
            <input type="password_1" password_1="password_1" placeholder="Enter password" id="password_1"><br><br>

            <label for="password_2">repeat password</label>
            <input type="password_2" password_2="password_2" placeholder="Repeat password" id="password_2"><br><br>

            <label for="dateOfBirth">birth date</label>
            <input type="dateOfBirth" dateOfBirth="dateOfBirth" placeholder="Enter birth date" id="dateOfBirth"><br><br>

            <label for="numberOfPassport">passport number</label>
            <input type="text" numberOfPassport="numberOfPassport" placeholder="Enter passport number" id="numberOfPassport"><br><br>

            <div class="form-group">
                <button type="submit" name="command" value="registration" class="btn btn-outline-primary sign-up">Sign Up</button>
            </div>
        </form>
    </div>
</body>
</html>
