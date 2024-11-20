package Model.employee;

import Model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employee extends Person {
    private double salary;

    public Employee() {

    }
    public Employee(String userName) {
        super(userName);

    }

    public Employee(String userName, String password, String lastName, String firstName, String address, String phoneNum, String dob, double salary) throws ParseException {
        super(userName, password, lastName, firstName, address, phoneNum, dob);
        this.salary = salary;
        
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-15s | %-15s | %-15s | %-15s | %-20s | %-15s | %-15s | %-10s\n",
                "Username", "Password", "Last Name", "First Name", "Address", "Phone Number", "DOB", "Salary");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = String.format("%-15s | %-15s | %-15s | %-15s | %-20s | %-15s | %-15s | %-10.2f",
                this.userName,
                this.password,
                this.lastName,
                this.firstName,
                this.address,
                this.phoneNum,
                sdf.format(dob),
                this.salary);

        return  row + "\n" + separator;
    }



}
