package com.medicure.employee.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Receptionists;


public class RecAutoGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RecAutoGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String g=request.getParameter("recipName");
		session.setAttribute("name", g);
		String recpName=session.getAttribute("name").toString();
		
		String e=request.getParameter("radioOne");
		session.setAttribute("gen", e);
		String gender=session.getAttribute("gen").toString();

		System.out.println(recpName);
		System.out.println(gender);	
		
		Receptionists r=new Receptionists();
		String password="";
		int counter=0,constant=100;
		String userid="R";
		System.out.println("inside post");
		
		
		counter=r.getrowCount();
		
		System.out.println(counter);
			//counter++;
			constant+=counter;
			System.out.println("CONST VALUE "+constant);
			System.out.println("uSERID "+userid);
			userid=userid+constant;
			System.out.println("uSERID "+userid);
			int n=(int)(Math.random()*10000);
			password=n+"";
			
			r.insertRow(userid,password,recpName,gender);
			
			response.sendRedirect("employee/admin/RegistrationSuccess.jsp");
	}


}
