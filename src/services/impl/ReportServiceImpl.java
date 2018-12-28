/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractDashboardReportDto;
import dataclasses.LaborWageDashboardReportDto;
import dataclasses.ReportContentDto;
import dataclasses.ReportsDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.ReportService;
import services.interfaces.ReportService;
import utils.DBHelper;

/**
 *
 * @author shinu.k
 */
public class ReportServiceImpl implements ReportService {
    
    @Override
    public List<ReportsDto> getAvailableReports() {
        List<ReportsDto> dtos = new ArrayList<>();
        try {
            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call GetReports()}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReportsDto reportsDto = new ReportsDto();
                String name = resultSet.getString("Name");
                String spName = resultSet.getString("SPName");
                boolean isDateFilterAvailable = resultSet.getBoolean("IsFilterAvailable");
                reportsDto.setReportName(name);
                reportsDto.setProcedureName(spName);
                reportsDto.setIsDateFilterAvailable(isDateFilterAvailable);
                dtos.add(reportsDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return dtos;
    }
    
    @Override
    public Vector<String> getReportNames(List<ReportsDto> reportsDtos) {
        Vector<String> reportNames = new Vector<>();
        for (ReportsDto dto : reportsDtos) {
            reportNames.add(dto.getReportName());
        }
        return reportNames;
    }
    
    @Override
    public ReportContentDto getreport(ReportsDto reportsDto) {
        ReportContentDto contentDto;
        if (reportsDto.isIsDateFilterAvailable()) {
            contentDto = getDateFilterReport(reportsDto);
        } else {
            contentDto = getReport(reportsDto);
        }
        return contentDto;
    }
    
    private ReportContentDto getDateFilterReport(ReportsDto reportsDto) {
        ReportContentDto contentDto = new ReportContentDto();
        try {
            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call " + reportsDto.getProcedureName() + "(?,?)}");
            statement.setDate("dateFrom", reportsDto.getStartDate());
            statement.setDate("dateTo", reportsDto.getEndDate());
            ResultSet resultSet = statement.executeQuery();
            Vector<Vector> rowData = new Vector<Vector>();
            Vector<String> columnNames = new Vector<String>();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 0; i < columnsNumber; i++) {
                    row.add(resultSet.getString(i));
                }
                rowData.add(row);
            }
            for (int i = 0; i < columnsNumber; i++) {
                columnNames.add(rsmd.getColumnName(i));
            }
            contentDto.setRowData(rowData);
            contentDto.setColumnNames(columnNames);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return contentDto;
    }
    
    private ReportContentDto getReport(ReportsDto reportsDto) {
         ReportContentDto contentDto = new ReportContentDto();
        try {
            CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                    "{call " + reportsDto.getProcedureName() + "()}");
            ResultSet resultSet = statement.executeQuery();
            Vector<Vector> rowData = new Vector<Vector>();
            Vector<String> columnNames = new Vector<String>();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 1; i <= columnsNumber; i++) {
                    row.add(resultSet.getString(i));
                }
                rowData.add(row);
            }
            for (int i = 1; i <= columnsNumber; i++) {
                columnNames.add(rsmd.getColumnName(i));
            }
            contentDto.setRowData(rowData);
            contentDto.setColumnNames(columnNames);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return contentDto;
    }
    
}