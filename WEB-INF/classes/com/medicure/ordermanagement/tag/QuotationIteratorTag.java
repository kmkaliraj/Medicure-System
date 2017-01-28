/**
 * 
 * Copyright OrderManagement@Medicure 
 * 
 * @IteratorTag.java
 * 
 */

package com.medicure.ordermanagement.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import com.medicure.ordermanagement.bean.QuoteBean;

public class QuotationIteratorTag extends BodyTagSupport {

    /**
     * 
     * Defines Custom Iterator tag for Quotation.jsp
     * 
     * @version August 06,2012
     * 
     */

    private static final long serialVersionUID = 769946997402698041L;
    private int counter = 0;
    private Object[] drugNames = null;
    private Object[] drugID = null;
    private Object[] quantity = null;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @SuppressWarnings("unused")

    /**
     * 
     * Initiates the Custom Iterator tag
     * 
     * @param drugID
     *            Array to store Drugs ID from QuoteBean
     * @param drugNames
     *            Array to store Drugs Name from QuoteBean
     * @param quantity
     *            Array to store Drugs Quantity from QuoteBean
     * 
     */

    public int doStartTag() {
        /* Receives request from Quotation.jsp */
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();

        /* Instance for QuoteBean */
        QuoteBean qb = (QuoteBean) req.getAttribute("qBean");

        drugID = qb.getDrugsId().toArray();
        drugNames = qb.getDrugs().toArray();
        quantity = qb.getQuantity().toArray();

        /* Performs the iteration function */
        for (Object j : quantity) {
            try {

                String val = "<tr>"
                        + "<td>"
                        + drugID[counter]
                        + "</td>"
                        + "<td>"
                        + drugNames[counter]
                        + "</td>"
                        + "<td>"
                        + quantity[counter]
                        + "</td>"
                        + "<td><input type=\"text\" id="+counter+" style=\"width: 30px;\" name=\"price"
                        + counter + "\"></td>" + "</tr>\n";

                pageContext.getOut().print(val);

            }
            catch (Exception e) {
                try {
                    throw new JspException(e.toString());
                }
                catch (JspException e1) {
                    e1.printStackTrace();
                }
            }
            counter++;
        }

        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {

        if (counter >= quantity.length) {
            System.out.println(quantity[counter]);
            return SKIP_BODY;
        }
        return EVAL_BODY_AGAIN;
    }
}
