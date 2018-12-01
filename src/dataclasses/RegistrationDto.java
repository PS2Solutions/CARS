/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

/**
 *
 * @author sreenath
 */
public class RegistrationDto {
    String Name;
    String companyName;
    String companyReg;
    String gst;
    String email;
    String phoneNumber;
    String tin;
    String companyLogo;
    String userName;
    String password;

    public RegistrationDto() {
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyReg(String companyReg) {
        this.companyReg = companyReg;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return Name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyReg() {
        return companyReg;
    }

    public String getGst() {
        return gst;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTin() {
        return tin;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
