/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalmanagement;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author numan.kilincoglu
 */
public class AdminUpdatePharmacist extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    int id;

    /**
     * Creates new form AdminUpdatePharmacist
     */
    public AdminUpdatePharmacist() {
        initComponents();
        pnl_rules.setVisible(false);
    }

    public AdminUpdatePharmacist(int id) {
        initComponents();
        this.id = id;
        fillBlanks();
        pnl_rules.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        doctorUpdate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        sur_txt = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        g_male = new javax.swing.JRadioButton();
        g_female = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pass_txt = new javax.swing.JPasswordField();
        combo_city = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        btn_updateAgent = new javax.swing.JButton();
        phone_txt = new javax.swing.JFormattedTextField();
        txt_tcno = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pnl_rules = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        pass_bar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        doctorUpdate.setBackground(new java.awt.Color(170, 255, 255));
        doctorUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        doctorUpdate.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NAME");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("SURNAME");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TC NO");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("PHONE");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("MAIL");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("GENDER");

        name_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        sur_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txt_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        buttonGroup1.add(g_male);
        g_male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        g_male.setText("MALE");

        buttonGroup1.add(g_female);
        g_female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        g_female.setText("FEMALE");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PASSWORD");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("PLACE OF BIRTH");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("DATE OF BIRTH");

        pass_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pass_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pass_txtKeyReleased(evt);
            }
        });

        combo_city.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DUZCE", "ISTANBUL", "ANKARA", "IZMIR", "ADANA", "KOCAELI" }));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Agent Records");

        datechooser.setToolTipText("");

        btn_updateAgent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_updateAgent.setForeground(new java.awt.Color(0, 0, 0));
        btn_updateAgent.setText("Update Records");
        btn_updateAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateAgentActionPerformed(evt);
            }
        });

        try {
            phone_txt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phone_txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        try {
            txt_tcno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tcno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        pnl_rules.setBackground(new java.awt.Color(170, 255, 255));
        pnl_rules.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Rules", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setText("* Surname must contain only letters.");

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("* Surname must contain only letters.");

        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setText("* Name must contain only letters.");

        jLabel49.setForeground(new java.awt.Color(255, 0, 0));
        jLabel49.setText("* TCNO must  be 11 numerical characters only.");

        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("* Password must contains at least 5 charachters and  ");

        jLabel51.setForeground(new java.awt.Color(255, 0, 0));
        jLabel51.setText("1 special charachter.");

        javax.swing.GroupLayout pnl_rulesLayout = new javax.swing.GroupLayout(pnl_rules);
        pnl_rules.setLayout(pnl_rulesLayout);
        pnl_rulesLayout.setHorizontalGroup(
            pnl_rulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rulesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_rulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_rulesLayout.createSequentialGroup()
                        .addGroup(pnl_rulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_rulesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_rulesLayout.setVerticalGroup(
            pnl_rulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_rulesLayout.createSequentialGroup()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addGap(28, 28, 28))
        );

        pass_bar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        javax.swing.GroupLayout doctorUpdateLayout = new javax.swing.GroupLayout(doctorUpdate);
        doctorUpdate.setLayout(doctorUpdateLayout);
        doctorUpdateLayout.setHorizontalGroup(
            doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorUpdateLayout.createSequentialGroup()
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabel3))
                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_rules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(doctorUpdateLayout.createSequentialGroup()
                                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, doctorUpdateLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, doctorUpdateLayout.createSequentialGroup()
                                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phone_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_tcno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sur_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(51, 51, 51)
                                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorUpdateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(doctorUpdateLayout.createSequentialGroup()
                            .addComponent(g_male)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(g_female))
                        .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_updateAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_city, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                        .addComponent(pass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(pass_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        doctorUpdateLayout.setVerticalGroup(
            doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(sur_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tcno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(44, 44, 44)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(doctorUpdateLayout.createSequentialGroup()
                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(g_male)
                            .addComponent(g_female))
                        .addGap(48, 48, 48)
                        .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))))
                    .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(doctorUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_rules, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doctorUpdateLayout.createSequentialGroup()
                        .addComponent(btn_updateAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doctorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doctorUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //this method fetches selected agent's informations from database.
    public void fillBlanks() {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("SELECT * FROM PHARMACISTS WHERE ID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, this.id);
            rs = pst.executeQuery();
            if (rs.next()) {
                name_txt.setText(rs.getString("NAME"));
                sur_txt.setText(rs.getString("SURNAME"));
                txt_tcno.setText(rs.getString("TCNO"));
                phone_txt.setText(rs.getString("PHONE"));
                txt_mail.setText(rs.getString("MAIL"));
                pass_txt.setText(rs.getString("PASSWORD"));
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdatePharmacist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //THIS METHOD TAKES INFORMATIONS FROM TEXTFIELDS.
    public void getInfo() {

        boolean rval = false;
        Connection conn = null;
        String pass = new String(pass_txt.getPassword());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String hastaTC = txt_tcno.getText();
        String name = name_txt.getText();
        String surname = sur_txt.getText();
        String phone = phone_txt.getText();
        String mail = txt_mail.getText();
        String city = (String) combo_city.getSelectedItem();

        Matcher matcher;
        //regex controls

        if (txt_tcno.getText().isEmpty()) {
            pnl_rules.setVisible(true);
            return;
        } else {
            pnl_rules.setVisible(false);
        }

        if (name_txt.getText().isEmpty()) {
            pnl_rules.setVisible(true);
            return;
        } else {
            matcher = Pattern.compile("^[a-zA-Z\\u0080-\\u9fff]*+$").matcher(name_txt.getText());
            if (!matcher.find()) {
                System.out.println("tutamdi");
                pnl_rules.setVisible(true);
                return;
            } else {
                System.out.println("tutttu");
                pnl_rules.setVisible(false);
            }
        }

        if (sur_txt.getText().isEmpty()) {
            pnl_rules.setVisible(true);
            return;
        } else {
            matcher = Pattern.compile("^[a-zA-Z\\u0080-\\u9fff]*+$").matcher(sur_txt.getText());
            if (!matcher.find()) {
                System.out.println("tutamdi");
                pnl_rules.setVisible(true);
                return;
            } else {
                System.out.println("tutttu");
                pnl_rules.setVisible(false);
            }
        }

        if (phone_txt.getText().isEmpty()) {
            pnl_rules.setVisible(true);
            return;
        } else {
            pnl_rules.setVisible(false);
        }

        if (txt_mail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please fill in all the required fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            matcher = Pattern.compile("^[a-zA-Z][\\w\\d]{2,}@[a-z]{2,10}(.com)$").matcher(txt_mail.getText());
            if (!matcher.find()) {
                System.out.println("mail olmadi");
                pnl_rules.setVisible(true);
                return;
            } else {
                System.out.println("mail tuttu");
                pnl_rules.setVisible(false);
            }
        }
        if (pass_txt.getPassword().length == 0) {
            pnl_rules.setVisible(true);
            return;
        } else {
            if (pass_bar.getValue() < 33) {
                pnl_rules.setVisible(true);
            } else {
                pnl_rules.setVisible(false);
            }
        }

        if (datechooser.getDate() == null) {
            pnl_rules.setVisible(true);
            return;
        } else {
            pnl_rules.setVisible(false);
        }

        String datebirth = date.format(datechooser.getDate());

        String gender = "";
        if (g_male.isSelected()) {
            gender = "MALE";
        } else {
            gender = "FEMALE";
        }
        boolean control = updateRecords(hastaTC, pass, name, surname, phone, mail, city, datebirth, gender);

        if (control) {
            JOptionPane.showMessageDialog(rootPane, "Record Uptated", "Successfull", JOptionPane.INFORMATION_MESSAGE);
            int x = JOptionPane.showConfirmDialog(rootPane, "Do you want to go to main page", "Information", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "TCNO, PHONE AND MAIL MUST BE UNIQUE!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    //this method updates agent'S records.   

    public boolean updateRecords(String tc, String pass, String name, String surname, String phone, String mail, String city, String datebirth, String gender) {
        boolean rvalue = false;
        try {
            boolean x = mailControl(mail, tc);
            boolean y = phoneControl(phone, tc);
            boolean z = tcControl(tc);
            if (!z) {
                if (!x) {
                    if (!y) {
                        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                        pst = conn.prepareStatement("UPDATE PHARMACISTS SET NAME = ?, SURNAME = ?, PHONE=? , MAIL=?, PLACEBIRTH =?, BIRTHDATE=? , GENDER=?, TCNO = ?, PASSWORD=? WHERE ID = ?");
                        pst.setString(1, name);
                        pst.setString(2, surname);
                        pst.setString(3, phone);
                        pst.setString(4, mail);
                        pst.setString(5, city);
                        pst.setString(6, datebirth);
                        pst.setString(7, gender);
                        pst.setString(8, tc);
                        pst.setString(9, pass);
                        pst.setInt(10, this.id);
                        pst.executeUpdate();
                        conn.close();
                        rvalue = true;
                        return rvalue;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;

    }

//following 3 methods control uniqueness of mail,tc,and phone.
    public boolean mailControl(String mail, String tc) {

        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PHARMACISTS WHERE MAIL = ?");
            pst.setString(1, mail);
            rs = pst.executeQuery();
            int key = 0;
            String TC = "";
            while (rs.next()) {
                TC = rs.getString("TCNO");
                key++;
            }
            conn.close();
            if (key > 2) {
                rvalue = true;
                System.out.println("key > 2 girdi");
            } else if (key > 1 && !TC.equals(tc)) {
                rvalue = true;
                System.out.println("key > 1 girdi");
            } else if (key == 1 && !TC.equals(tc)) {
                System.out.println("key == 1 ve !tc girdi");
                rvalue = true;
            } else if (key == 1 && TC.equals(tc)) {
                System.out.println("key ==1 girdi");
                rvalue = false;

            }

            System.out.println("mail count " + key);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;

    }

    public boolean phoneControl(String number, String tc) {
        boolean rvalue = false;
        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PHARMACISTS WHERE PHONE = ?");
            pst.setString(1, number);
            rs = pst.executeQuery();
            int key = 0;
            String TC = "";
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
                TC = rs.getString("TCNO");
                key++;
            }
            conn.close();
            if (key > 2) {
                System.out.println("key > 2 girdi");
                rvalue = true;
            } else if (key > 1 && !TC.equals(tc)) {
                System.out.println("key > 1 girdi");
                rvalue = true;
            } else if (key == 1 && !TC.equals(tc)) {
                System.out.println("key == 1 ve !tc gird");
                rvalue = true;
            } else if (key == 1 && TC.equals(tc)) {
                System.out.println("key ==1 girdi");
                rvalue = false;
            }
            System.out.println("tel count " + key);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;

    }

    public boolean tcControl(String tc) {

        boolean rvalue = false;
        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PHARMACISTS WHERE TCNO = ?");
            pst.setString(1, tc);
            rs = pst.executeQuery();
            int key = 0;
            String TC = "";
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
                TC = rs.getString("TCNO");
                key++;
            }
            conn.close();
            if (key > 2) {
                System.out.println("key > 2 girdi");
                rvalue = true;
            } else if (key > 1 && !TC.equals(tc)) {
                System.out.println("key > 1 girdi");
                rvalue = true;
            } else if (key == 1 && !TC.equals(tc)) {
                System.out.println("key == 1 ve !tc gird");
                rvalue = true;
            } else if (key == 1 && TC.equals(tc)) {
                System.out.println("key ==1 girdi");
                rvalue = false;
            }
            System.out.println("tel count " + key);
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;

    }

    public int passwordStrength(String pass) {

        int passScore = 0;
        if (pass.length() < 5) {
            return 0;
        } else if (pass.length() >= 10) {
            passScore += 2;
        } else {
            passScore += 1;
        }

        if (pass.matches("(?=.*[0-9]).*")) {
            passScore += 2;
        }

        if (pass.matches("(?=.*[a-z]).*")) {
            passScore += 2;
        }

        if (pass.matches("(?=.*[A-Z]).*")) {
            passScore += 2;
        }

        if (pass.matches("(?=.*[~!@#$%^&*()_-]).*")) {
            passScore += 2;
        }
        return passScore;
    }

    private void btn_updateAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateAgentActionPerformed
        getInfo();
    }//GEN-LAST:event_btn_updateAgentActionPerformed

    //password strength control
    private void pass_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_txtKeyReleased
        pass_bar.setForeground(Color.BLACK);
        String pass = new String(pass_txt.getPassword());
        pass_bar.setStringPainted(true);
        int strength = passwordStrength(pass);
        pass_bar.setValue(strength * 10);
    }//GEN-LAST:event_pass_txtKeyReleased

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
            java.util.logging.Logger.getLogger(AdminUpdatePharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUpdatePharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUpdatePharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUpdatePharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUpdatePharmacist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_updateAgent;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_city;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JPanel doctorUpdate;
    private javax.swing.JRadioButton g_female;
    private javax.swing.JRadioButton g_male;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField name_txt;
    private javax.swing.JProgressBar pass_bar;
    private javax.swing.JPasswordField pass_txt;
    private javax.swing.JFormattedTextField phone_txt;
    private javax.swing.JPanel pnl_rules;
    private javax.swing.JTextField sur_txt;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JFormattedTextField txt_tcno;
    // End of variables declaration//GEN-END:variables
}
