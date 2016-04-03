<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>MY ORDERS</h1></center> 	
  <c:forEach items="${orders}" var="list">
       <tr class="tab-highlighted-2">
        <td class="tab-highlighted-2" width="10%">
          <div align="left"><b> ORDER ID </b></div>
              <td>${list.orderId}</td>
        </td>
        <td class="tab-highlighted-2" width="10%">
          <div align="left"><b> STATUS </b></div>
          
        <td>${list.status}</td>  
        </td>
     
        
    </tr>
     
    
</c:forEach>
        
   
 

</body>
</html>