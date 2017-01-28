/*
 * @Inbox.java
 *
 * © Copyright IBM Corp. 2012
 * All Rights Reserved
 *
 * 
 */
package com.medicure.visitor;

import java.util.ArrayList;

/**
 * This Outbox class is working for providing Employee's received Mails
 * from the DataAccessObject to the JSP File
 * @version Aug 6, 2012-cleaned up warnings
 **/

public class Outbox {
	private static ArrayList<String> OutboxContent;
	
	public ArrayList<String> getOutboxContent() {
		System.out.println(OutboxContent);
		return OutboxContent;
	}

	public void setOutboxContent(ArrayList<String> outboxContent) {
		OutboxContent = outboxContent;
	}
}
