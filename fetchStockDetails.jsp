<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.medicure.drug.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
	String drugNames[][]=null;
	String character=request.getParameter("type");
	
	drugNames=new DrugDAO().getMedicineNameByFirstLetter(character);
	int length=drugNames.length;
	if(length!=0)
	{
%>

	<table id="mytable" align="center">
		<tr>
			<th>Drug ID</th>
			<th>Drug Name</th>
			<th>Available Quantity</th>
		</tr>
		<% for(int i=0;i<length;i++) { 	%>
		<tr>
			<% 	for(int j=0;j<3;j++) {	%>
			<td><%=drugNames[i][j]%></td>
			<%}%>
		</tr>
		<%}
		}
		else
		{
			%>

	</table>
	<font color="red"> No Details Of Medicine Found </font>
	<%
			
		}
		
		%>
</body>
</html>