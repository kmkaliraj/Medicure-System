/***
 * 
 * @ValidateReceptionist.java
 * ©Copyright IBM Corp. 2010
 * All Rights Reserved
 * 
 */


package com.medicure.employee.ReceptionistUpdateRecord;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Receptionists;

public class ReceptionistUpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReceptionistUpdateRecord() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("pwd");
		String password_hint=request.getParameter("pwd_hint");
		long contact=Long.parseLong(request.getParameter("contact"));
		String address=request.getParameter("address");
		String time=request.getParameter("shift_time");
		String dob=request.getParameter("dob");
		String joinDate=request.getParameter("join_date");
		
		
		HttpSession session=request.getSession();
		String Recept_ID=(String) session.getAttribute("Recept_ID");
		System.out.println(Recept_ID);


		try{
			Receptionists receptionists = new Receptionists();
			receptionists.updateRow(Recept_ID, password, password_hint, time, dob, contact, address, joinDate);
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
