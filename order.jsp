<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.medicure.drug.dao.PrescriptionDAO"%>
<%@page import="com.medicure.drug.dao.DrugDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salesman-Order</title>
<link href="css/order.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/contentdrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/sidebardrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8"> </script>

<script type="text/javascript">
	
		function refreshPage()
		{
			window.location.reload();
			
		}
		function checkStock(availQuantity,reqQuantity,counter)
		{
			
		//	deliver = "deliver"+counter;
			if(availQuantity>reqQuantity)
			{
				document.getElementById("check").removeAttribute("disabled");
				document.getElementById("hiddenId").setAttribute("value", counter);
				
			}
			else
			{
				document.getElementById(deliver).setAttribute("disabled", "disabled");
			}
		}
		
		function isEnabled()
		{
			if(document.getElementById(deliver).getAttribute("checked")==false)
			{
				document.getElementById(deliver).setAttribute("disabled", "disabled");
			}	
		}
		function navigate()
		{
			window.location.href="OrderGenerationToSupplier.serv";
		}

	</script>
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
			<a href="index.jsp" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="medicines1.jsp?search=A" class="menubar" target="_self">
				Medicines</a>&nbsp;&nbsp;&nbsp; <a
				href="physicians.jsp?search=A&speciality=name" class="menubar"
				target="_self">Physicians</a>
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
						<li><a class="sidebarlink" href="#" target="_self">Mail</a></li>
					</ul>
				</div>
				<div id="dropmenu">
					<!-- 				dropmenu from the sidebar -->
					<ul>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Inbox</a>
						</li>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Compose</a>
						</li>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Sentbox</a>
						</li>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Drafts</a>
						</li>

					</ul>
				</div>
				<div class="sidebardrop">
					<!-- 				sidebar goes here -->
					<ul>
						<li><a class="sidebarlink" href="#" target="_self">My
								Profile</a></li>
					</ul>
				</div>
				<div id="dropmenu">
					<!-- 				dropmenu from the sidebar -->
					<ul>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">View</a>
						</li>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Edit</a>
						</li>
					</ul>
				</div>
				<div id="sidebar">
					<ul>
						<li><a class="sidebarlink" href="#" target="_self">View
								Prescription</a>
						<li><a class="sidebarlink"
							href="OrderGenerationToSupplier.serv" target="_self">Order
								Status</a><br>
						<li><a class="sidebarlink" href="Quotation.jsp"
							target="_self">View Quotation</a><br>
						<li><a class="sidebarlink" href="ViewStockDetails.jsp"
							target="_self">Check Stock</a>
					</ul>
				</div>
			</div>

			<!-- 				Body Content Goes Here -->
			<div id="content">
				<!-- Order content goes here -->
				<%
					HttpSession sessions = request.getSession();
					int j = 0, totlalRow, totlalCol;
					String[][] prescriptionDetails = null;
					prescriptionDetails = new PrescriptionDAO()
							.getPrescriptionDetails();
					totlalRow = prescriptionDetails.length;
					
					if (!prescriptionDetails[0][0].equals("0")) {
						int availQuantity[] = new int[prescriptionDetails.length];
				%>
				<%
					for (int i = 0; i < totlalRow; i++) {
							availQuantity[i] = new DrugDAO()
									.getDrugQuantity(prescriptionDetails[i][4]);
							totlalCol = prescriptionDetails[i].length;
				%>
				<div class="tableheader">

					<table id="mytable">
						<tr>
							<td><input type="radio" name="selectPrescription"
								onchange="isEnabled()"
								onclick="checkStock(<%=availQuantity[i]%>,<%=prescriptionDetails[i][5]%>,<%=i%>)" />
							</td>
							<%
									for (j = 0; j < totlalCol; j++) {
								%>

							<td>
								<%
										sessions.setAttribute("index",prescriptionDetails);
									%> <%=prescriptionDetails[i][j]%></td>
							<%
									}
								%>



						</tr>
					</table>


				</div>
				<div id="tablecontent">

					<ul>
						<li>Status : <%=prescriptionDetails[i][3]%></li>
						<li>Drug ID : <%=prescriptionDetails[i][4]%></li>
						<li>Required Quantity : <%=prescriptionDetails[i][5]%></li>
						<li>Available Quantity : <%=availQuantity[i]%></li>
					</ul>

				</div>
				<%
					}
					}
					else
					{
						%>
				<font color="red"> No Prescription Found </font>
				<%
					}
				%>
				<%
					for (int i = 0; i < prescriptionDetails.length; i++) {

					}
				%>

				<form action="PrescriptionDelivery" method="post">
					<input type="hidden" id="hiddenId" name="hiddenData" />
					<table id="mytable">
						<tr>
							<th colspan="2"><input type="button" name="refresh"
								value="Refresh" onclick="refreshPage()" />
							</th>
							<th colspan="2"><input type="submit" id="check" name="index"
								disabled="disabled" value="Deliver to Patient" /></th>
							<th colspan="2"><input type="button"
								value="Order to Supplier" onclick="navigate()" /></th>
						</tr>
					</table>
				</form>


			</div>
		</div>

		<div id="footer">
			<!-- 			footer goes here  -->
			copyright &copy; IBM India Pvt Ltd
		</div>

	</div>

</body>
</html>

