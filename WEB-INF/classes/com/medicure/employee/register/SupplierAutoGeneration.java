package com.medicure.employee.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Supplier;

public class SupplierAutoGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SupplierAutoGeneration() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String g=request.getParameter("supplierName");
		session.setAttribute("name", g);
		String supplierName=session.getAttribute("name").toString();

		System.out.println(supplierName);
		
		Supplier r=new Supplier();
		String password="";
		int counter=0,constant=100;
		String userid="SP";
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
			
			r.insertRow(userid,password,supplierName);
			
			response.sendRedirect("employee/admin/RegistrationSuccess.jsp");
	}

}
