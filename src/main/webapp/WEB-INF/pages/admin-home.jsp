<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${ownerlist}" var="owner">
 		<form action="removeOwner.htm" method = "get">
 		<div id="owners">
 			<tr>
 				<td><input type="hidden" value = ${owner.getId()} name="ownerId" readonly/></td>
 				<td>Owner Name: ${owner.getUsername()}<br></td>
 				<td>Name: ${owner.getName()}<br></td>
 				<td>Emailid: ${owner.getEmailid()}<br></td>
 				<td>Phone: ${owner.getPhone()}<br></td>
 				<td><input type="submit" value="Remove"/></td>
 			</tr>
 		</div>
 		</form>
 	</c:forEach>
	
	<c:forEach items="${userlist}" var="user">
 		<form action="removeUser.htm" method = "get">
 		<div id="users">
 			<tr>
 				<td><input type="hidden" value = ${user.getId()} name="userId" readonly/></td>
 				<td>User Name: ${user.getUsername()}<br></td>
 				<td>Name: ${user.getName()}<br></td>
 				<td>Emailid: ${user.getEmailid()}<br></td>
 				<td>Phone: ${user.getPhone()}<br></td>
 				<td><input type="submit" value="Remove"/></td>
 			</tr>
 		</div>
 		</form>
 	</c:forEach>
 	
 	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
</body>
</html>