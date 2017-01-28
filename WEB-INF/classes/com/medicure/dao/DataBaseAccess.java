/**
 * 
 * @DataBaseAccess.java
 * COPYRIGHT IBM Corporation 2012
 * 
 */

package com.medicure.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.medicure.ordermanagement.bean.DataBaseAccessBean;
import com.medicure.ordermanagement.bean.QuoteBean;

/**
 * Separate methods to access the order Database
 */
public class DataBaseAccess {

    MedicureConnection medicureconnection = null;
    DataBaseAccessBean databaseaccessbean = null;
    QuoteBean quoteBean = null;
    Statement statement = null;
    ResultSet resultset = null;
    String sql = "";

    public DataBaseAccess() {
        medicureconnection = new MedicureConnection();
        databaseaccessbean = new DataBaseAccessBean();
        quoteBean = new QuoteBean();
    }

    /**
     * Does the function of retrieving the low stock items from the medicine
     * Stock table
     * @return Bean Object
     */
    public DataBaseAccessBean getLowStockItems() {

        ArrayList<String> DrugId = new ArrayList<String>();
        ArrayList<String> DrugName = new ArrayList<String>();
        ArrayList<Integer> Ordered = new ArrayList<Integer>();
        ArrayList<Integer> Quantity = new ArrayList<Integer>();
        try {

            /* Query for retrieving the low stock items */
            resultset = medicureconnection
                    .executeQuery(DataBaseConstants.LOW_STOCK_ITEMS_SQL);

            /* Retrieves the low stock items and adds it to ArrayList */
            while (resultset.next()) {
                DrugId.add(resultset.getString("drugid"));
                DrugName.add(resultset.getString("drugname"));
                Ordered.add(resultset.getInt("required"));
                Quantity.add(resultset.getInt("available"));
            }

            /* Setting values to the DataBaseAccessBean */
            databaseaccessbean.setDrugId(DrugId);
            databaseaccessbean.setDrugName(DrugName);
            databaseaccessbean.setRequiredQuantity(Ordered);
            databaseaccessbean.setAvailableQuantity(Quantity);

            getSupplierNames();
            medicureconnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: Low Stock Items cannot be " +
            		"retrieved from Database");;
        }
        return databaseaccessbean;
    }

    /**
     * Returns supplier names from supplier table
     */
    public void getSupplierNames() {

        ArrayList<String> SupplierNames = new ArrayList<String>();
        ArrayList<String> SupplierId = new ArrayList<String>();
        try {

            /* Query to retrieve supplier data */
            resultset = 
               medicureconnection
                         .executeQuery(DataBaseConstants.SUPPLIER_DETAILS_SQL);
 
            /* Adds data retrieved to ArrayList */
            while (resultset.next()) {
                SupplierNames.add(resultset.getString("Sup_Name"));
                SupplierId.add(resultset.getString("Sup_ID"));
            }

            /* Adds values to the DataBaseAccessBean */
            databaseaccessbean.setSupplierNames(SupplierNames);
            databaseaccessbean.setSupplierID(SupplierId);
            medicureconnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: Supplier Names cannot be retrieved ");
        }
    }

    /**
     * Updates the order table
     * 
     * @param DrugId
     * @param DrugName
     * @param Quantity
     */
    public void updateOrderTable(ArrayList<String> DrugId,
            ArrayList<String> DrugName, ArrayList<Integer> Quantity) {
        try {

            /* Auto generating OrderID */
            String PreviousOrderID = getOrderID();
            String NewOrderID = "";
            NewOrderID = "OR"
                    + ((Integer.parseInt(PreviousOrderID.substring(2)) + 1));

            /*
             * To insert order into the Order Table and updating OrderID in the
             * counter table
             */
            for (int counter = 0; counter < DrugId.size(); counter++) {
                sql = "insert into ordertable values(" + "'"
                        + NewOrderID.trim() + "','"
                        + DrugId.get(counter).trim() + "','"
                        + DrugName.get(counter).trim() + "',"
                        + Quantity.get(counter) + ",'waiting')";
                medicureconnection.updateQuery(sql);

                /* Update the Latest OrderID to counter Table */
                sql = "update counter set OrderID='" + NewOrderID
                        + "' where OrderID='" + PreviousOrderID + "'";
                medicureconnection.updateQuery(sql);
            }
            medicureconnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: Order Table cannot be updated ");;
        }
    }

    /**
     * Returns the latest OrderID from the Order Table
     * 
     * @return Order_ID
     */
    public String getOrderID() {
        try {
            resultset = medicureconnection
                    .executeQuery(DataBaseConstants.ORDER_ID_SQL);
            if (resultset.next()) {
                return resultset.getString("OrderID");
            }
        } catch (Exception e) {
            System.out.println("Error: Order ID cannot be retrieved ");
        }
        return "";
    }

    /**
     * Sends the mail to the particular Receiver one at a time
     * @param Sender
     * @param Receiver
     * @param Subject
     * @param Mail
     * @param Status
     */
    public void sendMail(String Sender, String Receiver, String Subject,
            String Mail, String Status) {
        try {
            sql = "insert into email(Sender,Receiver,Sub,Body,Status) values"
                    + "('" + Sender + "','" + Receiver + "','" + Subject
                    + "','" + Mail + "','" + Status + "')";
            medicureconnection.updateQuery(sql);
            medicureconnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: Mail cannot be sent...");
        }

    }
    
    public boolean isNotDuplicateQuotation(String supplierID, String orderID) {

        ResultSet check = medicureconnection
                .executeQuery("Select * from quotation where Sup_ID='"
                        + supplierID + "' and Order_ID='" + orderID + "'");
        try {
            if (check.next()) {
                return false;
            } else {
                return true;
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        medicureconnection.closeConnection();
        return false;
    }

    public QuoteBean getOrderDetails(String orderID) {

        List<String> drugs = new ArrayList<String>();
        List<String> drugsId = new ArrayList<String>();
        List<String> quantity = new ArrayList<String>();
        String query = "select * from ordertable where Order_ID='" + orderID
                + "'";

        ResultSet rs1 = medicureconnection.executeQuery(query);

        /* Retrieving order details from Order table */
        try {
            while (rs1.next()) {
                String id = rs1.getString("Drug_ID");
                String name = rs1.getString("Drug_Name");
                String qty = rs1.getString("Quantity");
                drugsId.add(id);
                drugs.add(name);
                quantity.add(qty);
            }
            quoteBean.setDrugs(drugs);
            quoteBean.setDrugsId(drugsId);
            quoteBean.setQuantity(quantity);
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
        return quoteBean;
    }

    public int insertIntoQuotationTable(List<String> param) {

        String drugID, drugName, drugQty, orderID, supplierID;
        drugID = drugName = drugQty = null;
        int count = 0;
        int successCount = 0;

        System.out.println(param);

        orderID = param.get(count++);
        supplierID = param.get(count++);

        try {
            ResultSet rs = medicureconnection
                    .executeQuery("select * from ordertable where Order_ID='"
                            + orderID + "'");

            ResultSet id = medicureconnection
                    .executeQuery(DataBaseConstants.QUOTATION_ID_QUERY);

            String newQID = "", prevQID = "";

            while (id.next()) {
                prevQID = id.getString("QuotationID");
            }

            /* Retrieving drug details from Order table */
            while (rs.next()) {

                newQID = "Q" + ((Integer.parseInt(prevQID.substring(1))) + 1);
                String insertQuery = "insert into quotation values(";

                drugID = rs.getString("Drug_ID");
                drugName = rs.getString("Drug_Name");

                drugQty = rs.getString("Quantity");

                insertQuery += "'" + newQID + "','" + drugID + "','" + drugName
                        + "','" + Integer.valueOf(drugQty) + "','"
                        + Double.valueOf(param.get(count))
                        + "','nil','waiting','" + supplierID + "' ,'" + orderID
                        + "')";

                successCount += medicureconnection.insertQuery(insertQuery);
                count++;
                prevQID = newQID;
                medicureconnection.insertQuery("update counter set QuotationID='" + newQID
                        + "' where QuotationID='" + prevQID + "'");
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return successCount;
    }
}
