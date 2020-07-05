<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles.css">

<title>No FollowUps found page</title>
</head>
<body>
	<%@include file="header.html"%>
	<div style="background-color: #f2f2f2" align="center">
		<h2>No Data found</h2>
	</div>
	<div class="container">
		<div class="menudetails">
			<%@include file="menu.html"%>
		</div>

		<div class="pagedetails">
			<h2>No Followups found for given Criteria. Please change the search</h2>
		</div>
		<div class="footer">
			<%@include file="footer.html"%></div>
	</div>
</body>
</html>