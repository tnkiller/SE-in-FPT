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
public class Customer {

    //attributes
    private String customerId;
    private String name;
    private String phone;
    private Date dateOfBirth;
    private String homeNetwork;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //constructor
    public Customer(String customerId, String name, String phone, String dateOfBirth, String homeNetwork) throws ParseException {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = setDateOfBirth(dateOfBirth);
        this.homeNetwork = homeNetwork;
    }

    public Customer(String customerId, String name, String phone, String dateOfBirth) throws ParseException {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = setDateOfBirth(dateOfBirth);
    }

    //method getter & setter
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return sdf.format(this.dateOfBirth);
    }

    public Date getDateOfBirthdDate() {
        return this.dateOfBirth;
    }

    public Date setDateOfBirth(String dateOfBirth) throws ParseException {
        return sdf.parse(dateOfBirth);
    }

    public String getHomeNetwork() {
        this.homeNetwork = checkHomenetwork();
        return this.homeNetwork;
    }

    public void setHomeNetwork(String homeNetwork) {
        this.homeNetwork = homeNetwork;
    }

    //method check homenetwork
    public String checkHomenetwork() {
        String headPhoneNum = this.phone.substring(0, 3);
        switch (headPhoneNum) {
            case "098":
                return "Viettel";
            case "090":
                return "VinaPhone";
            case "093":
                return "MobiPhone";
            default:
                return "ko co chi";
        }
    }

    //to String
    @Override
    public String toString() {
        return String.format("%-5s | %-20s | %-15s | %-15s", this.customerId, this.name, this.phone, sdf.format(this.dateOfBirth));
    }

}
