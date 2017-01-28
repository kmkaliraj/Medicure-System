/**
 * 
 * Copyright Medicure@IBM
 * 
 * @QuotationSendServlet.java
 * 
 */

package com.medicure.ordermanagement.quotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicure.dao.DataBaseAccess;

public class QuotationSendServlet extends HttpServlet {

    /**
     * 
     * Extracts the data from the Quotation form and updates the Quotation table
     * 
     * @version August 06,2012 Cleaned up warnings
     * 
     */

    private static final long serialVersionUID = 1L;

    public QuotationSendServlet() {
        super();
    }

    /**
     * 
     * @Param Drug_id to get the Drug ID
     * @Param Drug_name to get the Drug Name
     * @Param Drug_qty to get the Drug quantity
     * 
     */

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        
        DataBaseAccess dba = new DataBaseAccess();

       
        
        int successCount = 0;

        try {
            List<String> paramList= new ArrayList<String>();
            
            @SuppressWarnings("unchecked")
            Enumeration<String> priceParam = request.getParameterNames();
            
            // Stores the Drug price in Enumeration parameter
            while (priceParam.hasMoreElements()) {
                String temParam = priceParam.nextElement();
                paramList.add(request.getParameter(temParam));
            }
            successCount=dba.insertIntoQuotationTable(paramList); 
            if (successCount == 0) {
                request.setAttribute("result","Quotation Update failed!!!!!!!!");
            } else {
                request.setAttribute("result","Quotation Update Successfully!!!!!!!!");
            }
        }
        catch (Exception sqlExce) {
            
        }
        finally{
            RequestDispatcher dispatch=request.getRequestDispatcher("QuotationResultPage.jsp");
            dispatch.include(request, response);
        }
        
    }

}
