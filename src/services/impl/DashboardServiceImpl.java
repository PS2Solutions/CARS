/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractDashboardReportDto;
import dataclasses.LaborWageDashboardReportDto;
import dataclasses.ReportContentDto;
import java.util.Vector;
import services.interfaces.DashboardService;

/**
 *
 * @author shinu.k
 */
public class DashboardServiceImpl implements DashboardService{

    @Override
    public ReportContentDto getContractReport() {
        Vector<ContractDashboardReportDto> dashboardReportDtos = new Vector<ContractDashboardReportDto>();
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i=0 ; i<100 ; i++) {
            ContractDashboardReportDto dto = new ContractDashboardReportDto();
            dto.setContractRefNo("Ref: "+i);
            dto.setStartDate("12 jun 2018");
            dto.setEndDate("12 jun 2018");
            dto.setDaysToComplete(10);
            dto.setStatus("Progress");
            dto.setTotalAmount("100");
            dashboardReportDtos.add(dto);
        }
         for (int i=0 ; i<dashboardReportDtos.size(); i++) {
             Vector<String> row = new Vector<>();
             row.add(dashboardReportDtos.get(i).getContractRefNo());
             row.add(dashboardReportDtos.get(i).getStartDate());
             row.add(dashboardReportDtos.get(i).getEndDate());
             row.add(""+dashboardReportDtos.get(i).getDaysToComplete());
             row.add(dashboardReportDtos.get(i).getTotalAmount());
             row.add(dashboardReportDtos.get(i).getStatus());
             rowData.add(row);
         }
         Vector<String> columnNames = new Vector<String>();
         columnNames.addElement("Contract Ref");
         columnNames.addElement("Start Date");
         columnNames.addElement("End Date");
         columnNames.addElement("Pending days");
         columnNames.addElement("Amount");
         columnNames.addElement("Status");
         contentDto.setRowData(rowData);
         contentDto.setColumnNames(columnNames);
         return contentDto;
    }

    @Override
    public ReportContentDto getLaborWageReport() {
        
        Vector<LaborWageDashboardReportDto> reportDtos = new Vector<LaborWageDashboardReportDto>();
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i=0 ; i<100 ; i++) {
            LaborWageDashboardReportDto dto = new LaborWageDashboardReportDto();
            dto.setLaborId("Ref: "+i);
            dto.setName("sasi");
            dto.setDesignation("Test");
            dto.setWeekWage("100");
            reportDtos.add(dto);
        }
         for (int i=0 ; i<reportDtos.size(); i++) {
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
         columnNames.addElement("Week Wage");
         contentDto.setRowData(rowData);
         contentDto.setColumnNames(columnNames);
         return contentDto;
    }
    
}
