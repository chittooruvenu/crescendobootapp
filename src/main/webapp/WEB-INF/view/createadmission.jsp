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
<title>Admission Form</title>
</head>
<body>
	<form:form method="post" modelAttribute="admissionForm"
		action="/admissions/create">
		<div class="container">
			<%@include file="header.html"%>
			<div style="background-color: #f2f2f2" align="center">
				<h2>${createOrupdate} Admission</h2>
			</div>
			<div class="menudetails">
				<%@include file="menu.html"%>
			</div>
			<div class="pagedetails">
				<table>
					<tr>
						<form:hidden path="enquiryId" />
						<form:hidden path="admissionNumber"/>
						<td>Child's Name :</td>
						<td><form:input path="childName"
								value="${admissionForm.childName}" class="nameCheck" required="required"/></td>
						<td><font color="red"><form:errors path="childName"
									element="div" /></font></td>
						<td>Date Of Birth :</td>
						<td><form:input path="dateOfBirth" required="required"/></td>
						<td><font color="red"><form:errors path="dateOfBirth"
									element="div" /></font></td>
					</tr>
					<tr>
						<td>Age in years :</td>
						<td><form:input path="ageInYears"/></td>
						<td><font color="red"><form:errors path="ageInYears"
									element="div" /></font></td>
						<td>Number of months :</td>
						<td><form:input path="numberOfMonths" type="text"
								/></td>
						<td><font color="red"><form:errors
									path="numberOfMonths" element="div" /></font></td>
					</tr>
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td><form:radiobutton path="gender" value="Male" label="Male" checked="${admissionForm.gender == 'Male' ? 'checked' : ''}"/>
							<form:radiobutton path="gender" value="Female" label="Female" checked="${admissionForm.gender == 'Female' ? 'checked' : ''}"/></td>
						<td></td>
						<td>Blood Group :</td>
						<td><form:input path="bloodGroup" required="required"/></td>
						<td><font color="red"><form:errors
									path="bloodGroup" element="div" /></font></td>
					</tr>
					<tr>
						<td>Religion : </td>
						<td><form:input path="religion"/></td>
						<td><font color="red"><form:errors path="religion"
									element="div" /></font></td>
						<td>Nationality :</td>
						<td><form:input path="nationality"/></td>
						<td><font color="red"><form:errors
									path="nationality" element="div" /></font></td>
					</tr>	
					<tr>
						<td>Mother Tongue </td>
						<td><form:input path="motherTongue"/></td>
						<td><font color="red"><form:errors path="motherTongue"
									element="div" /></font></td>
						<td>Allergies if any:</td>
						<td><form:textarea path="allergies"/></td>
						<td><font color="red"><form:errors
									path="allergies" element="div" /></font></td>
					</tr>
					<tr>
						<td>Surgeries if any : </td>
						<td><form:textarea path="surgeries"/></td>
						<td><font color="red"><form:errors path="surgeries"
									element="div" /></font></td>
						<td>Chronic Illness if any:</td>
						<td><form:textarea path="chronicIllness"/></td>
						<td><font color="red"><form:errors
									path="chronicIllness" element="div" /></font></td>
					</tr>	
					<tr>
						<td>Immunization details if any: </td>
						<td><form:textarea path="immunization"/></td>
						<td><font color="red"><form:errors
									path="immunization" element="div" /></font></td>
						<td>Grade Joining For : </td>
						<td><form:input path="gradeJoiningFor"/></td>
						<td><font color="red"><form:errors path="gradeJoiningFor"
									element="div" /></font></td>
					</tr>	
					<tr><td><b>Father Details : </b></td><td></td><td></td><td></td><td></td><td></td></tr>
					<tr>
						<td>Name:</td>
						<td><form:input path="fathersName" class="nameCheck" required="required"/></td>
						<td><font color="red"><form:errors path="fathersName"
									element="div" /></font></td>
									
						<td>Qualification</td>
						<td><form:input path="fathersQualification" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersQualification" element="div" /></font></td>
					</tr>
					<tr>
						<td>Occupation:</td>
						<td><form:input path="fathersOccupation" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersOccupation" element="div" /></font></td>
						<td>Place of Work:</td>
						<td><form:input path="fathersPlaceOfWork" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersPlaceOfWork" element="div" /></font></td>
					</tr>
					<tr>
						<td>Official Address</td>
						<td><form:textarea path="fathersOfficialAddress" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="fathersOfficialAddress" element="div" /></font></td>
					</tr>
					<tr>
					<td>Phone Number:</td>
						<td><form:input path="fathersPhoneNumber" class="phoneNumber" required="required"/></td>
						<td><font color="red"><form:errors
									path="fathersPhoneNumber" element="div" /></font></td>
						<td>Email ID:</td>
						<td><form:input path="fathersEmailId" required="required"/></td>
						<td><font color="red"><form:errors
									path="fathersEmailId" element="div" /></font></td>
					</tr>
					
					
					<tr><td><b>Mother Details : </b></td></tr>
					<tr>
						<td>Name:</td>
						<td><form:input path="mothersName" class="nameCheck" required="required"/></td>
						<td><font color="red"><form:errors path="mothersName"
									element="div" /></font></td>
									
						<td>Qualification</td>
						<td><form:input path="mothersQualification" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersQualification" element="div" /></font></td>
					</tr>
					<tr>
						<td>Occupation:</td>
						<td><form:input path="mothersOccupation" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersOccupation" element="div" /></font></td>
						<td>Place of Work:</td>
						<td><form:input path="mothersPlaceOfWork" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersPlaceOfWork" element="div" /></font></td>
					</tr>
					<tr>
						<td>Official Address</td>
						<td><form:textarea path="mothersOfficialAddress" class="nameCheck"/></td>
						<td><font color="red"><form:errors
									path="mothersOfficialAddress" element="div" /></font></td>
									<td>Phone Number:</td>
						<td><form:input path="mothersPhoneNumber" class="phoneNumber" required="required"/></td>
						<td><font color="red"><form:errors
									path="mothersPhoneNumber" element="div" /></font></td>
					</tr>
					<tr>
					
						<td>Email ID:</td>
						<td><form:input path="mothersEmailId" required="required"/></td>
						<td><font color="red"><form:errors
									path="mothersEmailId" element="div" /></font></td>
									<td>Residential Address:</td>
						<td><form:textarea path="residentialAddress" /></td>
						<td><font color="red"><form:errors
									path="residentialAddress" element="div" /></font></td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<td></td>
						<td>&nbsp;</td>
						<td><input type="submit" value="${createOrupdate}" class="button"
							onclick="return validateAndSendAdmissionCreation()" /></td>
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
</html>