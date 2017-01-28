<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.TreeSet"%>
<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="name" class="com.medicure.visitor.MedicineName"
	scope="application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%=request.getParameter("search") %> --%>
<%=new DataAccessObject().medicineName(request.getParameter("search"))%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicure-Home</title>
<link href="index.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8"> </script>
<script type="text/javascript" src="script/adSearch.js" charset="UTF-8"> </script>
<script type="text/javascript">
	
	
	function func(d){
		
		var ida=""+d;
		
		xmlhttp = new XMLHttpRequest();
		var  a = document.getElementById(ida).innerHTML;
	
		d++;
		
		xmlhttp.open("GET","medicinalinfo.jsp?name="+a,true);
		xmlhttp.send();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4){
				var show = xmlhttp.responseText;
				document.getElementById(d).innerHTML=show;
			}
		};
		
	}
	
	
	</script>
<style type="text/css">
</style>
</head>
</head>
<body onload="f()">
	<div id="container">
		<div id="header">
			<!-- 		 	Header goes here -->
			MEDICINE INFORMATION
		</div>
		<div id="menubar">
			<!-- 			visitor name goes here -->
			<div id="menubartext">Hello Visitor</div>
			<!-- 			menubar links goes here -->
			<a href="index.jsp" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="#" class="menubar" target="_self"> Medicines</a>&nbsp;&nbsp;&nbsp;
			<a href="physicians.jsp?search=A&speciality=name" class="menubar"
				target="_self"> Physicians</a>
			<div style="float: right;">
				<input type="text" /> <input type="button" value="Search" />
			</div>
		</div>
		<div id="body">
			<div id="login">
				<!-- 				login table goes here -->

				<table>
					<form name="Searchbyname" action="medicines1.jsp" method="post">
						<tr>
							<th>Medicine Name</th>
							<th><input onkeyup="validName(this.value)" type="text"
								name="search" />
								<div style="color: red" id="dynamic" style="width: 20"></div>
							</th>
						</tr>
						<tr>
							<th></th>
							<th><input type="submit" name="submit" value="Search" />
							</th>
						</tr>

					</form>

				</table>
			</div>

			<a href="medicines1.jsp?search=A">A</a> <a
				href="medicines1.jsp?search=B">B</a> <a
				href="medicines1.jsp?search=C">C</a> <a
				href="medicines1.jsp?search=D">D</a> <a
				href="medicines1.jsp?search=E">E</a> <a
				href="medicines1.jsp?search=F">F</a> <a
				href="medicines1.jsp?search=G">G</a> <a
				href="medicines1.jsp?search=H">H</a> <a
				href="medicines1.jsp?search=I">I</a> <a
				href="medicines1.jsp?search=J">J</a> <a
				href="medicines1.jsp?search=K">K</a> <a
				href="medicines1.jsp?search=L">L</a> <a
				href="medicines1.jsp?search=M">M</a> <a
				href="medicines1.jsp?search=N">N</a> <a
				href="medicines1.jsp?search=O">O</a> <a
				href="medicines1.jsp?search=P">P</a> <a
				href="medicines1.jsp?search=Q">Q</a> <a
				href="medicines1.jsp?search=R">R</a> <a
				href="medicines1.jsp?search=S">S</a> <a
				href="medicines1.jsp?search=T">T</a> <a
				href="medicines1.jsp?search=U">U</a> <a
				href="medicines1.jsp?search=V">V</a> <a
				href="medicines1.jsp?search=W">W</a> <a
				href="medicines1.jsp?search=X">X</a> <a
				href="medicines1.jsp?search=Y">Y</a> <a
				href="medicines1.jsp?search=Z">Z</a> <br> <br> <br>
			<div id="searchResult" style="color: red"><%= name.getSearch() %></div>

			<%
					int i=0;
	   				for(Object ob:name.getName()) {
					i++;
				%>
			<p onclick="func(<%=i%>)" id="<%=i%>" class="flip">
				<%=ob%>
			</p>


			<!-- Doctor's detail goes here -->
			<%i++; %>

			<div class="panel" id="<%=i%>"></div>
			<%
			   }
			%>

			<div id="footer">
				<!-- footer goes here  -->
				Copyright &copy; IBM India Pvt Ltd.
			</div>
		</div>
	</div>


</body>
</html>