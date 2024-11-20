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
public class Employee implements Comparable<Employee> {

    private String id;
    private String name;
    private Date dob;
    private long salary;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Employee(String id, String name, String dob, int salary) throws ParseException {
        this.id = id;
        this.name = name;
        this.dob = setDob(dob);
        this.salary = salary;
    }

    public boolean checkId(String id) {
        if (id.matches("Emp[0-9]{3}")) {
            return true;
        }
        return false;
    }

    public boolean checkDob(String dob) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date tempDob = sdf.parse(dob);
            sdf.format(tempDob);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return sdf.format(dob);
    }

    public Date getDobDate() {
        return dob;
    }

    public Date setDob(String dob) throws ParseException {
        return sdf.parse(dob);
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public float calTax() {
        if (this.salary < 9000000) {
            return 0;
        } else if (this.salary >= 9000000 && this.salary < 15000000) {
            return (10 * this.salary) / 100;
        } else {
            return (12 * this.salary) / 100;
        }
    }

    public long calIncome() {
        return this.salary - (long) calTax();
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-15s | %-15d | %-10.1f ",
                this.id,
                this.name,
                sdf.format(this.dob),
                this.salary,
                calTax());
    }

    public String toStringIncome() {
        return String.format("%-10s | %-15s | %-15s | %-15d | %-10.1f | %-10d",
                this.id,
                this.name,
                sdf.format(this.dob),
                this.salary,
                calTax(),
                calIncome());

    }

    @Override
    public int compareTo(Employee o) {
        return Long.compare(this.salary, o.salary);
    }

}
