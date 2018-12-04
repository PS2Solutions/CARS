/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

/**
 *
 * @author shinu.k
 */
public class CustomerDto {
    int id;
    String Name;
    String companyName;
    String address1;
    String address2;
    String phoneNumber;
    String email;
    int totalContract;
    int activeContract;
    String quotes;

    public int getId() {
        return id;
    }
    
    public String getName() {
        return Name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalContract() {
        return totalContract;
    }

    public int getActiveContract() {
        return activeContract;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTotalContract(int totalContract) {
        this.totalContract = totalContract;
    }

    public void setActiveContract(int activeContract) {
        this.activeContract = activeContract;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }
}
