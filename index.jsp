<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script language="JavaScript" type="text/javascript">
      function validate() {
	  
    	  if(document.frm.username.value=="" && document.frm.password.value==""){
    		  alert("pls enter username n pwd");
              return false;  
    		  } 
			  
          if(document.frm.username.value==""){
			  alert("pls enter username");
              return false; 
              }

          if(document.frm.password.value==""){
              alert("Please enter password");
              return false;
              } 	  
       }
 </script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicure-Home</title>
<link href="index.css" rel="Stylesheet" type="text/css" />


</head>
<body>
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MEDICURE AUTOMATION
		</div>
		<div id="menubar">
			<!-- 			visitor name goes here -->
			<div id="menubartext">Hello Visitor</div>
			<!-- 			menubar links goes here -->
			<a href="index.jsp" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="medicines1.jsp?search=A" class="menubar" target="_self">Medicines</a>&nbsp;&nbsp;&nbsp;
			<a href="physicians.jsp?search=A&speciality=name" class="menubar"
				target="_self"> Physicians</a>
			<div style="float: right;">
				<input type="text" /> <input type="button" value="Search" />
			</div>
		</div>
		<div id="body">
			<div id="login">
				<!-- 				login table goes here -->

				<form name="frm" action="clinic.vld" onsubmit="return validate()"
					method="post">
					<table>
						<tr>
							<th><label>Category</label></th>
							<th><select name="employee">
									<option value="patient">Patient</option>
									<option value="doctor">Doctor</option>
									<option value="receptionists">Receptionist</option>
									<option value="salesman">Salesman</option>
									<option value="supplier">Supplier</option>
									<option value="db_admin">Administrator</option>
							</select></th>
						</tr>
						<tr>
							<th>User Name</th>
							<th><input type="text" name="username" /></th>
						</tr>
						<tr>
							<th>Password</th>
							<th><input type="password" name="pwd" /></th>
						</tr>
						<tr>
							<th><input type="reset" name="reset" value="Clear" /></th>
							<th><input type="submit" name="submit" value="Login" /></th>
						</tr>

					</table>
				</form>
			</div>
			<!-- 				Body Content Goes Here -->
		</div>


		<div id="footer">
			<!-- 			footer goes here  -->
			copyright &copy; IBM India Pvt. Ltd
		</div>
	</div>
</body>
</html>
