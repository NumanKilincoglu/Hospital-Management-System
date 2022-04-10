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
public class Prescription {
    Connection conn;
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;
    private int id, patientID, docID,branchID;
    private String docName,hospitalName, patientName, date, branch, birthDate,medication,comment,status;

    public Prescription() {
    }

    public Prescription( int id, int patientID, int docID, String docName, String hospitalName, String patientName, String date, String branch, String birthDate, String medication, String comment,int branchID,String status) {
        this.id = id;
        this.patientID = patientID;
        this.docID = docID;
        this.docName = docName;
        this.hospitalName = hospitalName;
        this.patientName = patientName;
        this.date = date;
        this.branch = branch;
        this.birthDate = birthDate;
        this.medication = medication;
        this.comment = comment;
        this.branchID = branchID;
        this.status = status;
    }

    //THIS METHOD FETCHES PATIENT PRESCRIPTIONS FROM DATABSE.
    public ArrayList<Prescription> getPatientPrescriptions(int patientID){
        ArrayList<Prescription> Prescriptions = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE PATIENTID =?");
            pst.setInt(1, patientID);
            rs = pst.executeQuery();
            while(rs.next()){
                Prescription prescription = new Prescription();
                prescription.setId(rs.getInt("ID"));
                prescription.setPatientID(rs.getInt("PATIENTID"));
                prescription.setDocID(rs.getInt("DOCTORID"));
                prescription.setDocName(rs.getString("DOCTORNAME"));
                prescription.setPatientName(rs.getString("PATIENTNAME"));
                prescription.setBranch(rs.getString("BRANCH"));
                prescription.setDate(rs.getString("DATE"));
                Prescriptions.add(prescription);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Prescriptions;
        
    }
    
     //THIS METHOD FETCHES PATIENT PRESCRIPTIONS FROM DATABSE.
    public ArrayList<Prescription> getDocPrescriptions(int docID){
        ArrayList<Prescription> Prescriptions = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE DOCTORID =? ORDER BY ID ASC");
            pst.setInt(1, docID);
            rs = pst.executeQuery();
            while(rs.next()){
                Prescription prescription = new Prescription();
                prescription.setId(rs.getInt("ID"));
                prescription.setPatientID(rs.getInt("PATIENTID"));
                prescription.setDocID(rs.getInt("DOCTORID"));
                prescription.setDocName(rs.getString("DOCTORNAME"));
                prescription.setPatientName(rs.getString("PATIENTNAME"));
                prescription.setBranch(rs.getString("BRANCH"));
                prescription.setDate(rs.getString("DATE"));
                Prescriptions.add(prescription);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Prescriptions;
        
    }
    
     //THIS METHOD FETCHES PRESCRIPTION FROM DATABSE.
    public Prescription prescription(int ID) {
        Prescription prescription = new Prescription();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE ID =?");
            pst.setInt(1, ID);
            rs = pst.executeQuery();
            if (rs.next()) {
                prescription.setId(rs.getInt("ID"));
                prescription.setPatientID(rs.getInt("PATIENTID"));
                prescription.setDocID(rs.getInt("DOCTORID"));
                prescription.setDocName(rs.getString("DOCTORNAME"));
                prescription.setBranchID(rs.getInt("BRANCHID"));
                prescription.setPatientName(rs.getString("PATIENTNAME"));
                prescription.setBranch(rs.getString("BRANCH"));
                prescription.setComment(rs.getString("COMMENT"));
                prescription.setMedication(rs.getString("MEDICATIONS"));
                prescription.setDate(rs.getString("DATE"));
                return prescription;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prescription;

    }

     //THIS METHOD FETCHES PATIENT PRESCRIPTIONS FROM DATABSE FOR PHARMACY SECTION.
    public ArrayList<Prescription> pharmacyPrescriptions() {
        ArrayList<Prescription> Prescriptions = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PRESCRIPTIONS WHERE STATUS =?");
            pst.setString(1, "CREATED");
            rs = pst.executeQuery();
            while (rs.next()) {
                Prescription prescription = new Prescription();
                prescription.setId(rs.getInt("ID"));
                prescription.setPatientID(rs.getInt("PATIENTID"));
                prescription.setDocID(rs.getInt("DOCTORID"));
                prescription.setDocName(rs.getString("DOCTORNAME"));
                prescription.setBranchID(rs.getInt("BRANCHID"));
                prescription.setPatientName(rs.getString("PATIENTNAME"));
                prescription.setBranch(rs.getString("BRANCH"));
                prescription.setComment(rs.getString("COMMENT"));
                prescription.setMedication(rs.getString("MEDICATIONS"));
                prescription.setDate(rs.getString("DATE"));
                prescription.setStatus(rs.getString("STATUS"));
                Prescriptions.add(prescription);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Prescriptions;

    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public int getBranchID() {
        return branchID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
