/**
 * @DrugDAO.java
 * @version 4 Aug 2012
 * © Copyright IBM Corp. 2012
 * All Rights Reserved
 **/

package com.medicure.drug.dao;
import com.medicure.dao.DataBaseConstants;
import com.medicure.dao.MedicureConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 * @interact with the Medicine_Stock,Medicines Databases and perform various 
 * function associated with it.This Class mainly manipulates the Medicine_stock
 * and medicines data.  
 **/

public class DrugDAO 
{
						   // Variable Declaration starts here
	 MedicureConnection medicureconnection = null;
	 Statement statement = null;
	 ResultSet resultset = null;
	 String sql = "";

	 public DrugDAO () 
	 {
		 medicureconnection = new MedicureConnection();
	 }
	 
	/**
	* This method get the drugid and returns the quantity of drug.
 	* @param drugid –  Id for Drug 
	* @return int – drugQuantity
 	*/
	public int getDrugQuantity(String drugId) 
	{
		int drugQuantity = 0; // variable for storing the drug quantity
		String query = "select sum(Quantity) from medicine_stock where Drug_ID=" +
				"'"+ drugId + "'";
		try 
		{
			
			ResultSet result = medicureconnection.executeQuery(query);
			while (result.next()) 
			{				//storing Quantity of drug in variable
							//drugQuantity
				drugQuantity += result.getInt("sum(Quantity)");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Sorry!! Request cannot be processed..");
		}
		return drugQuantity; // returns the drug quantity
	}

/**
 * This method get the count of rows in medicine_stock table.
 * @param null – null
 * @return int – RowCount
 * @throws  SQLException
 */

	public int getCount() throws SQLException {
		String query = DataBaseConstants.DRUG_GET_STOCK;;
		
		ResultSet resultSet = medicureconnection.executeQuery(query);
		resultSet.last();
		return resultSet.getRow(); //returns the rowcount
									

	}
	

	/**
	* This method returns the array of DrugId whose drug name starts with the 
	* given character 
 	* @param Character –String 
 	* @return String Array –Array of Drugid 
 	* @throws  Exception
 	*/
	
	public String[][] getMedicineNameByFirstLetter(String character)
			throws Exception {
		int length = 0, i = 0;
		String drugId[][] = null;
		String query = "select distinct(m.Drug_ID) from "
			+ "Medicine_Stock ms,medicines m where ms.Drug_ID=m.Drug_ID and"
			+ " m.Drug_Name like '" + character + "%';";
		
		ResultSet resultSet = medicureconnection.executeQuery(query);
		resultSet.last();
		length = resultSet.getRow();
		drugId = new String[length][3];
	

		if (length != 0) {//checking if drugId array has no elements and assigning

			query = "select m.Drug_ID,Drug_Name,sum(ms.Quantity) from medicines m," +
					"medicine_stock ms where m.Drug_ID=ms.Drug_ID and m.Drug_Name " +
					"like '"+character+"%' group by m.Drug_ID; ";
			
			resultSet = medicureconnection.executeQuery(query);
			while (resultSet.next()) {//assigning first element of drugId String
			//array as Drug_ID and second element as drug_quantity in stock

				drugId[i][0] = resultSet.getString("Drug_ID");
				drugId[i][1] = resultSet.getString("m.Drug_Name");
				drugId[i][2] = resultSet.getString("sum(ms.Quantity)");
				++i;

			}
		}
		return drugId;//return drugId String array

	}

	/**
	 * This method get the drugid and returns the name of the medicine.
	 * @param Drugid –String 
 	 * @return String  – Drug_Name 
 	 * @throws  SQLException
 	 **/

	public String getDrugName(String drugId) throws SQLException {
		String query = "select Drug_Name from medicines where Drug_ID='"
				+ drugId + "'";
		
		ResultSet result = medicureconnection.executeQuery(query);
		result.next();
		return result.getString("Drug_Name");//Return Drug_Name
	}

	/**
	 * This method get  the current date and delete the Expired Medicine
	 * and return the resultant boolean value
	 * @param CurrentDate  – Date 
 	 * @return boolean  – true/false 
 	 */

	public boolean deleteExpiredMedicine(Date currentDate) {
		// converting the Date type to compatible with in DB DataType
		@SuppressWarnings("deprecation")
		String date = currentDate.getYear() + "-" + currentDate.getMonth()
				+ "-" + currentDate.getDate();
		String query = "delete from medicine_stock where Exp_Date<='" + date
				+ "'";
		try {
			statement.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * This method get the drugid and requiredQuantity of medicine and checks 
	 * for availability in stock comparing with the required quantity and 
	 * return true or false.
	 * @param drugid  – String 
	 * @param requiredQuantity – int 
 	 * @return boolean  – true/false 
 	 */
	 
	public boolean isDrugOutOfStock(String drugId, int requiredQuantity)
			throws SQLException {
		int drugQuantity = this.getDrugQuantity(drugId);
		if (drugQuantity <= requiredQuantity) //Checking if drugQuantity in 
		//Stock is less than requiredQuantity and updating flag as 'red' 
		{
			String query = "update medicines set Flag ='red' where Drug_ID='"
					+ drugId + "'";
			medicureconnection.executeQuery(query);
			return true;
		} else 
		{
			return false;
		}
	}
		
	/**
	 * This method get the drugid and requiredQuantity of medicine and checks 
	 * for availability in stock comparing with the required quantity and 
	 * return true or false.It also update the stock
	 * @param drugid  – String 
	 * @param requiredQuantity – int 
 	 * @return boolean  – true/false 
 	 */
	public boolean isDeliverMedicine(String drugId, String prescriptionId, int reqQuantity)
			throws SQLException {
		
		String query, Batch_No;
		while (reqQuantity != 0) {
			query = "select Batch_no,Drug_ID,Quantity from medicine_stock"
				+ " where Exp_Date = (select min(Exp_Date) from medicine_stock"
				+ " where Drug_ID = '" + drugId + "' ) ";
			

			ResultSet result = medicureconnection.executeQuery(query);
			result.next();
			Batch_No = result.getString("Batch_No");
		
	
			int availQuantity = result.getInt("Quantity");
		
			
			if (reqQuantity <= availQuantity) {
				availQuantity = availQuantity - reqQuantity;
				reqQuantity = 0;
				
				query = "update medicine_stock set Quantity =" + availQuantity
						+ " where Batch_no= '" + Batch_No
						+ " ' and Drug_ID = '" + drugId + "'";
				medicureconnection.executeQuery(query);
				query = "update prescription set Statuss='delivered' " +
						"where Prescription_ID='"+ prescriptionId + "'";
				medicureconnection.executeQuery(query);
			}

			return true;
		}

		return false;
	}
	
	/**
	 * This method get the drugid ,prescriptionId and requiredQuantity of 
	 * medicine and changes the status of Prescription to "delivered" 
	 * 
	 * @param drugid  – String 
	 * @param prescriptionId  – String 
	 * @param requiredDrugQuantity – int 
 	 * @return boolean  – true/false 
 	 */
	
	public boolean isChangeStatus(String drugId, String prescriptionId,
			int requiredDrugQuantity) throws SQLException {
		int drugQuantity = this.getDrugQuantity(drugId);
		int updateddrugQuantity;
		System.out.println(drugQuantity);
		if (drugQuantity >requiredDrugQuantity) {
			updateddrugQuantity = drugQuantity - requiredDrugQuantity;
			String query = "update prescription set Quantity="
					+ updateddrugQuantity + " where Drug_ID='" + drugId + "'";
			medicureconnection.updateQuery(query);
			query = "update prescription set Statuss='delivered' where " +
					"Prescription_ID='"+ prescriptionId + "'";
			medicureconnection.updateQuery(query);
	
			return true;
		} else 
		{
			return false;
		}

	}
}
