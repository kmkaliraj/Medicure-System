<%@ page language="java" contentType="text/html; charset  =  ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="Iterator" uri="WEB-INF/Quotationtaglib.tld"%>
<jsp:useBean id="qBean"
	class="com.medicure.ordermanagement.bean.QuoteBean" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset  =  ISO-8859-1">
<title>Salesman-QuotationForm</title>
<link href="css/order.css" rel="Stylesheet" type="text/css" />
<link href="css/ordergeneration.css" rel="Stylesheet" type="text/css" />
<!-- <script type = "text/javascript" src = "script/jquery.js"></script> -->
<script type="text/javascript" src="script/contentdrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8">	
</script>
<script type="text/javascript">
	function validate() {
		var flag=false;
		var number_pattern=/^\d+(?:\.\d{0,2})?$/;
		
		var quoForm = document.getElementById("frm1");
		
		for ( var i = 2; i < quoForm.length-1; i++) {
			if (quoForm.elements[i].value==null || quoForm.elements[i].value==""){
				alert("Please enter the price!!!!");
				flag=false;
			}
			else{
				if(number_pattern.test(quoForm.elements[i].value) == false){
					alert("Invalid entry!!!\nOnly numbers are allowed!!!");
					flag = false;
				}
				else{
					
					if(parseFloat(quoForm.elements[i].value) == 0){
						alert("Enter a valid price!!!");
						flag = false;
					}
					else{
						flag=true;
					}					
				}
			}
		}		
		return flag;
	}
</script>
</head>
</head>
<body>
	<div id="container">
		<div id="header">
			<!-- Header goes here -->
			MediCure
		</div>
		<div id="menubar">
			<!-- visitor name goes here -->
			<div id="menubartext">Hello Supplier</div>
			<!-- menubar links goes here -->
		</div>
		<div id="body">
			<!-- SidebarContainer goes here -->
			<!-- Body Content Goes Here -->
			<div id="center">
				<form action="quote.send.serv" method="post" id="frm1"
					onsubmit="return validate()">
					<input type="hidden" name="orderId"
						value="<%= qBean.getOrderId()%>"> <input type="hidden"
						name="supplierId" value="<%= qBean.getSupplierId()%>">
					<table id="mytable">
						<tr>
							<th><label>ORDER ID</label></th>
							<td><label><%= qBean.getOrderId()%></label></td>
						</tr>
						<tr>
							<th><label>SUPPLIER ID</label></th>
							<td><label><%= qBean.getSupplierId()%></label></td>
						</tr>
					</table>
					<table id="sidetable">
						<tr>
							<th><label>DRUG ID</label></th>
							<th><label>DRUGS</label></th>
							<th><label>QUANTITY</label></th>
							<th><label>PRICE</label></th>
						</tr>
						<Iterator:iterator counter="0"></Iterator:iterator>
						<tr>
							<td colspan="4" align="right"><input type="submit"
								value="Update" name="submit" onclick="checkText()">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<!-- footer goes here  -->
			copyright &copy; IBM India Pvt Ltd.
		</div>
	</div>
</body>
</html>