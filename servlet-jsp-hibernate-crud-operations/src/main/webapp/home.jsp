<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tp</title>

<style type="text/css">
	body{
		text-align: center;
	}
	table {
		margin-left: 15%;
	    min-width: 70%; 
		border: 1px solid #CCC;
		border-collapse: collapse;   
	}
	table tr{line-height: 30px;}
	table tr th { background: black; color: #FFF;}
	table tr td { border:1px solid #CCC; margin: 5px; text-align: center;}
	input[type=text], input[type=email], input[type=tel]{
		min-width: 60%;
	}
	input[type=submit], a{
		background: black;
		padding: 5px;
		margin: 5px;
		color: #FFF;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	
	<c:url value="/patient/register" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>
			<c:if test="${patient.id ne null}">
				<tr>
				<td>Patient ID:</td>
					<td><input type="text" name="id" value="${patient.id}" readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${patient.firstName}" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${patient.lastName}" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${patient.email}" required></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="tel" pattern="[789][0-9]{9}" name="mobile" value="${patient.mobile}" required></td>
			</tr>

			<c:if test="${patient.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${patient.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>Tabl</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<!-- <th>Update</th>
			<th>Delete</th> -->
		</tr>
		<c:forEach items="${patientList}" var="patient">
			<tr>
				<td>${patient.id}</td>
				<td>${patient.firstName}</td>
				<td>${patient.lastName}</td>
				<td>${patient.email}</td>
				<td>${patient.mobile}</td>
				
				<td>
					<form action="<c:url value="/patient/update"/>" method="post">
						<input type="hidden" name="custId" value="${patient.id}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/patient/delete"/>" method="post">
						<input type="hidden" name="custId" value="${patient.id}">
						<input style="background: black;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>