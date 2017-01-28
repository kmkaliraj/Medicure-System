
<html>
<head>
<title>order Drug</title>
</head>
<body>
	<form action="../../OrderDrugUpdate" method="post">
		<%
	String Doctor_ID=(String) session.getAttribute("Uid");%>
		<table border="0" cellpadding="3" cellspacing="3">
			<tr>
				<th><label> DoctorID </label></th>
				<th><input type="text" name="doctor_ID" value="<%=Doctor_ID%>"
					disabled="disabled"></th>
			</tr>
			<tr>
				<th><label> Prescription_ID </label></th>
				<th><input type="text" name="Prescription_ID"></th>
			</tr>

			<tr>
				<th><label> Drug ID </label></th>
				<th><input type="text" name="DrugID"></th>
			</tr>
			<tr>
				<th><label> Quantity </label></th>
				<th><input type="text" name="Quantity"></th>
			</tr>
			<tr>
				<th><label> Dosage </label></th>
				<th><input type="text" name="Dosage"></th>
			</tr>
			<tr>
				<th><label>Patient_ID</label></th>
				<th><input type="text" name="Patient_ID"></th>
			</tr>
			<tr>
				<th><label> Prescription Date </label></th>
				<th><input type="text" name="Pres_date"></th>
			</tr>
			<tr>
				<th><label> Status </label></th>
				<th><input type="text" name="Status"></th>
			</tr>
			<tr>

				<th><input type="submit" value="Submit here"></th>

				<th><input type="reset" value="Reset value"></th>
			</tr>
		</table>
</body>
</form>
</html>







<
