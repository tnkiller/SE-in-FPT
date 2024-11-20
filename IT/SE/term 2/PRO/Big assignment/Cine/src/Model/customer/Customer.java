/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.customer;

import Model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public  class Customer extends Person {
    private int points;
    private CustomerLevel customerLevel;

    public Customer(String userName) {
        super(userName);
    }
    public Customer() {
        super();
    }


    public Customer(String userName, String password, String lastName, String firstName, String address, String phoneNum, String dob, int points) throws ParseException {
        super(userName, password, lastName, firstName, address, phoneNum, dob);
        this.points = points;
        this.customerLevel = CustomerLevel.BRONZE;
    }
    public Customer(String userName, String password, String lastName, String firstName, String address, String phoneNum, Date dob, int points) throws ParseException {
        super(userName, password, lastName, firstName, address, phoneNum, dob);
        this.points = points;
        this.customerLevel = CustomerLevel.BRONZE;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public CustomerLevel getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(CustomerLevel customerLevel) {
        this.customerLevel = customerLevel;
    }
    public boolean hasSameUsername(String other){
        return this.userName.equals(other);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "Username", "Password", "Last Name", "First Name", "DOB", "Phone", "Address", "Points");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
                this.getUserName(),
                this.getPassword(),
                this.getLastName(),
                this.getFirstName(),
                sdf.format(this.getDob()),
                this.getPhoneNum(),
                this.getAddress(),
                this.getPoints());

        return  row + "\n" + separator;
    }


    public String toStringFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return getUserName() + ", " + getPassword() + ", " + getLastName() + ", " + getFirstName() + ", " + getAddress() + ", " + getPhoneNum() + ", " + sdf.format(getDob()) + ", " + getPoints();
    }
}
