<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="buttons.css">
	<link rel="stylesheet" href="form.css">
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
	<form class="block" action="register-user.htm" method="post"><br>
		Username:<input type = "text" name = "username"><br>
		Password:<input type = "password" name = "password"><br>
		Email ID:<input type = "email" name = "emailid"><br>
		Name: <input type = "text" name = "name"><br>
		Phone: <input type = "text" name = "phone"><br>
		<input class="button-1" type = "submit" name = "register" value="register">
	</form>
</body>
</html>