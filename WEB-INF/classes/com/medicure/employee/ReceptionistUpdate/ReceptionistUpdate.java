/***
 * 
 * @UpdateReceptionist.java

 * ©Copyright IBM Corp. 2010
 * All Rights Reserved
 * 
 */


package com.medicure.employee.ReceptionistUpdate;

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

import com.medicure.employee.DAO.Receptionists;

public class ReceptionistUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReceptionistUpdate() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String Recept_ID=request.getParameter("recept_ID");
		session.setAttribute("Recept_ID", Recept_ID);
		
		
		try{
			Receptionists receptionists = new Receptionists();
			
			ResultSet rs=receptionists.selectRow(Recept_ID);
			while(rs.next())
			{
				String Recept_Id=rs.getString("Resp_ID");
				String Recept_Name=rs.getString("Resp_Name");
				String pwd=rs.getString("Pwd");
				String password_hint=rs.getString("Password_Hint");
				String shift_time=rs.getString("Shift_Time");
				PrintWriter out=response.getWriter();
				out.println("<html>"+
						"<body>"+
						"<form action=\"../../ReceptionistUpdateRecord\" method=\"post\">"+
							"<table border=0 cellpadding=3 cellspacing=3>"+
								
								"<tr>"+
									"<th><label>Name<label>"+
									"</th>"+
									"<th><input type=\"text\" name=\"Recept_Name\" value=\""+Recept_Name+"\" disabled=\"disabled\">"+
									"</th>"+
								"</tr>"+
								"<tr>"+
									"<th><label>Receptionist_ID<label>"+
									"</th>"+
									"<th><input type=\"text\" name=\"Recept_Id\" value=\""+Recept_Id+"\" disabled=\"disabled\"></th>"+
								"</tr>"+
								"<tr>"+
									"<th><label>Password<label>"+
									"</th>"+
									"<th><input type=\"password\" name=\"pwd\" value=\""+pwd+"\" ></th>"+
								"</tr>"+
								"<tr>"+
									"<th><label>Password Hint<label>"+
									"</th>"+
									"<th><input type=\"text\" name=\"pwd_hint\" value=\""+password_hint+"\" >"+
									"</th>"+
								"</tr>"+
								"<tr>"+
									"<th><label>Shift Time<label>"+
									"</th>"+
									"<th><input type=\"text\" name=\"shift_time\" value=\""+shift_time+"\" >"+
									"</th>"+
								"</tr>"+
								"<tr>"+
									"<th><input type=\"submit\" name=\"submit\" value=\"Update\">"+
									"</th>"+
								"</tr>"+
							"</table>"+
						"</form>"+
					"</body>"+
					"</html>"
					);



			}
			
										
			
			}
		catch(Exception e)
		{
			System.out.println("exception"+e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
