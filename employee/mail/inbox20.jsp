<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="inbox" class="com.medicure.visitor.Inbox"
	scope="request"></jsp:useBean>
<%= new DataAccessObject().getInboxData(request.getParameter("id")) %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
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
		<caption>INBOX</caption>
		<tr>
			<th>From</th>
			<th>Subject</th>
			<th>Time</th>
		</tr>
		<%
			String[] splitColumn=new String[4];
			for(Object ob:inbox.getInboxContent()){
				splitColumn = ob.toString().split("__");
				
		%>
		<tr onclick="clickLong(<%=splitColumn[0]%>)">
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