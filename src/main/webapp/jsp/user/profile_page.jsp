<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Controller" method="post">
    <div class="profile">
        <div class text_info>
            <div class="group">
                <label for="name" class="label">Name</label>
                <textarea name="name" class="card-text">${user.name }</textarea>
            </div>
            <div class="group">
                <label for="surname" class="label">Surname</label>
                <textarea name="surname" class="card-text">${user.surname }</textarea>
            </div>
            <div class="group">
                <label for="userName" class="label">User Name</label>
                <textarea name="userName" class="card-text">${user.userName }</textarea>
            </div>
            <div class="group">
                <label for="login" class="label">Login</label>
                <textarea name="login" class="card-text">${user.login }</textarea>
            </div>
            <div class="group">
                <label for="password" class="label">Password</label>
                <textarea name="password" class="card-text">${user.password }</textarea>
            </div>
            <div class="group">
                <label for="phoneNumber" class="label">Phone Number</label>
                <textarea name="phoneNumber" class="card-text">${user.phoneNumber }</textarea>
            </div>
            <div class="group">
                <button type="submit" name="command" value="savechanges" class="button">Save</button>
            </div>
        </div>

    </div>
</form>
</body>
</html>
