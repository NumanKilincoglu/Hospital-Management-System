/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagement;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author numan.kilincoglu
 */
public class Login extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Login() throws IOException {
        initComponents();
        URL resource = this.getClass().getClassLoader().getResource("images/yeni.jpg");
        ImageIcon foto = new ImageIcon(resource);
        background.setIcon(foto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        pnl_login = new javax.swing.JPanel();
        tab_Login = new javax.swing.JTabbedPane();
        tab_adminLogin = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_adminLogin = new javax.swing.JButton();
        txt_adminPass = new javax.swing.JPasswordField();
        txt_adminTC = new javax.swing.JFormattedTextField();
        check_dark = new javax.swing.JCheckBox();
        tab_doctorLogin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_docLogin = new javax.swing.JButton();
        txt_docPass = new javax.swing.JPasswordField();
        txt_doctorTC = new javax.swing.JFormattedTextField();
        tab_phramLogin = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_pharmaLogin = new javax.swing.JButton();
        txt_pharmaPass = new javax.swing.JPasswordField();
        txt_pharmaTC = new javax.swing.JFormattedTextField();
        tab_patientLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_patientLogin = new javax.swing.JButton();
        btn_patientRegister = new javax.swing.JButton();
        txt_patientPass = new javax.swing.JPasswordField();
        date_txt = new javax.swing.JLabel();
        txt_patientTC = new javax.swing.JFormattedTextField();
        lbl_header = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Management System");
        setResizable(false);

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));
        pnl_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_Login.setBackground(new java.awt.Color(204, 255, 204));
        tab_Login.setForeground(new java.awt.Color(0, 0, 0));
        tab_Login.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tab_Login.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N

        tab_adminLogin.setBackground(new java.awt.Color(205, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Admin Login");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("TC No");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Password");

        btn_adminLogin.setBackground(new java.awt.Color(120, 255, 255));
        btn_adminLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_adminLogin.setForeground(new java.awt.Color(0, 0, 0));
        btn_adminLogin.setText("Login");
        btn_adminLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_adminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adminLoginActionPerformed(evt);
            }
        });

        txt_adminPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_adminTC.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txt_adminTC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_adminTC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        check_dark.setBackground(new java.awt.Color(205, 255, 255));
        check_dark.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        check_dark.setForeground(new java.awt.Color(0, 0, 0));
        check_dark.setText("Dark Theme");
        check_dark.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_darkİtemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout tab_adminLoginLayout = new javax.swing.GroupLayout(tab_adminLogin);
        tab_adminLogin.setLayout(tab_adminLoginLayout);
        tab_adminLoginLayout.setHorizontalGroup(
            tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_adminLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_adminLoginLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_adminLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_adminPass)
                    .addComponent(txt_adminTC))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_adminLoginLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(check_dark, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        tab_adminLoginLayout.setVerticalGroup(
            tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_adminLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_adminTC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(tab_adminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(txt_adminPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_adminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(check_dark)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tab_Login.addTab("Admin Login", tab_adminLogin);

        tab_doctorLogin.setBackground(new java.awt.Color(205, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Doctor Login ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("TC No");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Password");

        btn_docLogin.setBackground(new java.awt.Color(120, 255, 255));
        btn_docLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_docLogin.setForeground(new java.awt.Color(0, 0, 0));
        btn_docLogin.setText("Login");
        btn_docLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_docLoginActionPerformed(evt);
            }
        });

        txt_docPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_doctorTC.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txt_doctorTC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_doctorTC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout tab_doctorLoginLayout = new javax.swing.GroupLayout(tab_doctorLogin);
        tab_doctorLogin.setLayout(tab_doctorLoginLayout);
        tab_doctorLoginLayout.setHorizontalGroup(
            tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_doctorLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_doctorLoginLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_docPass, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(btn_docLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_doctorTC))
                .addGap(113, 113, 113))
        );
        tab_doctorLoginLayout.setVerticalGroup(
            tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_doctorLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_doctorTC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(tab_doctorLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txt_docPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_docLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tab_Login.addTab("Doctor Login", tab_doctorLogin);

        tab_phramLogin.setBackground(new java.awt.Color(205, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pharmacist Login");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("TC No");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Password");

        btn_pharmaLogin.setBackground(new java.awt.Color(120, 255, 255));
        btn_pharmaLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_pharmaLogin.setForeground(new java.awt.Color(0, 0, 0));
        btn_pharmaLogin.setText("Login");
        btn_pharmaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pharmaLoginActionPerformed(evt);
            }
        });

        txt_pharmaPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_pharmaTC.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txt_pharmaTC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_pharmaTC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout tab_phramLoginLayout = new javax.swing.GroupLayout(tab_phramLogin);
        tab_phramLogin.setLayout(tab_phramLoginLayout);
        tab_phramLoginLayout.setHorizontalGroup(
            tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_phramLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_phramLoginLayout.createSequentialGroup()
                        .addGroup(tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tab_phramLoginLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_pharmaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(txt_pharmaPass)))
                            .addGroup(tab_phramLoginLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(79, 79, 79)
                                .addComponent(txt_pharmaTC)))
                        .addGap(113, 113, 113))
                    .addGroup(tab_phramLoginLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel11)
                        .addContainerGap())))
        );
        tab_phramLoginLayout.setVerticalGroup(
            tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_phramLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_pharmaTC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(tab_phramLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txt_pharmaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_pharmaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tab_Login.addTab("Pharmacist Login", tab_phramLogin);

        tab_patientLogin.setBackground(new java.awt.Color(205, 255, 255));
        tab_patientLogin.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Patient Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TC No");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Password");

        btn_patientLogin.setBackground(new java.awt.Color(120, 255, 255));
        btn_patientLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_patientLogin.setForeground(new java.awt.Color(0, 0, 0));
        btn_patientLogin.setText("Login ");
        btn_patientLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_patientLoginActionPerformed(evt);
            }
        });

        btn_patientRegister.setBackground(new java.awt.Color(120, 255, 255));
        btn_patientRegister.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_patientRegister.setForeground(new java.awt.Color(0, 0, 0));
        btn_patientRegister.setText("Register");
        btn_patientRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_patientRegisterActionPerformed(evt);
            }
        });

        txt_patientPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_patientTC.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txt_patientTC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_patientTC.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout tab_patientLoginLayout = new javax.swing.GroupLayout(tab_patientLogin);
        tab_patientLogin.setLayout(tab_patientLoginLayout);
        tab_patientLoginLayout.setHorizontalGroup(
            tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_patientLoginLayout.createSequentialGroup()
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_patientLoginLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab_patientLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_patientPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_patientLoginLayout.createSequentialGroup()
                        .addComponent(btn_patientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_patientRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addComponent(txt_patientTC))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        tab_patientLoginLayout.setVerticalGroup(
            tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_patientLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_patientLoginLayout.createSequentialGroup()
                        .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_patientLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_patientTC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txt_patientPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(tab_patientLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_patientLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_patientRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tab_Login.addTab("Patient Login", tab_patientLogin);

        pnl_login.add(tab_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 510, 370));

        lbl_header.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(61, 150, 222));
        lbl_header.setText("Hospital Management System");
        lbl_header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_login.add(lbl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 570, -1));

        background.setToolTipText("");
        background.setOpaque(true);
        pnl_login.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_patientRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_patientRegisterActionPerformed

        PatientRegistrationGUI h1 = new PatientRegistrationGUI();
        h1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_patientRegisterActionPerformed

    private void btn_docLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_docLoginActionPerformed
        String doctorTC = txt_doctorTC.getText();
        String pass = new String(txt_docPass.getPassword());
        boolean rval = false;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM DOCTORS WHERE TCNO = ? AND PASSWORD = ?");
            pst.setString(1, doctorTC);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                DoctorGUI docSection = new DoctorGUI(doctorTC);
                docSection.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "TCNO or password wrong", "Login Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_docLoginActionPerformed

    private void btn_adminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adminLoginActionPerformed
        String adminTCNO = txt_adminTC.getText();
        String adminPass = new String(txt_adminPass.getPassword());
        boolean rval = false;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM ADMIN WHERE TC = ? AND PASSWORD = ?");
            pst.setString(1, adminTCNO);
            pst.setString(2, adminPass);
            rs = pst.executeQuery();
            if (rs.next()) {
                AdminGUI adminSection = new AdminGUI(adminTCNO);
                adminSection.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "TCNO or Password wrong.", "Login Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_adminLoginActionPerformed

    private void btn_pharmaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pharmaLoginActionPerformed
        String pharmaTCNO = txt_pharmaTC.getText();
        String pharmaPass = new String(txt_pharmaPass.getPassword());
        boolean rval = false;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PHARMACISTS WHERE TCNO = ? AND PASSWORD = ?");
            pst.setString(1, pharmaTCNO);
            pst.setString(2, pharmaPass);
            rs = pst.executeQuery();
            if (rs.next()) {
                PharmacyGUI pharmacy = new PharmacyGUI(pharmaTCNO);
                pharmacy.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "TCNO or Password wrong.", "Login Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_pharmaLoginActionPerformed

    private void btn_patientLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_patientLoginActionPerformed
        String patientTC = txt_patientTC.getText();
        String pass = new String(txt_patientPass.getPassword());
        boolean rval = false;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PATIENTS WHERE TCNO = ? AND PASSWORD = ?");
            pst.setString(1, patientTC);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                PatientGUI patientfrm = new PatientGUI(patientTC);
                patientfrm.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "TCNO or password wrong.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_patientLoginActionPerformed

    //THIS CHECKBOX ACTIVATE DARK THEME.
    private void check_darkİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_darkİtemStateChanged
        Color old = new Color(205, 255, 255);
        if (check_dark.isSelected()) {
            Color c = new Color(68, 68, 68);
            tab_adminLogin.setBackground(c);
            tab_doctorLogin.setBackground(c);
            tab_patientLogin.setBackground(c);
            tab_phramLogin.setBackground(c);
        } else {
            tab_adminLogin.setBackground(old);
            tab_doctorLogin.setBackground(old);
            tab_patientLogin.setBackground(old);
            tab_phramLogin.setBackground(old);
        }
    }//GEN-LAST:event_check_darkİtemStateChanged

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_adminLogin;
    private javax.swing.JButton btn_docLogin;
    private javax.swing.JButton btn_patientLogin;
    private javax.swing.JButton btn_patientRegister;
    private javax.swing.JButton btn_pharmaLogin;
    private javax.swing.JCheckBox check_dark;
    private javax.swing.JLabel date_txt;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JTabbedPane tab_Login;
    private javax.swing.JPanel tab_adminLogin;
    private javax.swing.JPanel tab_doctorLogin;
    private javax.swing.JPanel tab_patientLogin;
    private javax.swing.JPanel tab_phramLogin;
    private javax.swing.JPasswordField txt_adminPass;
    private javax.swing.JFormattedTextField txt_adminTC;
    private javax.swing.JPasswordField txt_docPass;
    private javax.swing.JFormattedTextField txt_doctorTC;
    private javax.swing.JPasswordField txt_patientPass;
    private javax.swing.JFormattedTextField txt_patientTC;
    private javax.swing.JPasswordField txt_pharmaPass;
    private javax.swing.JFormattedTextField txt_pharmaTC;
    // End of variables declaration//GEN-END:variables
}
