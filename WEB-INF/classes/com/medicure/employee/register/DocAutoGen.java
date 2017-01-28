package com.medicure.employee.register;
import com.medicure.employee.DAO.Doctor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DocAutoGen
 */
public class DocAutoGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DocAutoGen() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String g=request.getParameter("docName");
		session.setAttribute("name", g);
		String docName=session.getAttribute("name").toString();
		
		String e=request.getParameter("radioOne");
		session.setAttribute("gen", e);
		String gender=session.getAttribute("gen").toString();
		
		String f=request.getParameter("docSpeciality");
		session.setAttribute("spc", f);
		String docSpec=session.getAttribute("spc").toString();
		
		String h=request.getParameter("docQualification");
		session.setAttribute("qual", h);
		String docQual=session.getAttribute("qual").toString();
		
		String j=request.getParameter("docAffiliation");
		session.setAttribute("aff", j);
		String docAff=session.getAttribute("aff").toString();
		
		String i=request.getParameter("docExperience");
		session.setAttribute("exp", i);
		String docExp=session.getAttribute("exp").toString();
		
		
		
		System.out.println(docName);
		System.out.println(gender);
		System.out.println(docSpec);
		System.out.println(docQual);
		System.out.println(docAff);
		System.out.println(docExp);
	
		
		Doctor d=new Doctor();
		String password="";
		int counter=0,constant=100;
		String userid="D";
		System.out.println("inside post");
		
		
		counter=d.getrowCount();
		
		
			//counter++;
			constant+=counter;
			System.out.println("CONST VALUE "+constant);
			System.out.println("uSERID "+userid);
			userid=userid+constant;
			System.out.println("USERID "+userid);
			int n=(int)(Math.random()*10000);
			password=n+"";
			
			d.insertRow(userid,docName,password,gender,docSpec,docQual,docAff,docExp);
			
			response.sendRedirect("employee/admin/RegistrationSuccess.jsp");
			
	}

}
