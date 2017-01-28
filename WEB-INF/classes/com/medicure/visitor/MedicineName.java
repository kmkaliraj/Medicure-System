/*
 * @MedicineName.java
 *
 * © Copyright IBM Corp. 2010
 * All Rights Reserved
 *
 * 
 */
package com.medicure.visitor;

import java.util.TreeSet;

/**
 * This MedicineName class is for getting and setting values for
 * Medicine Names 
 * 
 * @version Aug 06, 2012
 **/
public class MedicineName {
	static TreeSet<String> Name;
	static String Search;

	/**
	 * This method returns the search String for medicine 
	 * @param - null
	 * @return string – Medicine search String
	 */
	public static String getSearch() {
		return Search;
	}

	/**
	 * This method sets the search String to Search variable
	 * @param Name – Search string for medicine Name 
	 */
	public static void setSearch(String search) {
		Search = search;
	}

	/**
	 * This method returns the list of Medicine names in alphabetical order 
	 * @param - null
	 * @return string – list of Medicine names
	 */
	public static TreeSet<String> getName() {
		return Name;
	}

	/**
	 * This method sets the list of Medicine names retrieved from database to
	 * Name
	 * @param Name –List of medicine names 
	 */
	public static void setName(TreeSet<String> name) {
		Name = name;
	}

}
