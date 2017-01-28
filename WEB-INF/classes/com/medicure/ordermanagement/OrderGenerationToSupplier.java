/**
 *      @IterateSupplier.java
 *      COPYRIGHT IBM Corporation 2012
 *      
 */

package com.medicure.ordermanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicure.dao.DataBaseAccess;
import com.medicure.ordermanagement.bean.DataBaseAccessBean;

public class OrderGenerationToSupplier extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 
     * Performs Bean Population operation and forwards the page to Order
     * Generation Page
     * 
     */
    public OrderGenerationToSupplier() {
        super();

    }

    /**
     * 
     * Populates the Bean with Low Stock Items
     * 
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{
        try{
            DataBaseAccessBean bean = new DataBaseAccess().getLowStockItems();
            request.setAttribute("lowstock", bean);

            /* Forwards the page to Order Generation Page */
            RequestDispatcher dispatch = request
                    .getRequestDispatcher("OrderGenerationToSupplier.jsp");
            dispatch.forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
