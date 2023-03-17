<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="buttons.css">
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body class="block">
	Username: ${requestScope.username}
	Name: ${requestScope.name }
	Email ID: ${requestScope.emailid }
	Phone: ${requestScope.phone }
	
	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
</body>
</html>