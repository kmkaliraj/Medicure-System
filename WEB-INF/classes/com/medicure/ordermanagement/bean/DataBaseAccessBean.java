/**
 * 
 * @DataBaseAccessBean.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */

package com.medicure.ordermanagement.bean;

import java.util.ArrayList;

public class DataBaseAccessBean {

    public  ArrayList<String> DrugId;
    public  ArrayList<String> DrugName;
    public  ArrayList<Integer> RequiredQuantity;
    public  ArrayList<Integer> AvailableQuantity;
    public  ArrayList<String> SupplierNames;
    public  ArrayList<String> SupplierID;

    /**
     * @return the drugId
     */
    public  ArrayList<String> getDrugId() {
        return DrugId;
    }

    /**
     * @param drugId
     *            the drugId to set
     */
    public  void setDrugId(ArrayList<String> drugId) {
        DrugId = drugId;
    }

    /**
     * @return the drugName
     */
    public  ArrayList<String> getDrugName() {
        return DrugName;
    }

    /**
     * @param drugName
     *            the drugName to set
     */
    public  void setDrugName(ArrayList<String> drugName) {
        DrugName = drugName;
    }

    /**
     * @return the requiredQuantity
     */
    public  ArrayList<Integer> getRequiredQuantity() {
        return RequiredQuantity;
    }

    /**
     * @param requiredQuantity
     *            the requiredQuantity to set
     */
    public  void setRequiredQuantity(ArrayList<Integer> requiredQuantity) {
        RequiredQuantity = requiredQuantity;
    }

    /**
     * @return the availableQuantity
     */
    public  ArrayList<Integer> getAvailableQuantity() {
        return AvailableQuantity;
    }

    /**
     * @param availableQuantity
     *            the availableQuantity to set
     */
    public  void setAvailableQuantity(ArrayList<Integer> availableQuantity) {
        AvailableQuantity = availableQuantity;
    }

    /**
     * @return the supplierNames
     */
    public  ArrayList<String> getSupplierNames() {
        return SupplierNames;
    }

    /**
     * @param supplierNames
     *            the supplierNames to set
     */
    public  void setSupplierNames(ArrayList<String> supplierNames) {
        SupplierNames = supplierNames;
    }

    /**
     * @return the supplierID
     */
    public  ArrayList<String> getSupplierID() {
        return SupplierID;
    }

    /**
     * @param supplierID
     *            the supplierID to set
     */
    public  void setSupplierID(ArrayList<String> supplierID) {
        SupplierID = supplierID;
    }

}
