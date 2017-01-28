/**
 *      @IterateLowStockItems.java
 *      COPYRIGHT IBM Corporation 2012
 *      
 */

package com.medicure.ordermanagement.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.medicure.ordermanagement.bean.DataBaseAccessBean;

public class IterateLowStockItems extends BodyTagSupport {
    
    /**
     * 
     * Performs the Iteration function for Low Stock Items
     * 
     */
    
    
    private static final long serialVersionUID = 769946997402698041L;
    private int counter = 0;
    private Object[] drugID = null;
    private Object[] drugName = null;
    private Object[] requiredQuantity = null;
    private Object[] availableQuantity = null;

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
     * 
     * Starts the custom Iterator Tag and Displays the Low Stock Items
     * 
     */
    public int doStartTag() {
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
        DataBaseAccessBean dbab = (DataBaseAccessBean) req
                .getAttribute("lowstock");

        drugID = dbab.getDrugId().toArray();
        drugName = dbab.getDrugName().toArray();
        requiredQuantity = dbab.getRequiredQuantity().toArray();
        availableQuantity = dbab.getAvailableQuantity().toArray();

        /* Printing all the Low Stock Items from Bean to the PageContext */
        for (; counter <= drugID.length; counter++) {
            try {
                String value = "<tr> <td><input type=\"hidden\" name=\"drugid"
                        + counter + "\" value=\"" + drugID[counter] + "\" />"
                        + drugID[counter] + " </td> "
                        + " <td> <input type=\"hidden\" name=\"drugname"
                        + counter + "\" value=\"" + drugName[counter]
                        + "\" /> " + drugName[counter] + " </td> " + "<td> "
                        + requiredQuantity[counter] + "</td> " + "<td> "
                        + availableQuantity[counter] + "</td> "
                        + "<td> <input type=\"text\" name=\"toOrder"
                        + counter + "\" id=\"" + counter + "\" /> </td> </tr>";
                pageContext.getOut().print(value);
            } catch (Exception e) {

            }
        }

        /* setting the number of Low Stock Items in a hidden text box */
        try {
            String content = "<input name=\"stock\" type=\"hidden\"  value=\""
                    + counter + "\" id=\"nooflowstock\"/>";
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

        if (counter >= drugID.length) {

            return SKIP_BODY;
        }
        return EVAL_BODY_AGAIN;
    }
}
