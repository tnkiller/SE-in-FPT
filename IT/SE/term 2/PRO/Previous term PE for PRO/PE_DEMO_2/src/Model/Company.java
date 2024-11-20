/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class Company {

    private List<Customer> listCustomer;

    public Company() throws ParseException {
        listCustomer = new ArrayList<>();
        loadFile("customer.txt");
    }

    //getter & setter
    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    //LOAD FILE
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 4) {
                    if (Validation.checkId(temp[0]) != null && Validation.checkDob(temp[3]) != null) {
                        listCustomer.add(new Customer(temp[0], temp[1], temp[2], temp[3]));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    //Update homenetwork
    public void updateHomenetwork(List<Customer> list) {
        for (Customer i : list) {
            System.out.println(i + "| " + i.getHomeNetwork());
        }
        System.out.println("Total: " + list.size() + " customers");
    }

    //Display all customer
    public void displayAllCustomer() {
        listCustomer.forEach(System.out::println);
        System.out.println("Total: " + listCustomer.size() + " customers");
    }

    //SEARCH
    private ArrayList<Customer> search(Predicate<Customer> e) {
        ArrayList<Customer> res = new ArrayList<>();
        for (Customer i : listCustomer) {
            if (e.test(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public void searchCustomer() throws ParseException {

        String[] choice = {
            "by id",
            "by date of birth",
            "Back"
        };

        Menu subMenu = new Menu("Search by...", choice) {
            @Override
            public void execute(int n) throws ParseException {
                List<Customer> result = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String id = Utils.getId("Enter id to search");
                        result = search(e -> e.getCustomerId().equals(id));
                    }
                    case 2 -> {
                        Date dob = Utils.getDob("Enter name to search:");
                        result = search(e -> e.getDateOfBirthdDate().before(dob));
                    }
                }
                System.out.println("List of customers ");
                updateHomenetwork(result);
            }
        };
        subMenu.run();

    }

    //SORT
    public void sortCustomer() throws ParseException {
        Collections.sort(listCustomer, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        updateHomenetwork(listCustomer);
    }

    //STATISTICAL
    public void statis() {
        String[] network = {
            "Viettel",
            "VinaPhone",
            "MobiPhone"
        };
        List<Customer> result;
        for (String i : network) {
            result = new ArrayList<>();
            for (Customer j : listCustomer) {
                if (j.getHomeNetwork().equals(i)) {
                    result.add(j);
                }
            }
            if (!result.isEmpty()) {
                System.out.println("Company has " + result.size() + " customer(s) of " + i);
                System.out.println("List of customers");
                System.out.println("--------------------------");
                updateHomenetwork(result);
                System.out.println("--------------------------");
            }
        }
    }
}
