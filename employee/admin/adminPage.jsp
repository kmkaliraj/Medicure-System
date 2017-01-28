<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medicure-Admin-Home</title>
<link href="../../css/admin.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="../../script/Profile.js"></script>
<script type="text/javascript" src="../../script/ClientSideValid.js"></script>
<script type="text/javascript" src="../../script/RecClientSideValid.js"></script>
<script type="text/javascript"
	src="../../script/SalesmanClientSideValid.js"></script>
<script type="text/javascript"
	src="../../script/SupplierClientSideValid.js"></script>

<script type="text/javascript">
			function showmenu(elmnt)
			{
			document.getElementById(elmnt).style.visibility="visible";
			}
			function hidemenu(elmnt)
			{
			document.getElementById(elmnt).style.visibility="hidden";
			}
		</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MEDICURE AUTOMATION
		</div>
		<div id="menubar">
			<div id="menubartext">
				&nbsp;&nbsp;&nbsp;Hello Administrator <a href="../../index.jsp"
					style="font-style: italic; color: black; font-size: small; text-decoration: none;">(Logout)</a>
			</div>
			<!-- 			menubar links goes here -->

			<table>
				<tr>

					<td><a href="../../index.jsp" class="menubar" target="_self">
							Home</a>&nbsp;&nbsp;&nbsp;</td>
					<td onmouseover="showmenu('tutorials')"
						onmouseout="hidemenu('tutorials')"><a href="#"
						class="menuhead">Registration</a>&nbsp;&nbsp;&nbsp;<br />
						<table class="menu" id="tutorials">
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminDocReg()">Doctor</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminRecReg()">Receptionist</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminSalReg()">Salesman</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminSupReg()">Supplier</a></td>
							</tr>
						</table>
					</td>

					<!-- <td onmouseover="showmenu('scripting')" onmouseout="hidemenu('scripting')">
				   <a class="menuhead" href="#">View Account</a>&nbsp;&nbsp;&nbsp;<br />
				   <table class="menu" id="scripting">
				   <tr><td class="menu"><a class="menubar" href="#">Doctor</a></td></tr>
				   <tr><td class="menu"><a class="menubar" href="#">Receptionist</a></td></tr>
				   <tr><td class="menu"><a class="menubar" href="#">Salesman</a></td></tr>
				   <tr><td class="menu"><a class="menubar" href="#">Supplier</a></td></tr>
				   <tr><td class="menu"><a class="menubar" href="#">Patient</a></td></tr>
				   </table>
				  </td> -->

					<td onmouseover="showmenu('validation')"
						onmouseout="hidemenu('validation')"><a class="menuhead"
						href="#">Remove Account</a>&nbsp;&nbsp;&nbsp;<br />
						<table class="menu" id="validation">
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminDocRemove()">Doctor</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminRecRemove()">Receptionist</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminSalRemove()">Salesman</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminSupRemove()">Supplier</a></td>
							</tr>
							<tr>
								<td class="menu"><a class="menubar" href="#"
									onclick="adminPatRemove()">Patient</a></td>
							</tr>
						</table>
					</td>

				</tr>
			</table>
		</div>
		<div id="body">
			<!-- 				Body Content Goes Here -->


		</div>

		<div id="footer">
			<!-- 			footer goes here  -->
			Footer
		</div>
	</div>
</body>
</html>