/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author numan.kilincoglu
 */
public class Appointment {

    private int id, doctorID, patientID;
    private String doctorName, patientName, app_date, branch, docSurname, patientSurname, status;
    Connection conn;
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;

    public Appointment() {
    }

    public Appointment(int id, int doctorID, int patientID, String doctorName, String patientName, String app_date, String branch, String docSurname, String patientSurname, String status) {
        this.id = id;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.doctorName = doctorName;
        this.docSurname = docSurname;
        this.patientName = patientName;
        this.app_date = app_date;
        this.branch = branch;
        this.patientSurname = patientSurname;
        this.status = status;
    }

    //THIS METHOD DELETES APPOINTMENT FORM DATABASE.
    public boolean deleteAppointment(int docID, int patientID, String date) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("DELETE * FROM APPOINTMENTS WHERE DOCTORID  = ? AND PATIENTID =? AND APPOINTMENTDATE = ?");
            pst.setInt(1, docID);
            pst.setInt(2, patientID);
            pst.setString(3, date);
            pst.executeUpdate();

            //UPDATE DOCTOR'S WORK HOUR
            pst = conn.prepareStatement("UPDATE WORKHOURS SET STATUS =? WHERE DOCTORID =? AND DATE =?");
            pst.setString(1, "PASSIVE");
            pst.setInt(2, docID);
            pst.setString(3, date);
            pst.executeUpdate();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;

    }

    //THIS METHOD FETCHES APPOINTMENTS FROM DATABASE.
    public ArrayList<Appointment> getAppointments(int hastaID) {
        ArrayList<Appointment> randevular = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM APPOINTMENTS WHERE PATIENTID =? ORDER BY ID ASC");
            pst.setInt(1, hastaID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Appointment randevu = new Appointment();
                randevu.setDoctorName(rs.getString("DOCTORNAME"));
                randevu.setPatientName(rs.getString("PATIENTNAME"));
                randevu.setApp_date(rs.getString("APPOINTMENTDATE"));
                randevu.setId(rs.getInt("PATIENTID"));
                randevu.setDoctorID(rs.getInt("DOCTORID"));
                randevu.setBranch(rs.getString("BRANCHNAME"));
                randevu.setDocSurname("DOCTORSURNAME");
                randevu.setStatus(rs.getString("STATUS"));
                randevular.add(randevu);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randevular;
    }

    //THIS METHOD FETCHES DOCTOR'S OWN APPOINTMENTS FROM DATABASE.
    public ArrayList<Appointment> getDocAppointments(int docID) {
        ArrayList<Appointment> randevular = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM APPOINTMENTS WHERE DOCTORID = ? ORDER BY PATIENTID ASC");
            pst.setInt(1, docID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Appointment randevu = new Appointment();
                randevu.setId(rs.getInt("ID"));
                randevu.setDoctorID(rs.getInt("DOCTORID"));
                randevu.setPatientID(rs.getInt("PATIENTID"));
                randevu.setDoctorName(rs.getString("DOCTORNAME"));
                randevu.setDocSurname("DOCTORSURNAME");
                randevu.setPatientName(rs.getString("PATIENTNAME"));
                randevu.setApp_date(rs.getString("APPOINTMENTDATE"));
                randevu.setBranch(rs.getString("BRANCHNAME"));
                randevu.setPatientSurname(rs.getString("PATIENTSURNAME"));
                randevu.setStatus(rs.getString("STATUS"));
                randevular.add(randevu);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randevular;

    }

    //THIS METHOD UPDATE STATUS OF APPOINTMENT
    public boolean updateStatusAppointment(int docID, String date, int patientID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("UPDATE APPOINTMENTS SET STATUS = ? WHERE DOCTORID = ? AND APPOINTMENTDATE = ? AND PATIENTID =?");
            pst.setString(1, "CLOSED");
            pst.setInt(2, docID);
            pst.setString(3, date);
            pst.setInt(4, patientID);
            pst.executeUpdate();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setDocSurname(String docSurname) {
        this.docSurname = docSurname;
    }

    public String getDocSurname() {
        return docSurname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String dotorIsim) {
        this.doctorName = dotorIsim;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

}
