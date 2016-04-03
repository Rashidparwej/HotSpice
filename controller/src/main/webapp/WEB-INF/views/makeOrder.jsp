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
<script>
var limit = 1;
$('input.single-checkbox').on('change', function(evt) {
   if($(this).siblings(':checked').length >= limit) {
       this.checked = false;
   }
});
</script>
</head>

<body>

<form method="post"  action="orderConfirmed">

<h1>Select your Items</h1>
   <c:forEach items="${listOfItems}" var="list">
<p><input class="single-checkbox" input type="checkbox" name=item value="${list.name}"/>${list.name}</p>
			 
			
    </c:forEach>
    			<br> Enter Quantity <input type="text" name="quant" />
    
		
		<input type="hidden" name="userId" value="${user.userId}">	
			<br></br>   
<input type="submit" value="GO TO ITEM DETAILS">
</form>
</body>
</html>