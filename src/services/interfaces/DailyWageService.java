/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.ContractLaborChargeDetails;
import dataclasses.ContractLaborDto;
import dataclasses.DailyWageDto;
import dataclasses.ExtraPurchaseDetails;
import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface DailyWageService {

    List<ContractLaborChargeDetails> getContractLaborDetails();

    ReportContentDto getContractDetails(List<ContractLaborChargeDetails> laborDtos);

    List<LaborDto> getLabors(int contractId);

    String updateDailyWage(List<DailyWageDto> dailyWageDtos);
    
    Vector<String> getLabors(List<LaborDto> laborDtos);
    
    String UpdateContractLabor(ContractLaborDto contractLaborDto);
    
    List<DailyWageDto> getDailyWages(int contractID);
    
    List<ExtraPurchaseDetails> getExtraPurchaseDetails(int contractID);
}
