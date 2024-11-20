package Model;

import VIew.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientList {

    List<Patient> patientList;

    public PatientList() throws ParseException {
        this.patientList = new ArrayList<>();
        loadFile("patient.csv");
    }

    //LOAD FILE
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 4) {
                    patientList.add(new Patient(temp[0], temp[1], temp[2], temp[3]));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SEARCH
    public ArrayList<Patient> search(Predicate<Patient> p) {
        ArrayList<Patient> rs = new ArrayList<>();
        for (Patient i : patientList) {
            if (p.test(i)) {
                rs.add(i);
            }
        }
        return rs;
    }

    public void searchPatient() throws ParseException {

        String[] searchMenu = {
            "by ID",
            "by name",
            "by DOB",
            "by phone num",
            "Back"
        };

        Menu mn = new Menu("Search by...", searchMenu) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<Patient> res = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String id = Utils.getId("Enter id to search:  ");
                        res = search(p -> p.getId().equalsIgnoreCase(id));
                    }
                    case 2 -> {
                        String name = Utils.getName("Enter name to search: ");
                        res = search(p -> (p.getFullName().toLowerCase().contains(name.toLowerCase())));
                    }
                    case 3 -> {
                        String dob = Utils.getDob("Enter date of birth to search: ");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dobDate = sdf.parse(dob);
                        res = search(p -> p.getDobDate().equals(dobDate));
                    }
                    case 4 -> {
                        String phone = Utils.getPhone("Enter phone number to search: ");
                        res = search(p -> p.getPhone().contains(phone));
                    }
                }
                if (!res.isEmpty()) {
                    System.out.format("%-10s | %-20s | %-15s | %-10s\n", "ID", "Full name", "Date of birth", "Phone Num");
                    res.forEach(System.out::println);
                }
                if (res.isEmpty() && n != 5) {
                    System.out.println("Not found in list...");
                }
            }
        };
        mn.run();
    }

    //SHOW
    public void showAllPatient() {
        System.out.format("%-10s | %-20s | %-15s | %-10s\n", "ID", "Full name", "Date of birth", "Phone Num");
        List<Patient> sortedList = new ArrayList<>();
        sortedList = patientList;
        Collections.sort(sortedList);
        for (Patient i : sortedList) {
            System.out.println(i.toString());
        }
    }

    private boolean isOnly(String phone) {
        List<Patient> res = new ArrayList<>();
        res = search(p -> p.getPhone().equals(phone));
        if (res.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //ADD
    public void addNewPatient() throws ParseException {
        String id = Utils.getId("Enter new ID of patient: ");
        String fullName = Utils.getName("Enter full name of new patient: ");
        String dob = Utils.getDob("Enter date of birth of patient: ");
        String phone = Utils.getPhone("Enter new phone number: ");
        while (!isOnly(phone)) {
            System.out.println("Duplicated phone num!");
            phone = Utils.getPhone("Enter phone number again: ");
        }
        patientList.add(new Patient(id, fullName, dob, phone));
        System.out.println("Added successfully!");
    }

    //UPDATE phone num
    public void updateNewPhone() {
        String oldPhone = Utils.getPhone("Enter old phone to update: ");
        String newPhone = Utils.getPhone("Enter new phone to change: ");
        boolean check = false;
        for (Patient i : patientList) {
            if (i.updatePhone(oldPhone, newPhone)) {
                check = true;
                System.out.println("Updated successfully!");
                break;
            }
        }
        if (!check) {
            System.out.println("Not found in list...");
        }
    }

}
