/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Employee;
import View.Menu;
import View.Utils;
import View.Validation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class EmpManagement extends Menu<String> {

    //attributes
    List<Employee> listEmp;
    static String[] choice = {
        "List all employee",
        "Calculate money",
        "Sorting employee",
        "Search employee",
        "Exit"
    };

    public EmpManagement() throws ParseException {
        super("---TOOL---", choice);
        listEmp = new ArrayList<>();
        loadFile("employee.txt");
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 ->
                displayAll();
            case 2 ->
                calMoney();
            case 3 ->
                sortByIncome();
            case 4 ->
                searchEmp();
        }
    }

    //MAIN
    public static void main(String[] args) throws ParseException {
        new EmpManagement().run();
    }

    //LOAD FILE
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 5) {
                    if (Validation.checkIdData(temp[0]) != null && Validation.checkDobData(temp[2]) != null)   {
                        listEmp.add(new Employee(Validation.checkIdData(temp[0]), temp[1], Validation.checkDobData(temp[2]), Float.parseFloat(temp[3]), Long.parseLong(temp[4])));
                    }
                }
            }
        } catch (FileNotFoundException fne) {
            System.out.println("file not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    //DISPLAY
    public void displayAll() {
        listEmp.forEach(System.out::println);
        System.out.println("Total: " + listEmp.size());
    }

    //CALCULATE MONEY
    public void calMoney() {
        for (Employee i : listEmp) {
            i.setRewardSalary(i.calReward());
            i.setMonthlyIncome(i.calMonthlyIncome());
        }
        listEmp.forEach(System.out::println);
    }

    //SORT
    public void sortByIncome() {
        Collections.sort(listEmp, (o1, o2) -> Double.compare(o1.getMonthlyIncome(), o2.getMonthlyIncome()));
        listEmp.forEach(System.out::println);
    }

    //SEARCH
    public ArrayList<Employee> search(Predicate<Employee> p) {
        ArrayList<Employee> res = new ArrayList<>();
        for (Employee i : listEmp) {
            if (p.test(i)) {
                res.add(i);
            }

        }
        return res;
    }

    public void searchEmp() throws ParseException {
        String[] option = {
            "by account",
            "by work starting date",
            "Back"
        };
        Menu subMenu = new Menu("Search by...", option) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<Employee> result = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String acc = Utils.inputValue("Enter account to find: ");
                        result = search(p -> p.getAccount().equals(acc));
                    }
                    case 2 -> {
                        Date date = Utils.checkInputDob("Enter work starting date to search: ");
                        result = search(p -> p.getWorkStartingDate().before(date));
                    }
                }
                if (!result.isEmpty()) {
                    result.forEach(System.out::println);
                }
            }
        };
        subMenu.run();
    }

}
