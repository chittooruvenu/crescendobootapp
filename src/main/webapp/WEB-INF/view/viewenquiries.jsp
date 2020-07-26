<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles.css">
<style>
</style>
<title>View Enquiries</title>
</head>
<body>
	<%@include file="Logout.jsp"%>
	<form:form method="get" modelAttribute="viewEnquiries">
		<%@ include file="header.html"%>
	
		<c:if test="${not empty viewEnquiries}">
			<div style="background-color: #f2f2f2" align="center"><h2>View Enquiries</h2></div>
			<div class="container">
				<div class="menudetails">
					<%@include file="menu.html"%>
				</div>

				<div class="pagedetails">
					<table>
						<tr>
							<th>Child Name</th>
							<th>Enquired For</th>
							<th>Enquiry Date</th>
							<th>Father's Name</th>
							<th>Father's Contact</th>
							<th>Mother's Name</th>
							<th>Mother's Contact</th>
							<th>Admission Status</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${viewEnquiries}" var="enquiry"
							varStatus="status">

							<tr>
								<td><c:out value="${enquiry.childName}" /></td>
								<td><c:out value="${enquiry.gradeEnquiring}" /></td>
								<td><c:out value="${enquiry.dateOfEnquiry}" /></td>
								<td><c:out value="${enquiry.fathersName}" /></td>
								<td><c:out value="${enquiry.fathersPhoneNumber}" /></td>
								<td><c:out value="${enquiry.mothersName}" /></td>
								<td><c:out value="${enquiry.mothersPhoneNumber}" /></td>
								<td><c:out value="${enquiry.admissionStatus}" /></td>
								<td><a href="/enquiries/followups/${enquiry.enquiryId}">Followups</a>
									| <a href="/enquiries/siblings/${enquiry.enquiryId}">Siblings</a>
									| <a href="/enquiries/updateEnquiry/${enquiry.enquiryId}">Update</a>
									<c:if test="${enquiry.admissionStatus != 'Active'}">
									| <a href="/admissions/new/${enquiry.enquiryId}">Take Admission</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:if>
		<c:if test="${empty viewEnquiries}">
			<h2>No Enquiries available</h2>
		</c:if>
		<div class="footer">
			<%@ include file="footer.html"%></div>
	</form:form>
</body>
</html>