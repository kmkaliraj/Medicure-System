<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page For Patient</title>
<script type="text/javascript" src="../../script/PatClientSideValid.js"></script>
</head>
<body>
	<form action="../../patient.up" method="post" name="frm">
		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th><label>Name</label>
				</th>
				<th><input onkeyup="validName(this.value)" type="text"
					name="patName">
				</th>
			<tr>
				<td></td>
				<td><div id="a" style="color: red;"></div></td>
			</tr>
			</tr>
			<tr>
				<th><label>Father Name</label>
				</th>
				<th><input onkeyup="validFName(this.value)" type="text"
					name="patFather">
				</th>
			<tr>
				<td></td>
				<td><div id="b" style="color: red;"></div></td>
			</tr>
			</tr>
			<tr>
				<th><label>Marital Status</label>
				</th>
				<th><input type="radio" name="marital" value="yes"
					id="yesCheck" onclick="checkMarital()">Yes <input
					type="radio" name="marital" value="no" id="noCheck"
					onclick="checkMarital1()">No</th>
			</tr>
			<!-- Spouse Name is optional -->
			<tr>
				<th><label>Spouse Name</label>
				</th>
				<th><input onkeyup="validSName(this.value)" type="text"
					name="patSpouse" id="spouse" disabled="disabled">
				</th>
			<tr>
				<td></td>
				<td><div id="c" style="color: red;"></div></td>
			</tr>
			</tr>

			<tr>
				<th><label>Contact</label>
				</th>
				<th><input onkeyup="validContact(this.value)" type="text"
					name="patContact">
				</th>
			<tr>
				<td></td>
				<td><div id="d" style="color: red;"></div></td>
			</tr>
			</tr>
			<tr>
				<th><label>Occupation</label>
				</th>
				<th><input onkeyup="validOccu(this.value)" type="text"
					name="patOccupation">
				</th>
			<tr>
				<td></td>
				<td><div id="e" style="color: red;"></div></td>
			</tr>
			</tr>
			<tr>
				<th><input type="reset" value="Reset">
				</th>
				<th><input type="button" value="Validate" onclick="validate()">
					<input type="submit" name="submit" id="SUB" value="Submit"
					disabled="disabled">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>