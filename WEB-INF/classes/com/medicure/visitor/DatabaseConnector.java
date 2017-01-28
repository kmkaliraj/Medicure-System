package com.medicure.visitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @DataBaseConnector.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */

public class DatabaseConnector implements DatabaseConstance{
    
    Connection connection=null;
    Statement statement=null;
    ResultSet resultset=null;
    String sql = "";
    
    /**
     * Initializes the Database connection
     * @throws ClassNotFoundException
     */
    public  DatabaseConnector(){
        try {
        	Class.forName(DatabaseConstance.CLASSNAME);
            connection = DriverManager.getConnection(DatabaseConstance.URL,
            		DatabaseConstance.USER, DatabaseConstance.PASSWORD);
        } catch (Exception e) {
            System.out.println("Error: Connection cannot be created ");
        }
    }

    /**
     * To close the DataBase Connection
     */
    public void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Connection cannot be closed ");
        }
    }

    /**
     * Performs select queries in the DataBase and returns the Resultant
     * ResultSet
     * @param sql
     * @return ResultSet object
     */
    public ResultSet executeQuery(String sql) {
        try {
            statement = connection.createStatement();
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e) {
            System.out.println("Error: Query cannot be executed");
        }
        return null;
    }

    /**
     * Performs update and insert queries in the DataBase
     * @param sql
     */
    public void updateQuery(String sql) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: update query cannot be executed");
        }
    }


    

}
