package com.medicure.employee.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Doctor;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public View() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	try
        {
		    HttpSession session=request.getSession();
		    //String ID=(String) session.getAttribute("id");
		    String ID=session.getAttribute("Uid").toString(); 
		    
		    
		    
		    System.out.println("inside view: ");
		    System.out.println(ID);
		   
			String DoctorId = "",DocName = "",PassWord = "",PassHint = "",Quali = "",
			Speci = "",Affil = "",VisitTime = "";
			String EmployeeId,EmployeeName,EmployeeDOB,Gender,Address,Join_Date = "";
			int Experience = 0;
			long Contact = 0;
		    Doctor doctor = new Doctor();
    		      	
        	ResultSet setresult = doctor.selectRow(ID);
        	while(setresult.next())
        	{
        		
        		request.setAttribute("DoctorId" , setresult.getString("Doctor_ID"));
        		request.setAttribute("DocName" , setresult.getString("Doctor_Name"));
        	 	request.setAttribute("PassWord" , setresult.getString("Pwd"));
        	 	request.setAttribute("PassHint" , setresult.getString("Password_Hint"));
        	 	request.setAttribute("Quali" , setresult.getString("Qualification"));
        	 	request.setAttribute("Speci" , setresult.getString("Specialization"));
        	 	request.setAttribute("Experience" , setresult.getString("Experience"));
        	 	request.setAttribute("Affil" , setresult.getString("Affiliation"));
        	 	request.setAttribute("VisitTime" , setresult.getString("Visiting_Time"));
        	 	
        	 	
        	 	request.setAttribute("EmployeeId",setresult.getString("Emp_ID"));
        	 	request.setAttribute("EmployeeName" , setresult.getString("Emp_Name"));
        	 	request.setAttribute("EmployeeDOB" , setresult.getString("Emp_DOB"));
        	 	request.setAttribute("Gender" , setresult.getString("Gender"));
        	 	request.setAttribute("Address" , setresult.getString("Contact_no"));
        	 	request.setAttribute("Join_Date" , setresult.getString("Join_Date"));
        		System.out.println(setresult.getString("Doctor_ID"));
            
         	}
        	RequestDispatcher rd=request.getRequestDispatcher("employee/doctor/docview1.jsp");
			rd.include(request, response);
        	PrintWriter out=response.getWriter();
        	out.println("redirected");
        }
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
		
	
        		
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
      }
        	

}
