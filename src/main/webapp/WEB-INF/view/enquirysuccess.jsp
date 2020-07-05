<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles.css">

<title>Enquiry Success page</title>
</head>
<body>

	<div class="container">
		<%@include file="header.html"%>
		<div style="background-color: #f2f2f2" align="center">
			<h2>Successful</h2>
		</div>
		<div class="menudetails">
			<%@include file="menu.html"%>
		</div>

		<div class="pagedetails">
			<h2>Enquiry ${createOrupdate} successfully.</h2>
		</div>
		<div class="footer">
			<%@include file="footer.html"%>
		</div>
	</div>
</body>
</html>