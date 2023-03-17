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

	 Hello, ${requestScope.owner}
	 
	 <!-- <a href="profile.htm">Profile</a> -->
	 
	 <form action="ownerprofile.htm" method="post">
		
		 <input name = "ownerDetails" type = "hidden" value=${requestScope.owner} type="text"/>
		 <input class ="button-1" type="submit" value="Profile" />
	 </form>
	 
	 
	 	<input class ="button-1" type="submit" value="Add house for rent" id="addHouseBtn"/>
	 	
	 
	 
	 <div>
		 <form action = "addHouse.htm" method="post" id="addHouseForm" style="display: none">
			 <label id="unitNumber">Unit Number:</label>
			 <input type="text" name="unitNumber" id="unitNumber">
			 <label id="street">Street:</label>
			 <input type="text" name="street" id="street">
			 <label id="city">City:</label>
			 <input type="text" name="city" id="city">
			 <label id="state">State:</label>
			 <input type="text" name="state" id="state">
			 <label id="pincode">Pincode:</label>
			 <input type="text" name="pincode" id="pincode">
			 <label id="country">Country:</label>
			 <input type="text" name="country" id="country">
			 <label id="houseType">House type:</label>
			 <input type="text" name="houseType" id="houseType">
			 <label id="details">Details:</label>
			 <textarea rows="5" cols="10" name="details" id="details"></textarea>
			 <label id="amenities">Amenities:</label>
			 <input type="text" name="amenities" id="amenities">
			 <label id="area">Area in Sq.ft:</label>
			 <input type="text" name="area" id="area">
			 <label id="price">Rent amount:</label>
			 <input type="text" name="price" id="price">
			 <label id="contact">Contact:</label>
			 <input type="text" name="contact" id="contact">
			 Username:<input type="text" value=${requestScope.owner} name = "username" readonly="readonly">
			 <input class="button-2" type="submit" value="Add House">
		 </form>
	 </div>
	 
 	<c:forEach items="${messageInfo}" var="message">
 		<form action="removeMessage.htm" method="get">
 		<div id="all__messages">
 			<tr>
 				<td><input type="hidden" value = ${message.getId()} name="msgId" readonly/></td>
 				
 				<td>${message.getUser_name()}</td>
 				<td>${message.getUserid()}</td>
 				<td>${message.getMessage()}</td>
 				<td>${message.getDate()}</td>
 			</tr>
 		</div>
 		</form>
 	</c:forEach>
	
	
	<script type="text/javascript">
	
	const button = document.getElementById('addHouseBtn');
	
		button.addEventListener('click', () => {
			const form = document.getElementById('addHouseForm');
			if(form.style.display === 'none'){
				form.style.display = 'block';
			}
			else{
				form.style.display = 'none';
			}
		});
	
	
	</script> 

	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
	<form action="rentedHouses.htm" method="get">
		<input class="button-1" type="submit" name="rentList" value="View listed houses"/>
		
		
	</form>
	
	<form action="viewApplicationRequests.htm" method = "get">
		
		
		<input class = "button-1" value="Application Requests" type="submit"/>
	</form>
	
	
	
		
	
	
 	
</body>
</html>