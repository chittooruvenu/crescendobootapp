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
<title>View Admissions</title>
</head>
<body>
	<form:form method="get" modelAttribute="viewAdmissions">
		<%@ include file="header.html"%>
		<c:if test="${not empty viewAdmissions}">
			<div style="background-color: #f2f2f2" align="center"><h2>View Admissions</h2></div>
			<div class="container">
				<div class="menudetails">
					<%@include file="menu.html"%>
				</div>

				<div class="pagedetails">
					<table>
						<tr>
							<th>Child Name</th>
							<th>Grade Joined</th>
							<th>Grade Currently In</th>
							<th>Admission Date</th>
							<th>Father's Name</th>
							<th>Father's Contact</th>
							<th>Mother's Name</th>
							<th>Mother's Contact</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${viewAdmissions}" var="admission"
							varStatus="status">

							<tr>
								<td><c:out value="${admission.childName}" /></td>
								<td><c:out value="${admission.gradeJoiningFor}" /></td>
								<td><c:out value="${admission.gradeCurrentlyIn}" /></td>
								<td><c:out value="${admission.admissionDate}" /></td>
								<td><c:out value="${admission.fathersName}" /></td>
								<td><c:out value="${admission.fathersPhoneNumber}" /></td>
								<td><c:out value="${admission.mothersName}" /></td>
								<td><c:out value="${admission.mothersPhoneNumber}" /></td>
								<td><a href="/admissions/updateAdmission/${admission.admissionNumber}">Update</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:if>
		<c:if test="${empty viewAdmissions}">
			<h2>No Admissions available</h2>
		</c:if>
		<div class="footer">
			<%@ include file="footer.html"%></div>
	</form:form>
</body>
</html>