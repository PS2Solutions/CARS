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
public class ContractLaborChargeDetails {

    int contractId;
    String contractReference;
    int noOfLabors;
    double chargeSofar;
    double totalAmount;

    public String getContractReference() {
        return contractReference;
    }

    public void setContractReference(String contractReference) {
        this.contractReference = contractReference;
    }

    public int getNoOfLabors() {
        return noOfLabors;
    }

    public void setNoOfLabors(int noOfLabors) {
        this.noOfLabors = noOfLabors;
    }

    public double getChargeSofar() {
        return chargeSofar;
    }

    public void setChargeSofar(double chargeSofar) {
        this.chargeSofar = chargeSofar;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
