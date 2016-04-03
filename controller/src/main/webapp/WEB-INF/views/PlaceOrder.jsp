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
 <style>
 table, th, td {
    border: 1px solid black;
}
</style>
<body>
Hi ${userData[0].firstName}
Welcome to ordering page 

 
   
MAKE ORDER
<form method="post"  action="orderItem">
<select name="itemType">
			<option value="">Please select one </option>
			    <c:forEach items="${dishType}" var="dish">
			 <option value="${dish.categoryName}">${dish.categoryName}</option>
    </c:forEach>
		</select>
<input type="hidden" name="userId" value="${userData[0].userId}">			
<br></br>   
<input type="submit" value="GO TO ITEM DETAILS">
</form>
 ORDER HISTORY

</body>
</html>