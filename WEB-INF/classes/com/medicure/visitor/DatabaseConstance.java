/**
 * 
 * @DataBaseConstance.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */

package com.medicure.visitor;
/**
 * This DatabaseConstance class is used to get classname,url,usrname and 
 * password for database connection
 * 
 * @version Aug 07,2012
 **/

public interface DatabaseConstance {
	
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";

    public static final String URL = "jdbc:mysql://192.168.8.238:3306/clinic";

    public static final String USER = "root";

    public static final String PASSWORD = "ibm123";
}
