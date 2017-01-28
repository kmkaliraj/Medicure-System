<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Profile Update</title>
</head>
<body>
	<form action="#">
		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th><label>Name</label>
				</th>
				<th><input type="text" name="supplierName" disabled="disabled">
				</th>
			</tr>

			<tr>
				<th><label>Contact</label>
				</th>
				<th><input type="text" name="supplierContact">
				</th>
			</tr>
			<tr>
				<th><label>Address</label>
				</th>
				<th><textarea rows="5" cols="20" name="supplierAddress"></textarea>
				</th>
			</tr>
			<tr>
				<th><label>Date of Birth</label>
				</th>
				<th><input type="text" name="supplierDOB">
				</th>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="SUBMIT">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>