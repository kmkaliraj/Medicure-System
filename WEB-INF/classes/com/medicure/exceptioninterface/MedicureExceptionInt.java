package com.medicure.exceptioninterface;

public interface MedicureExceptionInt {
	static final String sqlMessage = "Problem Encountered with Data manipulation";
	static final String classNotFoundMessage = "The method or class cannot be accessed";
	static final String nullPointerMessage = "Value not found";
	static final String arithmeticMessage = "Invalid arithmetic operation";
	static final String numberFormatMessage = "The value is not in proper format or datatype";
	static final String mySQLNonTransientMessage = "Problem occured while connecting with database";
	static final String indexOutOfBoundsMessage = "Invalid parameters or size mismatch";
	static final String arrayOutOfBoundsMessage = "Array size mismatch with the accessed value";
}
