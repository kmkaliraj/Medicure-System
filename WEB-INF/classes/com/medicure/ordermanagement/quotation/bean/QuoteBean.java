/**
 * 
 * Copyright OrderManagement@Medicure 
 * 
 * @QuoteBean.java
 * 
 */
package com.medicure.ordermanagement.quotation.bean;

import java.util.ArrayList;

public class QuoteBean {
    private ArrayList<String> drugs;
    private ArrayList<String> drugsId;
    private ArrayList<String> quantity;
    private String supplierId;
    private String orderId;

    /**
     * @return the drugs
     */
    public ArrayList<String> getDrugs() {
        return drugs;
    }

    /**
     * @param drugs
     *            the drugs to set
     */
    public void setDrugs(ArrayList<String> drugs) {
        this.drugs = drugs;
    }

    /**
     * @return the drugsId
     */
    public ArrayList<String> getDrugsId() {
        return drugsId;
    }

    /**
     * @param drugsId
     *            the drugsId to set
     */
    public void setDrugsId(ArrayList<String> drugsId) {
        this.drugsId = drugsId;
    }

    /**
     * @return the quantity
     */
    public ArrayList<String> getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(ArrayList<String> quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId
     *            the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
