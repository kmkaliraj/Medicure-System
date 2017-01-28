/*
 * @DataAccessObject.java
 *
 * © Copyright IBM Corp. 2010
 * All Rights Reserved
 *
 * 
 */
 
package com.medicure.visitor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This DataAccessObject class is working for providing the database Access 
 * for the function on the server side.
 * 
 * @version Aug 06, 2012
 **/

public class DataAccessObject {
	DatabaseConnector databaseConnector = new DatabaseConnector();
	ResultSet resultSet;
	ResultSet resultSetTwo;
	ResultSet resultSetThree;
	/*Connection connection;
	Statement statement;
	
	String sql = "";
		public DataAccessObject()
		 {
			try{ 											
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection
				("jdbc:mysql://192.168.8.238:3306/clinic","root","ibm123");
				
			}
			catch(Exception e)
			{
				 Exception handling 
				e.printStackTrace();
			}
		 }
		 */
		 /**
		 * This method retrieves medicine information from database.
		 * @param name – name of medicine 
		 * @return string – empty string
		 */

		public String medicineInformation(String name){
			 try{
				 MedicinalInformation medicinalInformation = 
				 new MedicinalInformation();
/*				 Statement infoOne = connection.createStatement();
				 Statement infoTwo = connection.createStatement();
				 ResultSet resultOne = infoOne.executeQuery
				 ("select * from medicines where Drug_Name='"+name+"'");*/
				 String str = "select * from medicines where Drug_Name='"+name+"'";
				 resultSet = databaseConnector.executeQuery("str");
				 double price;
				 String id = "";
				 if(resultSet.next()){
					 /*If medicine name is present in database*/
					 id= resultSet.getString("Drug_ID");
					 /*ResultSet resultTwo = infoTwo.executeQuery
					 ("select min(Market_Price) from medicine_stock where" +
					 "Drug_ID ='"+id+"'");*/
					 String query = "select min(Market_Price) from medicine_stock where" +
							 "Drug_ID ='"+id+"'";
					 resultSetTwo = databaseConnector.executeQuery(query);
					 if(resultSetTwo.next()){
						 /*checking for availability of medicine*/
						 if(resultSetTwo.getString(1) != null){
							 /* When requested medicine stock is available */
							 medicinalInformation.setPrice
							 (resultSetTwo.getString(1));
						 }
						 else{
							 /*when requested medicine stock is not available*/
							 medicinalInformation.setPrice("NOT AVAILABLE");
						
							
						 }
					}
					 
					 medicinalInformation.setIngredients
					 (resultSet.getString("Ingredients"));
					 medicinalInformation.setUsageInstructions
					 (resultSet.getString("Usge"));
					 medicinalInformation.setBenefits
					 (resultSet.getString("Benefits"));
					 medicinalInformation.setSideEffects
					 (resultSet.getString("SideEffects"));
				 }
				 databaseConnector.closeConnection();
			 }catch(Exception e){
				 /* Exception handling */
				 System.out.println(e);
			 }
			 return "";
		 }
		 
		 /**
		 * This method searches medicine name in database and
		 * set the names to bean.
		 * @param name – search string of medicine 
		 * @return string - empty string
		 */

		 
		 public String medicineName(String name){
			 try{
				 MedicineName medicineName = new MedicineName();
				 medicineName.setSearch
				 ("Sorry There is no Medicine with this Name");
				 TreeSet<String> mName = new TreeSet<String>();

				 if(name.length() > 1){
					 	/* String search for medicine name entered 
					 	 *in Search box */
					 String query="select Drug_Name from employee where Drug_Name like " +
						"'"+name+"%'";
					 resultSet = databaseConnector.executeQuery(query);
					 
					}
					else{
						/* Search for Medicine names by clicking on an 
						* alphabet hyperlink */
						 String query="select Drug_Name from medicines where Drug_Name like " +
									"'"+name+"%'";
								resultSet =  databaseConnector.executeQuery(query);
					}
					while(resultSet.next()){
						/* Add the retrieved Medicine names to TreeSet */
						medicineName.setSearch("");
						mName.add(resultSet.getString("Drug_Name"));
					}
					medicineName.setName(mName);
					databaseConnector.closeConnection();
			 }catch(Exception e){
				 /* Exception Handling */
				 e.printStackTrace();
				 
			 }
			 
			 return "";
		 }

