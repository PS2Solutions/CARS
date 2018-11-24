/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LoginDto;
import services.interfaces.LoginService;

/**
 *
 * @author shinu.k
 */
public class LoginServiceImpl implements LoginService{

    @Override
    public String validateLogin(LoginDto loginDto) {
        String response = "invalid";
        if(loginDto.getUsername().equalsIgnoreCase("Test") && loginDto.getPassword().equalsIgnoreCase("Test")){
            response = "valid";
        }
        return response;
    }

    @Override
    public LoginDto getUserCredentials() {
        return null;
    }
    
}
