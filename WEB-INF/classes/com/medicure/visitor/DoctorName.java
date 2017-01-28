/*
 * @DoctorName.java
 *
 * © Copyright IBM Corp. 2010
 * All Rights Reserved
 *
 * 
 */
package com.medicure.visitor;
import java.util.ArrayList;
/**
 * This DoctorName class is for getting and setting values for
 * Doctor Names to generate a list of Doctor Names in alphabetical order
 * 
 * @version Aug 06, 2012
 **/
public class DoctorName {
	static ArrayList<String> DocName;
	static String Name;

	/**
	 * This method returns the Doctor's Name
	 * @param - null
	 * @return string – Doctor's Name
	 */
	public static String getName() {
		return Name;
	}

	/**
	 * This method sets the Doctor's name retrieved from Database 
	 * to Name
	 * @param Name – Doctor's Name 
	 */
	public static void setName(String name) {
		Name = name;
	}

	
	/**
	 * This method returns the list of Doctor's Name in alphabetical order
	 * @param - null
	 * @return ArrayList<string> – list of Doctor's names
	 */
	public ArrayList<String> getDocName() {
		System.out.println(DocName);
		return DocName;
	}

	/**
	 * This method sets the list of Doctor's name retrieved from Database 
	 * to DocName
	 * @param DocName – Doctor's Name 
	 */
	public void setDocName(ArrayList<String> docName) {
		DocName= docName;
		
	}
}
