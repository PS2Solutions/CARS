/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.CustomerDto;
import dataclasses.ReportContentDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.CustomerService;

/**
 *
 * @author shinu.k
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public ReportContentDto getCustomerDetails(List<CustomerDto> customerDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for(CustomerDto customerDto : customerDtos) {
            Vector<String> row = new Vector<>();
            
            row.add(customerDto.getName());
            row.add(customerDto.getPhoneNumber());
            row.add(customerDto.getEmail());
            row.add(Integer.toString(customerDto.getTotalContract()));
            row.add(Integer.toString(customerDto.getActiveContract()));
            row.add(customerDto.getQuotes());
            row.add(customerDto.getCompanyName());
            row.add(customerDto.getAddress1());
            row.add(customerDto.getAddress2());
            
            rowData.add(row);
        }
        
         Vector<String> columnNames = new Vector<String>();
         columnNames.addElement("Customer");
         columnNames.addElement("Phone");
         columnNames.addElement("Email");
         columnNames.addElement("Total Contract");
         columnNames.addElement("Active Contract");
         columnNames.addElement("Quotes");
         contentDto.setRowData(rowData);
         contentDto.setColumnNames(columnNames);
         return contentDto;
    }

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        return "sucess";
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        for (int i=0 ; i<100 ; i++) {
            CustomerDto dto = new CustomerDto();
            dto.setId(i);
            dto.setName("test" + i);
            dto.setCompanyName("companyName " + i);
            dto.setAddress1("Address 1 " + i);
            dto.setAddress2("Address 2 " + i);
            dto.setEmail("aadjkj@jsjf.com");
            dto.setPhoneNumber("1234567890");
            dto.setActiveContract(i);
            dto.setTotalContract(150);
            dto.setQuotes("Quotes " + i);
     
            customerDtos.add(dto);
        }
        return customerDtos;
    }
    
}
