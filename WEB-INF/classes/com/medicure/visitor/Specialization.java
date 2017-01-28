package com.medicure.visitor;

import java.util.ArrayList;

public class Specialization {
	static ArrayList<String> SpecializationList;

	/**
	 * This method returns the list of Specializations
	 * @param - null
	 * @return string – list of Doctor's Specializations
	 */
	public static ArrayList<String> getSpecializationList() {
		return SpecializationList;
	}

	
	/**
	 * This method sets the list of Specializations retrieved from database to
	 * SpecializationList
	 * @param SpecializationList –list of Doctor's Specializations
	 */
	public static void setSpecializationList(ArrayList<String> specializationList) {
		System.out.println(specializationList);
		SpecializationList = specializationList;
	}
}
