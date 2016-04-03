<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hi ${user.userId}
please choose your dish
<form method="post"  action="orderConfirmed">
<select name="item">
			<option value="">Please select one </option>
			    <c:forEach items="${listOfItems}" var="list">
			 <option value="${list.name}">${list.name}</option>
    </c:forEach>
    			<br> Enter Quantity <input type="text" name="quant" />
    
		</select>
		<input type="hidden" name="userId" value="${user.userId}">	
			<br></br>   
<input type="submit" value="GO TO ITEM DETAILS">
</form>
</body>
</html>