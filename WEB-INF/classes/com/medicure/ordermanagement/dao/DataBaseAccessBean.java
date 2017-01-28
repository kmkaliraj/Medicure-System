package com.medicure.ordermanagement.dao;

import java.util.ArrayList;

public class DataBaseAccessBean {

	static ArrayList<String> DrugId;
	static ArrayList<String> DrugName;
	static ArrayList<Integer> RequiredQuantity;
	static ArrayList<Integer> AvailableQuantity;
	static ArrayList<String> SupplierNames;
	static ArrayList<String> SupplierID;

	
	public ArrayList<String> getDrugId() {
		return DrugId;
	}
	public ArrayList<String> getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(ArrayList<String> supplierID) {
		SupplierID = supplierID;
	}
	public void setDrugId(ArrayList<String> drugId) {
		DrugId = drugId;
	}
	public ArrayList<String> getDrugName() {
		return DrugName;
	}
	public void setDrugName(ArrayList<String> drugName) {
		DrugName = drugName;
	}
	public ArrayList<Integer> getRequiredQuantity() {
		return RequiredQuantity;
	}
	public void setRequiredQuantity(ArrayList<Integer> requiredQuantity) {
		RequiredQuantity = requiredQuantity;
	}
	public ArrayList<Integer> getAvailableQuantity() {
		return AvailableQuantity;
	}
	public void setAvailableQuantity(ArrayList<Integer> requiredQuantity) {
		AvailableQuantity = requiredQuantity;
	}
	public ArrayList<String> getSupplierNames() {
		return SupplierNames;
	}
	public void setSupplierNames(ArrayList<String> supplierNames) {
		SupplierNames = supplierNames;
	}
	

	
}
