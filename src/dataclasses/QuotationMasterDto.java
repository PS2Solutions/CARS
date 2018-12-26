/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shinu.k
 */
public class QuotationMasterDto {
    int id;
    String title;
    String referenceNo;
    int customerId;
    String customerName;
    Date createdDate;
    String address1;
    String address2;
    String type;
    int typeId;
    int status;
    double laborCharge;
    double amount;
    List<QuotationDetailsDto> detailsDtos;

    public QuotationMasterDto() {
        this.detailsDtos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
       
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLaborCharge() {
        return laborCharge;
    }

    public void setLaborCharge(double laborCharge) {
        this.laborCharge = laborCharge;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<QuotationDetailsDto> getDetailsDtos() {
        return detailsDtos;
    }

    public void setDetailsDtos(List<QuotationDetailsDto> detailsDtos) {
        this.detailsDtos = detailsDtos;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
