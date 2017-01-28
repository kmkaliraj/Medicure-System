/**
 * 
 * @DataBaseAccess.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */


package com.medicure.dao;

public final class DataBaseConstants {

    /**
     * Final Variables that are used for DataBaseAccess
     */
    
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";

    public static final String URL = "jdbc:mysql://192.168.8.238:3306/clinic";

    public static final String USER = "root";

    public static final String PASSWORD = "ibm123";

    public static final String LOW_STOCK_ITEMS_SQL = "select m.Drug_ID drugid,m.Drug_Name drugname,"
            + "s.quantity available,p.quantity required from "
            + "( select Drug_ID,sum(Quantity) quantity from "
            + "medicine_stock "
            + "group by Drug_ID) s,(select Drug_ID,Sum(Quantity)"
            + " quantity from prescription where statuss='waiting'"
            + " group by Drug_ID) p,medicines m where "
            + "m.Drug_ID = s.Drug_ID "
            + "and m.Drug_ID = p.Drug_ID and m.Flag = 'red'";;

    public static final String SUPPLIER_DETAILS_SQL = "select Sup_Name,Sup_ID from supplier";

    public static final String ORDER_ID_SQL = "select OrderID from counter";

	public static final String DRUG_WAITING_PRESCRIPTION = "select count(*) from "+
			"prescription where Statuss='waiting'";

	public static final String DRUG_TOTAL_ROW_COUNT = "select count(*) from prescription";

	public static final String DRUG_WAITING_DETAILS = "select * from prescription where Statuss='waiting'";
	
	public static final String DRUG_GET_PRESCRIPTION_DETAILS = "select count(*)"+
				"from prescription ps,prescriptionsend p where p.Prescription_ID=" +
				"ps.Prescription_ID and ps.Statuss=" +
				"'waiting'";
			
	public static final String DRUG_GET_TOTAL_PRESCRIPTION = "select ps.Doctor_ID," +
			" p.Drug_ID, p.Patient_ID,p.Prescription_ID,p.Quantity,p.Statuss from prescription p," +
			"prescriptionsend ps " +"where p.Prescription_ID=" +
			"ps.Prescription_ID and " +"p.Statuss='waiting'";
	
	public static final String DRUG_GET_STOCK = "select * from Medicine_Stock";
	
	public static final String QUOTATION_ID_QUERY="select QuotationID from counter";
	
}
