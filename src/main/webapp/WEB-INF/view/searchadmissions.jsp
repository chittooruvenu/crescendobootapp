<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" href="/css/styles.css"> -->
<link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet" href="/css/alertify.core.css" />
<link rel="stylesheet" href="/css/alertify.default.css" id="toggleCSS" />
<style>
.alertify-log-custom {
	background: blue;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="/js/alertify.min.js"></script>
<script src="/js/validations.js"></script>
<title>Search Admissions</title>
</head>
<body>
	<form:form method="post" modelAttribute="admissionSearch"
		action="/admissions/viewadmissions" name="search">
		<div class="container">
			<%@include file="header.html"%>
			<div style="background-color: #f2f2f2" align="center">
				<h2>Search Admissions</h2>
			</div>
			<div class="menudetails">
				<%@include file="menu.html"%>
			</div>
			<div class="pagedetails">
				<table>
					<tr>
						<td>Child's Name :</td>
						<td><form:input path="childName" id="nameCheck"
								class="nameCheck" /></td>
						<td><font color="red"><form:errors path="childName"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Grade Joined :</td>
						<td><form:input path="gradeJoiningFor" /></td>
						<td><font color="red"><form:errors
									path="gradeJoiningFor" element="div" /></font></td>
					</tr>
					<tr>
						<td>Grade Currently In:</td>
						<td><form:input path="gradeCurrentlyIn" /></td>
						<td><font color="red"><form:errors
									path="gradeCurrentlyIn" element="div" /></font></td>
					</tr>
					<tr>
						<td>Phone Number :</td>
						<td><form:input path="phoneNumber" class="phoneNumber" /></td>
						<td><font color="red"><form:errors path="phoneNumber"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Start Date Of Admission</td>
						<td><form:input path="startAdmissionDate" type="date"
								id="startDate" /></td>
						<td><font color="red"><form:errors
									path="startAdmissionDate" element="div" /></font></td>

					</tr>
					<tr>
						<td>End Date Of Admission</td>
						<td><form:input path="endAdmissionDate" type="date"
								id="endDate" /></td>
						<td><font color="red"><form:errors
									path="endAdmissionDate" element="div" /></font></td>

					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="SEARCH" class="button"
							onclick="return validateAndSend()" /></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<div class="footer">
				<%@include file="footer.html"%></div>
		</div>
	</form:form>
</body>

</html>