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
<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/contentdrop.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="script/dropview.js" charset="UTF-8">
	
</script>
<script type="text/javascript">
	function closeWindow() {
		close();
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
				<label><%=request.getAttribute("result")%></label> <input
					type="button" value="close" onclick="closeWindow()">
			</div>
		</div>
		<div id="footer">
			<!-- footer goes here  -->
			copyright &copy; IBM India Pvt Ltd.
		</div>
	</div>
</body>
</html>