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
<script src="/js/validations.js"></script>

<style>


</style>
<title>Enquiry Form</title>
</head>
<body>
	<form:form method="post" modelAttribute="enquiryForm"
		action="/enquiries/create">
		<div class="container">
			<%@include file="header.html"%>
			<div style="background-color: #f2f2f2" align="center">
				<h2>${createOrupdate} Enquiry</h2>
			</div>
			<div class="menudetails">
				<%@include file="menu.html"%>
			</div>
			<div class="pagedetails">
				<table>
					<tr>
						<form:hidden path="enquiryId" />
						<td>Child's Name :</td>
						<td><form:input path="childName"
								value="${enquiryForm.childName}" class="nameCheck" required="required"/></td>
						<td><font color="red"><form:errors path="childName"
									element="div" /></font></td>
						<td>Date Of Birth :</td>
						<td><form:input type="date" path="dateOfBirth"
								id="birth_date" onblur="ageCalculate()" required="required"/></td>
						<td><font color="red"><form:errors path="dateOfBirth"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Age in years :</td>
						<td><form:input path="ageInYears" id="ageId"/></td>
						<td><font color="red"><form:errors path="ageInYears"
									element="div" /></font></td>
						<td>Number of months :</td>
						<td><form:input path="numberOfMonths" type="text"
								id="monthId"/></td>
						<td><font color="red"><form:errors
									path="numberOfMonths" element="div" /></font></td>
					</tr>
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td><form:radiobutton path="gender" value="Male" label="Male" />
							<form:radiobutton path="gender" value="Female" label="Female" /></td>
						<td></td>
						<td>Grade Enquiring for:</td>
						<td><form:input path="gradeEnquiring" required="required"/></td>
						<td><font color="red"><form:errors
									path="gradeEnquiring" element="div" /></font></td>
					</tr>
					<tr>
						<td>Father's Name:</td>
						<td><form:input path="fathersName" class="nameCheck" required="required"/></td>
						<td><font color="red"><form:errors path="fathersName"
									element="div" /></font></td>
						<td>Father's Occupation:</td>
						<td><form:input path="fathersOccupation" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersOccupation" element="div" /></font></td>
					</tr>
					<tr>
						<td>Father's Place of Work:</td>
						<td><form:input path="fathersPlaceOfWork" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersPlaceOfWork" element="div" /></font></td>
						<td>Father's Phone Number:</td>
						<td><form:input path="fathersPhoneNumber" class="phoneNumber" required="required"/></td>
						<td><font color="red"><form:errors
									path="fathersPhoneNumber" element="div" /></font></td>
					</tr>
					<tr>
						<td>Father's Email ID:</td>
						<td><form:input path="fathersEmailId" required="required"/></td>
						<td><font color="red"><form:errors
									path="fathersEmailId" element="div" /></font></td>
						<td>Mother's Name:</td>
						<td><form:input path="mothersName" class="nameCheck"/></td>
						<td><font color="red"><form:errors path="mothersName"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Mather's Occupation:</td>
						<td><form:input path="mothersOccupation" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersOccupation" element="div" /></font></td>
						<td>Mother's Place of Work:</td>
						<td><form:input path="mothersPlaceOfWork" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersPlaceOfWork" element="div" /></font></td>
					</tr>
					<tr>
						<td>Mother's Phone Number:</td>
						<td><form:input path="mothersPhoneNumber" required="required" class="phoneNumber"/></td>
						<td><font color="red"><form:errors
									path="mothersPhoneNumber" element="div" /></font></td>
						<td>Mother's Email ID:</td>
						<td><form:input path="mothersEmailId" required="required"/></td>
						<td><font color="red"><form:errors
									path="mothersEmailId" element="div" /></font></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><b>Enter Siblings details if any : </b></td>
						<td></td>

						<td><input type="submit" value="Add Sibling" class="button"
							onclick="addSibling(this)"></input></td>
						<td><input id="actionName" type="hidden" name="actionName"></input></td>
						<td></td>
					</tr>
					<c:if test="${not empty enquiryForm.siblings}">
						<tr style="outline: thin solid">
							<c:forEach items="${enquiryForm.siblings}" var="sibling"
								varStatus="status">
								<tr>
									<form:hidden path="siblings[${status.index}].siblingNumber" />
									<td>${status.index + 1}.</td>
									<td>Sibling's Name :</td>
									<td><form:input
											path="siblings[${status.index}].siblingName"
											value="${sibling.siblingName}" class="nameCheck" required="required"/></td>
									<td><font color="red"><form:errors
												path="siblings[${status.index}].siblingName" element="div" /></font></td>
									<!-- <td>Age in Years :</td> -->
									<td>Age in Years : <form:input
											path="siblings[${status.index}].ageInYears"
											value="${sibling.ageInYears}" required="required"/></td>
									<td><font color="red"><form:errors
												path="siblings[${status.index}].ageInYears" element="div" /></font></td>
								</tr>
								<tr>
									<td>Number Of Months :</td>
									<td><form:input
											path="siblings[${status.index}].numberOfMonths"
											value="${sibling.numberOfMonths}" /></td>
									<td><font color="red"><form:errors
												path="siblings[${status.index}].numberOfMonths"
												element="div" /></font></td>
									<td><form:label path="siblings[${status.index}].gender">Gender : </form:label></td>
									<td><form:radiobutton
											path="siblings[${status.index}].gender" value="M"
											label="Male" /> <form:radiobutton
											path="siblings[${status.index}].gender" value="F"
											label="Female" /></td>
									<td><font color="red"><form:errors
												path="siblings[${status.index}].gender" element="div" /></font></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td><input type="submit" value="Delete Sibling ${status.index + 1}" class="button"
										onclick="deleteSibling(${status.index})"></input></td>
									<td><input id="actionName" type="hidden" name="actionName"></input></td>
									
								</tr>

							</c:forEach>
							<tr><td><input id="siblingId" type="hidden" name="siblingId"></input></td></tr>
						<tr style="outline: thin solid"></tr>
					</c:if>
					<tr>
						<td>Residential Address:</td>
						<td><form:textarea path="residentialAddress" /></td>
						<td><font color="red"><form:errors
									path="residentialAddress" element="div" /></font></td>
						<td>Land line Number</td>
						<td><form:input path="landLineNumber" type="text" value="0" /></td>
						<td><font color="red"><form:errors
									path="landLineNumber" element="div" /></font></td>
					</tr>
					<tr>
						<td>Expectation from School</td>
						<td><form:textarea path="expectationFromSchool" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="expectationFromSchool" element="div" /></font></td>
						<td>Any Challenges and Specialties</td>
						<td><form:textarea path="challengesAndSpecialities" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="challengesAndSpecialities" element="div" /></font></td>
					</tr>
					<tr>
						<td>Date Of Enquiry</td>
						<td><form:input path="dateOfEnquiry" type="date" required="required"/></td>
						<td><font color="red"><form:errors
									path="dateOfEnquiry" element="div" /></font></td>
						<td>Admission Status</td>
						<td><form:input path="admissionStatus" type="text" required="required"/></td>
						<td><font color="red"><form:errors
									path="admissionStatus" element="div" /></font></td>
					</tr>
					<tr>
						<td>Referred By</td>
						<td><form:input path="referredBy" type="text" /></td>
						<td><font color="red"><form:errors path="referredBy"
									element="div" /></font></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>&nbsp;</td>
						<td colspan="2"><input type="submit" value="Add Followup" class="button"
							onclick="addFollowup(this)"></input></td>
						<td></td>
						<td><input id="actionName" type="hidden" name="actionName"></input></td>
						<td></td>
					</tr>
					<tr>
						<c:forEach items="${enquiryForm.followUps}" var="followup"
							varStatus="status">
							<table>
								<tr>
									<form:hidden path="followUps[${status.index}].followUpId" />
									<td>Follow Up Date :</td>
									<td><form:input
											path="followUps[${status.index}].followUpDate"
											value="${followup.followUpDate}" type="date" required="required"/></td>
									<td><font color="red"><form:errors
												path="followUps[${status.index}].followUpDate" element="div" /></font></td>
									<td>Next Follow Up Date :</td>
									<td><form:input
											path="followUps[${status.index}].nextFollowUpDate"
											value="${followup.nextFollowUpDate}" type="date" required="required"/></td>
									<td><font color="red"><form:errors
												path="followUps[${status.index}].nextFollowUpDate"
												element="div" /></font></td>
									<td>Follow up Remarks :</td>
									<td><form:textarea
											path="followUps[${status.index}].remarks"
											value="${followup.remarks}" required="required"/></td>
									<td><font color="red"><form:errors
												path="followUps[${status.index}].remarks" element="div" /></font></td>
								</tr>
							</table>
						</c:forEach>
					<tr>
					<tr>
						<td>&nbsp;</td>
						<td></td>
						<td>&nbsp;</td>
						<td><input type="submit" value="${createOrupdate}" class="button"
							onclick="return validateAndSendEnquiryCreation(); addEnquiry(this)" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<div class="footer">
				<%@include file="footer.html"%></div>
		</div>
	</form:form>

