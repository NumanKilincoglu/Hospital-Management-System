/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagement;

import Objects.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author numan.kilincoglu
 */
public class CreateTestGUI extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String docName;
    String patName;
    int testid;
    int patid;
    int docid;
    String testDate, resultdate, medicalfFindings;

    /**
     * Creates new form CreateTestGUI
     */
    public CreateTestGUI() {
        initComponents();

    }

    // create test (accessible from doctor)
    public CreateTestGUI(int testID, int patientID, int docid, String patientName, String doctorName) {
        initComponents();
        this.docid = docid;
        this.testid = testID;
        this.patid = patientID;
        this.patName = patientName;
        this.docName = doctorName;
        createAdj();
    }

    // edit test (accessible from doctor)
    public CreateTestGUI(int testID) {
        initComponents();
        this.testid = testID;
        updateAdj();
    }

    //update login adjustments.
    public void updateAdj() {
        getTestInfo();
        jLabel1.setText("UPDATE TEST");
        combo_testTypes.setEnabled(false);
        btn_createTest.setEnabled(false);
        date_chooser.setEnabled(false);
        txt_findings.setEnabled(true);
        date_chooser2.setEnabled(true);
        txt_cost.setEnabled(false);
        Date date = new Date();
        date_chooser.setMinSelectableDate(date);
        date_chooser2.setMinSelectableDate(date);

    }
    //create login adjustments

    public void createAdj() {
        jLabel1.setText("CREATE TEST");
        txt_findings.setEnabled(false);
        txt_findings.setVisible(false);
        date_chooser2.setEnabled(false);
        btn_update.setEnabled(false);
        btn_update.setVisible(false);
        Date date = new Date();
        date_chooser.setMinSelectableDate(date);
        date_chooser2.setMinSelectableDate(date);
        informations();

    }

    //this method updates test results.
    public boolean updateTest(String date, String finds) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("UPDATE TEST SET MEDICALFINDING =?, RESULTDATE = ? WHERE ID = ? ");
            pst.setString(1, finds);
            pst.setString(2, date);
            pst.setInt(3, this.testid);
            pst.executeUpdate();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;

    }

    //this method fills in the test information fields.
    public void getTestInfo() {

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST WHERE ID = ?");
            pst.setInt(1, this.testid);
            rs = pst.executeQuery();
            if (rs.next()) {
                txt_docName.setText(rs.getString("DOCTORNAME"));
                String patientID = Integer.toString(rs.getInt("PATIENTID"));
                txt_patientID.setText(patientID);
                txt_cost.setText(rs.getString("COST"));
                txt_patientName.setText(rs.getString("PATIENTNAME"));
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void informations() {
        txt_docName.setText(docName);
        txt_patientID.setText(Integer.toString(patid));
        txt_patientName.setText(patName);
    }

    //date control
    public boolean date() {
        boolean rvalue;
        if (date_chooser.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Date Must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
            rvalue = false;
            return rvalue;
        } else {
            SimpleDateFormat testdate = new SimpleDateFormat("yyyy-MM-dd");
            testDate = testdate.format(date_chooser.getDate());
            rvalue = true;
            return rvalue;
        }
    }

    //date control
    public boolean date2() {
        boolean rvalue;
        if (date_chooser2.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Date Must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
            rvalue = false;
            return rvalue;
        } else {
            SimpleDateFormat testdate = new SimpleDateFormat("yyyy-MM-dd");
            resultdate = testdate.format(date_chooser2.getDate());
            rvalue = true;
            return rvalue;
        }
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_docName = new javax.swing.JTextField();
        txt_patientID = new javax.swing.JTextField();
        txt_patientName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combo_testTypes = new javax.swing.JComboBox<>();
        txt_cost = new javax.swing.JTextField();
        btn_createTest = new javax.swing.JButton();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_findings = new javax.swing.JTextArea();
        btn_update = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        date_chooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(120, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CREATE TEST");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Patient ID:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Doctor Name:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Patient Name:");

        txt_docName.setForeground(new java.awt.Color(0, 0, 0));
        txt_docName.setEnabled(false);

        txt_patientID.setBackground(new java.awt.Color(255, 255, 255));
        txt_patientID.setForeground(new java.awt.Color(0, 0, 0));
        txt_patientID.setEnabled(false);

        txt_patientName.setForeground(new java.awt.Color(0, 0, 0));
        txt_patientName.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Test Type:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Test Date:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cost:");

        combo_testTypes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        combo_testTypes.setForeground(new java.awt.Color(0, 0, 0));
        combo_testTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Test", "Corona Test", "HIV Test", "AIDS Test", "H1N1 Test", "Influenza Test" }));
        combo_testTypes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_testTypesİtemStateChanged(evt);
            }
        });

        txt_cost.setForeground(new java.awt.Color(0, 0, 0));
        txt_cost.setEnabled(false);

        btn_createTest.setBackground(new java.awt.Color(170, 255, 255));
        btn_createTest.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_createTest.setForeground(new java.awt.Color(0, 0, 0));
        btn_createTest.setText("CREATE TEST");
        btn_createTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createTestActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Medical Findings:");

        txt_findings.setColumns(20);
        txt_findings.setLineWrap(true);
        txt_findings.setRows(5);
        txt_findings.setEnabled(false);
        jScrollPane1.setViewportView(txt_findings);

        btn_update.setBackground(new java.awt.Color(170, 255, 255));
        btn_update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(0, 0, 0));
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Result Date:");

        date_chooser2.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_docName)
                                    .addComponent(txt_patientName)
                                    .addComponent(txt_patientID)
                                    .addComponent(combo_testTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel8))
                                                .addGap(104, 104, 104))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_cost)
                                            .addComponent(date_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                            .addComponent(date_chooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_createTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_docName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_patientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_patientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(combo_testTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8))
                    .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_chooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_createTest, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //this method creates new test.
    private void btn_createTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createTestActionPerformed
        boolean controlDate = date();
        if (controlDate) {
            if (combo_testTypes.getSelectedIndex() == 0) {
                txt_cost.setText("20.75 USD");
            }
            String type = (String) combo_testTypes.getSelectedItem();
            System.out.println(type);
            SimpleDateFormat testdate = new SimpleDateFormat("yyyy-MM-dd");
            testDate = testdate.format(date_chooser.getDate());
            String cost = txt_cost.getText();
            boolean addTest = addNewTest(type, cost);
            if (addTest) {
                JOptionPane.showMessageDialog(rootPane, "Test has been created successfully!", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "This test already exists.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Date can not be empty!.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_createTestActionPerformed

    //when you change the combobox selection, test prices will be change. 
    private void combo_testTypesİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_testTypesİtemStateChanged

        if (combo_testTypes.getSelectedItem().equals("Blood Test")) {
            txt_cost.setText("20.75 USD");
        } else if (combo_testTypes.getSelectedItem().equals("HIV Test")) {
            txt_cost.setText("75 USD");
        } else if (combo_testTypes.getSelectedItem().equals("Corona Test")) {
            txt_cost.setText("59 USD");
        } else if (combo_testTypes.getSelectedItem().equals("AIDS Test")) {
            txt_cost.setText("45 USD");
        } else if (combo_testTypes.getSelectedItem().equals("H1N1 Test")) {
            txt_cost.setText("39 USD");
        } else if (combo_testTypes.getSelectedItem().equals("Influenza Test")) {
            txt_cost.setText("35 USD");
        }

    }//GEN-LAST:event_combo_testTypesİtemStateChanged

    //this method updates the test informations.
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (txt_findings.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Medical findings must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean controlDate = date2();
        if (controlDate) {
            boolean control = updateTest(resultdate, txt_findings.getText());
            if (control) {
                JOptionPane.showMessageDialog(rootPane, "Test has been updated successfully!", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Date Must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Date Must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    //this method adds new test into database. 
    public boolean addNewTest(String type, String cost) {
        boolean rvalue = false;
        try {
            //if test id already exists in db, you cannot create the same test.
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST WHERE ID = ? ");
            pst.setInt(1, this.testid);
            rs = pst.executeQuery();
            if (rs.next()) {
                conn.close();
                rvalue = false;
                return rvalue;

            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pst = conn.prepareStatement("INSERT INTO TEST VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, this.testid);
                pst.setInt(2, this.patid);
                pst.setInt(3, this.docid);
                pst.setString(4, this.docName);
                pst.setString(5, this.patName);
                pst.setString(6, "ROYAL HOSPITAL");
                pst.setString(7, type);
                pst.setString(8, this.testDate);
                pst.setString(9, "ONGOING");
                pst.setString(10, "ONGOING");
                pst.setString(11, cost);
                pst.executeUpdate();
                rvalue = true;
                return rvalue;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;

    }

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
            java.util.logging.Logger.getLogger(CreateTestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTestGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTestGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createTest;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_testTypes;
    private com.toedter.calendar.JDateChooser date_chooser;
    private com.toedter.calendar.JDateChooser date_chooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_cost;
    private javax.swing.JTextField txt_docName;
    private javax.swing.JTextArea txt_findings;
    private javax.swing.JTextField txt_patientID;
    private javax.swing.JTextField txt_patientName;
    // End of variables declaration//GEN-END:variables
}
