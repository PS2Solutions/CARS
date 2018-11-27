/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.LaborService;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class LaborServiceImpl implements LaborService{

    @Override
    public List<LaborDto> getLabor() {
        List<LaborDto> laborDtos = new ArrayList<LaborDto>();
        for (int i=0 ; i<100 ; i++) {
            LaborDto dto = new LaborDto();
            dto.setId(i);
            dto.setLaborId("3243");
            dto.setName("test");
            dto.setAddress1("eewrewrwe");
            dto.setAddress2("Progress");
            dto.setIdentityType("VotersId");
            dto.setIdentityNumber("342342");
            dto.setJoinDate("serwerwer");
            dto.setResignDate("Progress");
            dto.setPhoneNumber("100");
            dto.setWage(87);
            dto.setIsActive(false);
            laborDtos.add(dto);
        }
        return laborDtos;
    }

    @Override
    public ReportContentDto getLaborDetails(List<LaborDto> laborDtos) {
       ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (int i=0 ; i<laborDtos.size(); i++) {
             Vector<String> row = new Vector<>();
             row.add(laborDtos.get(i).getLaborId());
             row.add(laborDtos.get(i).getName());
             row.add(laborDtos.get(i).getDesignation());
             row.add(laborDtos.get(i).getPhoneNumber());
             row.add(""+laborDtos.get(i).getWage());
             row.add(laborDtos.get(i).isIsActive()?"Active" : "InActive");
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
        return Helper.getPropertyValue("Success");
    }

    @Override
    public List<LaborDto> getLabor(String empolyeeId, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
