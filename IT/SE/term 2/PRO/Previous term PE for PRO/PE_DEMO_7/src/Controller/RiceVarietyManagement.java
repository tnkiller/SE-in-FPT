/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.RiceVarietyList;
import View.Menu;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class RiceVarietyManagement {

    RiceVarietyList listRice;

    //constructor
    public RiceVarietyManagement() {
        listRice = new RiceVarietyList();
    }

    public void run() throws ParseException {
        String[] choice = {
            "Add a new rice variety",
            "Display all rice varieties",
            "Update information of a rice variety",
            "Search rice varieties",
            "Delete old rice varieties of low-yielding varieties",
            "Sort rice varieties",
            "Display summary report",
            "Export rice varieties to CSV",
            "Exit"
        };

        Menu<String> subMenu = new Menu<String>("---TOOL---", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        listRice.addNew();
                    case 2 ->
                        listRice.displayAll();
                    case 3 ->
                        listRice.updateRice();
                    case 4 ->
                        listRice.searchRice();
                    case 5 ->
                        listRice.deleteRice();
                    case 6 ->
                        listRice.sortRice();
                    case 7 ->
                        listRice.summary();
                    case 8 -> {
                        try {
                            listRice.exportToFile();
                        } catch (IOException ex) {
                            Logger.getLogger(RiceVarietyManagement.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        };
        subMenu.run();

    }

    //MAIN
    public static void main(String[] args) throws ParseException {
        RiceVarietyManagement rvm = new RiceVarietyManagement();
        rvm.run();
    }

}
