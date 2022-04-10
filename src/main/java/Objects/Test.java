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
public class Test {

    Connection conn;
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;

    int id, patientID, docID;
    String price, docName, patientName, hospitalName, testType, testDate, resultDate, medFinding;

    public Test() {
    }

    public Test(int id, int patientID, int docID, String price, String docName, String patientName, String hospitalName, String testType, String testDate, String resultDate, String medFinding) {
        this.id = id;
        this.patientID = patientID;
        this.docID = docID;
        this.price = price;
        this.docName = docName;
        this.patientName = patientName;
        this.hospitalName = hospitalName;
        this.testType = testType;
        this.testDate = testDate;
        this.resultDate = resultDate;
        this.medFinding = medFinding;
    }

    public ArrayList<Test> getPatientTests(int patientID) {
        ArrayList<Test> tests = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST WHERE PATIENTID =?");
            pst.setInt(1, patientID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("ID"));
                test.setPatientID(rs.getInt("PATIENTID"));
                test.setDocID(rs.getInt("DOCTORID"));
                test.setDocName(rs.getString("DOCTORNAME"));
                test.setPatientName(rs.getString("PATIENTNAME"));
                test.setHospitalName(rs.getString("HOSPITALNAME"));
                test.setTestType(rs.getString("TYPE"));
                test.setTestDate(rs.getString("TESTDATE"));
                test.setResultDate(rs.getString("RESULTDATE"));
                test.setPrice(rs.getString("COST"));
                tests.add(test);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tests;

    }

    public ArrayList<Test> getTests() {
        ArrayList<Test> tests = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST ORDER BY ID ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                System.out.println("GIRDI + " + rs.getInt("ID"));
                test.setId(rs.getInt("ID"));
                test.setPatientID(rs.getInt("PATIENTID"));
                test.setPatientName(rs.getString("PATIENTNAME"));
                test.setDocID(rs.getInt("DOCTORID"));
                test.setDocName(rs.getString("DOCTORNAME"));
                test.setHospitalName(rs.getString("HOSPITALNAME"));
                test.setTestType(rs.getString("TYPE"));
                test.setTestDate(rs.getString("TESTDATE"));
                test.setResultDate(rs.getString("RESULTDATE"));
                tests.add(test);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tests;

    }

    public ArrayList<Test> getDocTests(int docID) {
        ArrayList<Test> tests = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST WHERE DOCTORID =? ORDER BY ID ASC");
            pst.setInt(1, docID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("ID"));
                test.setPatientID(rs.getInt("PATIENTID"));
                test.setPatientName(rs.getString("PATIENTNAME"));
                test.setDocID(rs.getInt("DOCTORID"));
                test.setDocName(rs.getString("DOCTORNAME"));
                test.setHospitalName(rs.getString("HOSPITALNAME"));
                test.setTestType(rs.getString("TYPE"));
                test.setTestDate(rs.getString("TESTDATE"));
                test.setResultDate(rs.getString("RESULTDATE"));
                test.setPrice(rs.getString("COST"));
                tests.add(test);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tests;

    }

    public Test getTest(int testID) {
        Test test = new Test();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM TEST WHERE ID =?");
            pst.setInt(1, testID);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("GIRDI + " + rs.getInt("ID"));
                test.setId(rs.getInt("ID"));
                test.setPatientID(rs.getInt("PATIENTID"));
                test.setDocID(rs.getInt("DOCTORID"));
                test.setDocName(rs.getString("DOCTORNAME"));
                test.setPatientName(rs.getString("PATIENTNAME"));
                test.setHospitalName(rs.getString("HOSPITALNAME"));
                test.setTestType(rs.getString("TYPE"));
                test.setTestDate(rs.getString("TESTDATE"));
                test.setResultDate(rs.getString("RESULTDATE"));
                test.setMedFinding(rs.getString("MEDICALFINDING"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;

    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public void setMedFinding(String medFinding) {
        this.medFinding = medFinding;
    }

    public String getMedFinding() {
        return medFinding;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

}
