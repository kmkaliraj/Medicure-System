<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.TreeSet"%>
<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="Doctor" class="com.medicure.visitor.DoctorName"
	scope="application"></jsp:useBean>
<jsp:useBean id="specialization"
	class="com.medicure.visitor.Specialization" scope="application"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%=new DataAccessObject().getDoctorName(request.getParameter("search"),request.getParameter("speciality"))%>
<%=new DataAccessObject().getSpeciality()%>
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
	xmlhttp.open("GET","DoctorInformation.jsp?name="+a,true);
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
			DOCTOR INFORMATION
		</div>
		<div id="menubar">
			<!-- 			visitor name goes here -->
			<div id="menubartext">Hello Visitor</div>
			<!-- 			menubar links goes here -->
			<a href="index.jsp" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="medicines1.jsp?search=A" class="menubar" target="_self">Medicines</a>&nbsp;&nbsp;&nbsp;
			<a href="#" class="menubar" target="_self"> Physicians</a>

			<div style="float: right;">
				<input type="text" /> <input type="button" value="Search" />
			</div>
		</div>
		<div id="body">
			<div id="login">
				<!-- 				login table goes here -->

				<table>
					<form name="Searchbyname" action="physicians.jsp" method="post">
						<tr>
							<th>Doctor Name</th>
							<th><input type="text" name="search" />
							</th>
						</tr>
						<tr>
							<th><input type="hidden" name="speciality" value="name" />
							</th>
							<th><input type="submit" name="submit" value="Search" />
							</th>
						</tr>
						<tr>
					</form>
					<th colspan="2">
						<p class="flipsearch">
							<!-- 				Doctors name goes here -->
							Advanced Search

						</p>

						<div class="panelsearch" id="123">
							<form name="Searchbyspeciality" action="physicians.jsp"
								method="post">
								<!-- 					Doctor's detail goes here -->
								<table>
									<tr>
										<th>Speciality</th>
										<th><select name="search">
												<%for(Object abc : specialization.getSpecializationList()){%>
												<option value="<%= abc%>"><%= abc%></option>
												<%} %>
										</select>
										</th>
									</tr>
									<tr>
										<th><input type="hidden" name="speciality" value="*" />
										</th>
										<th><input type="submit" name="submit" value="Search" />
										</th>
									</tr>
								</table>
							</form>
						</div>
					</th>
					</tr>
				</table>
			</div>
			<!-- 				Body Content Goes Here -->
			<a href="physicians.jsp?search=A&speciality=name">A</a> <a
				href="physicians.jsp?search=B&speciality=name">B</a> <a
				href="physicians.jsp?search=C&speciality=name">C</a> <a
				href="physicians.jsp?search=D&speciality=name">D</a> <a
				href="physicians.jsp?search=E&speciality=name">E</a> <a
				href="physicians.jsp?search=F&speciality=name">F</a> <a
				href="physicians.jsp?search=G&speciality=name">G</a> <a
				href="physicians.jsp?search=H&speciality=name">H</a> <a
				href="physicians.jsp?search=I&speciality=name">I</a> <a
				href="physicians.jsp?search=J&speciality=name">J</a> <a
				href="physicians.jsp?search=K&speciality=name">K</a> <a
				href="physicians.jsp?search=L&speciality=name">L</a> <a
				href="physicians.jsp?search=M&speciality=name">M</a> <a
				href="physicians.jsp?search=N&speciality=name">N</a> <a
				href="physicians.jsp?search=O&speciality=name">O</a> <a
				href="physicians.jsp?search=P&speciality=name">P</a> <a
				href="physicians.jsp?search=Q&speciality=name">Q</a> <a
				href="physicians.jsp?search=R&speciality=name">R</a> <a
				href="physicians.jsp?search=S&speciality=name">S</a> <a
				href="physicians.jsp?search=T&speciality=name">T</a> <a
				href="physicians.jsp?search=U&speciality=name">U</a> <a
				href="physicians.jsp?search=V&speciality=name">V</a> <a
				href="physicians.jsp?search=W&speciality=name">W</a> <a
				href="physicians.jsp?search=X&speciality=name">X</a> <a
				href="physicians.jsp?search=Y&speciality=name">Y</a> <a
				href="physicians.jsp?search=Z&speciality=name">Z</a> <BR> <BR>
			<div id="searchResult" style="color: red"><%= Doctor.getName() %></div>
			<%
										TreeSet<String> arr = new TreeSet(Doctor.getDocName());
										
										Iterator it = arr.iterator();
										int i = 0;
										
										String check="pid";
										String checkone = "did";
										while (it.hasNext()) {
											i++;
									%>
			<p onclick="func(<%=i%>)" id="<%=i%>" class="flip">


				<%=it.next()%>



			</p>


			<!-- 					Doctor's detail goes here -->
			<%i++; %>
			<div class="panel" id="<%=i%>">hai</div>
			<%
				}
			%>


			<div id="footer">
				<!-- 			footer goes here  -->
				Footer
			</div>
		</div>
	</div>


</body>
</html>