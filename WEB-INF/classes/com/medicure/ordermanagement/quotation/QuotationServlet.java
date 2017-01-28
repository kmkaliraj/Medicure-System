/**
 * 
 * Copyright OrderManagement@Medicure 
 * 
 * @QuotationServlet.java
 * 
 */

package com.medicure.ordermanagement.quotation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicure.dao.DataBaseAccess;
import com.medicure.ordermanagement.bean.QuoteBean;

public class QuotationServlet extends HttpServlet {

    /**
     * 
     * Retrieves data from the order table and displays the Quotation form to
     * the supplier using JavaBeans
     * 
     * @version August 06,2012 Cleaned up warnings
     * 
     */

    private static final long serialVersionUID = 1L;

    public QuotationServlet() {
        super();
    }

    /**
     * 
     * @Param drugs stores the Drug Names
     * @Param drugsId stores the Drug ID
     * @Param quantity stores the Drug quantity
     * 
     */

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        
        DataBaseAccess dba = new DataBaseAccess();
        if (dba.isNotDuplicateQuotation(request.getParameter("sid"),
                request.getParameter("oid"))) {

            /* Instance for the JavaBean class QuoteBean */
            QuoteBean qb = dba.getOrderDetails(request.getParameter("oid"));

            try {

                /* Setting the values to QuoteBean class */
                qb.setOrderId(request.getParameter("oid"));
                qb.setSupplierId(request.getParameter("sid"));

                request.setAttribute("qBean", qb);

                /* Passing the data to Quotation.jsp to be displayed */
                RequestDispatcher dis = request
                        .getRequestDispatcher("QuotationForm.jsp");
                dis.forward(request, response);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("result","Quotation Already Updated!!!!!!!!");
            RequestDispatcher dispatch=request.getRequestDispatcher("QuotationResultPage.jsp");
            dispatch.include(request, response);
        }
    }

}
