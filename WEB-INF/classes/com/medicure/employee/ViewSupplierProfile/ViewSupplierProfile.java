/***
 * 
 * @ViewPatientProfile.java
 * ©Copyright IBM Corp. 2010
 * All Rights Reserved
 * 
 */


package com.medicure.employee.ViewSupplierProfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Patient;


public class ViewSupplierProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewSupplierProfile() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
        {
			HttpSession session=request.getSession();
			String ID=(String) session.getAttribute("id");
			String userid = request.getParameter("userid");
			String patientDOB = "",patientId = "",patientName = "",PassWord = "",
			PassHint = "",marital = "",spouse_name = "",father_name = "",
			occupation = "",address = "";
			long contact = 0;
			String EmployeeId,EmployeeName,EmployeeDOB,Gender,Address,Join_Date = "";
				
			double ShiftTime = 0.0;
		
    		Patient patient = new Patient();	
        	
       
        	ResultSet setresult = patient.selectRow(ID);
        	while(setresult.next())
        	{
        		
        		patientId = setresult.getString("Patient_ID");
        	 	patientName = setresult.getString("Patient_Name");
        	 	PassWord = setresult.getString("Pwd");
        	 	PassHint = setresult.getString("Password_Hint");
        	 	marital = setresult.getString("Marital_Status");
        	 	spouse_name = setresult.getString("Spouse_Name");
        	 	father_name = setresult.getString("Father_Name");
        	 	occupation = setresult.getString("Occupation");
        	 	contact = Long.parseLong(setresult.getString("Contact"));
        	 	address = setresult.getString("Address");
        	 	
        	 	
        	 	
      
        	 	patientDOB = setresult.getString("Emp_DOB");
        	 	Gender = setresult.getString("Gender");
        	 	Address = setresult.getString("Contact_no");
        	 	Join_Date = setresult.getString("Join_Date");
        	
        	 	
            	PrintWriter outt = response.getWriter();
            	
            	outt.println("<br><br>"+"THE EMPLOYEE IS A RECEPTIONIST"+"<br><br>");
            	
            	outt.println("PATIENT ID       : "+patientId+"<br><br>");
              	outt.println("PATIENT NAME     : "+patientName+"<br><br>"); 
            	outt.println("PATIENT DOB      : "+patientDOB+"<br><br>");
            	outt.println("PATIENT GENDER   : "+Gender+"<br><br>");
            	outt.println("PATIENT ADDRESS  : "+Address+"<br><br>");
            	outt.println("MARITAL STATUS   : "+marital+"<br><br>");
            	outt.println("SPOUSE NAME      : "+spouse_name+"<br><br>");
            	outt.println("FATHER NAME      : "+father_name+"<br><br>");
            	outt.println("OCCUPATION       : "+occupation+"<br><br>");
            	outt.println("CONTACT          : "+contact+"<br><br>");      	
            	           	
          
            	outt.println("PATIENT PASSWORD : "+PassWord+"<br><br>"); 
            	outt.println("PASSWORD HINT    : "+PassHint+"<br><br>"); 
          
            	
            	
            	outt.println("<html>");
            	outt.println("	<body>");
            	outt.println("		<form action=\"home.jsp\">");
            	outt.println("			<input type=\"submit\" value=\"HOME\">");
            	outt.println("		</form>");
            	outt.println("	</body>");
            	outt.println("</html>");
        	 		
         	}
        	

        	
        }
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
