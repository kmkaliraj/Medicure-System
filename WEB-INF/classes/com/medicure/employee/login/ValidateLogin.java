package com.medicure.employee.login;

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

public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = "", passWord = "";
		String username = request.getParameter("username");
		String category = request.getParameter("employee");
		String password = request.getParameter("pwd");
		session.setAttribute("Uid",username );
		

		System.out.println(category);
		try {
			System.out.println("inside try");
			Class.forName("com.mysql.jdbc.Driver");
			Connection login = DriverManager.getConnection(
					"jdbc:mysql://192.168.8.238/clinic", "root", "ibm123");
			Statement login_st = login.createStatement();
			String query = "";
			System.out.println("before query");
		
				if (category.equalsIgnoreCase("patient")) {

					query = "select * from " + category + " where Patient_ID='"
							+ username + "' and Pwd='" + password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("Patient_ID");
						passWord = setone.getString("Pwd");
					}
				} else if (category.equalsIgnoreCase("doctor")) {
					query = "select * from " + category + " where Doctor_ID='"
							+ username + "' and Pwd='" + password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("Doctor_ID");
						passWord = setone.getString("Pwd");
					}
					System.out.println("vxv");
				} else if (category.equalsIgnoreCase("salesman")) {
					query = "select * from " + category + " where Sman_ID='"
							+ username + "' and Pwd='" + password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("Sman_ID");
						passWord = setone.getString("Pwd");
					}
				} else if (category.equalsIgnoreCase("supplier")) {
					query = "select * from " + category
							+ " where Sup_ID='" + username + "' and Pwd='"
							+ password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("Sup_ID");
						passWord = setone.getString("Pwd");
					}
				} else if (category.equalsIgnoreCase("receptionists")) {
					query = "select * from " + category + " where Resp_ID='"
							+ username + "' and Pwd='" + password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("Resp_ID");
						passWord = setone.getString("Pwd");
					}
				} else if (category.equalsIgnoreCase("db_admin")) {
					query = "select * from " + category + " where ID='"
							+ username + "' and Pwd='" + password + "'";
					System.out.println(query);
					login_st.executeQuery(query);
					ResultSet setone = login_st.getResultSet();
					while (setone.next()) {
						userName = setone.getString("ID");
						passWord = setone.getString("Pwd");
					}
				}
			

			if (username.equalsIgnoreCase(userName)
					&& password.equalsIgnoreCase(passWord)) {

				session.setAttribute("id", userName);
				System.out.println(userName);
				if (category.equals("doctor")) {
					response.sendRedirect("employee/doctor/doctorPage.jsp");
					
				} else if (category.equals("receptionists")) {
					response.sendRedirect("employee/receptionist/receptionistPage.jsp");
				} else if (category.equals("patient")) {
					response.sendRedirect("employee/patient/patientPage.jsp");
				} else if (category.equals("supplier")) {
					response.sendRedirect("employee/supplier/supplierPage.jsp");
				} else if (category.equals("salesman")) {
					response.sendRedirect("ViewStockDetails.jsp");
				} else if (category.equals("db_admin")) {
					response.sendRedirect("employee/admin/adminPage.jsp");
				}
			} else {
				PrintWriter out = response.getWriter();
				out.println("check pwd and username");
				
				 response.sendRedirect("index.jsp");
				 
			}
		} catch (Exception e) {
			System.out.println("Exception from type 1" + e.getMessage());
			// response.sendRedirect("login.jsp");
		}
	}

}
