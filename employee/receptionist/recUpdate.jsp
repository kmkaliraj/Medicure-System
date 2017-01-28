<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receptionist Profile Update</title>
</head>
<body>
	<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
		<tr>
			<th><label>Name:</label>
			</th>
			<th><input type="text" disabled="disabled">
			</th>
		</tr>
		<tr>
			<th><label>Receptionist ID:</label>
			</th>
			<th><input type="text" disabled="disabled">
			</th>
		</tr>
		<tr>
			<th><label> contact: </label>
			</th>
			<th><input type="text" name="contact">
			</th>
		</tr>
		<tr>
			<th><label> Qualification: </label>
			</th>
			<th><input type="text" name="qualification">
			</th>
		</tr>

		<tr>
			<th><label> years of experience: </label>
			</th>
			<th><input type="text" name="yrexp">
			</th>
		</tr>
		<tr>
			<th><label> address: </label>
			</th>
			<th><textarea rows="7" cols="20" name="address"></textarea>
			</th>
		</tr>
		<tr>
			<th><input type="reset" value="reset">
			</th>
			<th><input type="submit" value="submit">
			</th>


		</tr>
	</table>
</body>
</html>