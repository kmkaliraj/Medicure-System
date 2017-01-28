/**
 *      @IterateSupplier.java
 *      COPYRIGHT IBM Corporation 2012
 *      
 */

package com.medicure.ordermanagement.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.medicure.ordermanagement.bean.DataBaseAccessBean;

public class IterateSupplier extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    /**
     * 
     * Performs the Iteration function for supplier Data
     * 
     * 
     */

    private int counter = 0;
    private Object[] supplierName = null;
    private Object[] supplierID = null;

    /**
     * 
     * Set the counter variable
     * 
     * @param counter
     */
    public void setCounter(int counter) {
        this.counter = counter;

    }

    /**
     * Starts the custom Iterator Tag and Displays the Supplier Names
     * 
     */
    public int doStartTag() throws JspException {
 
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
        DataBaseAccessBean dbab = (DataBaseAccessBean) req
                .getAttribute("lowstock");
        supplierID = dbab.getSupplierID().toArray();
        supplierName = dbab.getSupplierNames().toArray();

        /* Printing all the Supplier Names from Bean to the PageContext */
        for (; counter <= supplierID.length; counter++) {
            try {
                String value = "<tr> <td> <input type=\"checkbox\" onclick=\"enable("
                        + (counter + 100)
                        + ")\" name=\"supplier"
                        + (counter + 100)
                        + "\" value=\""
                        + supplierName[counter]
                        + "\" id=\"supplier"+counter+"\" />"
                        + supplierName[counter]
                        + " <input disabled=\"disabled\" type=\"hidden\" id=\""
                        + (counter + 100)
                        + "\" name=\"supid"
                        + (counter + 100)
                        + "\" value=\""
                        + supplierID[counter]
                        + "\"> </td> </tr>";
                pageContext.getOut().print(value);
            } catch (Exception e) {

            }
        }
        try {
            
            /* setting the number of suppliers in a hidden text box */
            
            String content = "<input name=\"supplier\" type=\"hidden\"  value=\""
                    + counter + "\" id=\"noofsuppliers\"/>";
            pageContext.getOut().print(content);
        } catch (Exception e) {
        }

        return EVAL_BODY_BUFFERED;
    }

    /**
     * 
     * Setting the condition, when should the iterator be stopped 
     * 
     */

    public int doAfterBody() throws JspException {

        if (counter >= supplierID.length) {

            return SKIP_BODY;
        }
        return EVAL_BODY_AGAIN;
    }
}