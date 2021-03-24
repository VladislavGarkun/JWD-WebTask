<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
    <style>
        <%@include file="/css/first_page.css" %>
    </style>
</head>
<body>
<form action="Controller" method="get">
    <div class="login_wrap">
        <div class="login_html">
            <input id="tab_1" type="radio" name="tab" class="sign_in" checked><label for="tab_1" class="tab">Sign In</label>
            <input id="tab_2" type="radio" name="tab" class="sign_up"><label for="tab_2" class="tab">Sign Up</label>
            <div class="login_form">
                <div class="sign_in_htm">
                    <div class="group">
                        <label for="log" class="label">Login</label>
                        <input id="log" name="login_1" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" name="password_1" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span>Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <button type="submit" name="command" value="authorization" class="button">Sign in</button>
                    </div>
                    <div class="hr"></div>
                </div>

                <div class="sign_up_htm">
                    <div class="group">
                        <label for="name" class="label">Name</label>
                        <input id="name" name="name" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="surname" class="label">Surname</label>
                        <input id="surname" name="surname" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="userName" class="label">User Name</label>
                        <input id="userName" name="userName" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="phoneNumber" class="label">Phone Number</label>
                        <input id="phoneNumber" name="phoneNumber" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="login_2" class="label">Login</label>
                        <input id="login_2" name="login_2" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="password_2" class="label">Password</label>
                        <input id="password_2" name="password_2" type="text" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="r_password_2" class="label">Repeat Password</label>
                        <input id="r_password_2" name="r_password_2" type="text" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <button type="submit" name="command" value="registration" class="button">Sign up</button>
                    </div>
                    <div class="hr"></div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
