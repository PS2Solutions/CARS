/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LaborWageDashboardReportDto;
import dataclasses.ReportContentDto;
import dataclasses.ReportsDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.ReportService;

/**
 *
 * @author shinu.k
 */
public class ReportServiceImpl implements ReportService {

    @Override
    public List<ReportsDto> getAvailableReports() {
        List<ReportsDto> dtos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ReportsDto dto = new ReportsDto();
            dto.setProcedureName("Test" + i);
            dto.setIsDateFilterAvailable(false);
            dto.setReportName("Test" + i);
            dtos.add(dto);
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
        Vector<LaborWageDashboardReportDto> reportDtos = new Vector<LaborWageDashboardReportDto>();
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i = 0; i < 100; i++) {
            LaborWageDashboardReportDto dto = new LaborWageDashboardReportDto();
            dto.setLaborId("Ref: " + i);
            dto.setName("sasi");
            dto.setDesignation("Test");
            dto.setWeekWage("100");
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
        columnNames.addElement("Week Wage");
        contentDto.setRowData(rowData);
        contentDto.setColumnNames(columnNames);
        return contentDto;
    }

}
