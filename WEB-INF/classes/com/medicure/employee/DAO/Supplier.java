package com.medicure.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Supplier {
	
	Connection con;
	Statement s;
	
	//DATABASE Connection
	void connectionTodb(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://192.168.8.238:3306/clinic", "root", "ibm123");
	
	} catch(Exception e){
		System.out.println("Exception message :"+e.getLocalizedMessage());
	}
	}
	
	//Function to get row count
	public int getrowCount(){
		int counter=0;
	try{
		connectionTodb();
		System.out.println("inside select");
		s=con.createStatement();
		s.executeQuery("select count(*) from supplier");
		ResultSet r=s.getResultSet();
		
		while(r.next()){
			 counter = r.getInt("count(*)");
			
		}
		System.out.println("inside select(out)");
		
		} catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
	return counter;
	
	}
	
	
	//Function to insert row
	public void insertRow(String userid,String password,String Name){
	try{
		System.out.println("inside insert");
		connectionTodb();
		String query="insert into supplier values (?,?,?,?,?)";//---incomplete
		PreparedStatement save_one=con.prepareStatement(query);
		save_one.setString(1,userid);
		save_one.setString(2,Name);
		save_one.setString(3,password);
		save_one.setString(4,"");
		save_one.setString(5,"");
		
		save_one.executeUpdate();
		System.out.println("done");
	}
	catch(Exception e){
		System.out.println("Exception message :"+e.getLocalizedMessage());
	}
	}
	
	
	//Function to select rows from DataBase
	public ResultSet selectRow(String userid){
		ResultSet setresult = null;
		try{
			connectionTodb();
			System.out.println("inside select");
			s=con.createStatement();
			//Query to get row values from Supplier table
			s.executeQuery("select * from supplier where sup_ID='"+userid+"'");
			setresult=s.getResultSet();
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
		return setresult;
	}
	
	
	
	//Function to delete row
	public void deleteRow(String userid){
		try{
			System.out.println("inside delete");
			connectionTodb();
			//delete row values from Supplier table
			//suppliermedicine orderlog quotation quotationlog

			s.executeUpdate("delete from suppliermedicine where Sup_ID='"+userid+"'");
			s.executeUpdate("delete from orderlog where Sup_ID='"+userid+"'");
			s.executeUpdate("delete from quotation where Sup_ID='"+userid+"'");
			s.executeUpdate("delete from quotationlog where Sup_ID='"+userid+"'");
			s.executeUpdate("delete from supplier where Sup_ID='"+userid+"'");
			
			System.out.println("done");
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
	}

		
		//Function to update row
		public void updateRow(String userid,String password,String hint){
			try{
				System.out.println("inside update");
				connectionTodb();
				s=con.createStatement();
				//update supplier table
				String query="update supplier set Pwd='"+password+"',Password_Hint='"+hint+
						"' where sup_ID='"+userid+"'";
				s.executeUpdate(query);
				System.out.println("done");
			}
			catch(Exception e){
				System.out.println("Exception message :"+e.getLocalizedMessage());
			}
		}

}