</body>
<script>
	function addSibling(ele) {
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Sibling';
	}
	
	function deleteSibling(ele) {
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Delete Sibling';
		var siblingIdEle = document.getElementById('siblingId');
		siblingIdEle.value = ele;
	}

	function addEnquiry(ele) {
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Enquiry';
	}
	function addFollowup(ele) {
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Followup';
	}
	function ageCalculate() {
		var date1 = new Date();
		var dob = document.getElementById("birth_date").value;
		var date2 = new Date(dob);

		//Regex to validate date format (dd/mm/yyyy)       
		//if (pattern.test(dob)) {
		var y1 = date1.getFullYear();
		var m1 = date1.getMonth();
		//getting current year            
		var y2 = date2.getFullYear();
		var m2 = date2.getMonth();
		//getting dob year            
		var age = y1 - y2;
		var months = m1 - m2;
		if (months < 0) {
			age = age - 1;
			months = months + 12;
		}

		//calculating age                       
		document.getElementById("ageId").value = age;
		document.getElementById("ageId").readOnly = true;
		document.getElementById("monthId").value = months;
		document.getElementById("monthId").readOnly = true;
		return true;
		//} else {
		//  alert("Invalid date format. Please Input in (dd/mm/yyyy) format!");
		// return false;
		//}

	}
</script>
</html>