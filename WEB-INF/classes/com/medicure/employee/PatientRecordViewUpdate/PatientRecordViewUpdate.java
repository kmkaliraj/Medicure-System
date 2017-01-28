package com.medicure.employee.PatientRecordViewUpdate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientValidate
 */
public class PatientRecordViewUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRecordViewUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String Patient_ID=request.getParameter("Pat_Id");
				String Spouse_Name=request.getParameter("Spouse_Name");
				String Contact=request.getParameter("Contact");
				String Password=request.getParameter("Pwd");
				String Password_Hint=request.getParameter("Pwd_hint");
				String Marital_Status=request.getParameter("Marital_status");
				String Address=request.getParameter("Address");
				String Occupation=request.getParameter("Occupation");
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://192.168.8.238/clinic","root","ibm123");
					Statement st=con.createStatement();
					String query="update patient set Spouse_Name='"+Spouse_Name+"',Pwd='"+Password+"',Marital_Status='"+Marital_Status+"',Address='"+Address+"',Occupation='"+Occupation+"',Password_Hint='"+Password_Hint+"',Contact="+Contact+" where Patient_ID='"+Patient_ID+"'";
					st.executeUpdate(query);
					System.out.println("success");
					String query1="select * from patient where Patient_ID='"+Patient_ID+"'";
					st.executeQuery(query1);
					ResultSet rs=st.getResultSet();
					while(rs.next()){
						String occupation=rs.getString("Occupation");
						System.out.println(occupation); 
					}
				}
				catch(Exception e){
					System.out.println(e);
				}
					
				}

}
