/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.CustomersDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationMasterDto;
import dataclasses.QuotationTypeDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.QuotationService;

/**
 *
 * @author shinu.k
 */
public class QuotationServiceImpl implements QuotationService{

    @Override
    public List<MaterialDto> getMaterials(int QuotationType) {
        List<MaterialDto>  dtos =new ArrayList<>();
        MaterialDto materialDto =new MaterialDto();
        materialDto.setMaterialCode("Test1");
        MaterialDto materialDto1 =new MaterialDto();
        materialDto1.setMaterialCode("JTest1");
        dtos.add(materialDto);
        dtos.add(materialDto);
        return dtos;
    }

    @Override
    public Vector<CustomersDto> getCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<QuotationTypeDto> getQuotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<String> getCustomers(Vector<CustomersDto> customersDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<String> getQuotationType(Vector<QuotationTypeDto> quotationTypeDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveQuotation(QuotationMasterDto masterDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuotationMasterDto getQuotation(String referenceNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
