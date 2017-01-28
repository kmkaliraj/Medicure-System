package com.medicure.drug.receive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicure.drug.dao.DrugDAO;;
/**
 * Servlet implementation class PrescriptionDelivery
 * 
 */
public class PrescriptionDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrescriptionDelivery() 
    {
        super();
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException 
    {
        doPost(req, resp);
    }
    
    /**
	 * This method get the string array from Order.jsp page and calls the
	 * isDeliverMedicine() function  and isChangeStatus function
	 * @param  request  
	 * @param  response 
 	 */
    
	protected void doPost(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException {
		
		//System.out.println(request.getParameter("hiddenData"));
		int i=Integer.parseInt(request.getParameter("hiddenData"));
		System.out.println("hiden : "+i);
		HttpSession session=request.getSession();
				
		String prescriptionData[][]=(String[][]) session.getAttribute("index");
		String counter = request.getParameter("hiddenData");
		System.out.println("Counter : "+counter);
		try 
		{
			
			new DrugDAO().isDeliverMedicine(prescriptionData[i][4],
			prescriptionData[i][2],Integer.parseInt(prescriptionData[i][5]));
			
			new DrugDAO().isChangeStatus(prescriptionData[i][4],
			prescriptionData[i][2],Integer.parseInt(prescriptionData[i][5]));
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("order.jsp");//redirect to Order.jsp page
		
	}

}
