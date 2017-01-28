package com.medicure.ordermanagement.dao;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class IterateLowStockItems extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counts = 0;
	private BodyContent bodyContent;

	public IterateLowStockItems()
	{
		counts=DataBaseAccessBean.DrugId.size();
	}
	
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	/*public void setCounts(int counts) {
		this.counts = counts;
	}*/

	public int doStartTag() throws JspException {
		if (counts > 0) {
			return EVAL_BODY_TAG;
		} else {
			return SKIP_BODY;
		}
	}

	public int doEndTag() throws JspException {
		try {
			if (bodyContent != null) {
				bodyContent.writeOut(bodyContent.getEnclosingWriter());
				counts=0;
			}
		} catch (IOException e) {
		}
		
		return EVAL_PAGE;
	}

	public int doAfterBody() throws JspException {
		if (counts > 1) {
			counts--;
			return EVAL_BODY_TAG;
		} else {
			return SKIP_BODY;
		}
	}
}