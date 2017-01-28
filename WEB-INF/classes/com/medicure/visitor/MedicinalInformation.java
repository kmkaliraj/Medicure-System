/*
 * @MedicinalInformation.java
 *
 * © Copyright IBM Corp. 2010
 * All Rights Reserved
 *
 * 
 */

package com.medicure.visitor;

/**
 * This MedicinalInformation class is for getting and setting values for
 * Medicine's Information
 * 
 * @version Aug 06, 2012
 **/

public class MedicinalInformation {
	static String Ingredients;
	static String Benefits;
	static String SideEffects;
	static String UsageInstructions;
	static String Price;
	public static String getIngredients() {
		return Ingredients;
	}
	
	/**
	 * This method sets the ingredients retrieved from Database to Ingredients
	 * @param Ingredients – ingredients of medicines
	 */
	public static void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}
	
	/**
	 * This method returns the Benefits retrieved from Database 
	  * @param - null
	 * @return string – Benefits of medicines
	 */
	public static String getBenefits() {
		return Benefits;
	}
	
	/**
	 * This method sets the benefits retrieved from Database to Benefits
	 * @param Benefits – benefits of medicines
	 */
	public static void setBenefits(String benefits) {
		Benefits = benefits;
	}
	
	/**
	 * This method returns the SideEffects retrieved from Database 
	  * @param - null
	 * @return string – SideEffects of medicines
	 */
	public static String getSideEffects() {
		return SideEffects;
	}
	
	/**
	 * This method sets the sideEffects retrieved from Database to SideEffects
	 * @param SideEffects – sideEffects of medicines
	 */
	public static void setSideEffects(String sideEffects) {
		SideEffects = sideEffects;
	}
	
	/**
	 * This method returns the UsageInstructions retrieved from Database 
	  * @param - null
	 * @return string – UsageInstructions of medicines
	 */
	public static String getUsageInstructions() {
		return UsageInstructions;
	}
	
	/**
	 * This method sets the usageInstructions retrieved from Database
	 *  to UsageInstructions
	 * @param UsageInstructions – usageInstructions of medicines
	 */
	public static void setUsageInstructions(String usageInstructions) {
		UsageInstructions = usageInstructions;
	}
	
	/**
	 * This method returns the Price retrieved from Database 
	  * @param - null
	 * @return string – Price of medicines
	 */
	public static String getPrice() {
		return Price;
	}
	
	/**
	 * This method sets the price retrieved from Database to Price
	 * @param Price – price of medicines
	 */
	public static void setPrice(String price) {
		Price = price;
	}
}
