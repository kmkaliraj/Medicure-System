package com.medicure.employee.UpdatePatient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.jdbc.Connection;


public class PatientRecordView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PatientRecordView() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session=request.getSession();
	    //String ID=(String) session.getAttribute("id");
	    //String ID=session.getAttribute("Uid").toString();
		String ID="D107";
	    try{
			//String doc_ID,name,password,password_hint,qualification,Specialization,Experience,Affliation;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
			Statement st=con.createStatement();
			String query="select Patient_ID from patientrecord where Doctor_ID='"+ID+"'";
			st.executeQuery(query);
			ResultSet rs=st.getResultSet();
			PrintWriter out=response.getWriter();
		/*	out.println("<html>+" +
					"<head>" +
					"</head>"+
					"<body>" +
					"<table border=\"3\" cellpadding=\"3\" cellspacing=\"3\">"+
					"<tr>"+
						"<th>");*/
					
			while(rs.next())
			{
				System.out.println("PatientID"+rs.getString("Patient_ID"));
				/*out.println(
				"<label>Patient ID</label>"+
				"</th>"+
				"<th>"+
				"<input type=\"text\" value=\""+rs.getString("Patient_ID")+"\">" +
				"</th>"+
				"</tr>"+
				"</table>"+
				"</body>"+
				"</html>");*/
										
			}
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Exception"+e);
	    }
	}

}
