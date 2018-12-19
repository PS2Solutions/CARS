/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.CustomersDto;
import dataclasses.DesignationDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationMasterDto;
import dataclasses.QuotationTypeDto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.QuotationService;
import utils.DBHelper;

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
        Vector<CustomersDto> cds =new Vector<>();
        for(int i= 0; i<2;i++){
            CustomersDto cd =new CustomersDto();
            cd.setCustomerId(i+1);
            cd.setCustomerName("Test"+i);
            cds.add(cd);
        }
        return cds;
    }

    @Override
    public Vector<QuotationTypeDto> getQuotationType() {
       Vector<QuotationTypeDto> quotationTypeDtos = new Vector<>();
        ResultSet quotationTypeSet = DBHelper.readDataFromDb("select * from quotationtypes");
        if (quotationTypeSet != null) {
            try {
                while (quotationTypeSet.next()) {
                    QuotationTypeDto quotationTypeDto = new QuotationTypeDto();
                    quotationTypeDto.setTypeId(quotationTypeSet.getInt("ID"));
                    quotationTypeDto.setType(quotationTypeSet.getString("Type"));
                    quotationTypeDtos.add(quotationTypeDto);
                }
            } catch (Exception ex) {

            }
        }
        return quotationTypeDtos;
    }

    @Override
    public Vector<String> getCustomers(Vector<CustomersDto> customersDtos) {
        Vector<String> designations = new Vector<>();
        for (int i = 0; i < customersDtos.size(); i++) {
            designations.add(customersDtos.get(i).getCustomerName());
        }
        return designations;
    }

    @Override
    public Vector<String> getQuotationType(Vector<QuotationTypeDto> quotationTypeDtos) {
        
        Vector<String> designations = new Vector<>();
        for (int i = 0; i < quotationTypeDtos.size(); i++) {
            designations.add(quotationTypeDtos.get(i).getType());
        }
        return designations;
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
