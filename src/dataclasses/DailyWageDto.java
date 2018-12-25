/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shinu.k
 */
public class DailyWageDto {

    int contractId;
    int laborId;
    String date;
    double wage;
    double ta;
    double fa;
    double oa;
    List<ExtraPurchaseDetails> purchaseDetailses;

    public DailyWageDto() {
        this.purchaseDetailses = new ArrayList<>();
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getLaborId() {
        return laborId;
    }

    public void setLaborId(int laborId) {
        this.laborId = laborId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getTa() {
        return ta;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    public double getFa() {
        return fa;
    }

    public void setFa(double fa) {
        this.fa = fa;
    }

    public double getOa() {
        return oa;
    }

    public void setOa(double oa) {
        this.oa = oa;
    }

    public List<ExtraPurchaseDetails> getPurchaseDetailses() {
        return purchaseDetailses;
    }

    public void setPurchaseDetailses(List<ExtraPurchaseDetails> purchaseDetailses) {
        this.purchaseDetailses = purchaseDetailses;
    }

}
