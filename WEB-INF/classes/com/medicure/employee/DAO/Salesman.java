package com.medicure.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Salesman {
	
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
		s.executeQuery("select count(*) from salesman");
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
	public void insertRow(String userid,String password,String name,String gender){
	try{
		System.out.println("inside insert");
		connectionTodb();
		//create table Salesman(Sman_ID varchar(10)  primary key, Sman_Name varchar(20), Pwd varchar(15), 
		//Password_Hint varchar(10));
		
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
		
		String query="insert into salesman values (?,?,?,?)";
		PreparedStatement save_one=con.prepareStatement(query);
		save_one.setString(1,userid);
		save_one.setString(2,name);
		save_one.setString(3,password);
		save_one.setString(4,"");
		save_one.executeUpdate();
		System.out.println("done");
	}
	catch(Exception e){
		System.out.println("Exception message :"+e.getLocalizedMessage());
	}
	}
	
	
	//Function to get rows from DataBase
	public ResultSet selectRow(String username){
		ResultSet setresult = null;
	try{
		connectionTodb();
		//System.out.println("inside select");
	s=con.createStatement();
	s.executeQuery("select * from salesman,employee where Sman_ID like '"+username+"' and Sman_ID=Emp_ID");
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
			//delete from employeelogin where u_id='D-100' stockupdate
			s.executeUpdate("delete from quotationlog where Sman_ID='"+userid+"'");
			s.executeUpdate("delete from stockupdate where Sman_ID='"+userid+"'");
			s.executeUpdate("delete from salesman where Sman_ID='"+userid+"'");
			s.executeUpdate("delete from workfor where Emp_ID='"+userid+"'");
			s.executeUpdate("delete from employee where Emp_id='"+userid+"'");
			System.out.println("done");
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
		}
		
    //Function to update row
	    public void updateRow(String userid,String Password,String hint,String dob,long contact,String address,String join_date){
		   try{
			    System.out.println("inside update");
			    connectionTodb();
			    s=con.createStatement();
				String query="update doctor set Pwd='"+Password+"',Password_Hint='"+hint+"' where Sman_ID='"+userid+"'";
			    s.executeUpdate(query);
			   
			    s.executeUpdate("update employee set Emp_DOB='"+dob+"',Contact_No='"+contact+"',Address='"+address+"',Join_Date='"+join_date+"' where Emp_ID='"+userid+"'");
			
				System.out.println("done");
				}
				catch(Exception e){
				System.out.println("Exception message :"+e.getLocalizedMessage());
				}
				}


}
