
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <body style="background-color:blue;">

<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<meta http-equiv="refresh" content="60">
<title>DASHBOARD-FNY</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
</head>
<body>
	<h1>
		<center>DASHBOARD-ORDER DETAILS SUMMARY</center>
	</h1>
	<a href="#" class="export">GET EXCEL</a>
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script                                    
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		
	<div id="table_div"></div>
	<script type="text/javascript">
		google.load("visualization", "1.1", {
			packages : [ "table" ]
		});
		google.setOnLoadCallback(drawTable);
		function drawTable() {
			var data = new google.visualization.DataTable();
			data.addColumn('number', 'ORDER ID');
			data.addColumn('string', 'CUSTOMER NAME');
			data.addColumn('string', 'CUSTOMER EMAIL ADDRESS ');
			data.addColumn('string', 'DISH NAME');
			data.addColumn('number', 'COST');
			data.addColumn('number', 'QUANTITY');
			data.addColumn('string', 'ORDER STATUS');
			data.addColumn('string', 'ORDER DATE');
			
			
			data.addRows([
					<c:forEach items="${orderSummary}" var="row">

					[
					{v: parseFloat('${row.orderId}')},"${row.customerName}","${row.email}","${row.dishName}",
					{v: parseFloat('${row.cost}')},{v: parseFloat('${row.quantity}')},"${row.status}","${row.date}"
							
							],

					</c:forEach> ]);
			var table = new google.visualization.Table(document
					.getElementById('table_div'));
			     table.draw(data, {showRowNumber: true, width: '100%', height: '100%'} );
	
		}
		
			function exportTableToCSV($table, filename) {

				var $rows = $table.find('tr:has(td)'),
	            $ro=$table.find('tr:has(th)'),
				// Temporary delimiter characters unlikely to be typed by keyboard
				// This is to avoid accidentally splitting the actual contents
				tmpColDelim = String.fromCharCode(11), // vertical tab character
				tmpRowDelim = String.fromCharCode(0), // null character

				// actual delimiter characters for CSV format
				colDelim = '","', rowDelim = '"\r\n"',

				// Grab text from table into CSV formatted string
				csv = '"'
						+ $rows.map(function(i, row) {
							var $row = $(row), $cols = $row.find('td');

							return $cols.map(function(j, col) {
								var $col = $(col), text = $col.text();

								return text.replace(/"/g, '""'); // escape double quotes

							}).get().join(tmpColDelim);

						}).get().join(tmpRowDelim).split(tmpRowDelim)
								.join(rowDelim).split(tmpColDelim).join(colDelim)
						+ '"',
			csv1='"'
					+ $ro.map(function(i, row) {
						var $row = $(row), $cols = $row.find('th');

						return $cols.map(function(j, col) {
							var $col = $(col), text = $col.text();

							return text.replace(/"/g, '""'); // escape double quotes

						}).get().join(tmpColDelim);

					}).get().join(tmpRowDelim).split(tmpRowDelim)
							.join(rowDelim).split(tmpColDelim).join(colDelim)
					+ '"'+"\r\n",

				// Data URI
				//csvData = 'data:application/csv;charset=utf-8,'
					//	+ encodeURIComponent(csv1)+encodeURIComponent(csv);
				csvData = csv1+csv;
				var blob = new Blob([csvData], { type: 'text/csv' }); 
				var csvUrl = URL.createObjectURL(blob);
				

				$(this).attr({
					'download' : filename,
					'href' : csvUrl,
					
				});                                                              
			}
				// This must be a hyperlink
				$(".export").on(
						'click',
						function(event) {
							// CSV
							exportTableToCSV.apply(this, [ $('#table_div>div>div>table'),
									'export.csv' ]);

							// IF CSV, don't do event.preventDefault() or return false
							// We actually need this to be a typical hyperlink
						});
		      

	</script>



</body>
</html>