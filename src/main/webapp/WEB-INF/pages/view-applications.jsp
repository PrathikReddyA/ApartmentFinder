<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="buttons.css">
	<link rel="stylesheet" href="form.css">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${applicationList}" var="application">
 		<form action="viewApplicationRequests.htm" method = "get">
 		<div id="applications">
 			<tr>
 				<td><input type="hidden" value = ${application.getId()} name="applicationId" readonly/></td>
 				<td>User Name: ${application.getUser()}<br></td>
 				<td>City: ${application.getCity()}<br></td>
 				<td>Number of People: ${application.getNoOfPeople()}<br></td>
 				<td>Occupation: ${application.getOccupation()}<br></td>
 				<td>Salary: ${application.getSalary()}<br></td>
 				<td>Preferences: ${application.getPreferences()}<br></td>
 				<td>House ID: ${application.getHouseId()}<br></td>
 				<td><input type="hidden" value = ${application.getUserid()} name="hiddenUserid"/></td>
 				<td><input type="hidden" value = ${application.getUser()} name="hiddenUsername"/></td>
 			</tr>
 		</div>	
 		</form>
 		<form action="approveApplication.htm" method="post">
 			<input type="hidden" value = ${application.getId()} name="hiddenApplicationId"/>
 			<input type="hidden" value = ${application.getUserid()} name="hiddenUserid"/>
 			<input type="hidden" value = ${application.getUser()} name="hiddenUsername"/>
 			<input type="hidden" value = ${application.getHouseId()} name="hiddenHouseId"/>
 			<input type="submit" value="Approve"/>
 		</form>
 		
 	</c:forEach>
 	
 	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
</body>
</html>