/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.sql.Date;

/**
 *
 * @author sreenath
 */
public class ContractDto {
    int id;
    String contractRefNo;
    String agrementReference;
    double totalAmount;
    String startDate;
    Date endDate;
    String lastCollectionDate;

    public int getId() {
        return id;
    }

    public String getContractRefNo() {
        return contractRefNo;
    }

    public String getAgrementReference() {
        return agrementReference;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLastCollectionDate() {
        return lastCollectionDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContractRefNo(String contractRefNo) {
        this.contractRefNo = contractRefNo;
    }

    public void setAgrementReference(String agrementReference) {
        this.agrementReference = agrementReference;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLastCollectionDate(String lastCollectionDate) {
        this.lastCollectionDate = lastCollectionDate;
    }
}
