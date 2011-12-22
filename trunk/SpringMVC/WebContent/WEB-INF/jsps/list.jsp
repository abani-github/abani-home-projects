<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Contacts</title>
</head>
<body>
	<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
		</tr>
	</thead>
		<c:forEach var="contact" items="contacts">
			<tr>
				<td>${contact.firstname}</td>
				<td>${contact.lastname}</td>
				<td>${contact.email}</td>
				<td>${contact.telephone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>