package com.medicure.employee.ViewPatientRecord;

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

public class ViewPatientRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewPatientRecord() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_ID = request.getParameter("Patient_ID");
		// System.out.println(Doctor_ID);
		// Double visiting_time=0.0d;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://192.168.8.238/clinic", "root", "ibm123");
			Statement st = con.createStatement();
			String query = "select * from patient where Patient_ID='" + user_ID
					+ "'";
			st.executeQuery(query);
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				request.setAttribute("patient_ID", rs.getString("Patient_ID"));
				request.setAttribute("name", rs.getString("Patient_Name"));
				request.setAttribute("password", rs.getString("Pwd"));
				request.setAttribute("password_Hint",
						rs.getString("Password_Hint"));
				request.setAttribute("spouse_Name", rs.getString("Spouse_Name"));
				request.setAttribute("marital_Status",
						rs.getString("Marital_Status"));
				request.setAttribute("father_Name", rs.getString("Father_Name"));
				request.setAttribute("occupation", rs.getString("Occupation"));
				request.setAttribute("contact", rs.getString("Contact"));
				request.setAttribute("address", rs.getString("Address"));
				request.setAttribute("DOB", rs.getString("DOB"));
				PrintWriter out = response.getWriter();
				out.println("<html>"
						+ "<body>"
						+ "<form action=\"../../PatientRecordViewUpdate\" method=\"post\">"
						+ "<table border=\"0\" cellpadding=\"3\" cellspacing=\"3\">"
						+ "<tr>"
						+ "<th>"
						+ "<label>Name<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Name\" value=\"name\" disabled=\"disabled\">"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Patient_ID<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Pat_Id\" value=\"patient_ID\" >"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Passwordlabel>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"password\" name=\"Pwd\" value=\"password\">"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Password_Hint<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Pwd_hint\" value=\"password_Hint\")%>"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Marital_Status<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Marital_status\"  value=\"marital_Status\")>"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Spouse_Namelabel>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Spouse_Name\" value=\"spouse_Name\")%>"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Father_Name<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Father_Name\" value=\"father_Name\")disabled=\"disabled\">"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Occupation<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Occupation\" value=\"occupation\")"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Contactlabel>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Contact\" value=\"contact\")"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>Address<label>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"Address\" value=\"address\")>"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<label>DOBlabel>"
						+ "</th>"
						+ "<th>"
						+ "<input type=\"text\" name=\"DOB\" value=\"DOB\")disabled=\"disabled\">"
						+ "</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>"
						+ "<input type=\"submit\" name=\"submit\" value=\"Update\">"
						+ "</th>" + "</tr>" + "</table>" + "</form>"
						+ "</body>" + "</html>");

			}
			RequestDispatcher rd = request
					.getRequestDispatcher("PatienForm.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			System.out.println("exception" + e);
		}
	}
}
