/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ComboContentDto;
import dataclasses.ContractDashboardReportDto;
import dataclasses.ContractDto;
import dataclasses.ContractPaymentDto;
import dataclasses.CustomerDto;
import dataclasses.ReportContentDto;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;
import services.interfaces.ContractService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author sreenath
 */
public class ContractServiceImpl implements ContractService {

    @Override
    public ReportContentDto getContractDetails(List<ContractDto> contractDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (ContractDto contractDto : contractDtos) {
            Vector<String> row = new Vector<>();
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
                statement.setString(4, contractDto.getEndDate());
                statement.setDouble(5, 0);
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
        try {
            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call GetContractDetails()}");
            ResultSet resultSet = statement.executeQuery();//sql response
            while (resultSet.next()) {
                ContractDto dto = new ContractDto();
                dto.setId(resultSet.getInt("ID"));
                dto.setTitle(resultSet.getString("title"));
                dto.setContractRefNo(resultSet.getString("Reference Number"));
                dto.setStartDate(resultSet.getString("Start Date"));
                dto.setTotalAmount(resultSet.getDouble("Collected Amount"));
                dto.setLastCollectionDate(resultSet.getString("Collected Date"));
                dto.setAgrementReference(resultSet.getString("Agreement Reference"));

                contractDtos.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return contractDtos;
    }

    @Override
    public Vector<String> getContractsNames(Vector<ComboContentDto> comboContentDtos) {
        Vector<String> contractDtos = new Vector<>();
        for (ComboContentDto ccd : comboContentDtos) {
            contractDtos.add(ccd.getName());
        }
        return contractDtos;
    }

    @Override
    public Vector<ComboContentDto> getContractNames() {
        String query = "SELECT ContractID,Title FROM `quotations` WHERE ContractID > 0";
        Vector<ComboContentDto> contractDtos = new Vector<>();

        ResultSet resultSet = DBHelper.readDataFromDb(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    ComboContentDto ccd = new ComboContentDto();
                    int id = resultSet.getInt("ContractID");
                    String title = resultSet.getString("Title");
                    ccd.setId(id);
                    ccd.setName(title);
                    contractDtos.add(ccd);
                }

            } catch (Exception ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contractDtos;
    }

    public boolean closeContract(int contractId, String endDate) {
        try {
            String query = "update contracts set EndDate = ? where ID = ?";
            PreparedStatement preparedStmt = DBHelper.getDbConnection().prepareStatement(query);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dateStr = formatter.parse(endDate);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            preparedStmt.setDate(1, dateDB);
            preparedStmt.setInt(2, contractId);
            preparedStmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public List<ContractDto> getClosedContracts() {
        List<ContractDto> contractDtos = new ArrayList<ContractDto>();

        ResultSet resultSet = DBHelper.readDataFromDb("Select * from contracts where EndDate is not NULL");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    ContractDto dto = new ContractDto();
                    dto.setId(resultSet.getInt("ID"));
                    dto.setContractRefNo(resultSet.getString("ReferenceNo"));

                    contractDtos.add(dto);

                }
            } catch (Exception ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return contractDtos;
    }

    @Override
    public void saveContractPayments(ContractPaymentDto contractPaymentDto) {
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call  UpdateContractPayment ( ?,?,?,?)}");) {

                statement.setInt(1, contractPaymentDto.getContractId());
                statement.setString(2, contractPaymentDto.getRemark());
                statement.setString(3, Helper.getCurrentMysqlFormattedDate());
                statement.setDouble(4, contractPaymentDto.getAmount());

                statement.executeQuery();//sql response
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
