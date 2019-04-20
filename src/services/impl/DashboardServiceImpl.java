/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractDashboardReportDto;
import dataclasses.LaborWageDashboardReportDto;
import dataclasses.ReportContentDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.DashboardService;
import utils.DBHelper;

/**
 *
 * @author shinu.k
 */
public class DashboardServiceImpl implements DashboardService {

    @Override
    public ReportContentDto getContractReport() {
        try {
            Vector<ContractDashboardReportDto> dashboardReportDtos = new Vector<ContractDashboardReportDto>();
            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call GetContractLastMonthReport()}");

            ResultSet resultSet = statement.executeQuery();//sql response
            while (resultSet.next()) {
                String referenceNo = resultSet.getString("Reference No");
                String startDate = "";
                if (resultSet.getString("Start Date") != null) {
                    startDate = resultSet.getString("Start Date");
                }
                float amount = resultSet.getFloat("Amount");
                float collectedAmount = resultSet.getFloat("Collected Amount");
                ContractDashboardReportDto dto = new ContractDashboardReportDto();
                dto.setContractRefNo(referenceNo);
                dto.setStartDate(startDate);
                dto.setCollectedAmount(Float.toString(collectedAmount));
                dto.setTotalAmount(Float.toString(amount));
                dashboardReportDtos.add(dto);
            }

            ReportContentDto contentDto = new ReportContentDto();
            Vector<Vector> rowData = new Vector<Vector>();

            for (int i = 0; i < dashboardReportDtos.size(); i++) {
                Vector<String> row = new Vector<>();
                row.add(dashboardReportDtos.get(i).getContractRefNo());
                row.add(dashboardReportDtos.get(i).getStartDate());
                row.add(dashboardReportDtos.get(i).getTotalAmount());
                row.add(dashboardReportDtos.get(i).getCollectedAmount());
                rowData.add(row);
            }
            Vector<String> columnNames = new Vector<String>();
            columnNames.addElement("Contract");
            columnNames.addElement("Start Date");
            columnNames.addElement("Amount");
            columnNames.addElement("Collected Amount");
            contentDto.setRowData(rowData);
            contentDto.setColumnNames(columnNames);
            return contentDto;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ReportContentDto getLaborWageReport() {
        try {
            Vector<LaborWageDashboardReportDto> reportDtos = new Vector<LaborWageDashboardReportDto>();
            ReportContentDto contentDto = new ReportContentDto();
            Vector<Vector> rowData = new Vector<Vector>();

            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call GetLabourReport()}");

            ResultSet resultSet = statement.executeQuery();//sql response
            while (resultSet.next()) {
                String labourID = resultSet.getString("Labour");
                String name = resultSet.getString("Name");
                String designation = resultSet.getString("Designation");
                int wage = resultSet.getInt("Wage");

                LaborWageDashboardReportDto dto = new LaborWageDashboardReportDto();
                dto.setLaborId(labourID);
                dto.setName(name);
                dto.setDesignation(designation);
                dto.setWeekWage(Integer.toString(wage));
                reportDtos.add(dto);
            }

            for (int i = 0; i < reportDtos.size(); i++) {
                Vector<String> row = new Vector<>();
                row.add(reportDtos.get(i).getLaborId());
                row.add(reportDtos.get(i).getName());
                row.add(reportDtos.get(i).getDesignation());
                row.add(reportDtos.get(i).getWeekWage());
                rowData.add(row);
            }
            Vector<String> columnNames = new Vector<String>();
            columnNames.addElement("Labor Id");
            columnNames.addElement("Name");
            columnNames.addElement("Designation");
            columnNames.addElement("Wage");
            contentDto.setRowData(rowData);
            contentDto.setColumnNames(columnNames);
            return contentDto;

        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
