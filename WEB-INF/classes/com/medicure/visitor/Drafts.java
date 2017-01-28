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
 * This Inbox class is working for providing Employee's received Mails
 * from the DataAccessObject to the JSP File
 * @version Aug 6, 2012-cleaned up warnings
 **/


public class Drafts {
	static ArrayList<String> DraftContent;
	public ArrayList<String> getDraftContent() {
		return DraftContent;
	}

	public void setDraftContent(ArrayList<String> draftContent) {
		DraftContent = draftContent;
	}
}
