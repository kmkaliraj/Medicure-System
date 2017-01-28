package com.medicure.ordermanagement.bean;



import java.util.ArrayList;

public class Bean {
	
	/** Creating a Array List */
	static ArrayList<String> QId = new ArrayList<String>();
	static ArrayList<Integer> Count = new ArrayList<Integer>();
	static ArrayList<Integer> Quantity = new ArrayList<Integer>();
	static ArrayList<String> DrugId = new ArrayList<String>();
	static ArrayList<String> DrugName = new ArrayList<String>();
	static ArrayList<String> SupID = new ArrayList<String>();
	static ArrayList<String> SupStatus = new ArrayList<String>();
	static ArrayList<String> Sman_stat = new ArrayList<String>();
	static ArrayList<String> Desc = new ArrayList<String>();
	static ArrayList<Float> Price = new ArrayList<Float>();
	
	static int bno;
	
	public static int getBno() {				//Getters for BatchNo  
		return bno;
	}

	public static void setBno(int bno) {		//Setters for BatchNo
		Bean.bno = bno;
	}

	public Bean()   							 //Bean CLass Constructor
	{
	}

	public ArrayList<String> getQId() {			//Getters for QuotationId
		return QId;
	}

	public void setQId(ArrayList<String> qId) {	//Setters for QuotationId
		
		QId = qId;
	}

	public ArrayList<Integer> getCount() {		//Getters for Count
		return Count;
	}

	public void setCount(ArrayList<Integer> count) {//Setters for Count
		Count = count;
	}

	public ArrayList<Integer> getQuantity() {	//Getters for Quantity
		return Quantity;
	}

	public void setQuantity(ArrayList<Integer> quantity) {	//Setters for Quantity
		Quantity = quantity;
	}

	public ArrayList<String> getDrugId() {		//Getters for DrugId
		return DrugId;
	}

	public void setDrugId(ArrayList<String> drugId) {	//Setters for DrugId
		
		DrugId = drugId;
	}

	public ArrayList<String> getDrugName() {	//Getters for DrugName
		return DrugName;
	}

	public void setDrugName(ArrayList<String> drugName) {	//Setters for DrugName
		DrugName = drugName;
	}

	public ArrayList<String> getSupID() { 		//Getters for Supplier ID
		return SupID;
	}

	public void setSupID(ArrayList<String> supID) {	//Setters for Supplier ID
		SupID = supID;
	}

	public ArrayList<String> getSupStatus() {	//Getters for Supplier Status
		return SupStatus;
	}

	public void setSupStatus(ArrayList<String> supStatus) {	//Setters for Supplier Status
		SupStatus = supStatus;
	}

	public ArrayList<String> getSman_stat() {	//Getters for Salesman Status
		return Sman_stat;
	}

	public void setSman_stat(ArrayList<String> sman_stat) {	//Setters for Salesman Status
		Sman_stat = sman_stat;
	}

	public ArrayList<String> getDesc() {		//Getters for Description
		return Desc;
	}

	public void setDesc(ArrayList<String> desc) {//Setters for Description
		Desc = desc;
	}

	public ArrayList<Float> getPrice() {		//Getters for Price
		return Price;
	}

	public void setPrice(ArrayList<Float> price) {//Setters for Price
		Price = price;
	}

	
}