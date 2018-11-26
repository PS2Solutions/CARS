/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.DesignationDto;
import java.util.Vector;
import services.interfaces.DesignationService;

/**
 *
 * @author shinu.k
 */
public class DesignationServiceImpl implements DesignationService {

    @Override
    public Vector<DesignationDto> getDesignations() {
        Vector<DesignationDto> designationDtos = new Vector<>();
        for (int i = 0; i < 3; i++) {
            DesignationDto dd = new DesignationDto();
            dd.setId(+i);
            dd.setDesignation("Test" + i);
            designationDtos.add(dd);
        }
        return designationDtos;
    }

    @Override
    public Vector<String> getDesignations(Vector<DesignationDto> designationDtos) {
        Vector<String> designations = new Vector<>();
        for (int i = 0; i < designationDtos.size(); i++) {
            designations.add(designationDtos.get(i).getDesignation());
        }
        return designations;
    }

}
