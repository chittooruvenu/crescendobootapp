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
<title>Search Enquiries</title>
</head>
<body>
	<form:form method="post" modelAttribute="enquirySearch"
		action="/enquiries/viewsearchenquiries" name="search">
		<div class="container">
			<%@include file="header.html"%>
			<div style="background-color: #f2f2f2" align="center">
				<h2>Search Enquiries</h2>
			</div>
			<div class="menudetails">
				<%@include file="menu.html"%>
			</div>
			<div class="pagedetails">
				<table>
					<tr>
						<td>Child's Name :</td>
						<td><form:input path="childName" id="nameCheck" class="nameCheck" /></td>
						<td><font color="red"><form:errors path="childName"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Phone Number :</td>
						<td><form:input path="phoneNumber" class="phoneNumber"/></td>
						<td><font color="red"><form:errors path="phoneNumber"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Grade Enquiring for:</td>
						<td><form:input path="gradeEnquiring" /></td>
						<td><font color="red"><form:errors
									path="gradeEnquiring" element="div" /></font></td>
					</tr>
					<tr>
						<td>Start Date Of Enquiry</td>
						<td><form:input path="startDateOfEnquiry" type="date" id="startDate"/></td>
						<td><font color="red"><form:errors
									path="startDateOfEnquiry" element="div" /></font></td>

					</tr>
					<tr>
						<td>End Date Of Enquiry</td>
						<td><form:input path="endDateOfEnquiry" type="date" id="endDate" /></td>
						<td><font color="red"><form:errors
									path="endDateOfEnquiry" element="div" /></font></td>

					</tr>
					<tr>
						<td>Admission Status</td>
						<td><form:input path="admissionStatus" type="text" /></td>
						<td><font color="red"><form:errors
									path="admissionStatus" element="div" /></font></td>
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