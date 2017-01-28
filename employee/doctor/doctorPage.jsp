<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% String email = new DataAccessObject().getEmailid((String)session.getAttribute("id")) ;
session.setAttribute("mailid", email);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medicure-Doctor</title>
<link href="../../css/navigation.css" rel="Stylesheet" type="text/css" />
<link href="../../css/accordion.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="../../script/Profile.js"></script>
<!-- for the accordion type of menu -->
<script type="text/javascript" src="../../script/jquerysource.js"></script>
<script type="text/javascript" src="../../script/accordion.js"></script>
<script type="text/javascript" src="../../script/mailbox.js"></script>

</head>
<body>
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MEDICURE AUTOMATION
		</div>
		<div id="menubar">
			<div id="menubartext">
				&nbsp;&nbsp;&nbsp;Hello Doctor <a href="#"
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
			<form name="mail">
				<div id="sidebar">
					<!-- 				Menu List goes here -->
					<input type="hidden" value="<%= email %>" name="mailid" />
					<ul>
						<ul id="menu5" class="example_menu">
							<li><a class="collapsed">Profile</a>
								<ul>
									<li><a href="#" onclick="docView()">View</a></li>
									<li><a href="#" onclick="docUpdate()">Update</a></li>
								</ul>
							</li>
							<li><a class="collapsed">Mail</a>
								<ul>
									<li><a href="#" onclick="compose(mailid.value)">Compose</a>
									</li>
									<li><a href="#" onclick="inbox(mailid.value)">Inbox</a></li>
									<li><a href="#" onclick="outbox(mailid.value)">Sent</a></li>
									<li><a href="#" onclick="drafts(mailid.value)">Draft</a></li>
								</ul>
							</li>
							<li><a class="collapsed">Patient Record</a>
								<ul>
									<li><a href="#" onclick="patRecView()">View</a></li>
									<li><a href="#" onclick="patRecUpdate()">Update</a></li>
								</ul>
							</li>
						</ul>

						<li><a class="sidebar" href="#"
							onclick="docUpdatePrescription()">Update Prescription</a><br>
					</ul>

				</div>
			</form>
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