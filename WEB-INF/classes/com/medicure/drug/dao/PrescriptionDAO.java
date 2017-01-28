/**
 * @PrescriptionDAO.java
 * @version 4 Aug 2012
 * © Copyright IBM Corp. 2012
 * All Rights Reserved
 **/
package com.medicure.drug.dao;

import com.medicure.dao.MedicureConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.medicure.dao.DataBaseConstants;

public class PrescriptionDAO 
{ 
	MedicureConnection medicureconnection = null;
	Statement statement = null;
	ResultSet resultset = null;
	String sql = "";

	 public PrescriptionDAO() 
	 {
		 medicureconnection = new MedicureConnection();
	 }
	
	/**
	* This method returns the total row count of the prescription table
	* @param null –null
	* @return int – rowcount
	* @throws  SQLException
	**/

	public int getTotalCount() throws SQLException
	{
		int totalRow;
		String query = DataBaseConstants.DRUG_TOTAL_ROW_COUNT;
		
		ResultSet resultSet = medicureconnection.executeQuery(query);
		resultSet.next();
		totalRow = resultSet.getInt("count(*)");
		return totalRow;    
		
	}
	/**
	 * This method returns  the prescriptionId of those prescription whose
	 *status is 'waiting'and store it in a String array
	 * @param null – null
	 * @return String array– prescriptionid
	 * @throws  SQLException
	*/

	public String[] getWaitingPrescription() throws SQLException 
	{
		int length = 0,i = 0;
		String[] prescriptionId;
		String query = DataBaseConstants.DRUG_WAITING_PRESCRIPTION;
		
		ResultSet resultSet = medicureconnection.executeQuery(query);
		resultSet.next();
		length = resultSet.getInt("count(*)");
		
		prescriptionId = new String[length];
		query = DataBaseConstants.DRUG_WAITING_DETAILS;
		
		resultSet = medicureconnection.executeQuery(query);
		while(resultSet.next())//Getting Prescription_ID and storing in 
								//prescriptionId string array
		{
			prescriptionId[i] = resultSet.getString("Prescription_ID");
			i++;
		}
		return prescriptionId;  
	}
	/** 
	* Returns the String array of Prescription details including doctor_id,
	* patient_id,quantity for those prescription status is waiting	 
	* @param null – null 
	* @return String array – Prescription details  
	* @throws  SQLException
	**/

	
	public String[][] getPrescriptionDetails() throws SQLException
	{	
		String[][] prescriptionDetails = null;
		int prescriptionCounter = 0,length;
		String query = DataBaseConstants.DRUG_GET_PRESCRIPTION_DETAILS;
		
		
		ResultSet resultSet = medicureconnection.executeQuery(query);
		resultSet.next();
		length = resultSet.getInt("count(*)");
		if(length!=0)
		{
			prescriptionDetails = new String[length][6];
		}
		else
		{
			prescriptionDetails = new String[1][1];
			prescriptionDetails[0][0]="0";
		}
		
		query = DataBaseConstants.DRUG_GET_TOTAL_PRESCRIPTION;
		
		resultSet = medicureconnection.executeQuery(query);
		if(resultSet!=null)
		{
			
		while(resultSet.next())//assigning elements Doctor_ID,Patient_ID,
							   //Prescription_ID,Statuss,Drug_ID,Quantity 
							   //to prescriptionDetails 
							   //String array
		{
			prescriptionDetails[prescriptionCounter][0] = 
					resultSet.getString("ps.Doctor_ID");
			prescriptionDetails[prescriptionCounter][1] = 
					resultSet.getString("p.Patient_ID");
			prescriptionDetails[prescriptionCounter][2] = 
					resultSet.getString("p.Prescription_ID");
			prescriptionDetails[prescriptionCounter][3] = 
					resultSet.getString("p.Statuss");
			prescriptionDetails[prescriptionCounter][4] = 
					resultSet.getString("p.Drug_ID");
			prescriptionDetails[prescriptionCounter][5] = 
					resultSet.getString("p.Quantity");
			
			
			prescriptionCounter++;
		}
		}
		else
		{
			prescriptionDetails[0][0]="0";
		
			if(prescriptionCounter==0)
			{
				prescriptionDetails[0][0]="0";
			}
		}
		
		return prescriptionDetails;   //returning prescriptionDetails
	}
	
	/**This method get drugid,required quantity and Change the status of 
	 *prescription to "delivered" 
	 * once the drug is delivered to the patient
	 * @param drugId - String
	 * @param requiredDrugQuantity-int
	 * @return null–null 
 	 * @throws  SQLException
	 */
	
	public void changeStatus(String drugId,int requiredDrugQuantity) throws 
	SQLException
	{
		int stock;
		String query = "select Quantity from prescription where Drug_ID =" +
				" '"+drugId+"'";
		
		ResultSet result = medicureconnection.executeQuery(query);
		stock=Integer.parseInt(result.getString("Quantity"));
		if(stock>=requiredDrugQuantity)//checking if stock available and 
		//updating status as 'delivered'
		{
			query = "update prescription set Statuss='delivered' where " +
					"Drug_ID = '"+drugId+"'";
			medicureconnection.updateQuery(query);
		}
		
	}
}
