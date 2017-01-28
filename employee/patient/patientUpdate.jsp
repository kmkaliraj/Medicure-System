<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Update</title>
<script type="text/javascript">
function checkMarital(){
	document.getElementById("spouse").removeAttribute("disabled");
}
function checkMarital1(){
	document.getElementById("spouse").setAttribute("disabled", "disabled");
}
</script>
</head>
<body>
	<form>
		<table border="3" cellpadding="3" cellspacing="3" bordercolor="black">
			<tr>
				<th><label>Name</label>
				</th>
				<th><input type="text" name="patName" disabled="disabled">
				</th>
			</tr>
			<tr>
				<th><label>Patient Id</label>
				</th>
				<th><input type="text" name="patId" disabled="disabled">
				</th>
			</tr>
			<tr>
				<th><label>Father Name</label>
				</th>
				<th><input type="text" name="patFather">
				</th>
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
				<th><input type="text" name="patSpouse" id="spouse"
					disabled="disabled">
				</th>
			</tr>

			<tr>
				<th><label>Contact</label>
				</th>
				<th><input type="text" name="patContact">
				</th>
			</tr>

			<tr>
				<th><label>Date of Birth</label>
				</th>
				<th><input type="text" name="patDOB">
				</th>
			</tr>
			<tr>
				<th><label>Occupation</label>
				</th>
				<th><input type="text" name="patOccupatin">
				</th>
			</tr>

			<tr>
				<th><label>Address</label>
				</th>
				<th><textarea rows="5" cols="20" name="patAddress"></textarea>
				</th>
			</tr>
			<tr>
				<th><input type="reset" value="Reset">
				</th>
				<th><input type="submit" value="Submit">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>