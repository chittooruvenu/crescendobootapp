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
<title>View FollwoUp History</title>
</head>
<body>
	<%@include file="header.html"%>
	<form:form method="get" modelAttribute="viewfollowups">
		<c:if test="${not empty viewfollowups}">
			<div style="background-color: #f2f2f2" align="center">

				<h2>View FollwoUp History</h2>
			</div>
			<div class="container">
				<div class="menudetails">
					<%@include file="menu.html"%>
				</div>

				<div class="pagedetails">
					<table>
						<tr>
							<th>Child name</th>
							<th>Followup ID</th>
							<th>Followup Date</th>
							<th>Next Followup Date</th>
							<th>Remarks</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${viewfollowups}" var="followup"
							varStatus="status">
							<tr>
								<td><c:out value="${followup.enquiries.childName}" /></td>
								<td><c:out value="${followup.followUpId}" /></td>
								<td><c:out value="${followup.followUpDate}" /></td>
								<td><c:out value="${followup.nextFollowUpDate}" /></td>
								<td><c:out value="${followup.remarks}" /></td>
								<td><a
									href="/enquiries/followupform/${followup.enquiries.enquiryId}">Create</a>
									| <a
									href="/enquiries/followupform/${followup.enquiries.enquiryId}/${followup.followUpId}">Update</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:if>
		<c:if test="${empty viewfollowups}">
			<h2>No Followups available</h2>
		</c:if>
		<div class="footer">
			<%@include file="footer.html"%></div>
	</form:form>

</body>
</html>