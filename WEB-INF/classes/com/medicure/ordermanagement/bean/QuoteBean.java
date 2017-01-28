/**
 * 
 * Copyright OrderManagement@Medicure 
 * 
 * @QuoteBean.java
 * 
 */
package com.medicure.ordermanagement.bean;

import java.util.List;

public class QuoteBean {
    private List<String> drugs;
    private List<String> drugsId;
    private List<String> quantity;
    private String supplierId;
    private String orderId;

    /**
     * @return the drugs
     */
    public List<String> getDrugs() {
        return drugs;
    }

    /**
     * @param drugs
     *            the drugs to set
     */
    public void setDrugs(List<String> drugs) {
        this.drugs = drugs;
    }

    /**
     * @return the drugsId
     */
    public List<String> getDrugsId() {
        return drugsId;
    }

    /**
     * @param drugsId
     *            the drugsId to set
     */
    public void setDrugsId(List<String> drugsId) {
        this.drugsId = drugsId;
    }

    /**
     * @return the quantity
     */
    public List<String> getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(List<String> quantity) {
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
