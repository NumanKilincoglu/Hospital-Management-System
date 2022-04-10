/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author numan.kilincoglu
 */
public class User {

    private int id;
    private String name, surname, tc, phone, mail, pass, gender, dateBirth, palceBirth;

    public User() {
    }

    public User(int id, String name, String surname, String tc, String phone, String mail, String pass, String gender, String dateBirth, String palceBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tc = tc;
        this.phone = phone;
        this.mail = mail;
        this.pass = pass;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.palceBirth = palceBirth;

    }

    public User(int id) {
        this.id = id;

    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

    }

    public void setPalceBirth(String palceBirth) {
        this.palceBirth = palceBirth;
    }

    public String getPalceBirth() {
        return palceBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
