package com.medicure.visitor;

public class MailOutboxBody {
	static String Cc;

	static String To;
	static String Subject;
	static String Message;
	public static String getCc() {
		return Cc;
	}
	public static void setCc(String cc) {
		Cc = cc;
	}
	
	public static String getTo() {
		return To;
	}
	public static void setTo(String to) {
		To = to;
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
