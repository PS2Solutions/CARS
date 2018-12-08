/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractDto;
import dataclasses.ReportContentDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.ContractService;

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
            
            row.add(contractDto.getCaption());
            row.add(contractDto.getStartDate());
            row.add(contractDto.getEndDate());
            row.add(contractDto.getStatus());
           
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
    public String saveContract(ContractDto contractDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContractDto> getContracts() {
        List<ContractDto> contractDtos = new ArrayList<ContractDto>();
        for (int i=0 ; i<100 ; i++) {
            ContractDto dto = new ContractDto();
            dto.setId(i);
            dto.setContractRefNo("Reff " + i);
            dto.setCaption("Caption " + i);
            dto.setCustomer("Customer " + i);
            dto.setAddress1("Address 1 " + i);
            dto.setAddress2("Address 2 " + i);
            dto.setType(i);
            dto.setTotalAmount("Cost " + i);
            dto.setDaysToComplete(i);
            dto.setStartDate("startDate" + i);
            dto.setEndDate("endDate" + i);
            dto.setStatus("Status "  +i);
     
            contractDtos.add(dto);
        }
        return contractDtos;
    }
    
}
