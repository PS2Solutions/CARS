/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.RegistrationDto;

/**
 *
 * @author sreenath
 */
public interface RegistrationService {
    String saveRegistrationDetails(RegistrationDto registrationDto);
    RegistrationDto getRegistrationDetails();
}
