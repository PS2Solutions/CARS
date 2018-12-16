/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.CustomerDto;
import dataclasses.ReportContentDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.CustomerService;
import utils.DBHelper;

/**
 *
 * @author shinu.k
 */
public class CustomerServiceImpl implements CustomerService {

    private String updateSP = "UpdateCustomerDetails";

    public CustomerServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public ReportContentDto getCustomerDetails(List<CustomerDto> customerDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (CustomerDto customerDto : customerDtos) {
            Vector<String> row = new Vector<>();
            row.add(customerDto.getName());
            row.add("" + customerDto.getPhoneNumber());
            row.add(customerDto.getEmail());
            row.add(Integer.toString(customerDto.getTotalContract()));
            row.add(Integer.toString(customerDto.getActiveContract()));
            row.add(customerDto.getQuotes());
            row.add(customerDto.getCompanyName());
            row.add(customerDto.getAddress1());
            row.add(customerDto.getAddress2());

            rowData.add(row);
        }

        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Customer");
        columnNames.addElement("Phone");
        columnNames.addElement("Email");
        columnNames.addElement("Total Contract");
        columnNames.addElement("Active Contract");
        columnNames.addElement("Quotes");
        contentDto.setRowData(rowData);
        contentDto.setColumnNames(columnNames);
        return contentDto;
    }

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        ResultSet resultSet = null;
        return updateCustomer(customerDto);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from customers");
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    CustomerDto customerDto = new CustomerDto();
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String companyName = resultSet.getString("CompanyName");
                    String address1 = resultSet.getString("Address1");
                    String address2 = resultSet.getString("Address2");
                    String email = resultSet.getString("Email");
                    String contactNo = resultSet.getString("ContactNo");
                    String regNo = resultSet.getString("RegistrationNo");
                    
                    customerDto.setId(id);
                    customerDto.setName(name);
                    customerDto.setCompanyName(companyName);
                    customerDto.setAddress1(address1);
                    customerDto.setAddress2(address2);
                    customerDto.setEmail(email);
                    customerDto.setPhoneNumber(contactNo);
                    customerDto.setCompanyRegNo(regNo);
                    customerDtos.add(customerDto);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return customerDtos;
    }

    private String updateCustomer(CustomerDto customerDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateCustomerDetails( ?, ?, ?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(9, Types.VARCHAR);

                statement.setInt(1, customerDto.getId());
                statement.setString(2, customerDto.getName());
                statement.setString(3, customerDto.getCompanyRegNo());
                statement.setString(4, customerDto.getPhoneNumber());
                statement.setString(5, customerDto.getCompanyName());
                statement.setString(6, customerDto.getEmail());
                statement.setString(7, customerDto.getAddress1());
                statement.setString(8, customerDto.getAddress2());
                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(9, String.class);// out value
                return response;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
