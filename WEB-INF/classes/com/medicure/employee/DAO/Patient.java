package com.medicure.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patient {

	
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
		s.executeQuery("select count(*) from patient");
		ResultSet r=s.getResultSet();
		
		while(r.next()){
			 counter = r.getInt("count(*)");
			
		}
		con.close();
		System.out.println("inside select(out)");
		
		} catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
	
	return counter;
	
	}
	
	
	//Function to insert row
	
	public void insertRow(String userid,String occupation,long contact,String name,String password,String father_name,String marital_status,String spouse_name){
	try{
		System.out.println("inside insert");
		connectionTodb();
		//create table	Patient(Patient_ID varchar(10)  primary key,  Patient_Name varchar(20),  
		//Pwd varchar(15), Password_Hint varchar(10),  Marital_Status varchar(5), Spouse_Name varchar(20) , 
		//Father_Name varchar(20), Occupation varchar(10), Contact long, Address varchar(50), DOB date );
		String query="insert into patient values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement save_p=con.prepareStatement(query);
		
		
		save_p.setString(1,userid);
		save_p.setString(2,name);
		save_p.setString(3,password);
		save_p.setString(4,"");
		save_p.setString(5,marital_status);
		save_p.setString(6,spouse_name);
		save_p.setString(7,father_name);
		save_p.setString(8,occupation);
		save_p.setLong(9,contact);
		save_p.setString(10,"");
		save_p.setString(11,null);
		save_p.setString(12,"");
		save_p.executeUpdate();
		
		
		System.out.println("done");
		con.close();
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
		s=con.createStatement();
		s.executeQuery("select * from patient where Patient_ID='"+userid+"'");
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
			//delete row from Patient using userid
			
			s.executeUpdate("delete from patientrecord where patient_id='"+userid+"'");
			s.executeUpdate("delete from prescription where patient_id='"+userid+"'");
			s.executeUpdate("delete from patient where patient_id='"+userid+"'");
			System.out.println("done");
			con.close();
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
	}
		
    //Function to update row
	    public void updateRow(String userid,String password,String hint,String occ,String contact,String address){
		   try{
			    System.out.println("inside update");
			    connectionTodb();
			    s=con.createStatement();
				String query="update patient set Pwd='"+password+"',Password_Hint='"+hint+"',Occupation='"+occ+"',Contact='"+contact+"',Address='"+address+"' where Patient_ID='"+userid+"'";
			    s.executeUpdate(query);
				System.out.println("done");
				con.close();
				}
				catch(Exception e){
				System.out.println("Exception message :"+e.getLocalizedMessage());
				}
				}

}
