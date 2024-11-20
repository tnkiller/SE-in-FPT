package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

    protected String userName;
    protected String password;
    protected String lastName;
    protected String firstName;
    protected String mail;
    protected String phoneNum;
    protected Date dateOfBirth;
    protected int token;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Customer() {

    }

    public Customer(String userName, String password, String lastName, String firstName, String mail, String phoneNum, String dateOfBirth) throws ParseException {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.dateOfBirth = setDateOfBirth(dateOfBirth);

    }

    public Customer(String userName, String password, String lastName, String firstName, String mail, String phoneNum, String dateOfBirth, int token) throws ParseException {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.dateOfBirth = setDateOfBirth(dateOfBirth);
        this.token = token;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDateOfBirth() {
        return sdf.format(this.dateOfBirth);
    }

    public Date getDateOfBirthDate() {
        return this.dateOfBirth;
    }


    public Date setDateOfBirth(String dateOfBirth) throws ParseException {
        return sdf.parse(dateOfBirth);
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public boolean hasSameUsername(String othername){
        return this.getUserName().equals(othername);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", token=" + token +
                ", sdf=" + sdf +
                '}';
    }
}
