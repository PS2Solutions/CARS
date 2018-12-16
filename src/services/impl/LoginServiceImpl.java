/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LoginDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.LoginService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class LoginServiceImpl implements LoginService {

    public LoginServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public String validateLogin(LoginDto loginDto) {
          String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call ValidateLogin(?,?,?)}");) {
                statement.registerOutParameter(3, Types.VARCHAR);

                statement.setString(1, loginDto.getUsername());
                statement.setString(2, loginDto.getPassword());

                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(3, String.class);// out value
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public LoginDto getUserCredentials() {
        return null;
    }

    @Override
    public boolean isUserRegistered() {
        try {
            String query = Helper.getPropertyValue("User_Details_Query");
            ResultSet resultSet = DBHelper.readDataFromDb(query);
            if (resultSet != null && resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
