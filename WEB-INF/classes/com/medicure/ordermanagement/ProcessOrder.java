/**
 * 
 *  @IterateSupplier.java
 *  COPYRIGHT IBM Corporation 2012
 * 
 */

package com.medicure.ordermanagement;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicure.dao.DataBaseAccess;

/**
 * 
 * Receives Order request from salesman and sends to Supplier
 * 
 */
public class ProcessOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProcessOrder() {
        super();

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{

        // Getting stock and supplier from the Order Table

        int stock = Integer.parseInt(request.getParameter("stock"));
        int supplier = Integer.parseInt(request.getParameter("supplier"));
        ArrayList<String> DrugId = new ArrayList<String>();
        ArrayList<String> DrugName = new ArrayList<String>();
        ArrayList<Integer> OrderQuantity = new ArrayList<Integer>();

        // Getting the Drug details to order from the OrderGeneration page
        for (int i = 0; i < stock - 1; i++) {
            DrugId.add(request.getParameter("drugid" + i));
            DrugName.add(request.getParameter("drugname" + i));
            OrderQuantity.add(Integer.parseInt(request.getParameter("toOrder"
                    + i)));

        }
        try {
            // Inserting the order to OrderTable
            new DataBaseAccess().updateOrderTable(DrugId, DrugName,
                    OrderQuantity);
            String OrderID = new DataBaseAccess().getOrderID();
            String Mail = "";
            // Sending Mail to the selected suppliers
            for (int i = 0; i < supplier; i++) {
                if (request.getParameter("supplier" + (i + 100)) != null) {
                    Mail = "Please click the Following Link "
                            + "( http://localhost:8080/"
                            + "MediCureClinicAutomation/" + "quote.serv?oid="
                            + OrderID + "" + "&sid="
                            + request.getParameter("supid" + (i + 100)) + " )"
                            + "to submit your quotation....\nThank you....";

                    new DataBaseAccess().sendMail(
                            "Salesman",
                            request.getParameter("supplier" + (i + 100)),
                            "Requesting For Quotation",
                            Mail,
                            "Salesman;"
                                    + request.getParameter("supplier"
                                            + (i + 100)));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Order Cannot be processed");
        }

        // Redirecting to Home Page
        
         RequestDispatcher dispatch=request.getRequestDispatcher("ViewStockDetails.jsp");
         dispatch.forward(request, response);
          
         

    }
}
