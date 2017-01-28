<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Remove</title>
</head>
<body>
	<form action="../../patient.remove" method="post">
		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th>Enter Patient Id</th>
				<th><input type="text" name="id">
				</th>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="submit"></th>
			</tr>
		</table>
</body>
</html>