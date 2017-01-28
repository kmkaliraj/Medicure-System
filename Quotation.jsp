<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>

<jsp:useBean id="getBean" class="com.medicure.ordermanagement.bean.Bean"
	scope="session"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salesman-Order</title>
<link href="css/order.css" rel="Stylesheet" type="text/css" />
<link href="css/ordergeneration.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/contentdrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8">
	
</script>
</head>
<body>

	<!-- 		start of container -->
	<div id="container">

		<!-- 			start of header -->
		<div id="header">Medicure Quotation Page</div>
		<!-- 			end of header  -->

		<!-- 			start of menu bar -->
		<div id="menubar">
			<div id="menubartext">Hello Salesman</div>
			<!-- 			menu bar links goes here -->
			<a href="#" class="menubar" target="_self"> Home</a>&nbsp;&nbsp;&nbsp;
			<a href="physicians.jsp" class="menubar" target="_self">
				Physicians</a>&nbsp;&nbsp;&nbsp; <a href="medicines.jsp" class="menubar"
				target="_self"> Medicines</a>

		</div>
		<!-- 			end of menu bar -->


		<!-- 			start of body -->
		<div id="body">

			<!-- 				start of side bar -->
			<div id="sidebarcontainer">
				<div class="sidebardrop">
					<!-- 				side bar goes here -->
					<ul>
						<li><a class="sidebarlink" href="#" target="_self">Mail</a></li>
					</ul>
				</div>
				<div id="dropmenu">
					<!-- 				drop menu from the side bar -->
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
					<!-- 				side bar goes here -->
					<ul>
						<li><a class="sidebarlink" href="#" target="_self">My
								Profile</a>
						</li>
					</ul>
				</div>
				<div id="dropmenu">
					<!-- 				drop menu from the side bar -->
					<ul>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">View</a>
						</li>
						<li><a class="dropmenubar" href="salesman.jsp" target="_self">Edit</a>
						</li>
					</ul>
				</div>
				<div id="sidebar">
					<ul>
						<li><a class="sidebarlink" href="order.jsp" target="_self">View
								Prescription</a>
						<li><a class="sidebarlink"
							href="OrderGenerationToSupplier.serv" target="_self">Order
								Status</a><br>
						<li><a class="sidebarlink" href="#" target="_self">View
								Quotation</a><br>
						<li><a class="sidebarlink" href="ViewStockDetails.jsp"
							target="_self">Check Stock</a>
					</ul>
				</div>

			</div>
			<!-- 				end of side bar -->

			<!-- 				start of content -->
			<div id="content">

				<form action="UpdateQuotation" method="get">
					<%
								// Creating objects for Database connection 
								Connection connection;
								Statement statement;
					
								String sql = "";
								String sql1 = "";
					
								//Declaring Arraylist
								ArrayList<String> qId = new ArrayList<String>();
								ArrayList<Integer> count = new ArrayList<Integer>();
								ArrayList<Integer> quantity = new ArrayList<Integer>();
								ArrayList<String> drugId = new ArrayList<String>();
								ArrayList<String> drugName = new ArrayList<String>();
								ArrayList<String> supID = new ArrayList<String>();
								ArrayList<String> supStatus = new ArrayList<String>();
								ArrayList<String> sman_stat = new ArrayList<String>();
								ArrayList<String> desc = new ArrayList<String>();
								ArrayList<Float> price = new ArrayList<Float>();
								ArrayList<String> quotList = new ArrayList<String>();
								
								//Database Connection
								try {
									Class.forName("com.mysql.jdbc.Driver");
									connection = DriverManager.getConnection(
											"jdbc:mysql://192.168.8.238:3306/clinic", "root", "ibm123");
									sql = "select * from quotation";
									PreparedStatement alldata = connection.prepareStatement(sql);
									alldata.executeQuery();
									ResultSet setResult = alldata.getResultSet();
											
									// Dynamically adding values to ArrayList from Quotation Table 
									while (setResult.next()) {
					
										qId.add(setResult.getString("Q_ID"));
										drugId.add(setResult.getString("Drug_Id"));
										drugName.add(setResult.getString("Drug_Name"));
										quantity.add(setResult.getInt("Quantity"));
										price.add(setResult.getFloat("Price"));
										desc.add(setResult.getString("Description"));
										sman_stat.add(setResult.getString("Sman_Status"));
										supID.add(setResult.getString("Sup_ID"));
									
					
									}
							
					
								}
								
					
								catch (Exception e) {
									e.printStackTrace();
								}
					
								//Finding the occurance of Supid and how much it got repeated
								String initial = "";
								
								initial = qId.get(0);
								int k = 0;
								int value = 0;
								for (k = 0; k < qId.size(); k++) {
									if (initial.equalsIgnoreCase(qId.get(k))) {
										value++;
									} else {
										count.add(value);
										int temp = 0;
										for (int z = 0; z < count.size(); z++) {
											temp = temp + count.get(z);
										}
										initial = qId.get(temp);
										value = 1;
					
									}
					
								}
								count.add(value);
					
								//Setting the value for Bean
								getBean.setQId(qId);
								getBean.setDrugId(drugId);
								getBean.setDrugName(drugName);
								getBean.setQuantity(quantity);
								getBean.setPrice(price);
								getBean.setDesc(desc);
								getBean.setSman_stat(sman_stat);
								getBean.setSupID(supID);
								getBean.setCount(count);
								int a = getBean.getQuantity().size();
					
								session.setAttribute("getBean", getBean);
							%>




					<%
								int track = 0;
							%>

					<%
								for (int j = 0; j < count.size(); j++) 
								{
								
									
							%>
					<!-- 					start of table header	 -->
					<div class="tableheader">
						<table id="mytable">


							<tr>
								<td rowspan=<%count.get(j);%>><input type="radio"
									name="selection" value="<%=j%>">
								<td><%=qId.get(track)%></td>
							</tr>
						</table>
					</div>
					<!-- 					end of table header -->

					<!-- 					start of table content -->
					<div id="tablecontent">
						<table id="mytable">
							<tr>
								<!-- <td>
								<input type="radio" name="select" value="">
							</td> -->

								<th>Drug ID</th>
								<th>Drug Name</th>
								<th>Supplier ID</th>
								<th>Quantity</th>
								<th>Order Status</th>
								<th>Price</th>
								<th>Description</th>

							</tr>
							<%
							for (int l = 0; l < count.get(j); l++) {
						%>
							<tr>
								<td><%=drugId.get(track)%></td>
								<td><%=drugName.get(track)%></td>
								<td><%=supID.get(track)%></td>
								<td><%=quantity.get(track).intValue()%></td>
								<td><%=sman_stat.get(track)%></td>
								<td><%=price.get(track)%></td>
								<td><%=desc.get(track)%></td>
							</tr>
							<%	
						track++;
								}
						%>
						</table>
					</div>
					<!-- 					end of tablecontent		 -->
					<%
								}
						%>


					<table id="mytable">
						<tr>
							<th>
								<!-- On Pressing this Button it will Update the selected
					 		Quotation to Quotation Send and main Stock will be Updated --> <input
								type="submit" value="place order" /></th>
						</tr>
					</table>
				</form>
			</div>
			<!-- 				end of content -->

		</div>
		<!-- 			end of body -->

		<!-- 			start of footer -->
		<div id="footer">Copyright &copy; IBM India Pvt. Ltd.</div>
		<!-- 			end of footer -->

	</div>
	<!-- 		end of container	 -->

</body>
</html>