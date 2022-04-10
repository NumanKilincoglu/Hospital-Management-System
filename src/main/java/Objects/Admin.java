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
public class Admin extends User {

    int branchID;
    String bloodGroup;
    String adress;
    String branch;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public Admin() {

    }

    public Admin(int id, String name, String surname, String tc, String phone, String mail, String pass, String gender, String datebirth, int branchID, String branch, String placebirth, String bloodgroup, String adress) {
        super(id, name, surname, tc, phone, mail, pass, gender, datebirth, placebirth);
        this.branchID = branchID;
        this.branch = branch;

    }

    @Override
    public String getDateBirth() {
        return super.getDateBirth(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDateBirth(String dogumTarihi) {
        super.setDateBirth(dogumTarihi); //To change body of generated methods, choose Tools | Templates.
    }

    //THIS METHOD FETCH DOCTORS FROM DB.
    public ArrayList<Doctor> getDoctors() throws SQLException {
        ArrayList<Doctor> doctorList = new ArrayList<>();
        doctorList.clear();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("SELECT * FROM DOCTORS ORDER BY ID ASC");
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME").toUpperCase());
                doctor.setSurname(rs.getString("SURNAME").toUpperCase());
                doctor.setTc(rs.getString("TCNO"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setMail(rs.getString("MAIL"));
                doctor.setPalceBirth(rs.getString("PLACEBIRTH"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setPass(rs.getString("PASSWORD"));
                doctor.setBRANCHID(rs.getInt("CLINICID"));
                doctor.setDateBirth(rs.getString("BIRTHDATE"));
                doctor.setBranch(rs.getString("BRANCH"));
                doctorList.add(doctor);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        return doctorList;
    }

    //THIS METHOD ADDS DOCTOR INTO DATABASE.
    public boolean addDoctor(String name, String surname, String datebirth, String TCNO, String branch, String placebirth, String phone, String gender, String password, String mail) throws SQLException {
        boolean rvalue = false;
        int bolumID = autoClinicID(branch);
        try {
            //CHECKING IF IS DOCTOR ALREADY REGISTERED IN DB.
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM DOCTORS WHERE TCNO = ?");
            pst.setString(1, TCNO);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                conn.close();
                return rvalue;
            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                String query = ("INSERT INTO DOCTORS VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                pst = conn.prepareStatement(query);
                pst.setInt(1, autoID());
                pst.setString(2, name);
                pst.setString(3, surname);
                pst.setString(4, datebirth);
                pst.setString(5, TCNO);
                pst.setString(6, branch);
                pst.setString(7, placebirth);
                pst.setString(8, phone);
                pst.setString(9, gender);
                pst.setString(10, password);
                pst.setInt(11, bolumID);
                pst.setString(12, mail);
                pst.executeUpdate();
                conn.close();
                rvalue = true;
                return rvalue;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rvalue;
    }

    //THIS METHOD ADDS NEW PHARMACY AGENT INTO DATABASE.
    public boolean addAgent(String name, String surname, String datebirth, String TCNO, String placebirth, String phone, String gender, String password, String mail) throws SQLException {
        boolean rvalue = false;
        int agentID = autoAgentID();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM PHARMACISTS WHERE TCNO = ?");
            pst.setString(1, TCNO);
            rs = pst.executeQuery();
            if (rs.next()) {
                rvalue = false;
                conn.close();
                return rvalue;
            } else {
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                String query = ("INSERT INTO PHARMACISTS VALUES (?,?,?,?,?,?,?,?,?,?)");
                pst = conn.prepareStatement(query);
                pst.setInt(1, agentID);
                pst.setString(2, name);
                pst.setString(3, surname);
                pst.setString(4, datebirth);
                pst.setString(5, TCNO);
                pst.setString(6, placebirth);
                pst.setString(7, phone);
                pst.setString(8, gender);
                pst.setString(9, password);
                pst.setString(10, mail);
                pst.executeUpdate();
                conn.close();
                rvalue = true;
                return rvalue;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD DELETES AGENT FROM DATABASE.
    public boolean deleteAgent(int agentID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM PHARMACISTS WHERE ID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, agentID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD DELETES DOCTOR FROM DATABASE.
    public boolean deleteDoc(int docID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM DOCTORS WHERE ID=?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, docID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD DELETES APPOINTMENT FROM DOCTOR'S RECORD
    public boolean deleteDocAppointment(int docID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM APPOINTMENTS WHERE DOCTORID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, docID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD DELETES DOCTOR'S WORKING HOUR.
    public boolean deleteWorkHours(int docID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM WORKHOURS WHERE DOCTORID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, docID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS MEHOD DELETES PATIENT RECORDS.
    public boolean deletePatient(int patientID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM PATIENTS WHERE ID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, patientID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD DELETES PATIENT'S APPOINTMENT
    public boolean deletePatientppointment(int patientID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM APPOINTMENTS WHERE PATIENTID = ? AND STATUS = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, patientID);
            pst.setString(2, "ACTIVE");
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }
    //THIS METHOD DELETES PATIENT'S TEST

    public boolean deletetTest(int testID) {
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM TEST WHERE ID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, testID);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }

    //THIS METHOD FETCHES PATIENT RECORDS FROM DB.
    public ArrayList<Patient> getPatients(int docID) {

        ArrayList<Patient> patients = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("SELECT * FROM APPOINTMENTS WHERE DOCTORID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, docID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("PATIENTID"));
                patient.setName(rs.getString("PATIENTNAME").toUpperCase());
                patient.setSurname(rs.getString("PATIENTSURNAME").toUpperCase());
                patients.add(patient);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return patients;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    private int autoID() {
        int id = 0;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM DOCTORS");
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

    private int autoAgentID() {
        int id = 0;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            Statement stm = conn.createStatement();
            rs = stm.executeQuery("SELECT MAX(ID) FROM PHARMACISTS");
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

    private int autoClinicID(String branch) throws SQLException {
        int bolumID = 0;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst = conn.prepareStatement("SELECT * FROM CLINICS WHERE NAME =? ");
            pst.setString(1, branch);
            rs = pst.executeQuery();
            if (rs.next()) {
                bolumID = rs.getInt("ID");
                return bolumID;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bolumID;
    }

    public ArrayList<Doctor> getPatientList() throws SQLException {
        ArrayList<Doctor> doctorList = new ArrayList<>();
        doctorList.clear();
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("SELECT * FROM DOCTORS");
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("ID"));
                doctor.setName(rs.getString("NAME").toUpperCase());
                doctor.setSurname(rs.getString("SURNAME").toUpperCase());
                doctor.setTc(rs.getString("TCNO"));
                doctor.setPhone(rs.getString("PHONE"));
                doctor.setMail(rs.getString("MAIL"));
                doctor.setPalceBirth(rs.getString("PLACEBIRTH"));
                doctor.setGender(rs.getString("GENDER"));
                doctor.setPass(rs.getString("PASSWORD"));
                doctor.setBRANCHID(rs.getInt("CLINICID"));
                doctor.setDateBirth(rs.getString("BIRTHDATE"));
                doctor.setBranch(rs.getString("BRANCH").toUpperCase());
                doctorList.add(doctor);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        return doctorList;
    }
}
