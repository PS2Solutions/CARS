/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractLaborChargeDetails;
import dataclasses.ContractLaborDto;
import dataclasses.DailyWageDto;
import dataclasses.ExtraPurchaseDetails;
import dataclasses.LaborDto;
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
import services.interfaces.DailyWageService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class DailyWageServiceImpl implements DailyWageService {

    @Override
    public List<ContractLaborChargeDetails> getContractLaborDetails() {
        List<ContractLaborChargeDetails> chargeDetailses = new ArrayList<ContractLaborChargeDetails>();
        try {

            CallableStatement statement = DBHelper.getDbConnection().prepareCall("{call GetContractAmountDetails()}");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                prepareContractSummaryDetails(resultSet, chargeDetailses);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DailyWageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chargeDetailses;
    }

    @Override
    public ReportContentDto getContractDetails(List<ContractLaborChargeDetails> chargeDetailses) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i = 0; i < chargeDetailses.size(); i++) {
            Vector<String> row = new Vector<>();
            row.add(chargeDetailses.get(i).getContractReference());
            row.add("" + chargeDetailses.get(i).getChargeSofar());
            row.add("" + chargeDetailses.get(i).getCollectedAmount());
            rowData.add(row);
        }
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Contract");
        columnNames.addElement("Amount so far");
        columnNames.addElement("Collected Amount");
        contentDto.setRowData(rowData);
        contentDto.setColumnNames(columnNames);
        return contentDto;
    }

    @Override
    public List<LaborDto> getLabors(int contractId) {
        List<LaborDto> laborDtos = new ArrayList<LaborDto>();
        try {

            CallableStatement statement = DBHelper.getDbConnection().prepareCall("{call GetContractLabors(?)}");
            statement.setInt("ContractId", contractId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                prepareLaborDetails(resultSet, laborDtos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DailyWageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laborDtos;
    }

    @Override
    public String updateDailyWage(List<DailyWageDto> dailyWageDtos) {
        String response = null;
        for (DailyWageDto dailyWageDto : dailyWageDtos) {
            try {
                try (
                        CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                                "{call UpdateLaborWageDetails( ?, ?, ?,?,?,?,?,?,?)}");) {
                    statement.registerOutParameter(9, Types.VARCHAR);
                    statement.setInt(1, dailyWageDto.getContractId());
                    statement.setInt(2, dailyWageDto.getLaborId());
                    statement.setString(3, dailyWageDto.getDate());
                    statement.setDouble(4, dailyWageDto.getWage());
                    statement.setDouble(5, dailyWageDto.getFa());
                    statement.setDouble(6, dailyWageDto.getTa());
                    statement.setDouble(7, dailyWageDto.getOa());
                    statement.setString(8, dailyWageDto.getRemark());
                    ResultSet resultSet = statement.executeQuery();//sql response
                    response = (String) statement.getObject(9, String.class);// out value
                    if (dailyWageDto.getPurchaseDetailses() != null && dailyWageDto.getPurchaseDetailses().size() > 0) {
                        for (ExtraPurchaseDetails details : dailyWageDto.getPurchaseDetailses()) {
                            try {
                                try (
                                        CallableStatement statement1 = DBHelper.getDbConnection().prepareCall(
                                                "{call UpdateExtraPurchaseDetails( ?, ?, ?,?,?,?,?)}");) {
                                    statement1.setInt(1, details.getContractId());
                                    statement1.setInt(2, details.getLaborId());
                                    statement1.setString(3, details.getBillNo());
                                    statement1.setString(4, details.getBillDate());
                                    statement1.setString(5, details.getMaterial());
                                    statement1.setInt(6, details.getQuantity());
                                    statement1.setDouble(7, details.getAmount());
                                    ResultSet resultSet1 = statement1.executeQuery();//sql response
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                return null;
                            }
                        }
                    }
                    if (response != null && !response.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
                        break;
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return response;
    }

    @Override
    public Vector<String> getLabors(List<LaborDto> laborDtos) {
        Vector<String> labors = new Vector<>();
        for (int i = 0; i < laborDtos.size(); i++) {
            labors.add(laborDtos.get(i).getName());
        }
        return labors;
    }

    private void prepareContractSummaryDetails(ResultSet resultSet, List<ContractLaborChargeDetails> chargeDetailses) {
        try {
            while (resultSet.next()) {
                ContractLaborChargeDetails chargeDetails = new ContractLaborChargeDetails();
                int id = resultSet.getInt("ContractID");
                String reference = resultSet.getString("ReferenceNo");
                double amount = resultSet.getDouble("Amount");
                double collectedAmount = resultSet.getDouble("CollectedAmount");
                chargeDetails.setContractId(id);
                chargeDetails.setContractReference(reference);
                chargeDetails.setCollectedAmount(collectedAmount);
                chargeDetails.setChargeSofar(amount);

                chargeDetailses.add(chargeDetails);
            }
        } catch (Exception ex) {

        }
    }

    private void prepareLaborDetails(ResultSet resultSet, List<LaborDto> laborDtos) {
        try {
            while (resultSet.next()) {
                LaborDto dto = new LaborDto();
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                int wage = resultSet.getInt("wage");
                dto.setId(id);
                dto.setName(name);
                dto.setWage(wage);
                laborDtos.add(dto);
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public String UpdateContractLabor(ContractLaborDto contractLaborDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateContractLaborDetails( ?, ?, ?)}");) {
                statement.registerOutParameter(3, Types.VARCHAR);
                statement.setInt(1, contractLaborDto.getContractId());
                statement.setInt(2, contractLaborDto.getLaborId());

                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(3, String.class);// out value
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return (response == null ? "Duplicate" : response);
    }

    public List<DailyWageDto> getDailyWages(int contractID) {
        List<DailyWageDto> dailyWages = new ArrayList<DailyWageDto>();
        ResultSet resultSet = DBHelper.readDataFromDb("Select LaborID, Wage, TA, FA from contractlaborchargedetails where ContractID = " + contractID);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    DailyWageDto dailyWageDto = new DailyWageDto();
                    int laborID = resultSet.getInt("LaborID");
                    double wage = resultSet.getDouble("Wage");
                    double ta = resultSet.getDouble("TA");
                    double fa = resultSet.getDouble("FA");

                    dailyWageDto.setLaborId(laborID);
                    dailyWageDto.setWage(wage);
                    dailyWageDto.setTa(ta);
                    dailyWageDto.setFa(fa);

                    dailyWages.add(dailyWageDto);
                }
            } catch (Exception ex) {

            }
        }
        return dailyWages;
    }

    @Override
    public List<ExtraPurchaseDetails> getExtraPurchaseDetails(int contractID) {
        List<ExtraPurchaseDetails> extraPurchases = new ArrayList<ExtraPurchaseDetails>();
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from extrapurchasedetails where ContractID = " + contractID);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    ExtraPurchaseDetails extraPurchaseDetails = new ExtraPurchaseDetails();
                    
                    int laborId = resultSet.getInt("LaborID");
                    double amount = resultSet.getDouble("Amount");
                    String billNo = resultSet.getString("BillNo");
                    String material = resultSet.getString("Material");
                    int quantity = resultSet.getInt("Quantity");
                    
                    extraPurchaseDetails.setLaborId(laborId);
                    extraPurchaseDetails.setAmount(amount);
                    extraPurchaseDetails.setBillNo(billNo);
                    extraPurchaseDetails.setMaterial(material);
                    extraPurchaseDetails.setQuantity(quantity);
  
                    extraPurchases.add(extraPurchaseDetails);
                }
            } catch (Exception ex) {

            }
        }
        return extraPurchases;
    }
}
