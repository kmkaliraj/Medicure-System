package com.medicure.employee.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Salesman;


public class SalesmanAutoGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SalesmanAutoGeneration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String g=request.getParameter("salesmanName");
		session.setAttribute("name", g);
		String salesmanName=session.getAttribute("name").toString();
		
		String e=request.getParameter("radioOne");
		session.setAttribute("gen", e);
		String gender=session.getAttribute("gen").toString();

		System.out.println(salesmanName);
		System.out.println(gender);	
		
		Salesman r=new Salesman();
		String password="";
		int counter=0,constant=100;
		String userid="S";
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
			
			r.insertRow(userid,password,salesmanName,gender);
			
			response.sendRedirect("employee/admin/RegistrationSuccess.jsp");
	}

}
