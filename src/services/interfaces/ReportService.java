/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.ReportContentDto;
import dataclasses.ReportsDto;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface ReportService {

    List<ReportsDto> getAvailableReports();

    Vector<String> getReportNames(List<ReportsDto> reportsDtos);

    ReportContentDto getreport(ReportsDto reportsDto);
}
