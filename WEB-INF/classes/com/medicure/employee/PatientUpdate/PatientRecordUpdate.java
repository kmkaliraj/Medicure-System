package com.medicure.employee.PatientUpdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PatientRecordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PatientRecordUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String Doctor_ID = (String) session.getAttribute("Uid");
		String Patient_ID = request.getParameter("Patient_ID");
		String Check_date = request.getParameter("Check_date");
		String Diagnosis = request.getParameter("Diagnosis");
		String Result = request.getParameter("Result");
		String Prescription = request.getParameter("Prescription");
		
				
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
			Statement st = con.createStatement();
			String query = "insert into patientrecord values('"+Doctor_ID+"','"+Patient_ID+"','"+Check_date+"','"+Diagnosis+"','"+Result+"','"+Prescription+"')";
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
		}
		}

}
