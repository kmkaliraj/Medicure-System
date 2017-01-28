package com.medicure.ordermanagement.updatequotation;

import com.medicure.visitor.DataAccessObject;

/*import com.quotation.Dao;*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicure.dao.Dao;
import com.medicure.ordermanagement.bean.Bean;




public class UpdateQuotation extends HttpServlet {
	/* Initializing variables */
	private static final long serialVersionUID = 1L;
	private int radio_value = 0;
	DataAccessObject compose = new DataAccessObject();

	public UpdateQuotation()	// Update Quotation Class Constructor 
	{
		super();
	}

	@SuppressWarnings({ "deprecation", "unused" })
	
	//DataAccessObject data = new DataAccessObject();
	
	/*Servlet function to do doget functionalities*/
	
		protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
					
		//Validating Empty Selection
		if(request.getParameter("selection")==null)
		{
			response.sendRedirect("Quotation.jsp");
			//alert("Please Select Some Quotation");
		}
		else
		{
			int bno ;
			//Creating Bean Object
			Bean BeanObject = new Bean();
					
			
				//creating DAO Object
				Dao DataAccess = null;
				try {
					DataAccess = new Dao();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				}
			
			//getting parameter value of quotation id radio button and storing it
			radio_value = Integer.parseInt(request.getParameter("selection"));
			
			int temp = 0; //temporary variable
			
			//Creating ArrayList
			ArrayList<Integer> countvalue = new ArrayList <Integer> ();
			ArrayList<Integer> Quantity = new ArrayList <Integer> ();
			ArrayList<String> SupId = new ArrayList <String> ();
			ArrayList<String> QId = new ArrayList <String> ();
			ArrayList<String> DrugId = new ArrayList <String> ();
			ArrayList<Float> Price = new ArrayList <Float> ();
			
			//Getting Values from Bean
			countvalue = BeanObject.getCount();
			SupId = BeanObject.getSupID();
			QId = BeanObject.getQId();
			DrugId = BeanObject.getDrugId();
			Price = BeanObject.getPrice();
			Quantity = BeanObject.getQuantity();
			
			//Dynamically Setting Batch Number
			bno = DataAccess.BatchNumber();
			
			/*bno += 1
			BeanObject.setBno(bno);
			*/
			
					
			for (int i = 0; i < radio_value; i++) 
			{
				temp = temp + countvalue.get(i);
			}
		//Declaring variables to store information that is to be 
		//updated in Quotation Log and Medicine STock
		
			String qlQuotationId;
			String qlSupplierId;
			String qlSalesmanId;
			String qlDrugId;
			String qlDate;
			Double qlRetPrice;
			Double qlMarketPrice;
			int qlQuantity;
			
			try
			{
				//Dynamically Setting the Manufacturing Date
				Date d = new Date();
				int year = d.getYear();
				year = year + 1900;
				int month = d.getMonth();
				month = month + 1;
				int date = d.getDate();
				String Man_Date = (year + "-" + month + "-" + date);
				year = year + 2;
				String Ex_Date = (year + "-" + month + "-" + date);
				String sql="",sql1="";
				
				
				if(radio_value == 0)
				{
					temp = 0;
					String toPass="";
					for (int i = 0; i < countvalue.get(0); i++) 
					{
						qlSalesmanId = "S001";
						qlDate = Man_Date;
						qlSupplierId = SupId.get(temp);
						qlQuotationId = QId.get(temp);
						toPass = qlQuotationId;
						qlDrugId = DrugId.get(temp);
						qlRetPrice = Price.get(temp).doubleValue();
						qlMarketPrice = qlRetPrice + 5;
						qlQuantity = Quantity.get(temp);
						
						/**Calling a function in order to insert values into 
						*Quotation Log Table*/
						
						DataAccess.setValueToQuotationLog(qlSalesmanId, qlSupplierId, qlQuotationId,
								qlDrugId, Man_Date);
						//Composing the Message to the Corresponding Supplier
						String Sender = qlSalesmanId;
						String Receiver = qlSupplierId;
						String Subject;
						String Body = ""+qlQuotationId+""+qlDrugId+""+qlQuantity;
						String cc="";
						Subject = "Your Quotation is Approved";
						compose.Composer(Sender,Receiver,cc,Subject,Body);
						
						
						/**Calling a function in order to insert values into 
						*Medicine Stock Table*/
						
						DataAccess.setValueToMedicineStock(bno, qlDrugId, Man_Date, Ex_Date, qlRetPrice,
								qlMarketPrice, qlQuantity);
						
						temp++;
					}
					/**Calling a function to truncate Quotation table of 
					 * that order
					 */
					DataAccess.deleteContents(toPass);
					
				}
				else
				{	
					String toPass = "";
					for (int i = 0; i < countvalue.get(radio_value); i++) 
					{
										
						qlSalesmanId = "S001";
						qlDate = Man_Date;
						qlSupplierId = SupId.get(temp);
						qlQuotationId = QId.get(temp);
						toPass = qlQuotationId;
						qlDrugId = DrugId.get(temp);
						qlRetPrice = Price.get(temp).doubleValue();
						qlMarketPrice = qlRetPrice + 5;
						qlQuantity = Quantity.get(temp);
						
						/**Calling a function in order to insert values into 
						*Quotation Log Table*/
						
						DataAccess.setValueToQuotationLog(qlSalesmanId, qlSupplierId, qlQuotationId,
								qlDrugId, Man_Date);
						
						//Composing the Message to the Corresponding Supplier
						String Sender = qlSalesmanId;
						String Receiver = qlSupplierId;
						String Subject;
						String Body = ""+qlQuotationId+""+qlDrugId+""+qlQuantity;
						String cc="";
						Subject = "Your Quotation is Approved";
						compose.Composer(Sender,Receiver,cc,Subject,Body);
						
						/**Calling a function in order to insert values into 
						*Medicine Stock Table*/
						DataAccess.setValueToMedicineStock(bno, qlDrugId, Man_Date, Ex_Date, qlRetPrice,
								qlMarketPrice, qlQuantity);
						
							
						temp++;
					
					}
					/**Calling a function to truncate Quotation table of 
					 * that order
					 */
					DataAccess.deleteContents(toPass);
					
				
				}		
						
					
			} 
			// Catching Exception
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		}

		// Redirecting to Home Page
        
         RequestDispatcher dispatch=request.getRequestDispatcher("ViewStockDetails.jsp");
          dispatch.forward(request, response);
         
	}

	/* Does the functionalities of Servlet Post Method */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
