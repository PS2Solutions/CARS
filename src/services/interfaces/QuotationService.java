/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.CustomerDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationMasterDto;
import dataclasses.QuotationTypeDto;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface QuotationService {

    Map< String,MaterialDto> getMaterials(int QuotationType);

    Vector<CustomerDto> getCustomers();

    Vector<String> getCustomers(Vector<CustomerDto> customersDtos);

    Vector<QuotationTypeDto> getQuotationType();

    Vector<String> getQuotationType(Vector<QuotationTypeDto> quotationTypeDtos);
    
    boolean saveQuotation(QuotationMasterDto masterDto);
    
    QuotationMasterDto getQuotation(String referenceNo);
    
    List<String> getQuotationRefs();
}
