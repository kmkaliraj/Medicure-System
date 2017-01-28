<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="message" class="com.medicure.visitor.MailBody"
	scope="request"></jsp:useBean>
<%= new DataAccessObject().getBodyData(request.getParameter("id")) %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../script/mailbox.js"></script>
<title></title>
</head>
<body>
	<table border="2" cellpadding="2" cellspacing="2" bordercolor="black"
		width="400px">
		<form name="inboxlong">

			<tr>
				<th>From<input type="hidden"
					value="<%= request.getParameter("id") %>" name="msgid" /> <input
					type="hidden" value="<%= (String)session.getAttribute("mailid") %>"
					name="mailid" /></th>


				<td><%= message.getFrom() %></td>
				<input type="hidden" value="<%= message.getFrom() %>" name="From" />
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
				<td colspan="3"><input type="button" name="reply" Value="Reply"
					onclick="replyMail(mailid.value,From.value)"> <input
					type="button" name="forward" Value="Forward"
					onclick="forwardMsg(mailid.value,Sub.value,Body.value)"> <input
					type="button" name="delete"
					onclick="deleteinbox(msgid.value ,mailid.value)" Value="Delete">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>