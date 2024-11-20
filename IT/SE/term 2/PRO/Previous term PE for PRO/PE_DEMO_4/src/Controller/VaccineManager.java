/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import View.Menu;
import View.Utils;
import View.Validation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VaccineManager {

    List<Vaccine> listVaccine;
    String fileName = "vaccines_input.txt";

    public VaccineManager() throws ParseException {
        listVaccine = new ArrayList<>();
        loadFile(fileName);
    }

    public void run() throws ParseException {

        String[] choice = {
            "Display all vaccines from file",
            "Add a vaccine",
            "Delete a vaccine by code",
            "Sort vaccines by name",
            "Save to file",
            "Exit"
        };

        Menu subMenu = new Menu("---Vaccine Management System---", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        displayAllVaccine();
                    case 2 ->
                        addNew();
                    case 3 ->
                        deleteByCode();
                    case 4 ->
                        sortByName();
                    case 5 ->
                        saveToFile();
                }

            }
        };
        subMenu.run();

    }

    //MAIN
    public static void main(String[] args) throws ParseException {

        VaccineManager vm = new VaccineManager();
        vm.run();

    }

    //DISPLAY
    public void displayAllVaccine() {
        listVaccine.forEach(System.out::println);
    }

    //ADD
    public boolean addNew() throws ParseException {
        String code = Utils.inputValue("Enter a new code: ");
        String name = Utils.inputValue("Enter a new name: ");
        int quan = Utils.checkIntData("Enter quantity: ");
        String expiredDate = Utils.checkInputDob("Enter expiration date: ");
        double price = Utils.checkDoubleData("Enter price: ");
        String lastInjectedDate = Utils.checkInputDob("Enter last injected date: ");

        for (Vaccine i : listVaccine) {
            if (i.getCode().equals(code)) {
                System.out.println("Code existed...");
                return false;
            }
        }
        listVaccine.add(new Vaccine(code, name, quan, expiredDate, price, lastInjectedDate));
        System.out.println("Added new vaccine successfully!");
        return true;

    }

    //DELETE 
    public void deleteByCode() {
        String code = Utils.inputValue("Enter vaccine code to delete: ");
        listVaccine.removeIf(vaccine -> vaccine.getCode().equals(code));
    }

    //SORT BY NAME
    public void sortByName() {
        Collections.sort(listVaccine, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        listVaccine.forEach(System.out::println);
    }

    //SAVE TO FILE
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("vaccines_input.txt"))) {
            for (Vaccine i : listVaccine) {
                bw.write(i.getCode() + ","
                        + i.getName() + ","
                        + i.getQuantity() + ","
                        + i.getExpirationDateString() + ","
                        + i.getPrice() + ","
                        + i.getLastInjectedDateString() + "\n");
            }
            bw.flush();
        } catch (Exception e) {
            System.out.println("Can not write to file...");
        }
    }

    //LOAD FIlE
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(", ");
                if (temp.length == 6) {
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Validation.removeLabel(temp[i]);
                    }
                    if (Validation.checkIntData(temp[2]) != null
                            && Validation.checkDoubleData(temp[4]) != null
                            && Validation.checkDob(temp[3]) != null
                            && Validation.checkDob(temp[5]) != null) {
                        listVaccine.add(new Vaccine(
                                temp[0],
                                temp[1],
                                Integer.parseInt(temp[2]),
                                temp[3],
                                Double.parseDouble(temp[4]),
                                temp[5]
                        ));
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Find not found...");
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }

}
