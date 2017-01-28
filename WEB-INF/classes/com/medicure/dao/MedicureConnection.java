package com.medicure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicureConnection {
    
    /**
     * 
     * @DataBaseAccessMethod.java
     * COPYRIGHT IBM Corporation 2012
     * 
     */
    
    Connection connection=null;
    Statement statement=null;
    ResultSet resultset=null;
    String sql = "";
    
    /**
     * Initializes the Database connection
     * @throws ClassNotFoundException
     */
    public MedicureConnection(){
        try {
            Class.forName(DataBaseConstants.CLASSNAME);
            connection = DriverManager.getConnection(DataBaseConstants.URL,
                    DataBaseConstants.USER, DataBaseConstants.PASSWORD);
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
     * Performs update  queries in the DataBase
     * @param sql
     */
    public void updateQuery(String sql) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error: UpdateQuery cannot be executed");
        }
    }
    /**
     * Performs insert queries in the DataBase
     * @param sql
     */
    public int insertQuery(String sql) {
        int result = 0;
        try {
            statement = connection.createStatement();
            result = statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    

}
