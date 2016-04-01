<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>Report</title>

<style type="text/css">
</style>

</head>

<body>
	<h1>
		<center>FASHION AND YOU-MARKETPLACE</center>
	</h1>

	<form id="queryBox" action="api/marketplace" name="marketplaceDto"
		method="POST">
		<b>Enter Start Date</b><br> <input type="date" name="date1"><br>

		<b>Enter End Date</b><br> <input type="date" name="date2"><br>
		<b>Select Status</b><br> <select name="status"">
			<option value="%">Please select one</option>
			<option value="Confirmed">Confirmed</option>
			<option value="Awaited">Awaited</option>
			<option value="Canceled">Canceled</option>
			<option value="VENDOR_CONFIRMED">VENDOR_CONFIRMED</option>
			<option value="VENDOR_CANCELLED">VENDOR_CANCELLED</option>
			<option value="MANIFEST_CREATED">MANIFEST_CREATED</option>
			<option value="DISPATCHED">DISPATCHED</option>
			<option value="READY_FOR_PACKAGING">READY_FOR_PACKAGING</option>

		</select><br> <br>
		<!--  AutoRefresh: <input type="checkbox" id="isTimeout" name="isTimeout"/> -->
		<input type="submit" value="GET DATA" />



	</form>





</body>
</html>