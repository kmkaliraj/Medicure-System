/*
 * @DoctorInformation2.java
 *
 * © Copyright IBM Corp. 2010
 * All Rights Reserved
 *
 * 
 */
 
package com.medicure.visitor;

/**
 * This DoctorInformation2 class is for getting and setting values for
 * Doctor's Information
 * 
 * @version Aug 06, 2012
 **/
public class DoctorInformation2 {
	static String Doc_Id;
	static String Qualification;
	static String Specialization;
	static String Affiliation;
	static String Experience;
	public String getDoc_Id() {
		return Doc_Id;
	}
	
	/**
	 * This method sets the doc_Id retrieved from Database to Doc_Id
	 * @param Doc_Id – Id of the Doctor
	 */
	public void setDoc_Id(String doc_Id) {
		Doc_Id = doc_Id;
	}
	
	/**
	 * This method returns the Doctor's Qualification
	 * @param - null
	 * @return string – Doctor's Qualification
	 */
	public String getQualification() {
		return Qualification;
	}
	
	/**
	 * This method sets the qualification retrieved from Database 
	 * to Qualification
	 * @param Qualification – Doctor's Educational Qualification
	 */
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	
	/**
	 * This method returns the Doctor's Specialization
	 * @param - null
	 * @return string – Doctor's Specialization
	 */
	public String getSpecialization() {
		return Specialization;
	}
	
	/**
	 * This method sets the specialization retrieved from Database 
	 * to Specialization
	 * @param Specialization – Doctor's specialization
	 */
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	
	/**
	 * This method returns the Doctor's Affiliation
	 * @param - null
	 * @return string – Doctor's Affiliation
	 */
	public String getAffiliation() {
		return Affiliation;
	}
	
	/**
	 * This method sets the affiliation retrieved from Database 
	 * to Affiliation
	 * @param Affiliation – Doctor's affiliation
	 */
	public void setAffiliation(String affiliation) {
		Affiliation = affiliation;
	}
	
	/**
	 * This method returns the Doctor's Experience
	 * @param - null
	 * @return string – Doctor's Experience
	 */
	public String getExperience() {
		return Experience;
	}
	
	/**
	 * This method sets the experience retrieved from Database 
	 * to Experience
	 * @param Experience – Doctor's experience
	 */
	public void setExperience(String experience) {
		Experience = experience;
	}
}
