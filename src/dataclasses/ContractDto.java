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
public class ContractDto {
    int id;
    String contractRefNo;
    String caption;
    String customer;
    String address1;
    String address2;
    int type;
    String totalAmount;
    int daysToComplete;
    String startDate;
    String endDate;
    String Status;

    public int getId() {
        return id;
    }

    public String getContractRefNo() {
        return contractRefNo;
    }

    public String getCaption() {
        return caption;
    }

    public String getCustomer() {
        return customer;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public int getType() {
        return type;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return Status;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setContractRefNo(String contractRefNo) {
        this.contractRefNo = contractRefNo;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDaysToComplete(int daysToComplete) {
        this.daysToComplete = daysToComplete;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
