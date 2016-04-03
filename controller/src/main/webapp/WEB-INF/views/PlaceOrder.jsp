<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color:red;">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style">
div {
    background-color: lightgrey;
    width: 120px;
    padding: 25px;
    border: 25px solid navy;
    margin: 25px;
}
</style>
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
Hi ${userData[0].firstName}
Welcome to ordering page 

<form method="post"  action="orderItem">
			<h1>Please select one </h1>
			    <c:forEach items="${dishType}" var="dish">
<p><input class="single-checkbox" input type="checkbox" name=itemType value="${dish.categoryName}"/>${dish.categoryName}</p>
    </c:forEach>
	
<input type="hidden" name="userId" value="${userData[0].userId}">			
<br></br>   
<input type="submit" value="GO TO ITEM DETAILS">
</form>
 <centre>
 <div><a href="orderhistory" ><h2>YOUR ORDER HISTORY</h2></a></div>
 </centre>
 
	

</body>
</html>