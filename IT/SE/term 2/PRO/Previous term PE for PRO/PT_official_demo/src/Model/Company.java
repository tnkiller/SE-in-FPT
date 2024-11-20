package Model;

import View.Menu;
import View.Utils;
import View.Validation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Company {

    List<Employee> employeeList;

    public Company() throws ParseException {
        employeeList = new ArrayList<>();
        loadFile("emp.txt");

    }

    //load file
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] temp = line.split(",");
                    if (Validation.checkId(temp[0]) != null && Validation.checkDob(temp[2]) != null) {
                        employeeList.add(new Employee(temp[0], temp[1], temp[2], Integer.parseInt(temp[3])));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Not found file");
        }
    }

    //show all
    public void listAll() {
        System.out.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", "ID", "Full name", "Date of birth", "Salary", "Tax");
        employeeList.forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Total: " + employeeList.size());
    }

    //show income
    public void showIncome() {
        System.out.format("%-10s | %-15s | %-15s | %-15s | %-10s | %-10s\n", "ID", "Full name", "Date of birth", "Salary", "Tax", "Income");
        for (Employee i : employeeList) {
            System.out.println(i.toStringIncome());
        }
    }

    //sort list by salary
    public void sortBySalary() {
        Collections.sort(employeeList);
        employeeList.forEach(System.out::println);
    }

    //search
    private ArrayList<Employee> search(Predicate<Employee> e) {
        ArrayList<Employee> res = new ArrayList<>();
        for (Employee iEmployee : employeeList) {
            if (e.test(iEmployee)) {
                res.add(iEmployee);
            }
        }
        return res;
    }

    public void searchEmp() throws ParseException {

        String[] searchMenu = {
            "by ID",
            "by name",
            "by DOB",
            "by salary",
            "Back"
        };

        Menu mn = new Menu("Search by...", searchMenu) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<Employee> res = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String id = Utils.getId("Enter id to search:  ");
                        res = search(p -> p.getId().equalsIgnoreCase(id));
                    }
                    case 2 -> {
                        String name = Utils.getName("Enter name to search: ");
                        res = search(p -> (p.getName().toLowerCase().contains(name.toLowerCase())));
                    }
                    case 3 -> {
                        String dob = Utils.getDob("Enter date of birth to search: ");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dobDate = sdf.parse(dob);
                        res = search(p -> p.getDobDate().equals(dobDate));
                    }
                    case 4 -> {
                        long salary;
                        try {
                            salary = Utils.getSalary("Enter phone number to search: ");
                            res = search(p -> p.getSalary() == salary);
                        } catch (Exception ex) {
                            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                if (!res.isEmpty()) {
                    System.out.format("%-10s | %-15s | %-15s | %-15s | %-10s\n", "ID", "Full name", "Date of birth", "Salary", "Tax");
                    res.forEach(System.out::println);
                }
                if (res.isEmpty() && n != 5) {
                    System.out.println("Not found in list...");
                }
            }
        };
        mn.run();
    }
}
