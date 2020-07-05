<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

<title>Search Follow Up</title>
</head>
<body>
	<%@include file="header.html"%>
	<form:form method="post" modelAttribute="searchfollowup" id="search"
		action="/enquiries/viewsearchfollowups">
		<div style="background-color: #f2f2f2" align="center">
			<h2>Search FollwoUp</h2>
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
						<td>Latest FollowedUp Date :</td>
						<td><form:input path="followUpDate" type="date" id="followUpDate"/></td>
						<td><font color="red"><form:errors path="followUpDate"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Next Follow Up Date :</td>
						<td><form:input path="nextFollowUpDate" type="date"  id="nextFollowUpDate"/></td>
						<td><font color="red"><form:errors
									path="nextFollowUpDate" element="div" /></font></td>
					</tr>
					<tr align="center">
						<td></td>
						<td><input type="submit" value="Search FollowUp"
							onclick="return validateAndSend()" class="button"/></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="footer">
	<%@include file="footer.html"%></div>

		</div>
	</form:form>
</body>
<script type="text/javascript">
	function validateAndSend() {

            if (search.followUpDate.value == '' && search.nextFollowUpDate.value == '') {
                //window.alert('You have to enter at least one input field.');
                alertify.alert("You have to enter at least one input field");
                search.followUpDate.focus();
                return false;
            }
            else {
            	search.submit();
            }
	}
</script>
</html>
