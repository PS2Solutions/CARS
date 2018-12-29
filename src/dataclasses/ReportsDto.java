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

}
