package com.medicure.employee.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Patient;

public class PatAutoGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PatAutoGen() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String g=request.getParameter("patName");
		session.setAttribute("name", g);
		String patName=session.getAttribute("name").toString();
		
		String a=request.getParameter("patFather");
		session.setAttribute("name", a);
		String patFather=session.getAttribute("name").toString();
		
		String e=request.getParameter("marital");
		session.setAttribute("gen", e);
		String marital=session.getAttribute("gen").toString();
		
		String f=request.getParameter("patSpouse");
		session.setAttribute("spc", f);
		String patSpouse=session.getAttribute("spc").toString();
		
		String h=request.getParameter("patContact");
		session.setAttribute("qual", h);
		long patContact=Long.parseLong(session.getAttribute("qual").toString());
		 
		
		String j=request.getParameter("patOccupation");
		session.setAttribute("aff", j);
		String patOccupation=session.getAttribute("aff").toString();
		
		
		
		System.out.println(patName);
		System.out.println(patFather);
		System.out.println(marital);
		System.out.println(patSpouse);
		System.out.println(patContact);
		System.out.println(patOccupation);
	
		
		Patient d=new Patient();
		String password="";
		int counter=0,constant=100;
		String userid="P";
		System.out.println("inside post");
		
		
		counter=d.getrowCount();
		
		
			//counter++;
			constant+=counter;
			System.out.println("CONST VALUE "+constant);
			System.out.println("uSERID "+userid);
			userid=userid+constant;
			System.out.println("uSERID "+userid);
			int n=(int)(Math.random()*10000);
			password=n+"";
			
			d.insertRow(userid,patOccupation,patContact,patName,password,patFather,marital,patSpouse);
			
			response.sendRedirect("employee/receptionist/receptionistPage.jsp");
			
	}

	}
