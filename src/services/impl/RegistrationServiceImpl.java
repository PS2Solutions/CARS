/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.RegistrationDto;
import services.interfaces.RegistrationService;

/**
 *
 * @author sreenath
 */
public class RegistrationServiceImpl implements RegistrationService{

    @Override
    public String saveRegistrationDetails(RegistrationDto registrationDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrationDto getRegistrationDetails() {
        RegistrationDto dto = new RegistrationDto();
        dto.setName("Name");
        dto.setCompanyName("CompanyName");
        dto.setCompanyReg("CompanyReg");
        dto.setGst("Gst");
        dto.setEmail("someone@something.com");
        dto.setPhoneNumber("1234567890");
        dto.setTin("Tin");
        dto.setUserName("Test");
        dto.setPassword("Test");
        
        return dto;
    }
    
}
