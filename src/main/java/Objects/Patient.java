/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import com.mycompany.hospitalmanagement.DoctorGUI;
import com.mycompany.hospitalmanagement.PatientRegistrationGUI;
import com.mycompany.hospitalmanagement.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author numan.kilincoglu
 */
public class Patient extends User {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    String bloodGroup;
    String address;

    public Patient() {
    }

    public Patient(int id, String name, String surname, String tc, String phone, String mail, String pass, String gender, String birthdate, String placebirth,String bloodGroup,String address) {
        super(id, name, surname, tc, phone, mail, pass, gender, birthdate,placebirth);
        this.bloodGroup = bloodGroup;
        this.address = address;
    }
    
    // THIS METHOD ADDS NEW APPOINTMENT INTO DATABASE.
    public boolean addAppointment(int branchID, int docID, int patientID, String docName,String docSurname, String patientName, String appotintmentDate,String branch,String patientSurname) {
        boolean rvalue = false;
        try {
            //CHECKS IF WORKHOURS STATUS AVAILABLE OR NOT
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM WORKHOURS WHERE STATUS = ? AND DOCTORID = ? AND DATE = ?");
            pst.setString(1, "ACTIVE");
            pst.setInt(2, docID);
            pst.setString(3, appotintmentDate);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                return rvalue;
            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pst = conn.prepareStatement("INSERT INTO APPOINTMENTS VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, autoID());
                pst.setInt(2, docID);
                pst.setString(3, docName);
                pst.setString(4, patientName);
                pst.setInt(5, branchID);
                pst.setInt(6, patientID);
                pst.setString(7, appotintmentDate);
                pst.setString(8, branch);
                pst.setString(9, docSurname);
                pst.setString(10, patientSurname);
                pst.setString(11, "ACTIVE");
                pst.executeUpdate();
                rvalue = true;
            }

            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }
    
    //THIS METHOD FETCHES PATIENT INFROMATIONS FROM DB.
    public Patient getPatient(String patientTC) {
        Patient patients = new Patient();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PATIENTS WHERE TCNO = ?");
            pst.setString(1, patientTC);
            rs = pst.executeQuery();
            if (rs.next()) {
                patients.setId(rs.getInt("ID"));
                patients.setName(rs.getString("NAME"));
                patients.setSurname(rs.getString("SURNAME"));
                patients.setPhone(rs.getString("PHONE"));
                patients.setMail(rs.getString("MAIL"));
                patients.setPalceBirth(rs.getString("PLACEBIRTH"));
                patients.setBloodGroup(rs.getString("BLOODGROUP"));
                patients.setAddress(rs.getString("ADRESS"));
                patients.setTc(patientTC);
                patients.setGender(rs.getString("GENDER"));
                patients.setDateBirth(rs.getString("BIRTHDATE"));
                conn.close();
                return patients;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patients;
    }
    
    //THIS METHOD UPDATES DOCTOR'S WORKHOUR IN DATABASE.
    public boolean updateWorkHour(int doctorID, String date) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("UPDATE WORKHOURS SET STATUS = ? WHERE DOCTORID = ? AND DATE = ?");
            pst.setString(1, "ACTIVE");
            pst.setInt(2, doctorID);
            pst.setString(3, date);
            pst.executeUpdate();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }
    
    //THIS METHOD UPDATES PATIENT RECORD IN DATABASE.
    public boolean patientUpdate(String patientTC, String address, String phone,String mail){
        boolean rvalue = false;
        try {
            boolean x = mailControl(mail,patientTC);
            boolean y = phoneControl(phone,patientTC);
            if (!x) {
                if (!y) {
                    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                    pst = conn.prepareStatement("UPDATE PATIENTS SET ADRESS = ?, PHONE = ?, MAIL = ?  WHERE TCNO = ?");
                    pst.setString(1, address);
                    pst.setString(2, phone);
                    pst.setString(3, mail);
                    pst.setString(4, patientTC);
                    pst.executeUpdate();
                    conn.close();
                    rvalue = true;
                    return rvalue;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }
    
    //FOLLOWING 3 METHODS CONTROL UNIQUNESS OF MAIL,TC,PHONE.
    public boolean mailControl(String mail, String tc) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PATIENTS WHERE MAIL = ?");
            pst.setString(1, mail);
            rs =  pst.executeQuery();
            int key = 0;
            String name;
            String TC="";
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
                TC = rs.getString("TCNO");
                key++;
            }
            conn.close();
            if (key > 2) {
                rvalue = true;
                System.out.println("key > 2 girdi");
            }
            else if (key > 1 && !TC.equals(tc)) {
                rvalue = true;
                System.out.println("key > 1 girdi");
            }
            else if (key == 1 && !TC.equals(tc)) {
                 System.out.println("key == 1 ve !tc girdi");
                rvalue = true;
            }
            else if (key == 1 && TC.equals(tc)) {
                System.out.println("key ==1 girdi");
                rvalue = false;
            }
            
            System.out.println("mail count "+key);
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    public boolean phoneControl(String number,String tc) {
        boolean rvalue = false;
        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PATIENTS WHERE PHONE = ?");
            pst.setString(1, number);
            rs = pst.executeQuery();
            int key = 0;
            String TC ="";
            while(rs.next()) {
                System.out.println(rs.getString("NAME"));
                TC = rs.getString("TCNO");
                key++;
            }
            conn.close();
            if (key > 2) {
                 System.out.println("key > 2 girdi");
                 rvalue = true;
            }
            else if (key > 1 && !TC.equals(tc)) {
                 System.out.println("key > 1 girdi");
                rvalue = true;
            }
            else if (key == 1 && !TC.equals(tc)) {
                 System.out.println("key == 1 ve !tc gird");
                rvalue = true;
            }
            else if (key == 1 && TC.equals(tc)) {
                System.out.println("key ==1 girdi");
                rvalue = false;
            }System.out.println("tel count "+key);
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;

    }
    
    //IF A PATIENT HAS 3 APPOINTMENT, PATIENT CAN NOT MAKE MORE APPOINTMENT.
    public boolean patientAppCount(int patientid) {
        boolean rvalue = false;
        try {

            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM APPOINTMENTS WHERE PATIENTID = ? AND STATUS =?");
            pst.setInt(1, patientid);
            pst.setString(2, "ACTIVE");
            rs = pst.executeQuery();
            int key = 0;
            while (rs.next()) {
                key++;
                if (key == 3) {
                    System.out.println(key+" key<<");
                    rvalue = true;
                    break;
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;

    }
    
    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    //GENERATES AUTO ID
    private int autoID(){
        int id = 0;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM APPOINTMENTS");
            rs.next();
            rs.getInt(1);
            if(rs.getInt(1) == 0){
                id = 1;
                return id;
            }
            else{
                id =  (rs.getInt(1));
                id++;
                return id;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }

    return id;
   
    }

}
    

    
    


