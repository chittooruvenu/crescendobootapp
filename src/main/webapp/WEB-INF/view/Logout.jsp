    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
	<head>
<meta charset="ISO-8859-1">
<title>CRESCENDO index Page</title>
</head>
<body>
<form:form action="/logout" method="post">
			<input type="submit" value="Logout" />
		</form:form>
</body>
</html>