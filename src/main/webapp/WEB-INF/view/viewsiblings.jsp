<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="/css/styles.css">
<style>

</style>
<title>View Sibling Details</title>
</head>
<body>
<%@include file="header.html" %>
	<form:form method="get" modelAttribute="viewsiblings">
		<c:if test="${not empty viewsiblings}">
			<div style="background-color: #f2f2f2" align="center">
				
					<h3>View Sibling History of : <c:out value="${viewsiblings[0].enquiries.childName}"/></h3>
			</div>
			<div class="container">
				<div class="menudetails">
					<%@include file="menu.html"%>
				</div>

				<div class="pagedetails">
			<table>
				<tr>
					<th>Sibling ID</th>
					<th>Sibling Name</th>
					<th>Age in Years</th>
					<th>Number Of months</th>
					<th>Gender</th>
				</tr>
				<c:forEach items="${viewsiblings}" var="sibling" varStatus="status">
					<tr>
						<td><c:out value="${sibling.siblingNumber}" /></td>
						<td><c:out value="${sibling.siblingName}" /></td>
						<td><c:out value="${sibling.ageInYears}" /></td>
						<td><c:out value="${sibling.numberOfMonths}" /></td>
						<td><c:out value="${sibling.gender}" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			</div>
		</c:if>
		<c:if test="${empty viewsiblings}">
			<h2>No Siblings available</h2>
		</c:if>
	</form:form>
	<div class="footer">
	<%@include file="footer.html" %></div>
</body>
</html>