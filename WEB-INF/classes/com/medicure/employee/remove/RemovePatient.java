package com.medicure.employee.remove;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.employee.DAO.Doctor;
import com.medicure.employee.DAO.Patient;

public class RemovePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemovePatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(); 
		String Patient_ID=request.getParameter("id");
		Patient delpat=new Patient();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try {
			if(delpat.selectRow(Patient_ID).next()){
				delpat.deleteRow(Patient_ID);
				out.println("<h1>");
				out.println("SuccessFull");
				out.println("</h1>");
			}
			else{
				out.println("<h1>");
				out.println("Failure Record not found");
				out.println("</h1>");
			}
				
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
		out.println("</body>");
		out.println("</html>");
	}

}