		 /**
		  * This method retrieves the doctor information from the database.
		  * @param name – name of the doctor
		  * @return string - empty string
		  */

		 public String doctorInformation(String name){
			 try{
				 DoctorInformation2 doctorInformation = 
				 new DoctorInformation2();
				 String query = "select * from doctor where Doctor_Name = '"+name+"'";
				 resultSet = databaseConnector.executeQuery(query);
				 if(resultSet.next()){
					 /* Check for the availability of Doctor name in database */
					 doctorInformation.setDoc_Id(resultSet.getString("ID"));
					 doctorInformation.setAffiliation
					 (resultSet.getString("Affiliation"));
					 doctorInformation.setExperience
					 (resultSet.getString("Experience"));
					 doctorInformation.setQualification
					 (resultSet.getString("Qualification"));
					 doctorInformation.setSpecialization
					 (resultSet.getString("Specialization"));
				 }
			 }catch(Exception e){
				 /* Exception handling */
				 System.out.println(e);
			 }
			 return "";
		 }
		 
		 /**
		  * This method retrieves the speciality information about the doctors.
		  * @return string - empty string
		  */

		 
		 public String getSpeciality(){
			 try{
				 Specialization specialization = new Specialization();
				 ArrayList<String> specializationList 
				 = new ArrayList<String>();
				 String query = "select Specialization from doctor group by Specialization" ;
				 resultSet = databaseConnector.executeQuery(query);
				 while(resultSet.next()){
					 /* Adds the retrieved Specializations to ArrayList */
					 specializationList.add
					 (resultSet.getString("Specialization"));
				 }
				 specialization.setSpecializationList(specializationList);
			 }catch(Exception e){
				 System.out.println(e);
			 }
			
			 return "";
		 }
		 
