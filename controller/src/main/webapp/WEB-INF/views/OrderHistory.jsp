<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
MY ORDERS 	
<table align="center">
       <tr class="tab-highlighted-2">
        <td class="tab-highlighted-2" width="10%">
          <div align="left"><b> ORDER ID </b></div>
        </td>
        <td class="tab-highlighted-2" width="10%">
          <div align="left"><b> STATUS </b></div>
        </td>
        <td class="tab-highlighted-2" width="10%">
          <div align="left"><b> DATE</b></div>
        </td>
        
    </tr>
    
      <tr class="bg-row1">
        <td class="td-highlighted-2">
         <div align="left"><b>${myorder[0].orderId}</b></div>
        </td>
        <td class="td-highlighted-2">
          <div align="left"><b> ${myorder[0].status}</b></div>
        </td>
        <td class="td-highlighted-2">
          <div align="left"><b> ${myorder[0].date} </b></div>
        </td>
    </tr>  
    </table>

</body>
</html>