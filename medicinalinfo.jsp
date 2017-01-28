<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Med_information"
	class="com.medicure.visitor.MedicinalInformation" scope="request"></jsp:useBean>
<%=request.getParameter("name") %>
<%= new DataAccessObject().medicineInformation(request.getParameter("name")) %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicine Information</title>
</head>
<body>
	<table>
		<tr>
			<td>USAGE INSTRUCTIONS</td>
			<td><%=Med_information.getUsageInstructions() %></td>
		</tr>
		<tr>
			<td>INGREDIENTS</td>
			<td><%=Med_information.getIngredients() %></td>
		</tr>
		<tr>
			<td>BENIFITS</td>
			<td><%=Med_information.getBenefits() %></td>
		</tr>
		<tr>
			<td>SIDE EFFECTS</td>
			<td><%=Med_information.getSideEffects() %></td>
		</tr>
		<tr>
			<td>PRICE</td>
			<td><%=Med_information.getPrice() %></td>
		</tr>
	</table>
</body>
</html>