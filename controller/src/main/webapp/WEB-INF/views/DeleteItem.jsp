<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
        <body style="background-color:red;">

</head>
<body>
<center><h1>DELETE ITEM ID FROM ITEM TABLE</h1></center>

<form action="deleteItemDb" method="POST">             
		<br>
            </br>
            	<b>SELECT ITEM ID TO BE DELETED</b>
		<br> <select name="itemId"">
			<option value="">Please select one </option>
			    <c:forEach items="${listOfItems}" var="list">
			 <option value="${list.itemId}">${list.itemId}</option>
    </c:forEach>
		</select>
			           
			<br>                      
		
		<br></br>
		<input type="submit" value="DELETE" />

	</form>
</body>
</html>