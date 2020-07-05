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
			<h2>Admission Success Page</h2>
		</div>
		<div class="menudetails">
			<%@include file="menu.html"%>
		</div>

		<div class="pagedetails">
			<div style="border: 1px solid blue;">
				<h2>Admission ${createOrupdate}d successfully.</h2>
				<p style="outline: thin solid"/>
				<br>
				<br>
				<h3>Child Name : ${childName}</h3>
				<h3>Admission Number : ${admissionNumber}</h3>
			</div>

		</div>
		<div class="footer">
			<%@include file="footer.html"%>
		</div>
	</div>
</body>
</html>