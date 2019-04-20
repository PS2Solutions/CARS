/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dataclasses.ComboContentDto;
import dataclasses.RegistrationDto;
import dataclasses.ReportContentDto;
import dataclasses.ReportsDto;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import navigationCofiguration.NavigationConstants;
import navigationCofiguration.NavigationController;
import org.jdatepicker.impl.JDatePickerImpl;
import services.impl.ContractServiceImpl;
import services.impl.LaborServiceImpl;
import services.impl.QuotationServiceImpl;
import services.impl.RegistrationServiceImpl;
import services.impl.ReportServiceImpl;
import services.interfaces.ContractService;
import services.interfaces.LaborService;
import services.interfaces.QuotationService;
import services.interfaces.ReportService;
import utils.DialogHelper;
import utils.FileHandler;
import utils.Helper;
import utils.ReportGenerator;

/**
 *
 * @author shinu.k
 */
public class ReportScreen extends javax.swing.JFrame {

    private int lastSelectedIndex = 0;
    private String reportName;
    ReportsDto reportsDto;

    /**
     * Creates new form ReportScreen
     */
    public ReportScreen() {
        initComponents();
        configureDatePicker();
        configureReports();
        
        btnPrint.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbReport = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPStartDate = new javax.swing.JScrollPane();
        jPEndDate = new javax.swing.JScrollPane();
        btnGetReport = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combContract = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        combQuote = new javax.swing.JComboBox<>();
        combLabor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSPReportPanel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("appResources/Strings"); // NOI18N
        setTitle(bundle.getString("Report_Screen")); // NOI18N
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1245, 709));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/home.png"))); // NOI18N
        btnHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/print.png"))); // NOI18N
        btnPrint.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnPrint.setFocusPainted(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/upload.png"))); // NOI18N
        btnExport.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExport.setFocusPainted(false);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Report");

        cmbReport.setMaximumRowCount(20);
        cmbReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReportActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Start Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("End Date");

        btnGetReport.setText("GO");
        btnGetReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetReportActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Contract");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Quotation");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Labor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(combLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbReport, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(combContract, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jPEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combQuote, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnGetReport)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(cmbReport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addComponent(jPStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(combLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(combContract, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(combQuote, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnGetReport)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jSPReportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPReportPanel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSPReportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        NavigationController.navigateToScreen(NavigationConstants.DASHBOARD, this);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void cmbReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportActionPerformed
        if (lastSelectedIndex != cmbReport.getSelectedIndex()) {
            lastSelectedIndex = cmbReport.getSelectedIndex();
            refreshScreen();
        }
    }//GEN-LAST:event_cmbReportActionPerformed

    private void btnGetReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetReportActionPerformed
        reportsDto = availableReports.get(lastSelectedIndex);
        if (reportsDto.isIsDateFilterAvailable() && (startPicker.getJFormattedTextField().getText().trim().length() == 0
                || endDatePicker.getJFormattedTextField().getText().trim().length() == 0)) {
            DialogHelper.showInfoMessage("Warning", Helper.getPropertyValue("ReportValidation"));
        } else {
            if (reportsDto.isIsDateFilterAvailable()) {
                try {
                    reportsDto.setStartDate(Helper.getMysqlFormattedDate(startPicker.getJFormattedTextField().getText().trim()));
                    reportsDto.setEndDate(Helper.getMysqlFormattedDate(endDatePicker.getJFormattedTextField().getText().trim()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            switch (reportsDto.getReportType()) {
                case 1:
                    int contractId = contracts.get(combContract.getSelectedIndex()).getId();
                    reportsDto.setContractName("" + contractId);
                    reportsDto.setQuotationName("0");
                    reportsDto.setLaborId("0");
                    break;
                case 2:
                    int quoteId = quotes.get(combQuote.getSelectedIndex()).getId();
                    reportsDto.setQuotationName("" + quoteId);
                    reportsDto.setContractName("0");
                    reportsDto.setLaborId("0");
                    break;
                case 3:
                    int laborId = labors.get(combLabor.getSelectedIndex()).getId();
                    reportsDto.setLaborId("" + laborId);
                    reportsDto.setContractName("0");
                    reportsDto.setQuotationName("0");
                    break;
                default:
                    reportsDto.setQuotationName("0");
                    reportsDto.setContractName("0");
                    reportsDto.setLaborId("0");
                    break;
            }
            ReportService reportService = new ReportServiceImpl();
            reportName = reportsDto.getReportName();
            reportContent = reportService.getreport(reportsDto);
            loadReport();
        }
    }//GEN-LAST:event_btnGetReportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            boolean response = FileHandler.exportTableToExcel(tblReport, reportName + ".xls");
            if (response) {
                DialogHelper.showInfoMessage("Response", "Report exported");
            } else {
                DialogHelper.showErrorMessage("Error", Helper.getPropertyValue("ReportExportError"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportScreen.class.getName()).log(Level.SEVERE, null, ex);
            DialogHelper.showErrorMessage("Error", Helper.getPropertyValue("ReportExportError"));
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            RegistrationDto regDto = new RegistrationServiceImpl().getRegistrationDetails();

            String output = ReportGenerator.generateReport(regDto, reportName, reportContent, reportsDto);
            
            if (output == null) {
                DialogHelper.showErrorMessage(Helper.getPropertyValue("Error"), Helper.getPropertyValue("Error_Quotation_Print_Message"));
            } else {
                Desktop.getDesktop().open(new File(output));
            }
        } catch (Exception ex) {
            Logger.getLogger(QuotationScreen.class.getName()).log(Level.SEVERE, null, ex);
            DialogHelper.showErrorMessage(Helper.getPropertyValue("Error"), Helper.getPropertyValue("Error_Quotation_Print_Message"));
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnGetReport;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> cmbReport;
    private javax.swing.JComboBox<String> combContract;
    private javax.swing.JComboBox<String> combLabor;
    private javax.swing.JComboBox<String> combQuote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jPEndDate;
    private javax.swing.JScrollPane jPStartDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSPReportPanel;
    // End of variables declaration//GEN-END:variables
    List<ReportsDto> availableReports;
    JDatePickerImpl startPicker;
    JDatePickerImpl endDatePicker;
    ReportContentDto reportContent;
    JTable tblReport;
    Vector<ComboContentDto> contracts;
    Vector<ComboContentDto> quotes;
    Vector<ComboContentDto> labors;

    private void configureReports() {
        ReportService reportService = new ReportServiceImpl();
        availableReports = reportService.getAvailableReports();
        if (availableReports != null && availableReports.size() > 0) {
            Vector<String> reportNames = reportService.getReportNames(availableReports);
            DefaultComboBoxModel model = new DefaultComboBoxModel(reportNames);
            cmbReport.setModel(model);
            ConfigureDateFields(availableReports.get(0));

        } else {
            DialogHelper.showInfoMessage("Report", Helper.getPropertyValue("ReportNotAvailable"));
            btnGetReport.setEnabled(false);
        }
    }

    private void ConfigureDateFields(ReportsDto reportsDto) {
        boolean isActive = reportsDto.isIsDateFilterAvailable();
        int type = reportsDto.getReportType();
        startPicker.getComponents()[1].setEnabled(isActive);
        endDatePicker.getComponents()[1].setEnabled(isActive);
        switch (type) {
            case 1:
                combContract.setEnabled(true);
                combQuote.setEnabled(false);
                combLabor.setEnabled(false);
                loadContracts();
                break;
            case 2:
                combContract.setEnabled(false);
                combLabor.setEnabled(false);
                combQuote.setEnabled(true);
                loadQuotes();
                break;
            case 3:
                combContract.setEnabled(false);
                combQuote.setEnabled(false);
                combLabor.setEnabled(true);
                loadLabors();
                break;
            default:
                combContract.setEnabled(false);
                combQuote.setEnabled(false);
                combLabor.setEnabled(false);
                break;
        }
    }

    private void configureDatePicker() {
        startPicker = Helper.getDatePicker();
        jPStartDate.setVisible(true);
        jPStartDate.setViewportView(startPicker);
        endDatePicker = Helper.getDatePicker();
        jPEndDate.setVisible(true);
        jPEndDate.setViewportView(endDatePicker);
    }

    private void refreshScreen() {
        startPicker.getJFormattedTextField().setText("");
        endDatePicker.getJFormattedTextField().setText("");
        jSPReportPanel.getViewport().removeAll();
        ConfigureDateFields(availableReports.get(cmbReport.getSelectedIndex()));
    }

    private void loadReport() {
        if (reportContent != null) {
            tblReport = new JTable(reportContent.getRowData(), reportContent.getColumnNames());
            jSPReportPanel.add(tblReport);
            jSPReportPanel.setViewportView(tblReport);
            jSPReportPanel.setVisible(true);
            
             btnPrint.setEnabled(true);
        } else {
            DialogHelper.showInfoMessage("Report", "Report not available");
        }
    }

    private void loadContracts() {
        ContractService contractService = new ContractServiceImpl();
        contracts = contractService.getContractNames();
        if (contracts != null) {
            Vector<String> contractNames = contractService.getContractsNames(contracts);
            DefaultComboBoxModel model = new DefaultComboBoxModel(contractNames);
            combContract.setModel(model);
        }
    }

    private void loadQuotes() {
        QuotationService quoteService = new QuotationServiceImpl();
        quotes = quoteService.getQuotationNames();
        if (quotes != null) {
            Vector<String> quoteNames = quoteService.getQuotationNames(quotes);
            DefaultComboBoxModel model = new DefaultComboBoxModel(quoteNames);
            combQuote.setModel(model);
        }
    }

    private void loadLabors() {
        LaborService laborService = new LaborServiceImpl();
        labors = laborService.getLabors();
        if (labors != null) {
            Vector<String> laborNames = laborService.getLaborNames(labors);
            DefaultComboBoxModel model = new DefaultComboBoxModel(laborNames);
            combLabor.setModel(model);
        }
    }
}
