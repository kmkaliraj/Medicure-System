<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="drafts" class="com.medicure.visitor.Drafts"
	scope="request"></jsp:useBean>
<%= new DataAccessObject().getDraftData(request.getParameter("id")) %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drafts</title>
<script>
/* function refresh()
{
	alert("chandru");
	window.location.reload();
	alert("chandru");
} */
</script>
</head>

<body>
	<table style="border-color: black; width: 400px; color: black;"
		border="2" cellpadding="2" cellspacing="2">
		<caption>Drafts</caption>
		<tr>
			<th>To</th>
			<th>Subject</th>
			<th>Time</th>
		</tr>
		<%
			String[] splitColumn=new String[4];
			for(Object ob:drafts.getDraftContent()){
				splitColumn = ob.toString().split("__");
				
		%>
		<tr onclick="clickLong2(<%=splitColumn[0]%>)">
			<td><%=splitColumn[1]%></td>
			<td><%=splitColumn[2]%></td>
			<td><%=splitColumn[3]%></td>
		</tr>
		<% } %>
	</table>
	<br>
	<br>
	<br>
	<div id="long"></div>
</body>
</html>