/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dataclasses.ContractLaborChargeDetails;
import dataclasses.ContractLaborDto;
import dataclasses.DailyWageDto;
import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import navigationCofiguration.NavigationConstants;
import navigationCofiguration.NavigationController;
import org.jdatepicker.impl.JDatePickerImpl;
import services.impl.DailyWageServiceImpl;
import services.impl.LaborServiceImpl;
import services.interfaces.DailyWageService;
import utils.Constants;
import utils.DialogHelper;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class LaborWageScreen extends javax.swing.JFrame {

    /**
     * Creates new form LaborWageScreen
     */
    public LaborWageScreen() {
        initComponents();
        dailyWageDtos = new ArrayList<>();
        initCalender();
        allLabors = new LaborServiceImpl().getLabor();
        cmbLabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLaborWage();
                selectedLaborIndex = cmbLabor.getSelectedIndex();
                clearEntryFields();
            }
        });
        getContractDetails();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblContractRef = new javax.swing.JLabel();
        cmbLabor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDailyWage = new javax.swing.JFormattedTextField();
        txtFA = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTA = new javax.swing.JFormattedTextField();
        txtOverTime = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();
        btnAddExtra = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblAdditionalPurchaseDetils = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPDate = new javax.swing.JScrollPane();
        jLabel10 = new javax.swing.JLabel();
        jPContractDetails = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("appResources/Strings"); // NOI18N
        setTitle(bundle.getString("Labor_Wage_Screen")); // NOI18N
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/home.png"))); // NOI18N
        btnHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/save.png"))); // NOI18N
        btnSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/upload.png"))); // NOI18N
        btnUpload.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnUpload.setFocusPainted(false);
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/add.png"))); // NOI18N
        btnAddNew.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAddNew.setFocusPainted(false);
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblContractRef.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContractRef.setForeground(new java.awt.Color(0, 0, 204));

        cmbLabor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Labour");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Daily Wage");

        txtDailyWage.setColumns(5);
        txtDailyWage.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtFA.setColumns(5);
        txtFA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("FA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TA");

        txtTA.setColumns(5);
        txtTA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        txtOverTime.setColumns(5);
        txtOverTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Over Time");

        txtRemark.setColumns(20);
        txtRemark.setRows(5);
        jScrollPane1.setViewportView(txtRemark);

        btnAddExtra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/add.png"))); // NOI18N
        btnAddExtra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAddExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExtraActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Additional purchase");

        lblAdditionalPurchaseDetils.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAdditionalPurchaseDetils.setForeground(new java.awt.Color(0, 0, 255));
        lblAdditionalPurchaseDetils.setText("No Additional Bills");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Date");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Remark");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblContractRef)
                        .addGap(302, 302, 302))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblAdditionalPurchaseDetils)
                                .addGap(99, 99, 99))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPDate, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDailyWage, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFA, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOverTime, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddExtra)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblContractRef)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDailyWage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOverTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblAdditionalPurchaseDetils))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAddExtra)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPContractDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPContractDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        NavigationController.navigateToScreen(NavigationConstants.DASHBOARD, this);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        updateDailyWage();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void updateDailyWage() {
        addLaborWage();
        dailyWageDtos = prepareData();
        if (dailyWageDtos != null && dailyWageDtos.size() > 0) {
            DailyWageService dailyWageService = new DailyWageServiceImpl();
            String response = dailyWageService.updateDailyWage(dailyWageDtos);
            if (response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
                DialogHelper.showInfoMessage(Helper.getPropertyValue("Success"),
                        Helper.getPropertyValue("SuccessMessage"));
                dailyWageDtos = new ArrayList<>();
                clearEntryFields();
            } else {
                DialogHelper.showErrorMessage("Error", Helper.getPropertyValue("Failed_To_Update"));
            }
        } else {
            DialogHelper.showErrorMessage("Error", Helper.getPropertyValue("NoDataToSave"));
        }
    }

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed

    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnAddExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExtraActionPerformed
        addLaborWage();
    }//GEN-LAST:event_btnAddExtraActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        if (selectedContractId > 0) {
            clearFields();
            addLaborToContract();
        } else {
            DialogHelper.showInfoMessage("Information", "Please select a contract.");
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

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
            java.util.logging.Logger.getLogger(LaborWageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaborWageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaborWageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaborWageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaborWageScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddExtra;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cmbLabor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jPContractDetails;
    private javax.swing.JScrollPane jPDate;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdditionalPurchaseDetils;
    private javax.swing.JLabel lblContractRef;
    private javax.swing.JFormattedTextField txtDailyWage;
    private javax.swing.JFormattedTextField txtFA;
    private javax.swing.JFormattedTextField txtOverTime;
    private javax.swing.JTextArea txtRemark;
    private javax.swing.JFormattedTextField txtTA;
    // End of variables declaration//GEN-END:variables
    List<ContractLaborChargeDetails> contractLaborChargeDetailses;
    JTable tblContract;
    int selectedContractId;
    int selectedLaborIndex = 0;
    String selectedContract;
    List<LaborDto> labors;
    List<LaborDto> allLabors;
    JDatePickerImpl datePicker;
    List<DailyWageDto> dailyWageDtos;

    private void getContractDetails() {
        DailyWageService dailyWageService = new DailyWageServiceImpl();
        lblContractRef.setText("Labor wage");
        contractLaborChargeDetailses = dailyWageService.getContractLaborDetails();
        if (contractLaborChargeDetailses != null && contractLaborChargeDetailses.size() > 0) {
            ReportContentDto contentDto = dailyWageService.getContractDetails(contractLaborChargeDetailses);
            configureTable(contentDto);
            btnSave.setEnabled(false);
        }
    }

    private void configureTable(ReportContentDto contentDto) {
        TableModel model = new DefaultTableModel(contentDto.getRowData(), contentDto.getColumnNames()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tblContract = new JTable(model);
        tblContract.setRowSelectionAllowed(true);
        tblContract.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLaborWage();
                if (dailyWageDtos.size() == 0) {
                    prepareContent(evt);
                } else {
                    int response = DialogHelper.showQuestionDialog(LaborWageScreen.this, "Confirm", "Do you want to save the details?.");
                    if (response == JOptionPane.YES_OPTION) {
                        updateDailyWage();
                    } else {
                        dailyWageDtos = new ArrayList<>();
                    }
                    prepareContent(evt);
                }
            }

            private void prepareContent(MouseEvent evt) {
                int row = tblContract.rowAtPoint(evt.getPoint());
                selectedContractId = contractLaborChargeDetailses.get(row).getContractId();
                selectedContract = contractLaborChargeDetailses.get(row).getContractReference();
                enableLaborChargeEntry();
            }
        });
        jPContractDetails.add(tblContract);
        jPContractDetails.setViewportView(tblContract);
        jPContractDetails.setVisible(true);
    }

    private void enableLaborChargeEntry() {
        DailyWageService dailyWageService = new DailyWageServiceImpl();
        labors = dailyWageService.getLabors(selectedContractId);
        if (labors != null && labors.size() > 0) {
            Vector<String> vecLabors = dailyWageService.getLabors(labors);
            DefaultComboBoxModel model = new DefaultComboBoxModel(vecLabors);
            cmbLabor.setModel(model);
            lblContractRef.setText(selectedContract);
            btnSave.setEnabled(true);
        } else {
            DialogHelper.showInfoMessage("Message", Helper.getPropertyValue("Labor_Not_Assigned"));
            clearFields();
            btnSave.setEnabled(false);
        }
    }

    private void clearFields() {
        lblContractRef.setText("Labor wage");
        lblAdditionalPurchaseDetils.setText("No Additional Bills");
        initCalender();
        clearEntryFields();
        cmbLabor.removeAllItems();
    }

    private void clearEntryFields() {
        txtDailyWage.setText("");
        txtFA.setText("");
        txtOverTime.setText("");
        txtRemark.setText("");
        txtTA.setText("");
    }

    private void initCalender() {
        datePicker = Helper.getDatePicker();
        datePicker.setVisible(true);
        jPDate.setViewportView(datePicker);
    }

    private void addLaborWage() {
        try {
            if (txtDailyWage.getText().trim().length() > 0) {
                DailyWageDto dailyWageDto = new DailyWageDto();
                dailyWageDto.setContractId(selectedContractId);
                if (labors != null && labors.size() > 0) {
                    dailyWageDto.setLaborId(labors.get(selectedLaborIndex).getId());
                } else {
                    dailyWageDto.setLaborId(0);
                }
                dailyWageDto.setDate(Helper.getMysqlFormattedDate(datePicker.getJFormattedTextField().getText()));
                dailyWageDto.setRemark(txtRemark.getText().trim());
                try {
                    dailyWageDto.setWage(Double.parseDouble(txtDailyWage.getText().trim()));
                } catch (Exception ex) {
                    dailyWageDto.setWage(0);
                }
                try {
                    dailyWageDto.setFa(Double.parseDouble(txtFA.getText().trim()));
                } catch (Exception ex) {
                    dailyWageDto.setFa(0);
                }
                try {
                    dailyWageDto.setTa(Double.parseDouble(txtTA.getText().trim()));
                } catch (Exception ex) {
                    dailyWageDto.setTa(0);
                }
                try {
                    dailyWageDto.setOa(Double.parseDouble(txtOverTime.getText().trim()));
                } catch (Exception ex) {
                    dailyWageDto.setOa(0);
                }
                DailyWageDto duplicateDto = null;
                if (dailyWageDtos.size() > 0) {
                    for (DailyWageDto dto : dailyWageDtos) {
                        if (dto.getContractId() == selectedContractId
                                && dto.getLaborId() == dailyWageDto.getLaborId()
                                && dto.getDate().equalsIgnoreCase(dailyWageDto.getDate())) {
                            duplicateDto = dto;
                            break;
                        }
                    }
                    if (duplicateDto != null) {
                        dailyWageDto.setPurchaseDetailses(duplicateDto.getPurchaseDetailses());
                        dailyWageDtos.remove(duplicateDto);
                    }
                }
                dailyWageDtos.add(dailyWageDto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean validateEntry(DailyWageDto dailyWageDto) {
        boolean isValid = true;
        if (dailyWageDto.getWage() <= 0) {
            isValid = false;
        } else if (dailyWageDto.getDate().trim().length() == 0) {
            isValid = false;
        } else if (dailyWageDto.getLaborId() <= 0) {
            isValid = false;
        } else if (dailyWageDto.getContractId() <= 0) {
            isValid = false;
        }
        return isValid;
    }

    private void addLaborToContract() {
        boolean isDuplicate = false;
        if (allLabors != null && allLabors.size() > 0) {
            DailyWageService dailyWageService = new DailyWageServiceImpl();
            Vector<String> vecLabors = dailyWageService.getLabors(allLabors);
            DefaultComboBoxModel model = new DefaultComboBoxModel(vecLabors);
            JPanel jPanel = new JPanel(new GridLayout(2, 2));

            jPanel.add(new JLabel("Labors"));
            JComboBox comboLabor = new JComboBox(model);
            jPanel.add(comboLabor);
            int result = DialogHelper.showQuestionDialog(this, "Choose labors for contract " + selectedContract, jPanel, JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                int selectedLaborId = allLabors.get(comboLabor.getSelectedIndex()).getId();
                ContractLaborDto contractLaborDto = new ContractLaborDto();
                contractLaborDto.setContractId(selectedContractId);
                contractLaborDto.setLaborId(selectedLaborId);
                if (labors != null && labors.size() > 0) {
                    for (LaborDto labor : labors) {
                        if (labor.getId() == selectedLaborId) {
                            isDuplicate = true;
                            break;
                        }
                    }
                }
                if (!isDuplicate) {
                    String response = dailyWageService.UpdateContractLabor(contractLaborDto);
                    if (response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
                        DialogHelper.showInfoMessage(Helper.getPropertyValue("Success"),
                                Helper.getPropertyValue("SuccessMessage"));
                        labors = dailyWageService.getLabors(selectedContractId);
                    } else {
                        DialogHelper.showErrorMessage("Duplicate", "Labor already assigned to the selected contract.");
                    }
                } else {
                    DialogHelper.showErrorMessage("Duplicate", "Labor already assigned to the selected contract.");
                }
            }
        } else {
            DialogHelper.showInfoMessage("Message", "Labor information not available");
        }

    }

    private List<DailyWageDto> prepareData() {
        List<DailyWageDto> tmpList = new ArrayList<>();
        if (dailyWageDtos != null && dailyWageDtos.size() > 0) {
            for (DailyWageDto dailyWageDto : dailyWageDtos) {
                if (validateEntry(dailyWageDto)) {
                    tmpList.add(dailyWageDto);
                }
            }
        }
        return tmpList;
    }
}
