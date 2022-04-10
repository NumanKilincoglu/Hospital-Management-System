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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author numan.kilincoglu
 */
public class Clinic {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    private int id;
    private String name;

    public Clinic() {
    }
    
    public Clinic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    //THIS METHOD FETCHES CLINICS FROM DATABASE.
   public ArrayList<Clinic> getClinics() throws SQLException {
        ArrayList<Clinic> clinicList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("SELECT * FROM CLINICS");
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Clinic klinik = new Clinic();
                klinik.setName(rs.getString("NAME"));
                klinik.setId(rs.getInt("ID"));
                clinicList.add(klinik);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Clinic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        return clinicList;
    }
    //THIS METHOD ADDS CLINICS INTO DATABASE.
   public boolean addClinic(String name,int id){
       boolean rvalue = false;
       try {
           conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
           pst = conn.prepareStatement("SELECT * FROM CLINICS WHERE NAME = ?");
           pst.setString(1, name);
           rs = pst.executeQuery();
           if (rs.next()) {
               rvalue = false;
               conn.close();
               return rvalue;
           } else {
               conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
               pst = conn.prepareStatement("INSERT INTO CLINICS VALUES(?,?)");
               pst.setInt(1, id);
               pst.setString(2, name);
               pst.executeUpdate();
               rvalue = true;
               return rvalue;
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Clinic.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rvalue;
 
   }
   //THIS METHOD UPDATES CLINICS IN DATABASE.
   public boolean updateClinic(String name, int id){
      boolean rvalue = false;
       try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            pst  = conn.prepareStatement("SELECT * FROM CLINICS WHERE NAME =?");
            pst.setString(1, name);
            rs = pst.executeQuery();
            int count = 0;
            while(rs.next()){
                count++;
            }
            conn.close();
            if(count == 1){
                rvalue = false;
                return rvalue;
            }else{
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
                pst = conn.prepareStatement("UPDATE CLINICS SET NAME = ? WHERE ID =?");
                pst.setString(1, name);
                pst.setInt(2, id);
                pst.executeUpdate();
                rvalue = true;
                return rvalue;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Clinic.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rvalue;
   }
    
   //THIS METHOD DELETES CLINICS FROM DATABASE.
   public boolean deleteClinic(int id){
        boolean rvalue = false;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HastaneYonetimSistemi", "sa", "as");
            String query = ("DELETE FROM CLINICS WHERE ID = ?");
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            conn.close();
            rvalue = true;
            return rvalue;
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rvalue;
    }
   
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
