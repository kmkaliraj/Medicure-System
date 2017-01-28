<%@ page language="java" import="com.medicure.visitor.DataAccessObject"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%=  new DataAccessObject().Composer(request.getParameter("from"), request.getParameter("to"), request.getParameter("cc"), request.getParameter("subject"), request.getParameter("body"))%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drafts</title>
</head>
<body>EMAIL SAVED SUCCESSFULLY....
</body>
</html>