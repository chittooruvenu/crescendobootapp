<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquiry Form</title>
</head>
<body>
<h1>Create New Enquiry</h1>  
       <form:form method="post" modelAttribute="enquiryForm" action="/enquiries/create">    
        <table >    
         <tr>    
          <td>Child's Name : </td>   
          <td><form:input path="childName"  value="${enquiryForm.childName}" required="required"/></td>
          <td><font color="red"><form:errors path="childName" element="div"/></font></td>  
         </tr> 
         <tr>    
          <td>Date Of Birth : </td>   
          <td><form:input type="date" path="dateOfBirth"  required="required" /></td>  
          <td><font color="red"><form:errors path="dateOfBirth" element="div"/></font></td>
         </tr>    
         <tr>    
          <td>Age in years :</td>    
          <td><form:input path="ageInYears" /></td>
          <td><font color="red"><form:errors path="ageInYears" element="div"/></font></td>  
         </tr>   
         <tr>    
          <td>Number of months :</td>    
          <td><form:input path="numberOfMonths" type="text" required="required"/></td> 
          <td><font color="red"><form:errors path="numberOfMonths" element="div"/></font></td> 
         </tr> 
          <tr>
               <td><form:label path = "gender">Gender</form:label></td>
               <td>
                  <form:radiobutton path = "gender" value = "M" label = "Male" />
                  <form:radiobutton path = "gender" value = "F" label = "Female" />
               </td>
            </tr>
         <tr>    
          <td> </td>    
         </tr>    
         <tr>    
          <td>Grade Enquiring for:</td>    
          <td><form:input path="gradeEnquiring" /></td> 
          <td><font color="red"><form:errors path="gradeEnquiring" element="div"/></font></td>  
         </tr>  
         <tr>    
          <td>Father's Name:</td>    
          <td><form:input path="fathersName" /></td> 
          <td><font color="red"><form:errors path="fathersName" element="div"/></font></td>  
         </tr> 
          <tr>    
          <td>Father's Occupation:</td>    
          <td><form:input path="fathersOccupation" /></td>  
          <td><font color="red"><form:errors path="fathersOccupation" element="div"/></font></td> 
         </tr> 
          <tr>    
          <td>Father's Place of Work:</td>    
          <td><form:input path="fathersPlaceOfWork" /></td> 
          <td><font color="red"><form:errors path="fathersPlaceOfWork" element="div"/></font></td> 
         </tr> 
         <tr>    
          <td>Father's Phone Number:</td>    
          <td><form:input path="fathersPhoneNumber" /></td>  
          <td><font color="red"><form:errors path="fathersPhoneNumber" element="div"/></font></td>
         </tr> 
         <tr>    
          <td>Father's Email ID:</td>    
          <td><form:input path="fathersEmailId" /></td>  
          <td><font color="red"><form:errors path="fathersEmailId" element="div"/></font></td>
         </tr>
         <tr>    
          <td>Mother's Name:</td>    
          <td><form:input path="mothersName" /></td>  
          <td><font color="red"><form:errors path="mothersName" element="div"/></font></td>
         </tr> 
          <tr>    
          <td>Mather's Occupation:</td>    
          <td><form:input path="mothersOccupation" /></td>  
          <td><font color="red"><form:errors path="mothersOccupation" element="div"/></font></td>
         </tr> 
          <tr>    
          <td>Mother's Place of Work:</td>    
          <td><form:input path="mothersPlaceOfWork" /></td>  
          <td><font color="red"><form:errors path="mothersPlaceOfWork" element="div"/></font></td>
         </tr> 
         <tr>    
          <td>Mother's Phone Number:</td>    
          <td><form:input path="mothersPhoneNumber" /></td>  
          <td><font color="red"><form:errors path="mothersPhoneNumber" element="div"/></font></td>
         </tr> 
         <tr>    
          <td>Mother's Email ID:</td>    
          <td><form:input path="mothersEmailId" /></td>  
          <td><font color="red"><form:errors path="mothersEmailId" element="div"/></font></td>
         </tr>
         <tr>    
          <td>Enter Siblings details if any</td> 
         </tr>
         <tr><td><input type="submit" value="Add Sibling" onclick="addSibling(this)"></input></td>
         	 <td><input id="actionName" type="hidden" name="actionName"></input></td>
         </tr>
         <tr>
         <c:forEach items="${enquiryForm.siblings}" var="sibling" varStatus="status">
				<tr>
					<td><form:input path="siblings[${status.index}].ageInYears" value="${sibling.ageInYears}"/></td>
					<td><font color="red"><form:errors path="siblings[${status.index}].ageInYears" element="div"/></font></td>
					<td><form:input path="siblings[${status.index}].numberOfMonths" value="${sibling.numberOfMonths}"/></td>
					<td><font color="red"><form:errors path="siblings[${status.index}].numberOfMonths" element="div"/></font></td>
					<td><form:input path="siblings[${status.index}].gender" value="${sibling.gender}"/></td>
					<td><font color="red"><form:errors path="siblings[${status.index}].gender" element="div"/></font></td>
				</tr>	
		 </c:forEach>
		
		 <tr>    
          <td>Residential Address:</td>    
          <td><form:textarea path="residentialAddress"/></td>  
          <td><font color="red"><form:errors path="residentialAddress" element="div"/></font></td>
         </tr>
         <tr>    
          <td>Land line Number</td>    
          <td><form:input path="landLineNumber" type="text" value="0"/></td>  
          <td><font color="red"><form:errors path="landLineNumber" element="div"/></font></td>
         </tr>
          <tr>    
          <td>Expectation from School</td>    
          <td><form:textarea path="expectationFromSchool"/></td>  
          <td><font color="red"><form:errors path="expectationFromSchool" element="div"/></font></td>
         </tr>
         <tr>    
          <td>Any Challenges and Specialties</td>    
          <td><form:textarea path="challengesAndSpecialities"/></td>  
          <td><font color="red"><form:errors path="challengesAndSpecialities" element="div"/></font></td>
         </tr>
          <tr>    
          <td>Date Of Enquiry</td>    
          <td><form:input path="dateOfEnquiry" type="date"/></td>  
          <td><font color="red"><form:errors path="dateOfEnquiry" element="div"/></font></td>
         </tr>
          <tr>    
          <td>Admission Status</td>    
          <td><form:input path="admissionStatus" type="text"/></td>  
          <td><font color="red"><form:errors path="admissionStatus" element="div"/></font></td>
         </tr>
         <tr>
          <td>Referred By</td>    
          <td><form:input path="referredBy" type="text"/></td>  
          <td><font color="red"><form:errors path="referredBy" element="div"/></font></td>
         </tr>
         <tr><td><input type="submit" value="Add Followup" onclick="addFollowup(this)"></input></td>
         	 <td><input id="actionName" type="hidden" name="actionName"></input></td>
         </tr>
         <tr>
	         <c:forEach items="${enquiryForm.followUps}" var="followup" varStatus="status">
					<tr>
						<td><form:input path="followUps[${status.index}].followUpDate" value="${followup.followUpDate}" type="date"/></td>
						<td><font color="red"><form:errors path="followUps[${status.index}].followUpDate" element="div"/></font></td>
						<td><form:input path="followUps[${status.index}].nextFollowUpDate" value="${followup.nextFollowUpDate}"  type="date"/></td>
						<td><font color="red"><form:errors path="followUps[${status.index}].nextFollowUpDate" element="div"/></font></td>
						<td><form:textarea path="followUps[${status.index}].remarks" value="${followup.remarks}"/></td>
						<td><font color="red"><form:errors path="followUps[${status.index}].remarks" element="div"/></font></td>
					</tr>	
			 </c:forEach>
		<tr> 
		<tr>
          <td><input type="submit" value="Save" onclick="addEnquiry(this)"/></td>   
        </tr>  
        </table>    
       </form:form>    
</body>
<script>

	function addSibling(ele){
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Sibling';
	}

	function addEnquiry(ele){
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Enquiry';
	}
	function addFollowup(ele){
		var actionEle = document.getElementById('actionName');
		actionEle.value = 'Add Followup';
	}

</script>
</html>