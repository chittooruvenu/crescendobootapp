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
<title>Create OR Update Follow Up</title>
</head>
<body>
	<%@include file="header.html"%>
	<form:form method="post" modelAttribute="followupform"
		action="/enquiries/savefollowup">
		<div style="background-color: #f2f2f2" align="center">
			<h2>Save FollwoUp</h2>
		</div>
		<div class="container">
			<div class="menudetails">
				<%@include file="menu.html"%>
			</div>

			<div class="pagedetails" align="center">
				<table>
					<form:hidden path="followUpId" />
					<form:hidden path="enquiries.enquiryId" />
					<tr>
						<td>Follow Up Date :</td>
						<td><form:input path="followUpDate" type="date" required="required"/></td>
						<td><font color="red"><form:errors path="followUpDate"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Next Follow Up Date :</td>
						<td><form:input path="nextFollowUpDate" type="date" required="required"/></td>
						<td><font color="red"><form:errors
									path="nextFollowUpDate" element="div" /></font></td>
					</tr>
					<tr>
						<td>Follow up Remarks :</td>
						<td><form:textarea path="remarks" required="required"/></td>
						<td><font color="red"><form:errors path="remarks"
									element="div" /></font></td>
					</tr>
					<tr align="center">
						<td></td>
						<td><input type="submit" value="Save FollowUp" class="button"/></td>
						<td></td>
					</tr>
				</table>
				</div>
				</div>
	</form:form>
</body>
<div class="footer">
	<%@include file="footer.html"%></div>
</html>