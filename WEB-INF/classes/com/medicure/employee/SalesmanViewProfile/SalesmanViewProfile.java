/***
 * 
 * @ViewSalesmanProfile.java
 * ęCopyright IBM Corp. 2010
 * All Rights Reserved
 * 
 */


package com.medicure.employee.SalesmanViewProfile;

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

import com.medicure.employee.DAO.Salesman;


public class SalesmanViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SalesmanViewProfile() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
        {
		
			HttpSession session=request.getSession();
			String ID=(String) session.getAttribute("id");		
			String SalesId = "",SalesName = "",PassWord = "",PassHint = "";
			String EmployeeId,EmployeeName,EmployeeDOB,Gender,Address,Join_Date = "";
			Salesman salesman = new Salesman();	
			double ShiftTime = 0.0;
		
    		 	
        	
       
        	ResultSet setresult = salesman.selectRow(ID);
        	while(setresult.next())
        	{
        		
        		SalesId = setresult.getString("Sman_ID");
        	 	SalesName = setresult.getString("Sman_Name");
        	 	PassWord = setresult.getString("Pwd");
        	 	PassHint = setresult.getString("Password_Hint");
        	 	
        	 	
        	 	
        	 	EmployeeId = setresult.getString("Emp_ID");
        	 	EmployeeName = setresult.getString("Emp_Name");
        	 	EmployeeDOB = setresult.getString("Emp_DOB");
        	 	Gender = setresult.getString("Gender");
        	 	Address = setresult.getString("Contact_no");
        	 	Join_Date = setresult.getString("Join_Date");
        	
        	 	
            	PrintWriter outt = response.getWriter();
            	
            	outt.println("<br><br>"+"THE EMPLOYEE IS A SALESMAN"+"<br><br>");
            	
            	outt.println("EMPLOYEE ID        : "+EmployeeId+"<br><br>");
            	outt.println("EMPLOYEE NAME      : "+EmployeeName+"<br><br>");
            	outt.println("EMPLOYEE DOB       : "+EmployeeDOB+"<br><br>");
            	outt.println("EMPLOYEE GENDER    : "+Gender+"<br><br>");
            	outt.println("EMPLOYEE ADDRESS   : "+Address+"<br><br>");
            	outt.println("EMPLOYEE JOINDATE  : "+Join_Date+"<br><br>");
            
            	
            	
            	outt.println("SALESMAN NAME      : "+SalesName+"<br><br>"); 
            	outt.println("SALESMAN PASSWORD  : "+PassWord+"<br><br>"); 
            	outt.println("PASSWORD HINT      : "+PassHint+"<br><br>"); 
            	
            	
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
