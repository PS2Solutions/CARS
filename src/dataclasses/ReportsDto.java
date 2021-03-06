/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.sql.Date;

/**
 *
 * @author shinu.k
 */
public class ReportsDto {

    String reportName;
    String procedureName;
    boolean isDateFilterAvailable;
    String startDate;
    String endDate;
    String contractName;
    String quotationName;
    String laborId;
    /**
     * Normal report = 0
     * Contract report = 1
     * Quotation report = 2
     */
    int reportType;
    String reportTypeName;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public boolean isIsDateFilterAvailable() {
        return isDateFilterAvailable;
    }

    public void setIsDateFilterAvailable(boolean isDateFilterAvailable) {
        this.isDateFilterAvailable = isDateFilterAvailable;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getQuotationName() {
        return quotationName;
    }

    public void setQuotationName(String quotationName) {
        this.quotationName = quotationName;
    }

    public String getLaborId() {
        return laborId;
    }

    public void setLaborId(String laborId) {
        this.laborId = laborId;
    }

    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }
}
