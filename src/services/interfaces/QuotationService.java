/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.CustomersDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationMasterDto;
import dataclasses.QuotationTypeDto;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface QuotationService {

    List<MaterialDto> getMaterials(int QuotationType);

    Vector<CustomersDto> getCustomers();

    Vector<String> getCustomers(Vector<CustomersDto> customersDtos);

    Vector<QuotationTypeDto> getQuotationType();

    Vector<String> getQuotationType(Vector<QuotationTypeDto> quotationTypeDtos);
    
    boolean saveQuotation(QuotationMasterDto masterDto);
    
    QuotationMasterDto getQuotation(String referenceNo);
}
