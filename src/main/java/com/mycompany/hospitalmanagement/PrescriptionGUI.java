/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagement;

import Objects.Doctor;
import Objects.Prescription;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author numan.kilincoglu
 */
public class PrescriptionGUI extends javax.swing.JFrame implements ActionListener {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    private int docID, patientID, branchID, prescriptionID, appID;
    private String DocName, patientName, date, branch, cost;

    /**
     * Creates new form Prescription
     */

    public PrescriptionGUI() {
        initComponents();
    }

    // doc login
    public PrescriptionGUI(int DocID, String DocName, String branch, String date, int patientID, String patientName, int branchID, int appID) {
        initComponents();
        lbl_header.setText("Create Prescription");
        btn_createPrescript.setVisible(true);
        btn_createPrescript.setEnabled(true);
        btn_closePrescription.setEnabled(false);
        btn_closePrescription.setVisible(false);
        this.DocName = DocName;
        this.docID = DocID;
        this.patientID = patientID;
        this.patientName = patientName;
        this.date = date;
        this.branch = branch;
        this.branchID = branchID;
        this.appID = appID;
        showInfos();
    }

    //PATIENT && PHARMACY ISNPECTION LOGIN
    public PrescriptionGUI(int prescriptionID, String x) {
        initComponents();
        lbl_header.setText("Prescription Details");
        this.prescriptionID = prescriptionID;
        btn_createPrescript.setVisible(false);
        btn_createPrescript.setEnabled(false);
        btn_closePrescription.setEnabled(false);
        btn_closePrescription.setVisible(false);
        txt_medication.setEnabled(false);
        txt_comment.setEnabled(false);
        getDocPrecriptionInfo();
    }

    public PrescriptionGUI(int prescriptionID) {
        initComponents();
        lbl_header.setText("Prescription Details");
        this.prescriptionID = prescriptionID;
        txt_medication.setEnabled(false);
        txt_comment.setEnabled(false);
        showInfos();
        getDocPrecriptionInfo();
        btn_createPrescript.setVisible(false);
        btn_createPrescript.setEnabled(false);

    }
    // PHARMACY LOGIN

    public PrescriptionGUI(int prescriptionID, String pharmacyLogin, String cost) {
        initComponents();
        lbl_header.setText("Prescription Details");
        this.prescriptionID = prescriptionID;
        this.cost = cost;
        System.out.println(this.prescriptionID + " " + this.cost);
        txt_medication.setEnabled(false);
        txt_comment.setEnabled(false);
        showInfos();
        getDocPrecriptionInfo();
        btn_createPrescript.setVisible(false);
        btn_createPrescript.setEnabled(false);
    }

    public void showInfos() {
        txt_docName.setText(DocName);
        txt_patientName.setText(patientName);
        txt_patientID.setText(Integer.toString(patientID));

    }

    //NULL CONTROL
    public boolean control() {
        boolean rvalue = false;
        if (txt_medication == null) {
            JOptionPane.showMessageDialog(this, "Please fill the blanks!");
            rvalue = false;
            return rvalue;
        } else if (txt_comment == null) {
            JOptionPane.showMessageDialog(this, "Please fill the blanks!");
            rvalue = false;
            return rvalue;
        } else {
            rvalue = true;
            return rvalue;
        }

    }

