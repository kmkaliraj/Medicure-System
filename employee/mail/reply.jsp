<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>compose</title>
</head>
<body>
	<form action="ComposeMail" method="post">
		<table border="2" cellpadding="2" cellspacing="2" bordercolor="black"
			width="300px">
			<input type="hidden" value="<%= request.getParameter("from")%>"
				name="from" />
			<tr>
				<th><label>To</label>
				</th>
				<td><input onblur="checkmailid(this.value)" type="text"
					name="to" width="1" value="<%= request.getParameter("to")%>" />
					<div id="toid" style="color: red"></div>
				</td>
			</tr>
			<tr>
				<th><label>CC</label>
				</th>
				<td><input onblur="checkmailccid(this.value)" type="text"
					name="cc" />
					<div id="ccid" style="color: red"></div>
				</td>
			</tr>
			<tr>
				<th><label>Subject</label>
				</th>
				<td><input type="text" name="subject" />
				</td>
			</tr>
			<tr>
				<th><label>Message</label>
				</th>
				<td><textarea rows="10" cols="50" name="message"></textarea>
				</td>
			</tr>
			<tr>
				<th colspan="1"><input type="button" id="send"
					disabled="disabled"
					onclick="send(from.value,to.value,cc.value,subject.value,message.value)"
					Value="Send">
				</th>
				<th colspan="2"><input type="Reset" name="Reset" Value="Clear">
					<input type="button" name="Save"
					onclick="save(from.value,to.value,cc.value,subject.value,message.value)"
					Value="Save"></th>


			</tr>
		</table>
	</form>

</body>
</html>