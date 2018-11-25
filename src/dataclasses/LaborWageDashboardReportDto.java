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
public class LaborWageDashboardReportDto {
    String laborId;
    String name;
    String designation;
    String weekWage;

    public String getLaborId() {
        return laborId;
    }

    public void setLaborId(String laborId) {
        this.laborId = laborId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWeekWage() {
        return weekWage;
    }

    public void setWeekWage(String weekWage) {
        this.weekWage = weekWage;
    }
    
    
}
