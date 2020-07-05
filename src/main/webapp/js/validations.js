	function validateAndSend() {
		
		var elements = document.getElementsByTagName("input");

		if (document.getElementById("endDate").value != '') {

			if (document.getElementById("startDate").value == '') {
				alertify.alert('Please enter Start Date if End date is entered.');
				document.getElementById("startDate").focus();
				return false;
			} 
		}

		var flag = true;
		for (var i = 0; i < elements.length; i++) {
			/* do whatever you need to do with each input */
			
			if(elements[i].type != 'submit') {
				if (elements[i].value != '') {
					flag = false;
					break;
				} 
			}
		}

		if (flag) {
			alertify.alert('Enter atleast one input field.');
			return false;
		} else {
			return verifynames() && phonenumbercheck();
		}
	}

	function validateAndSendEnquiryCreation() {
		
		return verifynames() && phonenumbercheck();
	}
	
	function verifynames() {
		var namesCheck = document.getElementsByClassName("nameCheck");
		var letters = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
		var flag = true
			for(var i = 0; i < namesCheck.length; i++) {
				if(namesCheck[i].value == '') {
					flag = true;
					continue;
				}
				
				if (namesCheck[i].value.match(letters)) {
					flag = true;
				} else {
					//window.alert(namesCheck[i].name + ' must have characters only');
					alertify.alert(namesCheck[i].name + ' must have characters only');
					namesCheck[i].focus();
					return false;
				}
			}
		return flag;
	}
	

	function phonenumbercheck() {

		var numbers = /^.*(?=.{10,})(?=.*[0-9]).*$/;
		var phones = document.getElementsByClassName("phoneNumber");		
		var flag = true
		
		for(var i = 0; i < phones.length; i++) {
			if(phones[i].value == '') {
				flag = true;
				continue;
			}
			
			if (phones[i].value.match(numbers)) {
				flag = true;
			} else {
				alertify.alert(phones[i].name + ' Phone Number must contain only digits (10)');
				phones[i].focus();
				return false;
			}
		}
		return flag;
	}
	
	/*function alphanumeric() {
	var nameCheck = document.getElementById("nameCheck");
	var letters = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;

	if(nameCheck.value == '') {
		return true;
	}
	
	if (nameCheck.value.match(letters)) {
		return true;
	} else {
		window.alert('Name must have characters only');
		//namecheck.focus();
		return false;
	}
}*/
	
	/*function ageCalculate() {
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
		document.getElementById("ageId").disabled = true;
		document.getElementById("monthId").value = months;
		document.getElementById("monthId").disabled = true;
		return true;
		//} else {
		//  alert("Invalid date format. Please Input in (dd/mm/yyyy) format!");
		// return false;
		//}

	}
	*/
	

