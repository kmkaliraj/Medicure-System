
<!-- 
 *      @OrderGenerationToSupplier.java
 *      COPYRIGHT IBM Corporation 2012
 *      
 * -->
<!-- Importing class for accessing DB -->
<%@page import="com.medicure.dao.DataBaseAccess"%>
<!-- Importing Tag Libraries -->
<%@ taglib uri="/WEB-INF/lowstock.tld" prefix="custom"%>

<%@ taglib uri="/WEB-INF/supplier.tld" prefix="supplier"%>
<jsp:useBean id="lowstock"
	class="com.medicure.ordermanagement.bean.DataBaseAccessBean"
	scope="request" />

<html>
<head>

<!-- Enabling and disabling Selected Suppliers and Validating Quantity and Supplier List -->
<script type="text/javascript">   
		var number_regexp=/^[1-9][0-9]{0,3}$/;
		
     	function enable(id)
       	{
       		if(document.getElementById(id).getAttribute("disabled") == true)
       			document.getElementById(id).setAttribute("disabled",false);
 			else
       			document.getElementById(id).setAttribute("disabled",true);
		}
     	/* Validating The Quantity for Numbers */
     	function validate()
     	{
     		var nooflowstock=document.getElementById("nooflowstock").getAttribute("value")-1;
     		var noofsuppliers=document.getElementById("noofsuppliers").getAttribute("value")-1;
     		
     		if(nooflowstock == 0 )
     		{
     			alert("There are no items to be ordered...");
     			return false;
     		}
     		
     		/* Looping through all the Quantity Text Boxes */
     		for(var index=0;index<nooflowstock;index++)
     		{	
				if(number_regexp.test(document.getElementById(index).value) == false)
     			{
     				alert("Please enter only numbers in AMOUNT TO ORDER field...!!!");
     				return false;
     			}
     			else
     			{
     				if(parseInt(document.getElementById(index).value) == 0 )
     				{
     					alert("Please enter values above zero...!!!");
     					return false;
     				}
     			}
			}
     		
     		/* Looping through all the Supplier Check Boxes */
			for(var index=0;index<noofsuppliers;index++)
     		{
     			if(document.getElementById("supplier"+(index+100)).checked == true )
     			{
     				alert("Your Order has Been successfully placed...!!!");
     				return true;
     			}
			}
     		alert("Please select ATLEAST ONE SUPPLIER from the list...!!!");
     		
     		return false;
     	}
</script>

<meta http-equiv="Content-Type"
	content="text/html; charset = ISO-8859-1">
<title>Order Generation To Supplier</title>
<link href="css/order.css" rel="Stylesheet" type="text/css" />
<!-- css importing lines -->
<link href="css/ordergeneration.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8"> 
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
			<a href="#" class="menubar" target="_self"> Home </a>&nbsp;&nbsp;&nbsp;
			<a href="physicians.jsp" class="menubar" target="_self">
				Physicians </a>&nbsp;&nbsp;&nbsp; <a href="medicines.jsp"
				class="menubar" target="_self"> Medicines </a>
			<!-- 			<div style="float: right;"> -->
			<!-- 				<input type="text" /> <input type="button" value="Search" /> -->
			<!-- 			</div> -->
		</div>
		<div id="body">
			<!-- 	SidebarContainer goes here -->
			<div id="sidebarcontainer">
				<div class="sidebardrop">
					<!-- 				sidebar goes here -->
					<ul>
						<li><a class="sidebarlink" href="#" target="_self"> Mail
						</a>
						</li>
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
						<li><a class="sidebarlink" href="order.jsp" target="_self">View
								Prescription</a>
						<li><a class="sidebarlink" href="#" target="_self">Order
								Status</a><br>
						<li><a class="sidebarlink" href="Quotation.jsp"
							target="_self">View Quotation</a><br>
						<li><a class="sidebarlink" href="ViewStockDetails.jsp"
							target="_self">Check Stock</a>
					</ul>
				</div>
			</div>

			<!-- 				Body Content Goes Here -->
			<form action="ProcessOrder.serv" method="post" name="order"
				onsubmit="return validate();">
				<div id="content">
					<table id="mytable">
						<!-- Table for displaying the Low Stock Items -->
						<caption>ORDER PREPARED</caption>
						<tr>
							<th>DrugID</th>
							<th>DrugName</th>
							<th>QuantityRequired</th>
							<th>QuantityInStock</th>
							<th>Amount To Order</th>
						</tr>
						<!-- Iterator to iterate Low Stock Items -->
						<custom:iterateLowStockItems counter="0">
						</custom:iterateLowStockItems>
					</table>
					<!-- Table for displaying the suppliers -->
					<table id="sidetable">
						<caption>Suppliers</caption>
						<tr>
							<th>Select The Suppliers</th>
						</tr>
						<!-- Iterating the Supplier Names -->
						<supplier:iterateSupplier counter="0">
						</supplier:iterateSupplier>
					</table>
					<table id="mytable">
						<tr>
							<th><input type="submit" name="placeOrder"
								value="Place Order" />
							</th>
						</tr>
					</table>
				</div>
			</form>
		</div>

		<div id="footer">
			<!-- 			footer goes here  -->
			Copyright &copy; IBM India Pvt. Ltd.
		</div>
	</div>
</body>
</html>