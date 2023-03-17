<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="form.css">
<title>Registration</title>
</head>
<body>
	<div class="container">
	<form action="submitApplication.htm" method="post">
		<div>
			Full name: <input type="text" name="user"/>
			City: <input type="text" name="city"/>
			How many people along with you?:<input type="text" name="NoOfPeople"/>
			Occupation:<input type="text" name="occupation"/>
			Salary: <input type="text" name="salary"/>
			Preferences:<textarea name="preferences" rows="2" cols="10"></textarea>
			<input type="hidden" value=${ownername} name="hiddenOwnerName"/>
			<input type="hidden" value=${houseId} name="hiddenHouseId"/>
			<input type="hidden" value=${ownerid} name="hiddenOwnerId"/>
			<input type="hidden" value=${userid} name="hiddenUserId"/>
			<input type="submit" value="Submit Application">
		</div>
	</form>
	
	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
	</div>
</body>
</html>