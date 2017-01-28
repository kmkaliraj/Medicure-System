package com.medicure.employee.update;

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


public class DoctorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DoctorUpdate() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String Name=request.getParameter("name");
		String Doctor_ID=request.getParameter("doc_Id");
		//String Specialization=request.getParameter("Specialization");
		//String Gender=request.getParameter("radio1");
		//String Email=request.getParameter("email");
		//String Contact=request.getParameter("contact");
		String Password=request.getParameter("pwd");
		String Password_Hint=request.getParameter("pwd_hint");
		//String DateOfBirth=request.getParameter("dob");
		String Qualification=request.getParameter("qualification");
		//String Affiliation=request.getParameter("Affliation");
		String Experience=request.getParameter("Experience");
		//String Address=request.getParameter("address");
		//String DateOfJoining=request.getParameter("doj");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
			Statement st=con.createStatement();
			String query="update doctor set Experience='"+Experience+"',Pwd='"+Password+"',Qualification='"+Qualification+"',Password_Hint='"+Password_Hint+"' where Doctor_ID='"+Doctor_ID+"'";
			st.executeUpdate(query);
			String query1="select Experience from doctor where Doctor_ID='"+Doctor_ID+"'";
			st.executeQuery(query1);
			ResultSet rs=st.getResultSet();
			while(rs.next()){
				PrintWriter out=response.getWriter();
				out.println("Value updated");
				String Exp=rs.getString("Experience");
				out.println(Exp); 
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
			
	}

}
