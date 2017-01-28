<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% String email = new DataAccessObject().getEmailid((String)session.getAttribute("id")) ;
session.setAttribute("mailid", email);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salesman-Order</title>
<link href="css/order.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/sidebardrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8"> </script>
<script type="text/javascript">
function order(beginChar){
	xmlhttp = new XMLHttpRequest();
	page="fetchStockDetails.jsp?type="+beginChar;
	xmlhttp.open("GET",page, true);
	xmlhttp.send();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4){
			var show = xmlhttp.responseText;
			document.getElementById("mainbar").innerHTML=show;
		}
	};
}
</script>
</head>
</head>
<body>
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MediCure
		</div>
		<div id="menubar">
			<!-- 			visitor name goes here -->
			<div id="menubartext">Hello Salesman</div>
			<!-- 			menubar links goes here -->
			<a href="#" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="physicians.jsp" class="menubar" target="_self">
				Physicians</a>&nbsp;&nbsp;&nbsp; <a href="medicines.jsp" class="menubar"
				target="_self"> Medicines</a>
			<div style="float: right;">
				<input type="text" /> <input type="button" value="Search" />
			</div>
		</div>
		<div id="body">
			<!-- 	SidebarContainer goes here -->
			<div id="sidebarcontainer">
				<div class="sidebardrop">
					<!-- 				sidebar goes here -->
					<ul>
						<li><a class="sidebarlink" href="#" target="_self">Mail</a>
						</li>
					</ul>
				</div>
				<div id="dropmenu">
					<form name="form">
						<input type="hidden" value="<%= email %>" name="mailid" />
						<!-- 				dropmenu from the sidebar -->

						<li><a class="collapsed">Mail</a>
							<ul>
								<li><a href="#" onclick="compose(mailid.value)">Compose</a>
								</li>
								<li><a href="#" onclick="inbox(mailid.value)">Inbox</a></li>
								<li><a href="#" onclick="outbox(mailid.value)">Sent</a></li>
								<li><a href="#" onclick="drafts(mailid.value)">Draft</a></li>
							</ul>
						</li>
				</div>
				</form>
				
				<div id="sidebar">
					<ul>
						<li><a class="sidebarlink" href="order.jsp" target="_self">View
								Prescription</a>
						<li><a class="sidebarlink"
							href="OrderGenerationToSupplier.serv" target="_self">Order
								Status</a><br>
						<li><a class="sidebarlink" href="Quotation.jsp"
							target="_self">View Quotation</a><br>
						<li><a class="sidebarlink" href="#" target="_self">Check
								Stock</a>
					</ul>
				</div>
			</div>
			<div id="alpha">
				<a class="alphabar" href="#" target="_self" onclick="order('a')">A</a>
				<a class="alphabar" href="#" target="_self" onclick="order('b')">B</a>
				<a class="alphabar" href="#" target="_self" onclick="order('c')">C</a>
				<a class="alphabar" href="#" target="_self" onclick="order('d')">D</a>
				<a class="alphabar" href="#" target="_self" onclick="order('e')">E</a>
				<a class="alphabar" href="#" target="_self" onclick="order('f')">F</a>
				<a class="alphabar" href="#" target="_self" onclick="order('g')">G</a>
				<a class="alphabar" href="#" target="_self" onclick="order('h')">H</a>
				<a class="alphabar" href="#" target="_self" onclick="order('i')">I</a>
				<a class="alphabar" href="#" target="_self" onclick="order('j')">J</a>
				<a class="alphabar" href="#" target="_self" onclick="order('k')">K</a>
				<a class="alphabar" href="#" target="_self" onclick="order('l')">L</a>
				<a class="alphabar" href="#" target="_self" onclick="order('m')">M</a>
				<a class="alphabar" href="#" target="_self" onclick="order('n')">N</a>
				<a class="alphabar" href="#" target="_self" onclick="order('o')">O</a>
				<a class="alphabar" href="#" target="_self" onclick="order('p')">P</a>
				<a class="alphabar" href="#" target="_self" onclick="order('q')">Q</a>
				<a class="alphabar" href="#" target="_self" onclick="order('r')">R</a>
				<a class="alphabar" href="#" target="_self" onclick="order('s')">S</a>
				<a class="alphabar" href="#" target="_self" onclick="order('t')">T</a>
				<a class="alphabar" href="#" target="_self" onclick="order('u')">U</a>
				<a class="alphabar" href="#" target="_self" onclick="order('v')">V</a>
				<a class="alphabar" href="#" target="_self" onclick="order('w')">W</a>
				<a class="alphabar" href="#" target="_self" onclick="order('x')">X</a>
				<a class="alphabar" href="#" target="_self" onclick="order('y')">Y</a>
				<a class="alphabar" href="#" target="_self" onclick="order('z')">Z</a>
			</div>
			<!-- 				Body Content Goes Here -->
			<div id="mainbar">
				<!-- Stock content goes here -->


			</div>
		</div>

		<div id="footer">
			<!-- 			footer goes here  -->
			copyright &copy; IBM India Pvt Ltd
		</div>

	</div>

</body>
</html>