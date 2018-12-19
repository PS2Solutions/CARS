/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dataclasses.DesignationDto;
import dataclasses.LaborDto;
import dataclasses.ReportContentDto;
import dataclasses.UploadHelperDto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import navigationCofiguration.NavigationConstants;
import navigationCofiguration.NavigationController;
import org.jdatepicker.impl.JDatePickerImpl;
import services.impl.CustomerServiceImpl;
import services.impl.DashboardServiceImpl;
import services.impl.DesignationServiceImpl;
import services.impl.LaborServiceImpl;
import services.interfaces.CustomerService;
import services.interfaces.DesignationService;
import services.interfaces.LaborService;
import utils.DialogHelper;
import utils.FileHandler;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class LaborScreen extends javax.swing.JFrame {

    /**
     * Creates new form LaborScreen
     */
    public LaborScreen() {
        initComponents();
        initCalender();
        setDesignation();
        setLaborReport();
        selectedLaborId = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        btnAddNew = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jPLaborDeails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmployeeId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        cmbDesignation = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProofNumber = new javax.swing.JTextField();
        cmbIdProof = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPJoinDate = new javax.swing.JScrollPane();
        txtContactNumber = new javax.swing.JFormattedTextField();
        txtDailyWage = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        lblResignDate = new javax.swing.JLabel();
        jPResignDate = new javax.swing.JScrollPane();
        chkStatus = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPLaborList = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        txtEmpIdSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmpNameSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("appResources/Strings"); // NOI18N
        setTitle(bundle.getString("Labor_Screen")); // NOI18N
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(new java.awt.Dimension(1245, 709));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appResources/addLabor.png"))); // NOI18N
        btnAddNew.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAddNew.setFocusPainted(false);
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPLaborDeails.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Employee ID*");

        txtEmployeeId.setColumns(10);
        txtEmployeeId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtName.setColumns(20);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbDesignation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Designation");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Joining Date*");

        txtIdProofNumber.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdProofNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProofNumberActionPerformed(evt);
            }
        });

        cmbIdProof.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbIdProof.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Voters Id", "Aadhaar", "Pan Card", "License", "Passport" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Id Proof*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Address 1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Contact Number*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Daily wage");

        txtContactNumber.setColumns(10);
        txtContactNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtDailyWage.setColumns(5);
        txtDailyWage.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Address 2");

        lblResignDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblResignDate.setText("Resign Date");

        chkStatus.setText("Active");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name*");

        javax.swing.GroupLayout jPLaborDeailsLayout = new javax.swing.GroupLayout(jPLaborDeails);
        jPLaborDeails.setLayout(jPLaborDeailsLayout);
        jPLaborDeailsLayout.setHorizontalGroup(
            jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(lblResignDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                                .addComponent(cmbIdProof, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdProofNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPResignDate, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAddress1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAddress2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDailyWage, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtContactNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkStatus)))
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jPJoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        jPLaborDeailsLayout.setVerticalGroup(
            jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPJoinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)))
                .addGap(26, 26, 26)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIdProof, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProofNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDailyWage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPLaborDeailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPResignDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPLaborDeailsLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblResignDate)))
                .addGap(18, 18, 18)
                .addComponent(chkStatus)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPLaborList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtEmpIdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIdSearchActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Employee ID");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Employee ID");

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtEmpIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtEmpNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmpNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(btnSearch))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmpIdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPLaborList))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPLaborDeails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPLaborList))
                    .addComponent(jPLaborDeails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdProofNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProofNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProofNumberActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        clearFields();
        resignDatePicker.getComponents()[1].setEnabled(false);
        txtEmployeeId.setEditable(true);
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        NavigationController.navigateToScreen(NavigationConstants.DASHBOARD, this);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (validateFields()) {
            LaborService laborService = new LaborServiceImpl();
            LaborDto laborDto = getEnteredData();
            String response = laborService.saveLabor(laborDto);
            if (response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success"))) {
                DialogHelper.showInfoMessage(Helper.getPropertyValue("Success"),
                        Helper.getPropertyValue("SuccessMessage"));
                clearFields();
                setLaborReport();
            } else {
                DialogHelper.showErrorMessage("Error", Helper.getPropertyValue("Failed_To_Update"));
            }
        } else {
            DialogHelper.showInfoMessage("Validation", Helper.getPropertyValue("EmptyFields"));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtEmpIdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIdSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIdSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String employeeId = txtEmpIdSearch.getText().trim();
        String name = txtEmpNameSearch.getText().trim();
        if (employeeId.length() > 0 || name.length() > 0) {
            LaborService laborService = new LaborServiceImpl();
            laborDtos = laborService.getLabor(employeeId, name);
            if (laborDtos.size() > 0) {
                ReportContentDto contentDto = laborService.getLaborDetails(laborDtos);
                configureTable(contentDto);
            } else {

            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        uploadExcel();
    }//GEN-LAST:event_btnUploadActionPerformed

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
            java.util.logging.Logger.getLogger(LaborScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaborScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaborScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaborScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaborScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpload;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JComboBox<String> cmbDesignation;
    private javax.swing.JComboBox<String> cmbIdProof;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jPJoinDate;
    private javax.swing.JPanel jPLaborDeails;
    private javax.swing.JScrollPane jPLaborList;
    private javax.swing.JScrollPane jPResignDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblResignDate;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JFormattedTextField txtContactNumber;
    private javax.swing.JFormattedTextField txtDailyWage;
    private javax.swing.JTextField txtEmpIdSearch;
    private javax.swing.JTextField txtEmpNameSearch;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtIdProofNumber;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    JDatePickerImpl joinDatePicker;
    JDatePickerImpl resignDatePicker;
    Vector<DesignationDto> designationDtos;
    List<LaborDto> laborDtos;
    int selectedLaborId;
    JTable tblContract;

    private void initCalender() {
        joinDatePicker = Helper.getDatePicker();
        jPJoinDate.setVisible(true);
        jPJoinDate.setViewportView(joinDatePicker);
        resignDatePicker = Helper.getDatePicker();
        jPResignDate.setVisible(true);
        jPResignDate.setViewportView(resignDatePicker);
    }

    private void setDesignation() {
        DesignationService designationService = new DesignationServiceImpl();
        designationDtos = designationService.getDesignations();
        DefaultComboBoxModel model = new DefaultComboBoxModel(designationService.getDesignations(designationDtos));
        cmbDesignation.setModel(model);
    }

    private void setLaborReport() {
        LaborService laborService = new LaborServiceImpl();
        laborDtos = laborService.getLabor();
        if (laborDtos.size() > 0) {
            ReportContentDto contentDto = laborService.getLaborDetails(laborDtos);
            configureTable(contentDto);
        }
    }

    private void configureTable(ReportContentDto contentDto) {

        tblContract = new JTable(contentDto.getRowData(), contentDto.getColumnNames());
        tblContract.setRowSelectionAllowed(true);
        tblContract.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblContract.rowAtPoint(evt.getPoint());
                selectedLaborId = laborDtos.get(row).getId();
                populateSelectedDetails(laborDtos.get(row));
            }
        });
        jPLaborList.add(tblContract);
        jPLaborList.setViewportView(tblContract);
        jPLaborList.setVisible(true);
    }

    private void populateSelectedDetails(LaborDto laborDto) {
        resignDatePicker.getComponents()[1].setEnabled(true);       
        txtEmployeeId.setEditable(false);
        txtIdProofNumber.setText(laborDto.getIdentityNumber());
        txtName.setText(laborDto.getName());
        txtEmployeeId.setText(laborDto.getLaborId());
        txtContactNumber.setText(laborDto.getPhoneNumber());
        txtDailyWage.setText("" + laborDto.getWage());
        txtAddress1.setText(laborDto.getAddress1());
        txtAddress2.setText(laborDto.getAddress2());
        joinDatePicker.getJFormattedTextField().setText(laborDto.getJoinDate());
        resignDatePicker.getJFormattedTextField().setText(laborDto.getResignDate());
        for (DesignationDto designationDto : designationDtos) {
            if (designationDto.getDesignation().equalsIgnoreCase(laborDto.getDesignation())) {
                cmbDesignation.setSelectedIndex(designationDtos.indexOf(designationDto));
                break;
            }
        }
        cmbIdProof.setSelectedIndex(getIdProofIndex(laborDto.getIdentityType()));
        chkStatus.setSelected(laborDto.isIsActive());
    }

    private void clearFields() {
        selectedLaborId = 0;
        txtIdProofNumber.setText("");
        txtName.setText("");
        txtEmployeeId.setText("");
        txtContactNumber.setText("");
        txtDailyWage.setText("");
        txtAddress1.setText("");
        txtAddress2.setText("");
        initCalender();
        cmbDesignation.setSelectedIndex(0);
        cmbIdProof.setSelectedIndex(0);
        chkStatus.setSelected(false);

    }

    private LaborDto getEnteredData() {
        LaborDto laborDto = new LaborDto();
        laborDto.setId(selectedLaborId);
        laborDto.setLaborId(txtEmployeeId.getText().trim());
        laborDto.setName(txtName.getText().trim());
        laborDto.setPhoneNumber(txtContactNumber.getText().trim());
        laborDto.setAddress1(txtAddress1.getText().trim());
        laborDto.setAddress2(txtAddress2.getText().trim());
        laborDto.setIdentityType(cmbIdProof.getSelectedItem().toString());
        laborDto.setIdentityNumber(txtIdProofNumber.getText().trim());
        laborDto.setIsActive(chkStatus.isSelected());
        laborDto.setJoinDate(Helper.getMysqlFormattedDate(joinDatePicker.getJFormattedTextField().getText()));
        laborDto.setResignDate(Helper.getMysqlFormattedDate(resignDatePicker.getJFormattedTextField().getText()));
        try {
            laborDto.setWage(Integer.parseInt(txtDailyWage.getText().trim()));
        } catch (Exception ex) {
            laborDto.setWage(0);
        }
        String designation = designationDtos.get(cmbDesignation.getSelectedIndex()).getDesignation();
        laborDto.setDesignation(designation);
        return laborDto;
    }

    private boolean validateFields() {
        if (txtEmployeeId.getText().trim().length() == 0 || txtName.getText().trim().length() == 0
                || txtIdProofNumber.getText().trim().length() == 0
                || txtContactNumber.getText().trim().length() == 0
                || joinDatePicker.getJFormattedTextField().getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    private int getIdProofIndex(String identityType) {
        int index = 0;
        switch (identityType) {
            case "Voters Id":
                index = 0;
                break;
            case "Aadhaar":
                index = 1;
                break;
            case "Pan Card":
                index = 2;
                break;
            case "License":
                index = 3;
                break;
            case "Passport":
                index = 4;
                break;
        }
        return index;
    }
     private void uploadExcel() {
        List<String> extensions = new ArrayList<>();
        extensions.add("xlsx");
        extensions.add("xls");
        File file = FileHandler.showFileChooser("Excel Upload", extensions);
        if (file.getName().equals("Labor_Details")) {
            List<UploadHelperDto> uplodedData = FileHandler.getExcelData(file);
            LaborService laborService = new LaborServiceImpl();
            boolean response = laborService.uploadExcel(uplodedData);
            if(response) {
                  DialogHelper.showErrorMessage("Upload Excel", Helper.getPropertyValue("Data_Uploded"));
            } else {
                  DialogHelper.showErrorMessage("Upload Excel", Helper.getPropertyValue("Failed_To_Upload"));
            }
        } else {
            DialogHelper.showErrorMessage("Upload Excel", Helper.getPropertyValue("Invalid_File"));
        }
    }
}
