/*
 * @CheckMailId.java
 *
 * © Copyright IBM Corp. 2012
 * All Rights Reserved
 *
 * 
 */

package com.medicure.visitor;

/**
 * This CheckMailId class is used to get and send the status for database
 * 
 * @version Aug 07, 2012 
 **/

public class CheckMailId {
	static String Status;

	/**
	 * This method returns status
	 * @return String – status 
	 */

	public static String getStatus() {
		return Status;
	}
	
	/**
	 * This method sets the status 
	 * @param status – status from the database
	 */

	public static void setStatus(String status) {
		Status = status;
	}
}
