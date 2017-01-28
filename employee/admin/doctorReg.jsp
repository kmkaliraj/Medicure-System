<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration Page For Doctor</title>
<script type="text/javascript" src="../../script/ClientSideValid.js"></script>
</head>

<body>
	<h1>Registration For Doctor</h1>
	<form action="../../doctor.up" method="post" name="frm">

		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th><label>Name</label>
				</th>
				<th><input type="text" name="docName"
					onkeyup="validName(this.value)">
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
				<th><label>Speciality</label>
				</th>
				<th><input type="text" name="docSpeciality"
					onkeyup="validSpecl(this.value)">
				</th>
			<tr>
				<td></td>
				<td><div id="b" style="color: red;"></div>
				</td>
			</tr>
			</tr>
			<tr>
				<th><label>Qualification</label>
				</th>
				<th><input type="text" name="docQualification"
					onkeyup="validQuali(this.value)">
				</th>
			<tr>
				<td></td>
				<td><div id="qual" style="color: red;"></div>
				</td>
			</tr>
			</tr>
			<tr>
				<th><label>Affiliation</label>
				</th>
				<th><input type="text" name="docAffiliation">
				</th>
			</tr>
			<tr>
				<th><label>Experience</label>
				</th>
				<th><input type="text" onkeyup="validExp(this.value)"
					name="docExperience">
				</th>
			<tr>
				<td></td>
				<td><div id="exp" style="color: red;"></div>
				</td>
			</tr>
			</tr>
			<tr>
				<th><input type="reset" value="Clear">
				</th>
				<th><input type="button" value="Validate"
					onclick="validateData()"> <input type="submit"
					name="submit" id="sub" value="Submit" disabled="disabled">
				</th>
			</tr>
		</table>

	</form>
</body>
</html>