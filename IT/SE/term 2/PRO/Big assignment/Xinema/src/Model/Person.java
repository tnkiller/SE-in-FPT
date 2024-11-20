package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {

    protected String userName;
    protected String password;
    protected String lastName;
    protected String firstName;
    protected String address;
    protected String phoneNum;
    protected Date dob;

    public Person(){
        
    }

    public Person(String userName){
        this.userName=userName;

    }
    public Person(String userName, String password, String lastName, String firstName, String address, String phoneNum, String dob) throws ParseException {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.dob = setDob(dob);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getDob() {
        return dob;
    }

    public Date setDob(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(dob);
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-10s |%-10s |%-10s |%-10s |%-10s | %-10s ",
                this.userName,
                this.password,
                this.lastName,
                this.firstName,
                this.dob,
                this.phoneNum,
                this.address);
    }

    public String toStringFile() {
        return userName + ", " + password + ", " + lastName + ", " + firstName + ", " + address + ", " + phoneNum + ", " + dob;
    }

}
