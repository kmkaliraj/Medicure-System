/*
 * @MedicureException.java
 * copyright IBM India Pvt Ltd.
 * All rights reserved.
 */

package com.medicure.exception;


import com.medicure.exceptioninterface.*;
/*
 * This class handles the all the exception thrown by the subclasses
 */
public class MedicureException extends Exception implements MedicureExceptionInt{

	/**
	 * default serial version of Exception Class
	 */
	private static final long serialVersionUID = 1L;
	
	Exception exception;
	
	public MedicureException(){
		
	}
	
	public String getMessage(){
		String message=exception.getMessage();
		return message;
	}

}
