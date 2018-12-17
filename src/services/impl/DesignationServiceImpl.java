/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.DesignationDto;
import java.sql.ResultSet;
import java.util.Vector;
import services.interfaces.DesignationService;
import utils.DBHelper;

/**
 *
 * @author shinu.k
 */
public class DesignationServiceImpl implements DesignationService {

    public DesignationServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public Vector<DesignationDto> getDesignations() {
        Vector<DesignationDto> designationDtos = new Vector<>();
        ResultSet designationSet = DBHelper.readDataFromDb("select * from Designations");
        if (designationSet != null) {
            try {
                while (designationSet.next()) {
                    DesignationDto designationDto = new DesignationDto();
                    designationDto.setId(designationSet.getInt("ID"));
                    designationDto.setDesignation(designationSet.getString("Designation"));
                    designationDtos.add(designationDto);
                }
            } catch (Exception ex) {

            }
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
