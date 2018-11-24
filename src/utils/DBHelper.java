/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHINU
 */
public class DBHelper {

    private static Connection dbConnection;
    private static Statement statement;
    private static ResultSet resultSet;

    static {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Driver could not be loaded : " + cnf);
        }

    }

    public static void connectToDb() {
        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection(Constants.connURL, Constants.dbUser, Constants.dbPass);
                statement = dbConnection.createStatement();
            } catch (SQLException ex) {
                System.out.println("DBHelper : Exe :" + ex.getMessage());

            }
        }
    }

    public static ResultSet readDataFromDb(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            resultSet = null;
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public static int updateDataToDb(String query) {
        int rowId = -1;
        try {
            rowId = statement.executeUpdate(query);
        } catch (SQLException ex) {
            rowId = -1;
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowId;
    }
     public static ResultSet readDataUsingSP(String spName,String params) {
        try {
            String query = String.format("{CALL %s(%s)}",spName,params);
            CallableStatement stmt = dbConnection.prepareCall(query);	
            resultSet = stmt.executeQuery();
        } catch (SQLException ex) {
            resultSet = null;
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
}
