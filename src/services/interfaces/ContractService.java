/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.ComboContentDto;
import dataclasses.ContractDto;
import dataclasses.ReportContentDto;
import java.util.List;
import java.util.Vector;

public interface ContractService {
    ReportContentDto getContractDetails( List<ContractDto> contractDtos );
    int saveContract(ContractDto contractDto);
    List<ContractDto> getContracts();
    Vector<ComboContentDto> getContractNames();
    Vector<String> getContractsNames(Vector<ComboContentDto> comboContentDtos);
    boolean closeContract(int contractId, String endDate);
    
    List<ContractDto> getClosedContracts();
}
