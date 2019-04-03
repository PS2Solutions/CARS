/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.ComboContentDto;
import dataclasses.CustomerDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationDetailsDto;
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
    
    int updateQuotation(String quotationRef, int contractId);
    
    Vector<ComboContentDto> getQuotationNames();
    
    Vector<String> getQuotationNames(Vector<ComboContentDto> comboContentDtos);
    
    int getCustomerId(int contractId);
    
    QuotationMasterDto getQuotation(int contractId);
    
    List<QuotationDetailsDto> getQuotationDetails(int quotationId);
    
    int getQuotationType(int quotationId);
    
    boolean updateMaterials(QuotationMasterDto masterDto);
    
    String getQuotationTitle(int quotationId);
}
