/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractDto;
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
import services.interfaces.ContractService;
import utils.DBHelper;

/**
 *
 * @author sreenath
 */
public class ContractServiceImpl implements ContractService{

    @Override
    public ReportContentDto getContractDetails(List<ContractDto> contractDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for(ContractDto contractDto : contractDtos) {
            Vector<String> row = new Vector<>();
            
            //row.add(contractDto.getCaption());
           // row.add(contractDto.getStartDate());
           // row.add(contractDto.getEndDate());
           // row.add(contractDto.getStatus());
           
            rowData.add(row);
        }
        
         Vector<String> columnNames = new Vector<String>();
         columnNames.addElement("Contract caption");
         columnNames.addElement("Start date");
         columnNames.addElement("End date");
         columnNames.addElement("Status");

         contentDto.setRowData(rowData);
         contentDto.setColumnNames(columnNames);
         return contentDto;
    }

    @Override
    public int saveContract(ContractDto contractDto) {
        int contractId = updateContract(contractDto);
        return contractId;
    }
    
    private int updateContract(ContractDto contractDto) {
        int contractId = 0;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call  UpdateContractDetails ( ?,?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(8, Types.INTEGER);

                statement.setInt(1, contractDto.getId());
                statement.setString(2, contractDto.getContractRefNo());
                statement.setString(3, contractDto.getStartDate());
                statement.setDate(4, contractDto.getEndDate());
                statement.setDouble(5, contractDto.getTotalAmount());
                statement.setString(6, contractDto.getLastCollectionDate());
                statement.setString(7, contractDto.getAgrementReference());
                
                statement.executeQuery();//sql response
                contractId = statement.getObject(8, Integer.class);// out value
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contractId;
    }
    
    @Override
    public List<ContractDto> getContracts() {
        List<ContractDto> contractDtos = new ArrayList<ContractDto>();
        
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from contracts");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    String endDate = resultSet.getString("EndDate");
                    if(endDate == null || endDate.isEmpty()) {
                        ContractDto dto = new ContractDto();
                        dto.setId(resultSet.getInt("ID"));
                        dto.setContractRefNo(resultSet.getString("ReferenceNo"));
                        dto.setStartDate(resultSet.getString("StartDate"));
                        dto.setTotalAmount(resultSet.getDouble("CollectedAmount"));
                        dto.setLastCollectionDate(resultSet.getString("LastCollectionDate"));
                        dto.setAgrementReference(resultSet.getString("AgrementReference"));
                        
                        contractDtos.add(dto);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return contractDtos;
    }

    @Override
    public Vector<String> getContractsNames() {
        String query = "SELECT Title FROM `quotations` WHERE ContractID > 0" ;
        Vector<String> contractDtos = new Vector<>();
        
        ResultSet resultSet = DBHelper.readDataFromDb(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    String title = resultSet.getString("Title");
                    contractDtos.add(title);
                 }
                
            } catch (Exception ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contractDtos;
    }
    
}
