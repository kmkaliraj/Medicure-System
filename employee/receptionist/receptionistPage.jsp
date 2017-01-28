<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medicure-Receptionist</title>
<link href="../../css/navigation.css" rel="Stylesheet" type="text/css" />
<link href="../../css/accordion.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="../../script/Profile.js"></script>
<!-- for the accordion type of menu -->
<script type="text/javascript" src="../../script/jquerysource.js"></script>
<script type="text/javascript" src="../../script/accordion.js"></script>
<script type="text/javascript" src="../../script/PatClientSideValid.js"></script>
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
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MEDICURE AUTOMATION
		</div>
		<div id="menubar">
			<div id="menubartext">
				&nbsp;&nbsp;&nbsp;Hello Receptionist <a href="#"
					style="font-style: italic; color: black; font-size: small; text-decoration: none;">(Logout)</a>
			</div>
			<!-- 			menubar links goes here -->
			<a href="../../index.jsp" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="#" class="menubar" target="_self"> Medicines</a>&nbsp;&nbsp;&nbsp;
			<a href="#" class="menubar" target="_self"> Physicians</a>
			<div style="float: right;">
				<input type="text" /> <input type="button" value="Search" />
			</div>
		</div>
		<div id="body">
			<div id="sidebar">
				<!-- 				Menu List goes here -->
				<ul>
					<ul id="menu5" class="example_menu">
						<li><a class="collapsed">Profile</a>
							<ul>
								<li><a href="#" onclick="recView()">View</a></li>
								<li><a href="#" onclick="recUpdate()">Update</a></li>
							</ul>
						</li>
						<li><a class="collapsed">Patient Details</a>
							<ul>
								<li><a href="#">View</a></li>
								<li><a href="#" onclick="recPatientRegister()">Register</a>
								</li>
							</ul>
						</li>
					</ul>
				</ul>

			</div>
			<!-- 				Body Content Goes Here -->
			<div id="mainbar"></div>
		</div>


		<div id="footer">
			<!-- 			footer goes here  -->
			Footer
		</div>
	</div>
</body>
</html>