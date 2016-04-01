<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="queryBox" action="updateStatusDb" method="POST">             
		<br>
            </br>
            	<b>SELLER NAME</b>
		<br> <select name="orderId"">
			<option value="">Please select one </option>
			    <c:forEach items="${orders}" var="orders">
			 <option value="${orders}">${orders}</option>
    </c:forEach>
		</select>
			<br></br>                                  
	<b> please select status</b>
	<select name="status">
	<option value="dispached">dispached</option>
		<option value="awaited">awaited</option>
		<option value="confirmed">confirmed</option>
	</select>
		
		<br></br>
		<input type="submit" value="GET DATA" />

	</form>

</body>
</html>