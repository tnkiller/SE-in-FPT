package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient implements Comparable<Patient> {

    private String id;
    private String fullName;
    private Date dob;
    private String phone;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Patient(String id, String fullName, String dob, String phone) throws ParseException {
        this.id = id;
        this.fullName = fullName;
        this.dob = setDob(dob);
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob(Date dob) {
        return sdf.format(dob);
    }

    public Date getDobDate() {
        return dob;
    }

    public Date setDob(String dob) throws ParseException {
        return sdf.parse(dob);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean updatePhone(String oldPhone, String newPhone) {
        if (this.phone.equals(oldPhone)) {
            this.phone = newPhone;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-15s | %-10s",
                this.id,
                this.fullName,
                getDob(this.dob),
                this.phone);
    }

    @Override
    public int compareTo(Patient o) {
        return this.dob.compareTo(o.dob);
    }

}
