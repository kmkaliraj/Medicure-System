package com.medicure.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {
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
		s.executeQuery("select count(*) from doctor");
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
	
	public void insertRow(String userid,String name,String password,String gender,String specialization,String qualification,String affiliation,String experience){
	try{
		System.out.println("inside insert");
		connectionTodb();
		
		String query1="insert into employee values (?,?,?,?,?,?,?,?)";
		PreparedStatement save_emp=con.prepareStatement(query1);
		
		
		save_emp.setString(1,userid);
		save_emp.setString(2,name);
		save_emp.setString(3,null);
		save_emp.setString(4,gender);
		save_emp.setString(5,"");
		save_emp.setString(6,"");
		save_emp.setString(7,null);
		save_emp.setString(8,"");
		save_emp.executeUpdate();
		
		String query="insert into doctor values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement save_doc=con.prepareStatement(query);
		
		
		save_doc.setString(1,userid);
		save_doc.setString(2,name);
		save_doc.setString(3,password);
		save_doc.setString(4,"");
		save_doc.setString(5,qualification);
		save_doc.setString(6,specialization);
		save_doc.setString(7,experience);
		save_doc.setString(8,affiliation);
		save_doc.setString(9,null);
		save_doc.executeUpdate();
		
		System.out.println("done");
	}
	catch(Exception e){
		System.out.println("Exception message :"+e.getLocalizedMessage());
	}
	}
	
	
	//Function to get rows from DataBase
	public ResultSet selectRow(String userid){
		ResultSet setresult = null;
	try{
		connectionTodb();
	s=con.createStatement();
	s.executeQuery("select * from doctor,employee where Doctor_ID like '"+userid+"' and Doctor_ID=Emp_ID");
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
			s=con.createStatement();
			s.executeUpdate("delete from prescriptionsend where Doctor_ID='"+userid+"'");
			s.executeUpdate("delete from doctor where Doctor_ID='"+userid+"'");
			s.executeUpdate("delete from workfor where Emp_ID='"+userid+"'");
			s.executeUpdate("delete from employee where Emp_ID='"+userid+"'");
			System.out.println("done");
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
		}
		
    //Function to update row
	    public void updateRow(String userid,String Experience,String Password,String hint,String Qualification,String time,String dob,long contact,String address,String join_date){
		   try{
			    System.out.println("inside update");
			    connectionTodb();
			    s=con.createStatement();
				String query="update doctor set Experience='"+Experience+"',Pwd='"+Password+"',Password_Hint='"+hint+"',Visiting_Time='"+time+"',Qualification='"+Qualification+"' where Doctor_ID='"+userid+"'";
			    s.executeUpdate(query);
			   
			    s.executeUpdate("update employee set Emp_DOB='"+dob+"',Contact_No='"+contact+"',Address='"+address+"',Join_Date='"+join_date+"' where Emp_ID='"+userid+"'");
			
				System.out.println("done");
				}
				catch(Exception e){
				System.out.println("Exception message :"+e.getLocalizedMessage());
				}
				}

}
