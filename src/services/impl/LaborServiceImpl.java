/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import dataclasses.UploadHelperDto;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.DateUtil;
import services.interfaces.LaborService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class LaborServiceImpl implements LaborService {

    @Override
    public List<LaborDto> getLabor() {
        List<LaborDto> laborDtos = new ArrayList<LaborDto>();
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from labors");
        if (resultSet != null) {
            prepareLaborDetails(resultSet, laborDtos);
        }
        return laborDtos;
    }

    private void prepareLaborDetails(ResultSet resultSet, List<LaborDto> laborDtos) {
        try {
            while (resultSet.next()) {
                LaborDto laborDto = new LaborDto();
                int id = resultSet.getInt("ID");
                String laborID = resultSet.getString("LaborID");
                String name = resultSet.getString("Name");
                String designation = resultSet.getString("Designation");
                String identityType = resultSet.getString("IdentityType");
                String identityNo = resultSet.getString("IdentityNo");
                String address1 = resultSet.getString("Address1");
                String address2 = resultSet.getString("Address2");
                String phoneNumber = resultSet.getString("PhoneNumber");
                int wage = resultSet.getInt("Wage");
                String joiningDate = resultSet.getString("JoiningDate");
                String resignationDate = resultSet.getString("ResignationDate");
                Boolean isActive = resultSet.getBoolean("IsActive");
                laborDto.setId(id);
                laborDto.setLaborId(laborID);
                laborDto.setName(name);
                laborDto.setDesignation(designation);
                laborDto.setIdentityType(identityType);
                laborDto.setIdentityNumber(identityNo);
                laborDto.setAddress1(address1);
                laborDto.setAddress2(address2);
                laborDto.setPhoneNumber(phoneNumber);
                laborDto.setWage(wage);
                laborDto.setJoinDate(Helper.getFormattedDate(joiningDate));
                laborDto.setResignDate(Helper.getFormattedDate(resignationDate));
                laborDto.setIsActive(isActive);
                laborDtos.add(laborDto);
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public ReportContentDto getLaborDetails(List<LaborDto> laborDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i = 0; i < laborDtos.size(); i++) {
            Vector<String> row = new Vector<>();
            row.add(laborDtos.get(i).getLaborId());
            row.add(laborDtos.get(i).getName());
            row.add(laborDtos.get(i).getDesignation());
            row.add(laborDtos.get(i).getPhoneNumber());
            row.add("" + laborDtos.get(i).getWage());
            row.add(laborDtos.get(i).isIsActive() ? "Active" : "InActive");
            rowData.add(row);
        }
        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Id");
        columnNames.addElement("Name");
        columnNames.addElement("Designation");
        columnNames.addElement("Contact #");
        columnNames.addElement("Wage");
        columnNames.addElement("Status");
        contentDto.setRowData(rowData);
        contentDto.setColumnNames(columnNames);
        return contentDto;
    }

    @Override
    public String saveLabor(LaborDto laborDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateLaborDetails( ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(14, Types.VARCHAR);

                statement.setInt(1, laborDto.getId());
                statement.setString(2, laborDto.getLaborId());
                statement.setString(3, laborDto.getName());
                statement.setString(4, laborDto.getDesignation());
                statement.setString(5, laborDto.getIdentityType());
                statement.setString(6, laborDto.getIdentityNumber());
                statement.setString(7, laborDto.getAddress1());
                statement.setString(8, laborDto.getAddress2());
                statement.setString(9, laborDto.getPhoneNumber());
                statement.setInt(10, laborDto.getWage());
                statement.setString(11, laborDto.getJoinDate());
                statement.setString(12, laborDto.getResignDate());
                statement.setBoolean(13, laborDto.isIsActive());
                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(14, String.class);// out value
                return response;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<LaborDto> getLabor(String empolyeeId, String name) {
        List<LaborDto> laborDtos = new ArrayList<LaborDto>();
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from labors where LaborID = '" + empolyeeId + "' OR Name = '" + name + "'");
        if (resultSet != null) {
            prepareLaborDetails(resultSet, laborDtos);
        }
        return laborDtos;
    }

    @Override
    public boolean uploadExcel(List<UploadHelperDto> helperDtos) {
        boolean response = true;
        try {
            for (UploadHelperDto excelContent : helperDtos) {
                if (helperDtos.indexOf(excelContent) > 0) {
                    LaborDto laborDto = new LaborDto();
                    laborDto.setId(0);
                    laborDto.setLaborId(excelContent.getColumnValues().get(0));
                    laborDto.setName(excelContent.getColumnValues().get(1));
                    laborDto.setDesignation(excelContent.getColumnValues().get(2));
                    laborDto.setIdentityType(excelContent.getColumnValues().get(3));
                    laborDto.setIdentityNumber(excelContent.getColumnValues().get(4));
                    laborDto.setAddress1(excelContent.getColumnValues().get(5));
                    laborDto.setAddress2(excelContent.getColumnValues().get(6));
                    laborDto.setPhoneNumber(excelContent.getColumnValues().get(7));
                    String[] arrWage = excelContent.getColumnValues().get(8).trim().split("\\.");
                    laborDto.setWage(Integer.parseInt(arrWage[0]));
                    double dJoinDate = Double.parseDouble(excelContent.getColumnValues().get(9).trim());
                    Date javaDate = DateUtil.getJavaDate(dJoinDate);
                    laborDto.setJoinDate(new SimpleDateFormat("yyyy-MM-dd").format(javaDate));
                    laborDto.setResignDate(null);
                    laborDto.setIsActive(true);
                    String resp = saveLabor(laborDto);
                    if (!resp.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
                        response = false;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            response = false;
        }
        return response;
    }

    @Override
    public int getLaborCount(int contractId) {
        int numberRow = 0;
        try {
            ResultSet resultSet = DBHelper.readDataFromDb("select count(*) from contractlabordetails where ContractID=" + contractId);

            if (resultSet != null && resultSet.next()) {
                numberRow = resultSet.getInt(1);
            }
        } catch (Exception ex) {

        }
        return numberRow;
    }

    @Override
    public String getLaborName(int laborId) {
        ResultSet resultSet = DBHelper.readDataFromDb("Select Name from labors where LaborID = " + laborId);
        try {
            if (resultSet != null && resultSet.next()) {
                return resultSet.getString("Name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaborServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }
}
