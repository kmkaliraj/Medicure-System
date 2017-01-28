package com.medicure.dao;

//import com.medicure.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {


	Connection connection;
	Statement statement;

	String sql = "";
	String sql1 = "";

	public Dao() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.8.238:3306/clinic", "root", "ibm123");

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/** Get Batch no */
	public int BatchNumber()
	{
		int B_No=0;
		
		try
		{
			
			statement = connection.createStatement();
			String sql3 = "select BNo from counter ";
			
				statement.executeQuery(sql3);
				ResultSet rs = statement.getResultSet();
				while(rs.next())
				{
				B_No=Integer.parseInt(rs.getString("BNo"));	
				}
			
				
				String sql4 = "update counter set BNo = "+(++B_No)+ "";
				statement.executeUpdate(sql4);
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e.getMessage());
		}
		
		
		return B_No;
		
		
	}

	/** Setting value to Quotation log Table after retrieving value 
	 * from the Database */
	public String setValueToQuotationLog(String qlSalesmanId, String qlSupplierId, 
			String qlQuotationId, String qlDrugId, String Man_Date ) {
		
		try
		{
			//Inserting values to Quotation Log Table
			sql="insert into quotationlog values(?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, qlSalesmanId);
			pst.setString(2, qlSupplierId);
			pst.setString(3, qlQuotationId);
			pst.setString(4, qlDrugId);
			pst.setString(5, Man_Date);
			pst.executeUpdate();
			
			
			//Composing the Message to the Corresponding Supplier
			/*String Sender = "",Receiver = "",Cc = "",Subject = "", Body = "";
			Sender = qlSupplierId;
			Receiver = qlSupplierId;
			Subject = "Your Quotation is Approved";
			data.Composer(Sender, Receiver, Cc, Subject, Body);
			*/
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:"+e.getMessage());
		
		}
		return "";
	}
		
	
	/** Setting value to Medicine Stock Table after selecting the
	 *  Quotation from Quotation Log Table */
	public String setValueToMedicineStock(int bno, String qlDrugId,
			String Man_Date, String Ex_Date, double qlRetPrice,
			double qlMarketPrice, int qlQuantity)
	{
		
		try
		{
			
			//Inserting Values to Medicine Stock Table
			String BatchNo="B"+bno;
			sql1="insert into medicine_stock values(?,?,?,?,?,?,?)";
			PreparedStatement pst1 = connection.prepareStatement(sql1);
			pst1.setString(1, BatchNo);
			pst1.setString(2, qlDrugId);
			pst1.setString(3, Man_Date);
			pst1.setString(4, Ex_Date);
			pst1.setDouble(5, qlRetPrice);
			pst1.setDouble(6, qlMarketPrice);
			pst1.setInt(7, qlQuantity);
			
			pst1.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:"+e.getMessage());
			
		}
		return "";
	}
		
	public void deleteContents(String qID) {

		try {
			String sql2 = "delete from quotation where Q_ID=?";
			PreparedStatement pst2 = connection.prepareStatement(sql2);
			pst2.setString(1, qID);
			pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	}


