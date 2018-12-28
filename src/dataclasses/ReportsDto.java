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
    Date startDate;
    Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

   

}
