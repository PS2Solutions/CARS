/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.DesignationDto;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface DesignationService {
    Vector<DesignationDto> getDesignations();
    Vector<String> getDesignations(Vector<DesignationDto> designationDtos);
}
