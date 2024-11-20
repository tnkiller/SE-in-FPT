/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Vaccine {

    //atributes
    private String name;
    private String code;
    private int quantity;
    private Date expirationDate;
    private double price;
    private Date lastInjectedDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //constructor
    public Vaccine(String code, String name, int quantity, String expirationDate, double price, String lastInjectedDate) throws ParseException {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.expirationDate = setExpirationDate(expirationDate);
        this.price = price;
        this.lastInjectedDate = setLastInjectedDate(lastInjectedDate);
    }

    //getter & setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Date getExpirationDate() {
        return expirationDate;
    }
    
    public String getExpirationDateString() {
        return sdf.format(this.expirationDate);
    }
    
    public Date setExpirationDate(String expirationDate) throws ParseException {
        return sdf.parse(expirationDate);
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Date getLastInjectedDate() {
        return lastInjectedDate;
    }
    
    public String getLastInjectedDateString() {
        return sdf.format(this.lastInjectedDate);
    }
    
    public Date setLastInjectedDate(String lastInjectedDate) throws ParseException {
        return sdf.parse(lastInjectedDate);
    }

    //to String
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s | %-10s | %-10s | %-10s",
                this.code,
                this.name,
                this.quantity,
                getExpirationDateString(),
                this.price,
                getLastInjectedDateString()
        );
    }
    
}
