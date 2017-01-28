<%@ page language="java" import="com.medicure.visitor.DataAccessObject" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String email = new DataAccessObject().getEmailid((String)session.getAttribute("id")) ;
session.setAttribute("mailid", email);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medicure-Supplier</title>
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
				&nbsp;&nbsp;&nbsp;Hello Supplier <a href="#"
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
		<form name="form"></form>
		<div id="body">
			<div id="sidebar">
				<!-- 				Menu List goes here -->
				<ul>
					<ul id="menu5" class="example_menu">
						<li><a class="collapsed">Profile</a>
							<ul>
								<li><a href="#" onclick="supView()">View</a></li>
								<li><a href="#" onclick="supUpdate()">Update</a></li>
							</ul>
						</li><form name="form"><input type="hidden" name="mailid" value="<%=email%>"/>
						<li><a class="collapsed">Mail</a>
							<ul>
								<li><a href="#" onclick="compose(mailid.value)">Compose</a></li>
								<li><a href="#" onclick="inbox(mailid.value)">Inbox</a></li>
								<li><a href="#" onclick="outbox(mailid.value)">Sent</a></li>
								<li><a href="#" onclick="draft(mailid.value)">Draft</a></li>
							</ul>
						</li></form>
					</ul>
					<li><a class="sidebar" href="#" onclick="supOrderStatus()">View
							Order Status</a><br>
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