/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import java.util.List;

/**
 *
 * @author shinu.k
 */
public interface LaborService {
    List<LaborDto> getLabor();
    ReportContentDto getLaborDetails( List<LaborDto> laborDtos );
    String saveLabor(LaborDto laborDto);
    List<LaborDto> getLabor(String empolyeeId, String name);
}