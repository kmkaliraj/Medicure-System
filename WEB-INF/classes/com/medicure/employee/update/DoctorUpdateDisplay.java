package com.medicure.employee.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.digester.SetRootRule;

import com.medicure.employee.DAO.Doctor;

/**
 * Servlet implementation class docupdation
 */
public class DoctorUpdateDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DoctorUpdateDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String Doctor_ID=(String) session.getAttribute("id");
		System.out.println(Doctor_ID);
		System.out.println("hiua");
		//Double visiting_time=0.0d;
		try{
			String doc_ID,name,password,password_hint,qualification,Specialization,Experience,Affliation;
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
			Statement st=con.createStatement();
			String query="select * from doctor where ID='"+Doctor_ID+"'";
			st.executeQuery(query);*/
			String ID=session.getAttribute("Uid").toString(); 
			Doctor doctor = new Doctor();
			ResultSet rs = doctor.selectRow(ID);
        	while(rs.next())
			{
			doc_ID=rs.getString("Doctor_ID");
			name=rs.getString("Doctor_Name");
			password=rs.getString("pwd");
			password_hint=rs.getString("Password_Hint");
			qualification=rs.getString("Qualification");
			Specialization=rs.getString("Specialization");
			Experience=rs.getString("Experience");
			Affliation=rs.getString("Affiliation");
			PrintWriter out=response.getWriter();
			out.println(
			"<html>" +
			"<head>"+
			"<title>Doctor Profile Update</title>"+
			"</head>"+
			"<body>"+
				"<form action=\"../../DoctorUpdate\" method=\"post\">"+
					"<table border=0 cellpadding=3 cellspacing=3>"+
						"<tr>"+
							"<th><label>Name<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"name\" value=\""+name+"\") disabled=\"disabled\">"+
							"</th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Doctor_ID<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"doc_Id\" value=\""+doc_ID+"\")></th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Password<label>"+
							"</th>"+
							"<th><input type=\"password\" name=\"pwd\" value=\""+password+"\">"+
							"</th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Password_hint<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"pwd_hint\" value=\""+password_hint+"\">"+
							"</th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Qualification<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"qualification\" value=\""+qualification+"\"></th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Specialization<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"Specialization\" value=\""+Specialization+"\" disabled=\"disabled\"></th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Experience<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"Experience\" value=\""+Experience+"\">"+
							"</th>"+
						"</tr>"+
						"<tr>"+
							"<th><label>Affliation<label>"+
							"</th>"+
							"<th><input type=\"text\" name=\"Affliation\" value=\""+Affliation+"\" disabled=\"disabled\"></th>"+
						"</tr>"+
						"<tr>"+
							"<th><input type=\"submit\" name=\"submit\" value=\"Update\">"+
							"</th>"+
						"</tr>"+
					"</table>"+
				"</form>"+
			"</body>"+
		"</html>");
			}		
		}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
	}
}
