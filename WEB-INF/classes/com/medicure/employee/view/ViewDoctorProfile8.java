package com.medicure.employee.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.medicure.employee.DAO.Doctor;


public class ViewDoctorProfile8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewDoctorProfile8() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {

	
        		
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	try
        {
   		    HttpSession session=request.getSession();
		   String ID=(String) session.getAttribute("id");
		   
		    
		   
			String DoctorId = "",DocName = "",PassWord = "",PassHint = "",Quali = "",
			Speci = "",Affil = "",VisitTime = "";
			String EmployeeId,EmployeeName,EmployeeDOB,Gender,Address,Join_Date = "";
			int Experience = 0;
			long Contact = 0;
		    Doctor doctor = new Doctor();
    		      	
        	ResultSet setresult = doctor.selectRow(ID);
        	 System.out.println("hiii ");
        	while(setresult.next())
        	{	System.out.println("Doctor Profile view");
        		DoctorId=setresult.getString("Doctor_ID");
        		//  ("DoctorId" , setresult.getString("Doctor_ID"));
        		DocName = setresult.getString("Doctor_Name");
        	 	PassWord = setresult.getString("Pwd");
        	 	PassHint = setresult.getString("Password_Hint");
        	 	Quali = setresult.getString("Qualification");
        	 	Speci = setresult.getString("Specialization");
        	 	Experience = Integer.parseInt(setresult.getString("Experience"));
        	 	Affil = setresult.getString("Affiliation");
        	 	VisitTime = setresult.getString("Visiting_Time");
        	 	EmployeeId = setresult.getString("Emp_ID");
        	 	EmployeeName = setresult.getString("Emp_Name");
        	 	EmployeeDOB = setresult.getString("Emp_DOB");
        	 	Gender = setresult.getString("Gender");
        	 	Address = setresult.getString("Contact_no");
        	 	Join_Date = setresult.getString("Join_Date");
        	 	PrintWriter out = response.getWriter();
        	 	out.println("<html>"+
        	 					"<head>"+
        	 					"</head>"+
        	 					"<body>"+
        	 						"<table boder=\"3\" cellpadding=\"3\" cellspacing=\"3\">"+
        	 							"<tr>"+
        	 								"<th>"+
        	 									"<label>Doctor ID</label>"+
        	 								"</th>"+
        	 								"<th>"+
        	 									"<input type=\"text\" value=\""+DoctorId+"\" disabled=\"disabled\" >"+
        	 								"</th>"+
        	 							"</tr>"+
        	 								"<tr>"+
        	 									"<th>"+
        	 										"<label>Name</label>"+
        	 									"</th>"+
        	 									"<th>"+
        	 										"<input type=\"text\" value=\""+DocName+"\" disabled=\"disabled\">"+
        	 									"</th>"+ 
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Specialization </label></th>"+
        	 									"<th>"+
        	 									"<input type=\"text\" value=\""+Speci+"\" disabled=\"disabled\">"+
        	 									"</th>"+
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Qualification </label></th>"+
        	 									"<th>"+
        	 										"<input type=\"text\" value=\""+Quali+"\" disabled=\"disabled\">"+
        	 									"</th>"+
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Affiliation </label></th>"+
        	 									"<th>"+
        	 									"<input type=\"text\" value=\""+Affil+"\" disabled=\"disabled\">"+
        	 									"</th>"+
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Years of Experience </label></th>"+
        	 									"<th>"+
        	 									"<input type=\"text\" value=\""+Experience+"\" disabled=\"disabled\">"+
        	 									"</th>"+
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Address </label></th>"+
        	 									"<th>"+
        	 									"<input type=\"text\" value=\""+Address+"\" disabled=\"disabled\">"+ 
        	 									"</th>"+
        	 								"</tr>"+
        	 								"<tr>"+
        	 									"<th><label> Join Date </label></th>"+
        	 									"<th>"+
        	 									"<input type=\"text\" value=\""+Join_Date+"\" disabled=\"disabled\">"+
        	 									"</th>"+
        	 								"</tr>"+
        	 							
        	 						"</table>"+
        	 					"</body>"+
        	 				"</html>");
        	 		   	 								
        	 					
         	}
        	
        }
        	catch(Exception e)
        	{
        		
        	}
		
      }
        	

}
