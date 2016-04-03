<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
th, td {
    padding: 5px;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
<body style="background-color:red;">
<title>order history</title>
</head>
<body>
<center><h1>MY ORDERS</h1></center> 
<table style="width:100%">	
 <tr>
    <th>ORDER ID</th>
    <th>STATUS</th>		
    </tr>
    <c:forEach items="${myorder}" var="list">
    <tr>
    <td>${list.orderId}</td>
    <td>${list.status}</td>		
  </tr>
  </c:forEach>
</table>
<h2>CANCEL YOUR ORDER </h2>
<form id="queryBox" action="updateStatusForCustomer" method="POST">             
		<br>
            </br>
            	<b>SELECT ORDER ID</b>
		<br> <select name="orderId"">
			<option value="">Please select one </option>
			    <c:forEach items="${myorder}" var="list">
			 <option value="${list.orderId}}">${list.orderId}</option>
    </c:forEach>
		</select>
		<br></br>
		<input type="submit" value="UPDATE" />

	</form>


 

</body>
</html>