/**
 * 
 * @DataBaseAccess.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */

package com.medicure.ordermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.medicure.ordermanagement.bean.DataBaseAccessBean;

/**
 * 
 * Separate methods to access the order Database
 * 
 */
public class DataBaseAccess {

    Connection connection;
    Statement statement;
    ResultSet resultset;
    String sql = "";
    DataBaseAccessBean dbab;

    /**
     * 
     * Initializes the Database connection
     * 
     * @throws ClassNotFoundException
     */
    public DataBaseAccess() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://192.168.8.238/clinic", "root", "ibm123");
            dbab = new DataBaseAccessBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Does the function of retrieving the low stock items from the medicine
     * Stock table
     * 
     * @return
     */
    public String getLowStockItems() {

        ArrayList<String> DrugId = new ArrayList<String>();
        ArrayList<String> DrugName = new ArrayList<String>();
        ArrayList<Integer> Ordered = new ArrayList<Integer>();
        ArrayList<Integer> Quantity = new ArrayList<Integer>();
        try {

            /* Query for retrieving the low stock items */
            sql = "select m.Drug_ID drugid,m.Drug_Name drugname," +
            		"s.quantity available,p.quantity required from " +
            		"( select Drug_ID,sum(Quantity) quantity from " +
            		"medicine_stock " +
            		"group by Drug_ID) s,(select Drug_ID,Sum(Quantity)" +
            		" quantity from prescription where statuss='waiting'" +
            		" group by Drug_ID) p,medicines m where " +
            		"m.Drug_ID = s.Drug_ID " +
            		"and m.Drug_ID = p.Drug_ID and m.Flag = 'red'";
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);

            /* Retrieves the low stock items and adds it to ArrayList */
            while (resultset.next()) {
                DrugId.add(resultset.getString("drugid"));
                DrugName.add(resultset.getString("drugname"));
                Ordered.add(resultset.getInt("required"));
                Quantity.add(resultset.getInt("available"));

            }

            /* Setting values to the DataBaseAccessBean */
            dbab.setDrugId(DrugId);
            dbab.setDrugName(DrugName);
            dbab.setRequiredQuantity(Ordered);
            dbab.setAvailableQuantity(Quantity);

            getSupplierNames();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Returns supplier names from supplier table
     * 
     */
    public void getSupplierNames() {

        ArrayList<String> SupplierNames = new ArrayList<String>();
        ArrayList<String> SupplierId = new ArrayList<String>();
        try {

            /* Query to retrieve supplier data */
            sql = "select Sup_Name,Sup_ID from supplier";
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);

            /* Adds data retrieved to ArrayList */
            while (resultset.next()) {
                SupplierNames.add(resultset.getString("Sup_Name"));
                SupplierId.add(resultset.getString("Sup_ID"));
            }

            /* Adds values to the DataBaseAccessBean */
            dbab.setSupplierNames(SupplierNames);
            dbab.setSupplierID(SupplierId);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Updates the order table
     * 
     * @param DrugId
     * @param DrugName
     * @param Quantity
     */
    public void updateOrderTable(ArrayList<String> DrugId,
            ArrayList<String> DrugName, ArrayList<Integer> Quantity) {
        System.out.println("inside update");
        try {

            /* Auto generating OrderID */
            String PreviousOrderID = getOrderID();
            System.out.println("Previous Order ID " + PreviousOrderID);
            String NewOrderID = "";
            NewOrderID = "OR"
                    + ((Integer.parseInt(PreviousOrderID.substring(2)) + 1));
            System.out.println("new Order ID : " + NewOrderID);

            /*
             * To insert order into the Order Table and updating OrderID in the
             * counter table
             */
            for (int counter = 0; counter < DrugId.size(); counter++) {
                sql = "insert into ordertable values('" + NewOrderID + "','"
                        + DrugId.get(counter) + "','" + DrugName.get(counter)
                        + "'," + Quantity.get(counter) + ",'waiting')";
                statement.executeUpdate(sql);
                sql = "update counter set OrderID='" + NewOrderID
                        + "' where OrderID='" + PreviousOrderID + "'";
                statement.executeUpdate(sql);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Getting the Order ID from the counter table */
    public String getOrderID() {
        try {
            sql = "select OrderID from counter";
            statement = connection.createStatement();
            resultset = statement.executeQuery(sql);

            /* Getting the OrderID */
            if (resultset.next()) {
                return resultset.getString("OrderID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    /* Sends the notification mail to the supplier */
    public void sendMail(String Sender, String Receiver, String Subject,
            String Mail, String Status) {

        try {
            sql = "insert into email(Sender,Receiver,Sub,Body,Status) values('"
                    + Sender + "','" + Receiver + "','" + Subject + "','"
                    + Mail + "','" + Status + "')";

            statement = connection.createStatement();
            statement.executeUpdate(sql);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
