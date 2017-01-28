
<html>
<head>
<title>update patient's Record</title>
</head>
<body>
	<form action="../../PatientRecordUpdate" method="post">
		<table border="0" cellpadding="3" cellspacing="3">
			<%String Doctor_ID=(String) session.getAttribute("Uid");%>
			<tr>
				<th><label>Doctor_ID</label></th>
				<th><input type="text" name="Doctor_ID" value="Doctor_ID  "
					disabled=" disabled"></th>
			</tr>
			<tr>
				<th><label>Patient's ID</label></th>
				<th><input type="text" name="Patient_ID"></th>
			</tr>
			<tr>
				<th><label>CheckDate</label></th>
				<th><input type="text" name="Check_date"></th>
			</tr>
			<tr>
				<th><label>diagnosis</label></th>
				<th><input type="text" name="Diagnosis"></th>
			</tr>
			<tr>
				<th><label>Result</label></th>
				<th><input type="text" name="Result"></th>
			</tr>
			<tr>
				<th><label>Prescription</label></th>
				<th><input type="text" name="Prescription"></th>
			</tr>
			<tr>
				<th><input type="submit" value="submit"></th>

				<th><input type="reset" value="reset"></th>
			</tr>
		</table>
	</form>
</body>
</html>
