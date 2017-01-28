package com.medicure.employee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Receptionists {

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
		s.executeQuery("select count(*) from receptionists ");
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
		//create table Receptionists(Resp_ID varchar(10) primary key, Resp_Name varchar(20), Pwd varchar(15),
		//Password_Hint varchar(10), Shift_Time date);
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
		
		String query="insert into receptionists values (?,?,?,?,?)";
		PreparedStatement save_one=con.prepareStatement(query);
		save_one.setString(1,userid);
		save_one.setString(2,name);
		save_one.setString(3,password);
		save_one.setString(4,"");
		save_one.setString(5,null);
		save_one.executeUpdate();
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
		//System.out.println("inside select");
	s=con.createStatement();
	s.executeQuery("select * from receptionists,employee where Resp_ID like '"+userid+"' and Resp_ID=Emp_ID");
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
			//delete from employeelogin where u_id='D-100'
			s.executeUpdate("delete from receptionists where Resp_ID='"+userid+"'");
			s.executeUpdate("delete from workfor where Emp_ID='"+userid+"'");
			s.executeUpdate("delete from employee where Emp_ID='"+userid+"'");
			System.out.println("done");
		}
		catch(Exception e){
			System.out.println("Exception message :"+e.getLocalizedMessage());
		}
		}
		
    //Function to update row
	    public void updateRow(String userid,String Password,String hint,String time,String dob,long contact,String address,String join_date){
		   try{
			    System.out.println("inside update");
			    connectionTodb();
			    s=con.createStatement();
				String query="update receptionists set Pwd='"+Password+"',Password_Hint='"+hint+"',Shift_Time='"+time+"' where Doctor_ID='"+userid+"'";
			    s.executeUpdate(query);
			   
			    s.executeUpdate("update employee set Emp_DOB='"+dob+"',Contact_No='"+contact+"',Address='"+address+"',Join_Date='"+join_date+"' where Emp_ID='"+userid+"'");
			
				System.out.println("done");
				}
				catch(Exception e){
				System.out.println("Exception message :"+e.getLocalizedMessage());
				}
				}

}
