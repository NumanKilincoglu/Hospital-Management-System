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
public class Medicine {
    int id,qty;
    double price;
    String name, manifacDate,expDateicompany;

    public Medicine() {
    }

    public Medicine(int id, int qty, double price, String name, String manifacDate, String expDateicompany) {
        this.id = id;
        this.qty = qty;
        this.price = price;
        this.name = name;
        this.manifacDate = manifacDate;
        this.expDateicompany = expDateicompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManifacDate() {
        return manifacDate;
    }

    public void setManifacDate(String manifacDate) {
        this.manifacDate = manifacDate;
    }

    public String getExpDateicompany() {
        return expDateicompany;
    }

    public void setExpDateicompany(String expDateicompany) {
        this.expDateicompany = expDateicompany;
    }
    
    
    
    
    
}