    //THIS METHOD SAVE NEW PRESCRIPTION INTO DATABASE
    public boolean createPrescript() {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE STATUS = ? AND APPOINTMENTID = ? ");
            pst.setString(1, "CREATED");
            pst.setInt(2, this.appID);
            rs = pst.executeQuery();
            if (rs.next()) {
                conn.close();
                rvalue = false;
                return rvalue;
            }

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("INSERT INTO PRESCRIPTIONS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, autoID());
            pst.setInt(2, this.patientID);
            pst.setInt(3, docID);
            pst.setString(4, this.DocName);
            pst.setString(5, this.patientName);
            pst.setString(6, this.date);
            pst.setString(7, this.branch);
            pst.setString(8, txt_comment.getText());
            pst.setInt(9, this.branchID);
            pst.setString(10, txt_medication.getText());
            pst.setString(11, "CREATED");
            pst.setString(12, "IN PROGRESS");
            pst.setInt(13, this.appID);
            pst.executeUpdate();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(PrescriptionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    private int autoID() {
        int id = 0;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM PRESCRIPTIONS");
            rs.next();
            rs.getInt(1);
            if (rs.getInt(1) == 0) {
                id = 1;
                return id;
            } else {
                id = (rs.getInt(1));
                id++;
                return id;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    public void getDocPrecriptionInfo() {
        Prescription nprescription = new Prescription();
        nprescription = nprescription.prescription(this.prescriptionID);
        txt_docName.setText(nprescription.getDocName());
        System.out.println(nprescription.getDocName());
        txt_patientName.setText(nprescription.getPatientName());
        txt_patientID.setText(Integer.toString(nprescription.getPatientID()));
        txt_medication.setText(nprescription.getMedication());
        txt_comment.setText(nprescription.getComment());

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
        lbl_header = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_docName = new javax.swing.JTextField();
        txt_patientID = new javax.swing.JTextField();
        txt_patientName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_medication = new javax.swing.JTextArea();
        btn_createPrescript = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_comment = new javax.swing.JTextArea();
        btn_closePrescription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(120, 255, 255));

        lbl_header.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(0, 0, 0));
        lbl_header.setText("Create Prescription");

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

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Medication:");

        txt_medication.setColumns(20);
        txt_medication.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_medication.setForeground(new java.awt.Color(0, 0, 0));
        txt_medication.setLineWrap(true);
        txt_medication.setRows(5);
        jScrollPane1.setViewportView(txt_medication);

        btn_createPrescript.setBackground(new java.awt.Color(100, 176, 235));
        btn_createPrescript.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_createPrescript.setForeground(new java.awt.Color(0, 0, 0));
        btn_createPrescript.setText("Create Prescription");
        btn_createPrescript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createPrescriptActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Comment:");

        txt_comment.setColumns(20);
        txt_comment.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_comment.setForeground(new java.awt.Color(0, 0, 0));
        txt_comment.setLineWrap(true);
        txt_comment.setRows(5);
        jScrollPane2.setViewportView(txt_comment);

        btn_closePrescription.setBackground(new java.awt.Color(100, 176, 235));
        btn_closePrescription.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_closePrescription.setForeground(new java.awt.Color(0, 0, 0));
        btn_closePrescription.setText("Close Prescription");
        btn_closePrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closePrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_closePrescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_createPrescript, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_docName)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_patientName)
                            .addComponent(txt_patientID)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_header, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header)
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
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btn_createPrescript, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_closePrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createPrescriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createPrescriptActionPerformed

        if (control()) {
            if (createPrescript()) {
                JOptionPane.showMessageDialog(this, "Prescription has been created.", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "This patient already has a active prescription.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_createPrescriptActionPerformed

    private void btn_closePrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closePrescriptionActionPerformed

        if (closePresc()) {
            JOptionPane.showMessageDialog(this, "Prescription was closed", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            Timer timer = new Timer(1000, (ActionListener) this);
            timer.start();
        } else {
            JOptionPane.showMessageDialog(this, "This prescription is already closed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_closePrescriptionActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }

    public boolean closePresc() {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE ID = ? AND STATUS = ? ");
            pst.setInt(1, this.prescriptionID);
            pst.setString(2, "CLOSED");
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                return rvalue;
            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pst = conn.prepareStatement("UPDATE PRESCRIPTIONS SET STATUS = ?, COST =? WHERE ID =?");
                pst.setString(1, "CLOSED");
                pst.setString(2, this.cost);
                pst.setInt(3, this.prescriptionID);
                pst.executeUpdate();
                rvalue = true;
                return rvalue;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PharmacyGUI.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_closePrescription;
    private javax.swing.JButton btn_createPrescript;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JTextArea txt_comment;
    private javax.swing.JTextField txt_docName;
    private javax.swing.JTextArea txt_medication;
    private javax.swing.JTextField txt_patientID;
    private javax.swing.JTextField txt_patientName;
    // End of variables declaration//GEN-END:variables
}
