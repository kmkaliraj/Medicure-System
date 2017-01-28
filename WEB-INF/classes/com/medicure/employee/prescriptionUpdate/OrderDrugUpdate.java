package com.medicure.employee.prescriptionUpdate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderDrugUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderDrugUpdate() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String Doctor_ID=(String) session.getAttribute("id");
		String Prescription_ID=request.getParameter("Prescription_ID");
		String Drug_ID=request.getParameter("DrugID");
		int Quantity=Integer.parseInt(request.getParameter("Quantity"));
		int Dosage=Integer.parseInt(request.getParameter("Dosage"));
		double Price=0.0d;
		String Patient_ID=request.getParameter("Patient_ID");
		String Status=request.getParameter("status");
		Date Pres_date=Date.valueOf(request.getParameter("Pres_date"));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
			Statement st=con.createStatement();
			String query="insert into prescription values('"+Prescription_ID+"','"+Drug_ID+"',"+Quantity+","+Dosage+","+Price+",'"+Patient_ID+"','"+Status+"')"; 
			st.executeUpdate(query);
			String query1="insert into prescriptionsend values('"+Doctor_ID+"','"+Prescription_ID+"','"+Pres_date+"')";
			String query2="select * from prescriptionsend where Doctor_ID='"+Doctor_ID+"'";
			
			st.executeUpdate(query1);
			st.executeQuery(query2);
			st.executeQuery("commit");
			PrintWriter out=response.getWriter();	
			out.println("VALUE UPDATED SUCCESSFULLY");
		
		
	}
		catch(Exception e)
		{
			System.out.println("Exception"+e.getMessage());
		}

}
}
