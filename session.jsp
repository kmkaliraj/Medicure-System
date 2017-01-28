<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
    String userName=request.getParameter("username");
    String password=request.getParameter("pwd");
    if(userName==null)
    	userName="";
    if(password==null)
    	password="";
    if(!userName.equals(" ")&& !password.equals("")){
    	session.setAttribute("SessionUser", userName);
    	session.setAttribute("SessionPassword", password);
    	out.println("Welcome"+ userName+ "!");
    	out.println("<br/><a href=sessionresult.jsp> Next page with session true</a>");
    	out.println("<br/><a href=ShowFalseSession.jsp> Next page with session false.</a>");
    	
    }
    else if(userName.equals(" ")){
    	out.println("<font color=red> <b> userName required.</b></font>");
    	out.println("<br/><a href=index.jsp> Go back!</a>");
    	
    	
    }
    else if(password.equals(" ")){
    	out.println("<font color=red> <b> Password required.</b></font>");
    	out.println("<br/><a href=index.jsp> Go back!</a>");
    	
    	
    }
    
    %>
