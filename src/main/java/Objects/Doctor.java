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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author numan.kilincoglu
 */
public class Doctor extends User {

    static ArrayList<Doctor> doktorlar = new ArrayList<>();
    private int BRANCHID;
    private String branch;
    Connection conn;
    PreparedStatement pst;
    PreparedStatement pstt;
    ResultSet rs;

    public Doctor() {
    }

    public Doctor(int id) {
        super(id);
    }

    public Doctor(int id, String name, String surname, int branchID) {
        super(id, name, surname);
        this.BRANCHID = branchID;
    }

    public Doctor(int id, String name, String surname, String tc, String phone, String mail, String pass, String gender, int BRANCHID, String dateBirth, String branch, String palceBirth) {
        super(id, name, surname, tc, phone, mail, pass, gender, dateBirth, palceBirth);
        this.BRANCHID = BRANCHID;
        this.branch = branch;
    }

    //THIS METHOD FETCHES DOCTORS INFROMATIONS FROM DB.
    public Doctor getDoctors(String tcno) {
        Doctor doctor = new Doctor();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM DOCTORS WHERE TCNO = ?");
            pst.setString(1, tcno);
            rs = pst.executeQuery();
            if (rs.next()) {
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setSurname(rs.getString("SURNAME"));
                doctor.setDateBirth(rs.getString("BIRTHDATE"));
                doctor.setTc(rs.getString("TCNO"));
                doctor.setBranch(rs.getString("BRANCH"));
                doctor.setPalceBirth(rs.getString("PLACEBIRTH"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setBRANCHID(rs.getInt("CLINICID"));
                doctor.setMail(rs.getString("MAIL"));
                conn.close();
                return doctor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doctor;
    }

    //THIS METHOD FETCHES DOCTORS INFROMATIONS FROM DB.
    public Doctor getDoctors(int doktorID) {
        Doctor doctor = new Doctor();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM DOCTORS WHERE ID = ?");
            pst.setInt(1, doktorID);
            rs = pst.executeQuery();
            if (rs.next()) {
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME"));
                doctor.setSurname(rs.getString("SURNAME"));
                doctor.setDateBirth(rs.getString("BIRTHDATE"));
                doctor.setTc(rs.getString("TCNO"));
                doctor.setBranch(rs.getString("BRANCH"));
                doctor.setPalceBirth(rs.getString("PLACEBIRTH"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setBRANCHID(rs.getInt("CLINICID"));
                doctor.setMail(rs.getString("MAIL"));
                conn.close();
                return doctor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doctor;
    }

    // THIS METHOD ADDS NEW WORKING HOUR FOR DOCTOR INTO DATABASE.
    public boolean addWorkHour(int docID, String docName, String surname, String WDate) throws SQLException {
        boolean rvalue = false;
        int WhourID = autoID();
        String name = (docName + " " + surname);
        boolean checkStatus = checkWhourStatus(docID, WDate);
        boolean checkHour = timeControl(docID, WDate);
        System.out.println(checkStatus + " " + checkHour);
        if (!(checkStatus) && !(checkHour)) {
            try {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pstt = conn.prepareStatement("INSERT INTO WORKHOURS VALUES(?,?,?,?,?)");
                pstt.setInt(1, WhourID);
                pstt.setInt(2, docID);
                pstt.setString(3, name);
                pstt.setString(4, "PASSIVE");
                pstt.setString(5, WDate);
                pstt.executeUpdate();
                conn.close();
                rvalue = true;
            } catch (SQLException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rvalue;
    }

    // THIS METHOD DELETES WORKING HOUR FROM DATABASE.
    public boolean deleteWhour(int WhourID, int docID, String WDate) throws SQLException {
        boolean rvalue = false;

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pstt = conn.prepareStatement("DELETE FROM WORKHOURS WHERE ID = ? AND DOCTORID = ? AND DATE = ? ");
            pstt.setInt(1, WhourID);
            pstt.setInt(2, docID);
            pstt.setString(3, WDate);
            pstt.executeUpdate();
            conn.close();
            rvalue = true;
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    //THIS METHOD CHECKS STATUS OF WORK HOUR
    public boolean checkWhourStatus(int doctorID, String w_Date) throws SQLException {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM WORKHOURS WHERE STATUS = ? AND DOCTORID = ? AND DATE=?");
            pst.setString(1, "ACTIVE");
            pst.setInt(2, doctorID);
            pst.setString(3, w_Date);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                conn.close();
                return rvalue;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    //THIS METHOD CHECKS IF WOKING HOUR AVAILABLE OR NOT
    public boolean timeControl(int doctorID, String workDate) {
        boolean rvalue = false;
        try {
            pst = conn.prepareStatement("SELECT * FROM WORKHOURS WHERE STATUS = ? AND DOCTORID = ? AND DATE=?");
            pst.setString(1, "PASSIVE");
            pst.setInt(2, doctorID);
            pst.setString(3, workDate);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = true;
                conn.close();
                return rvalue;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    //THIS METHOD FETCHES AVAILABLE HOURS.
    public ArrayList<String> getAvailableHours(int doctorID, String wDate) {
        ArrayList<String> availableHours = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM WORKHOURS WHERE STATUS = ? AND DOCTORID = ? ");
            pst.setString(1, "PASSIVE");
            pst.setInt(2, doctorID);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dateFormat = rs.getString("DATE");
                String array[] = dateFormat.split(" ");
                if (array[0] != null) {
                    if (array[0].equals(wDate)) {
                        availableHours.add(rs.getString("DATE"));
                        System.out.println("tarih <<>>" + rs.getString("DATE"));
                    }

                }

            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return availableHours;
    }

    //HTHIS METHOD CREATES NEW APPOTINTMENT AND SAVES INTO DATABASE.
    public boolean addAppointment(int branchID, int docID, int patientID, String docName, String docSurname, String appDate, String branchName) {
        boolean rvalue = false;
        Patient patient = new Patient();
        patient = getPatient(patientID);
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM WORKHOURS WHERE STATUS = ? AND DOCTORID = ? AND DATE = ?");
            pst.setString(1, "ACTIVE");
            pst.setInt(2, docID);
            pst.setString(3, appDate);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                conn.close();
                return rvalue;
            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pst = conn.prepareStatement("INSERT INTO APPOINTMENTS VALUES(?,?,?,?,?,?,?,?,?,?,?)");

                int appid = appointmentIDgenerator();
                pst.setInt(1, appid);
                pst.setInt(2, docID);
                pst.setString(3, docName);
                pst.setString(4, patient.getName());
                pst.setInt(5, branchID);
                pst.setInt(6, patientID);
                pst.setString(7, appDate);
                pst.setString(8, branchName);
                pst.setString(9, docSurname);
                pst.setString(10, patient.getSurname());
                pst.setString(11, "ACTIVE");
                pst.executeUpdate();
                rvalue = true;
                return rvalue;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD UPDATES WORKHOUR STATUS
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

    //tHIS METHOD FETCHES A PATIENT RECORDS
    public Patient getPatient(int patID) {
        Patient patient = new Patient();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PATIENTS WHERE ID = ?");
            pst.setInt(1, patID);
            rs = pst.executeQuery();
            if (rs.next()) {
                patient.setId(rs.getInt("ID"));
                patient.setName(rs.getString("NAME"));
                patient.setSurname(rs.getString("SURNAME"));
                conn.close();
                return patient;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;

    }

    public String getBranch() {
        return branch;
    }

    public int getBRANCHID() {
        return BRANCHID;
    }

    public void setBRANCHID(int BRANCHID) {
        this.BRANCHID = BRANCHID;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    private int autoID() {
        int id = 0;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM WORKHOURS");
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

    // ID GENERATORS
    private int appointmentIDgenerator() {
        int id = 0;
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM APPOINTMENTS");
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