		 public String getOutboxData(String id)
			{	
				Outbox outboxBean = new Outbox();	//Bean class instantiation
				ArrayList<String> outboxContent=new ArrayList<String>();
			
				
				
				try{
					//Query for accessing the low stock items
					String sql="select Msg_ID,Sender,Receiver,Sub,Date from email" +
							" where Sender = '"+id+"' and Status like '%"+id+"%' order by Date desc";
					
					resultSet = databaseConnector.executeQuery(sql);
					while(resultSet.next())	//Resultant Records are Traversed
					{
						String rowInbox =resultSet.getString("Msg_ID")+"__"+resultSet.getString("Receiver")+"__"+
						resultSet.getString("Sub")+"__"+resultSet.getString("Date");
						System.out.println(rowInbox);
						
						outboxContent.add(rowInbox);
					}
					outboxBean.setOutboxContent(outboxContent)	;
				}
				catch(Exception e)
				{
					e.printStackTrace();		//printing the exception trace
				}
				return "";
			}
		 public String getEmailid(String id){
			 String mailid="";
			 try{
				 
				 
				 resultSet = databaseConnector.executeQuery("select Email_ID from employee where  Emp_ID= '"+id+"' ");
				 resultSetTwo = databaseConnector.executeQuery("select Email_ID from supplier where Sup_ID = '"+id+"' ");
				 resultSetThree = databaseConnector.executeQuery("select Email_ID from patient where Patient_ID = '"+id+"' ");
				 if(resultSet.next() ){
					 mailid = resultSet.getString(1);
				 }
				 if(resultSetTwo.next()){
					 mailid = resultSetTwo.getString(1);						 
				 }
				 if(resultSetThree.next()){
					 mailid = resultSetThree.getString(1);
				 }
				
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			return mailid; 
			
		 }
		 public String mailCheck(String mailid){
			 CheckMailId check = new CheckMailId();

			 try{
				 String[] str = mailid.split(";");
				 for(int i=0;i<str.length;i++){
				 resultSet = databaseConnector.executeQuery("select Email_ID from employee where Email_ID = '"+str[i]+"' ");
				 resultSetTwo = databaseConnector.executeQuery("select Email_ID from supplier where Email_ID = '"+str[i]+"' ");
				 resultSetThree = databaseConnector.executeQuery("select Email_ID from patient where Email_ID = '"+str[i]+"' ");
				 if(resultSet.next() || resultSetTwo.next() || resultSetThree.next()){
					 check.setStatus("");
				 }
				 else{
					 check.setStatus("INVALID MAIL ID");
					 break;
					 
				 }
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			return ""; 
		 }
		 
		 
		 public String getInboxData(String id)
			{	
				Inbox inboxBean = new Inbox();	//Bean class instantiation
				ArrayList<String> inboxContent=new ArrayList<String>();
			
				
				
				try{
					//Query for accessing the low stock items
					String sql="select Msg_ID,Sender,Receiver,Sub,Date from email" +
							" where Receiver = '"+id+"' and Status like '%"+id+"%' order by Date desc";
					
					resultSet = databaseConnector.executeQuery(sql);
					while(resultSet.next())	//Resultant Records are Traversed
					{
						String rowInbox =resultSet.getString("Msg_ID")+"__"+resultSet.getString("Sender")+"__"+
						resultSet.getString("Sub")+"__"+resultSet.getString("Date");
						System.out.println(rowInbox);
						
						inboxContent.add(rowInbox);
					}
					inboxBean.setInboxContent(inboxContent);	
				}
				catch(Exception e)
				{
					e.printStackTrace();		//printing the exception trace
				}
				return "";
			}
		 
		 public String getDraftData(String id)
			{	
				Drafts draftBean = new Drafts();	//Bean class instantiation
				ArrayList<String> draftContent=new ArrayList<String>();
				String draft = "drafts"+id;
				
				
				try{
					//Query for accessing the low stock items
					String sql="select Msg_ID,Sender,Receiver,Sub,Date from email" +
							" where Sender like '"+draft+"' order by Date desc";
					
					resultSet = databaseConnector.executeQuery(sql);
					while(resultSet.next())	//Resultant Records are Traversed
					{
						String rowInbox =resultSet.getString("Msg_ID")+"__"+resultSet.getString("Receiver")+"__"+
						resultSet.getString("Sub")+"__"+resultSet.getString("Date");
						draftContent.add(rowInbox);
					}
					System.out.println(draftContent);
					draftBean.setDraftContent(draftContent);	
				}
				catch(Exception e)
				{
					e.printStackTrace();		//printing the exception trace
				}
				return "";
			}
		 
		 public String Composer(String sender, String receiver,String cc, String subject, String body){
				try{
					String status = sender+";"+receiver+";"+cc;
					if(subject==null || subject==""){
						subject="No Subject";
					}
					/*Statement updatemail = connection.createStatement();
					updatemail.executeUpdate("insert into email values(NULL,+'"+sender+"','"+
							receiver+"','"+subject+"','"+body+"' , SYSDATE(),'"+status+"')");*/
					String str = "insert into email values(NULL,+'"+sender+"','"+
							receiver+"','"+subject+"','"+body+"' , SYSDATE(),'"+status+"')";
					databaseConnector.updateQuery(str);
					System.out.println("updated");
					databaseConnector.closeConnection();
				}catch(Exception e){
					System.out.println(e);
				}
				return "";
			}
		 public String delete(String id, String mailid){
			 try{
				 
				 resultSet = databaseConnector.executeQuery("select Status from email where Msg_ID='"+id+"'");
				 String newstatus="";
				 if(resultSet.next()){
					 String[] mid = resultSet.getString(1).split(";");
					 if(mid.length==1){
						 System.out.println("ONLY ONE");
						 databaseConnector.updateQuery("delete from email where Msg_Id='"+id+"'");
					 }
					 else{
						 System.out.println("MORE THAN ONE");
						 for(int i=0;i<mid.length;i++){
							 System.out.println(mid[i]);
							 System.out.println(mailid);
							 if(mid[i].equals(mailid)){
								 continue;
							 }
							 else{
								 newstatus = newstatus+mid[i]+";";
								 System.out.println(newstatus);
								
							 }
						 }
						 databaseConnector.updateQuery("update email set Status='"+newstatus+"' where Msg_ID='"+id+"'");
					 }
				 }
			 }catch(Exception e){
				 System.out.println(e);
			 }
			 return "";
		 }
		 
		 public String getBodyData(String id){
				try{
					resultSet =databaseConnector.executeQuery("select * from email where Msg_ID = '"+id+"'");
					MailBody mailBody = new MailBody();
					if(resultSet.next()){
						mailBody.setFrom(resultSet.getString("Receiver"));
						mailBody.setSubject(resultSet.getString("Sub"));
						mailBody.setMessage(resultSet.getString("Body"));
						System.out.println(resultSet.getString("Body"));
					}
				}catch(Exception e){
					System.out.println(e);
				}
				return "";
			}
		 
		 public String Discard(String id){
			 try{
			 databaseConnector.updateQuery("delete from email where Msg_ID ='"+id+"'");
			 }catch(Exception e){
				 System.out.println(e);
			 }
			 return "";
		 }
		 
		 public String getOutBodyData(String id){
				try{
					resultSet = databaseConnector.executeQuery("select * from email where Msg_ID = '"+id+"'");
					MailOutboxBody mailBody = new MailOutboxBody();
					if(resultSet.next()){
						String str = resultSet.getString("Status").replace(resultSet.getString("Sender"), "");
						str = str.replace(resultSet.getString("Receiver"), "");
						mailBody.setCc(str);
						mailBody.setTo(resultSet.getString("Receiver"));
						mailBody.setSubject(resultSet.getString("Sub"));
						mailBody.setMessage(resultSet.getString("Body"));
						System.out.println(resultSet.getString("Body"));
					}
				}catch(Exception e){
					System.out.println(e);
				}
				return "";
			}
		 /**
		  * This method gets the list of doctor names
		  * @param search - search string
		  * @param speciality - search criteria string
		  * @return string - empty string
		  */
		 
		 
		 public String getDoctorName(String search, String speciality){
			 DoctorName DoctorName = new DoctorName();
			 ArrayList<String> docName = new ArrayList<String>();
			 DoctorName.setName("Sorry no such name exists");
			  try{
				boolean check = false;
				if(!speciality.equalsIgnoreCase("*"))
					check = true;
				if(search.length()>1 && check){
					/* String search for name entered in the Search box */
					resultSet = databaseConnector.executeQuery
					("select Doctor_Name from doctor where Doctor_Name like " +
					"'%"+search+"%'");	
				}
				else if(search.length() == 1 && check){
					/* Search for Doctor names by clicking on an 
					* alphabet hyperlink */
					resultSet = databaseConnector.executeQuery
					("select Doctor_Name from doctor where Doctor_Name like " +
					"'"+search+"%'");
				}
				else{
					/* Search for Doctor names based on their Specialization*/
					resultSet = databaseConnector.executeQuery
					("select Doctor_Name from doctor where Specialization = " +
					"'"+search+"'");
				}
				while(resultSet.next()){
					/* Adds the retrieved Doctor Names to an ArrayList */
					DoctorName.setName("");
					docName.add(resultSet.getString("Doctor_Name"));
					System.out.println(resultSet.getString("Doctor_Name"));
					
				}
				DoctorName.setDocName(docName);
			}catch(Exception e){
				/* Exception handling */
				e.printStackTrace();
			}
			 return "";
		 }

}

