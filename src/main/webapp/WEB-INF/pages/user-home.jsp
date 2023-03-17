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
<body>
	Welcome ${requestScope.user}
	
	<form action="userprofile.htm" method="post">
		
		 <input name = "userDetails" type = "hidden" value=${requestScope.user} type="text"/>
		 <input class="button-3" type="submit" value="Profile" />
	 </form>
	 
	<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
	</form>
	
	
	<p>${requestScope.applicationSuccessMsg}</p>
	
		<c:forEach items="${availablehouses}" var="houses">
 		<form action="sendmessage.htm" method="post">
 		<div id="all-houses">
 			<tr>
 				<td>${houses.getStreet()}</td>
 				<td>${houses.getCity()}</td>
 				<td>${houses.getState()}</td>
 				<td>${houses.getCountry()}</td>
 				<td>${houses.getArea()}</td>
 				<td>${houses.getPrice()}</td>
 				<td>${houses.getDetails()}</td>
 				<td>${houses.getUsername()}</td>
 				<td><input type="text" name="message"/></td>
 				<td><input type="hidden" value=${houses.getUsername()} name="hiddenOwnerUsername" readonly/></td>
 				<td><input type="hidden" value=${houses.getRoleid()} name="hiddenRoleId" readonly/></td>
 				<td><input type="hidden" value=${houses.getId()} name="hiddenHouseId" readonly/></td>
 				<td><input class="button-3" type="submit" value="Send Message"/></td>
 			</tr>
 		</div>
 		</form>
 		<form action="applyForHouse.htm" method="get">
 			<div>
 				<input type="hidden" value=${houses.getUsername()} name="hiddenOwnerName" readonly/>
 				<input type="hidden" value=${houses.getId()} name="hiddenHouseId" readonly/>
 				<input type="hidden" value=${houses.getRoleid()} name="hiddenRoleId" readonly/>
 				<input type="hidden" value=${userid} name="hiddenUserId" readonly/>
 				<input class="button-3" type="submit" value="Apply for house"/>
 			</div>
 		</form>
 	</c:forEach>
	
 
        
<!-- <script type="text/javascript">

	let availableHousesDiv = document.getElementById("houses-div");

	for(let i = 0; i < ${availableHousesSize}; i+=1){
			let data = '${availablehouses.get(i).getStreet()} ${availablehouses.get(i).getCity()} ${availablehouses.get(i).getState()} ${availablehouses.get(i).getCountry()} ${availablehouses.get(i).getArea()} ${availablehouses.get(i).getPrice()} ${availablehouses.get(i).getDetails()} ${availablehouses.get(i).getUsername()}';

			let newDiv = document.createElement("div");
			
			let newForm = document.createElement("form");
			newForm.setAttribute("method", "post");
			newForm.setAttribute("action", "sendmessage.htm");
			
			let newInput = document.createElement("input");
			newInput.setAttribute("type", "text");
			newInput.setAttribute("name", "message");
			
			let newHiddenInput = document.createElement("input");
			newHiddenInput.setAttribute("type", "hidden");
			newHiddenInput.setAttribute("value", "${availablehouses.get(i).getUsername()}");
			newHiddenInput.setAttribute("name", "hiddenOwnerUsername");
			newHiddenInput.setAttribute("readonly", "readonly");
			
			let newSubmitBtn = document.createElement("input");
			newSubmitBtn.setAttribute("type", "submit");
			newSubmitBtn.setAttribute("value", "Send Message");
			
			let newData = document.createElement("p");
			
			newDiv.appendChild(newForm);
			newForm.appendChild(newData);
			newForm.appendChild(newInput);
			newForm.appendChild(newHiddenInput);
			
			newForm.appendChild(newSubmitBtn);
			
			newData.innerText = data;

			availableHousesDiv.append(newDiv);
			
			document.getElementById("houses-div").appendChild(newDiv);
			
	}
	
	

</script> -->
       
	
</body>
</html>
