<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <body style="background-color:red;">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> UPDATE ORDER STATUS HERE</h1>
<form id="queryBox" action="updateStatusDb" method="POST">             
		<br>
            </br>
            	<b>SELECT ORDER ID</b>
		<br> <select name="orderId"">
			<option value="">Please select one </option>
			    <c:forEach items="${orders}" var="ord">
			 <option value="${ord}">${ord}</option>
    </c:forEach>
		</select>
			<br></br>           
			<br>                       
	<b> please select status</b>
	<select name="status">
	<option value="dispached">dispached</option>
		<option value="awaited">awaited</option>
		<option value="confirmed">confirmed</option>
	</select>
		
		<br></br>
		<input type="submit" value="POST DATA" />

	</form>

</body>
</html>