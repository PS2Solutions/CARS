/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.ReportContentDto;

/**
 *
 * @author shinu.k
 */
public interface DashboardService {
    /**
     * For getting contract details for dashboard.
     * @return contract details.
     */
    ReportContentDto getContractReport();
    /**
     * For getting current week labe wage details.
     * @return labor wage details.
     */
    ReportContentDto getLaborWageReport();
}
