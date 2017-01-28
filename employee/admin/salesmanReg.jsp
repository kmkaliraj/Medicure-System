<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Page For Salesman</title>
<script type="text/javascript"
	src="../../script/SalesmanClientSideValid.js"></script>
</head>
<body>
	<h1>Registration For Salesman</h1>
	<form action="../../salesman.up" method="post" name="frm">
		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th><label>Name</label>
				</th>
				<th><input onkeyup="validName(this.value)" type="text"
					name="salesmanName">
				</th>
			<tr>
				<td></td>
				<td><div id="a" style="color: red;"></div>
				</td>
			</tr>
			</tr>

			<tr>
				<th><label>Gender</label>
				</th>
				<th><input type="radio" name="radioOne" value="male"
					checked="checked">Male <input type="radio" name="radioOne"
					value="female">Female</th>
			</tr>



			<tr>
				<th><input type="reset" value="Clear">
				</th>
				<th><input type="button" value="Validate"
					onclick="validateSale()"> <input type="submit"
					name="submit" id="sub" value="submit" disabled="disabled">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>