<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="addItem" method="post">
    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">ITEM  ID</td>
            <td><input type="text" name="itemId"></td>
        </tr>
        <tr>
            <td align="right">CATEGORY ID</td>
            <td><input type="text" name="categoryId"></td>
        </tr>
        <tr>
            <td align="right">NAME</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td align="right">COST</td>
            <td><input type="text" name="cost"></td>
        </tr>

    </table>
    <input type="submit" value="Submit">
</form>

</body>
</html>