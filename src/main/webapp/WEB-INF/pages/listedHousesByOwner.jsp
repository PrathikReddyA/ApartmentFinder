<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="buttons.css">
<title>Insert title here</title>
</head>


<body>

<c:forEach items="${ownerRentList}" var="owner">
    
    <form action="removeHouse.htm" method="get">
    <div id="owner-div">
    <tr>   
    	<td><input type="hidden" value = ${owner.getId()} name="rentId" readonly/></td>
    	<td><input type="hidden" value = ${appId} name="appId" readonly/></td>
        <td>${owner.getUsername()}</td>
       	<td>${owner.getStreet()}</td>
        <td>${owner.getCity()}</td>
        <td>${owner.getState()}</td>
		
    </tr>
    </div>
    <input class="button-3" type="submit" value="remove"/>
    </form>
</c:forEach>


<form action="logout.htm" method="get">
		<input class="button-3" type="submit" name="Logout" value="Logout"/>
		
	</form>
 
        
<!-- <script type="text/javascript">

	let ownerDiv = document.getElementById("owner-div");

	for(let i = 0; i < ${ownerRentListSize}; i+=1){
			let data = '${ownerRentList.get(i).getStreet()} ${ownerRentList.get(i).getCity()} ${ownerRentList.get(i).getState()} ${ownerRentList.get(i).getCountry()} ${ownerRentList.get(i).getArea()} ${ownerRentList.get(i).getPrice()} ${ownerRentList.get(i).getDetails()}';

			let newDiv = document.createElement("div");

			newDiv.innerText = data;

			ownerDiv.append(newDiv);
	}
	
	

</script> -->
           

</body>
</html>