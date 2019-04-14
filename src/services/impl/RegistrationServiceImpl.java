/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.CustomerDto;
import dataclasses.RegistrationDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.RegistrationService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author sreenath
 */
public class RegistrationServiceImpl implements RegistrationService {

    public RegistrationServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public String saveRegistrationDetails(RegistrationDto registrationDto) {
        String response = null;
        response = updateUserDetails(registrationDto);
        if (response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
            response = updateLoginCredentials(registrationDto);
        }
        return response;
    }

    private String updateUserDetails(RegistrationDto registrationDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateUserDetails(?,?,?,?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(10, Types.VARCHAR);

                statement.setInt(1, registrationDto.getUserId());
                statement.setString(2, registrationDto.getName());
                statement.setString(3, registrationDto.getCompanyName());
                statement.setString(4, registrationDto.getCompanyReg());
                statement.setString(5, registrationDto.getGst());
                statement.setString(6, registrationDto.getEmail());
                statement.setString(7, registrationDto.getPhoneNumber());
                statement.setString(8, registrationDto.getTin());
                statement.setString(9, registrationDto.getCompanyLogo());

                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(10, String.class);// out value

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public RegistrationDto getRegistrationDetails() {
        String query = Helper.getPropertyValue("User_Details_Query");
        ResultSet resultSet = DBHelper.readDataFromDb(query);
        RegistrationDto dto = new RegistrationDto();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    CustomerDto customerDto = new CustomerDto();
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String companyName = resultSet.getString("CompanyName");
                    String regNo = resultSet.getString("CompanyRegNo");
                    String gst = resultSet.getString("CompanyGST");
                    String email = resultSet.getString("Email");
                    String contactNo = resultSet.getString("MobileNo");
                    String companyTin = resultSet.getString("CompanyTin");
                    String logoPath = resultSet.getString("LogoPath");

                    dto.setUserId(id);
                    dto.setName(name);
                    dto.setCompanyName(companyName);
                    dto.setCompanyReg(regNo);
                    dto.setGst(gst);
                    dto.setEmail(email);
                    dto.setPhoneNumber(contactNo);
                    dto.setTin(companyTin);
                    dto.setCompanyLogo(logoPath);
                }

                ResultSet set = DBHelper.readDataFromDb("Select * from logindetails");
                if (set != null && set.next()) {
                    String userName = set.getString("UserName");
                    String password = set.getString("Password");
                    dto.setUserName(userName);
                    dto.setPassword(password);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return dto;
    }

    private String updateLoginCredentials(RegistrationDto registrationDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateLoginDetails(?,?,?)}");) {
                statement.registerOutParameter(3, Types.VARCHAR);

                statement.setString(1, registrationDto.getUserName());
                statement.setString(2, registrationDto.getPassword());

                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(3, String.class);// out value

            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

}
