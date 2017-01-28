<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Profile Update</title>
</head>
<body>
	<form action="DoctorUpdate" method="post">
		<table border=0 cellpadding=3 cellspacing=3>
			<tr>
				<th><label>Name<label>
				</th>
				<th><input type="text" name="name"
					value=<%=request.getAttribute("name") %> disabled="disabled">
				</th>
			</tr>
			<tr>
				<th><label>Doctor_ID<label>
				</th>
				<th><input type="text" name="doc_Id"
					value=<%=request.getAttribute("doc_ID") %>>
				</th>
			</tr>
			<tr>
				<th><label>Password<label>
				</th>
				<th><input type="password" name="pwd"
					value=<%=request.getAttribute("password") %>></th>
			</tr>
			<tr>
				<th><label>Password_hint<label>
				</th>
				<th><input type="password" name="pwd_hint"
					value=<%=request.getAttribute("password_hint") %>></th>
			</tr>
			<tr>
				<th><label>Qualification<label>
				</th>
				<th><input type="text" name="qualification"
					value=<%=request.getAttribute("qualification") %>>
				</th>
			</tr>
			<tr>
				<th><label>Specialization<label>
				</th>
				<th><input type="text" name="Specialization"
					value=<%=request.getAttribute("Specialization") %>
					disabled="disabled">
				</th>
			</tr>
			<tr>
				<th><label>Experience<label>
				</th>
				<th><input type="text" name="Experience"
					value=<%=request.getAttribute("Experience") %>></th>
			</tr>
			<tr>
				<th><label>Affliation<label>
				</th>
				<th><input type="text" name="Affliation"
					value=<%=request.getAttribute("Affliation") %> disabled="disabled">
				</th>
			</tr>
			<tr>
				<th><input type="submit" name="submit" value="Update">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>