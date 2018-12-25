/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ContractLaborChargeDetails;
import dataclasses.DailyWageDto;
import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import java.util.List;
import java.util.Vector;
import services.interfaces.DailyWageService;

/**
 *
 * @author shinu.k
 */
public class DailyWageServiceImpl implements DailyWageService{

    @Override
    public Vector<String> getContractReference(List<ContractLaborChargeDetails> contractDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ContractLaborChargeDetails> getContractLaborDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReportContentDto getContractDetails(List<ContractLaborChargeDetails> laborDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LaborDto> getLabors(int contractId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateDailyWage(List<DailyWageDto> dailyWageDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<String> getLabors(List<LaborDto> laborDtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
