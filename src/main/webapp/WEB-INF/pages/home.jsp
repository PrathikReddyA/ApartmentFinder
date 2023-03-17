<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
		<h1>Hello, this is the starting page. Please select any action below:</h1>
		<div class="container">
		<form action="roles-owner.htm" method="get">
			<input class="button-3" type="submit" value="Apartment Owner" id="apartmentOwner"/>
		</form>
		
		<form action="roles-user.htm" method="get">
			<input class="button-3" type="submit" value="User Sign in/Sign up" id="user"/>
		</form>
		
		<form action="roles-admin.htm" method="get">
			<input class="button-3" type="submit" value="Admin Sign in" id="admin"/>
		</form>
	</div>
	</body>
</html>