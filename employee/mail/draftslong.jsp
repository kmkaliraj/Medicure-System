<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="message" class="com.medicure.visitor.MailOutboxBody"
	scope="request"></jsp:useBean>
<%= new DataAccessObject().getOutBodyData(request.getParameter("id")) %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<form name="outboxlong">
		<table border="2" cellpadding="2" cellspacing="2" bordercolor="black"
			width="400px">
			<tr>
				<th>To<input type="hidden"
					value="<%= request.getParameter("id") %>" name="msgid" /> <input
					type="hidden" value="<%= (String)session.getAttribute("mailid") %>"
					name="mailid" /></th>

				<input type="hidden" value="<%= message.getCc() %>" name="cc" />
				<td><%= message.getTo() %></td>
				<input type="hidden" value="<%= message.getTo() %>" name="From" />
			</tr>
			<tr>
				<th>Subject</th>
				<td><%= message.getSubject() %></td>
				<input type="hidden" value="<%= message.getSubject() %>" name="Sub" />
			</tr>
			<tr>
				<th>Message</th>
				<td><%= message.getMessage() %></td>
				<input type="hidden" value="<%= message.getMessage() %>" name="Body" />
			</tr>
			<tr>
			<tr>
				<td colspan="3"><input type="button" name="send" value="Send"
					onclick="send1(msgid.value,mailid.value,From.value,cc.value,Sub.value,Body.value)">
					<input type="button" name="delete" Value="Delete"
					onclick="deletedrafts(msgid.value)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>