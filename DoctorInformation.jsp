<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Doctorinfo"
	class="com.medicure.visitor.DoctorInformation2" scope="request"></jsp:useBean>
<%= new DataAccessObject().doctorInformation(request.getParameter("name")) %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoctorInformation</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td><%=Doctorinfo.getDoc_Id() %></td>
		</tr>
		<tr>
			<td>Qualification</td>
			<td><%=Doctorinfo.getQualification() %></td>
		</tr>
		<tr>
			<td>SPECIALISATION</td>
			<td><%=Doctorinfo.getSpecialization() %></td>
		</tr>
		<tr>
			<td>AFFILIATION</td>
			<td><%=Doctorinfo.getAffiliation() %></td>
		</tr>
		<tr>
			<td>EXPERIENCE</td>
			<td><%=Doctorinfo.getExperience() %></td>
		</tr>
	</table>
</body>
</html>