/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.CustomerDto;
import dataclasses.ReportContentDto;
import java.util.List;

public interface CustomerService {
    ReportContentDto getCustomerDetails( List<CustomerDto> customerDtos );
    String saveCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomers();
}
