<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Enquiries</title>
</head>
<body>
<form:form method="get" modelAttribute="enquiryForm" >
	<h2>View All Enquiries</h2>
	<c:if test ="${not empty enquiries}">
		<c:forEach items="${enquiries.siblings}" var="sibling" varStatus="status">
				<tr>
					<td>Sibling Age : </td>
					<td><form:input path="siblings[${status.index}].ageInYears" value="${sibling.ageInYears}"/></td>
				</tr>
				<tr>
					<td><form:input path="siblings[${status.index}].numberOfMonths" value="${sibling.numberOfMonths}"/></td>
					<td><form:input path="siblings[${status.index}].gender" value="${sibling.gender}"/></td>
				</tr>	
		</c:forEach>
	</c:if>
</form:form>
</body>
</html>