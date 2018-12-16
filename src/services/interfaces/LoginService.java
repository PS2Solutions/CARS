/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.LoginDto;

/**
 *
 * @author shinu.k
 */
public interface LoginService {
    /**
     * For checking user credentials.
     * @param loginDto user details.
     * @return validation result.
     */
    String validateLogin(LoginDto loginDto);
    /**
     * For getting user credentials when user enables the remember me.
     * @return user details when user enables the remember me other wise null.
     */
    LoginDto getUserCredentials();
    /**
     * For checking whether user registered or not.
     * @return  is user already registered return true other wise false.
     */
    boolean isUserRegistered();
}
