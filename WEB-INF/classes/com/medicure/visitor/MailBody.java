package com.medicure.visitor;

public class MailBody {
	
	static String From;
	static String Subject;
	static String Message;
	
	
	public static String getFrom() {
		return From;
	}
	public static void setFrom(String from) {
		From = from;
	}
	public static String getSubject() {
		return Subject;
	}
	public static void setSubject(String subject) {
		Subject = subject;
	}
	public static String getMessage() {
		return Message;
	}
	public static void setMessage(String message) {
		Message = message;
	}
}
