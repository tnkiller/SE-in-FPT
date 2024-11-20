package controller;

import java.text.ParseException;
import model.*;
import view.Menu;
import view.Utils;

public class SchoolManagement {

    School school;

    public SchoolManagement() throws ParseException {
        school = new School();
    }

    public void execute() throws ParseException {
        int choice;
        do {
            Menu.showMainMenu();
            choice = Integer.parseInt(Utils.getValue("Enter your choice: "));
            switch (choice) {
                case 1 -> {
                    Menu.subMenu();
                    int opt = Integer.parseInt(Utils.getValue("Enter you choice: "));
                    school.searchList(opt);
                }
                case 2 ->
                    school.printList();
                case 3 ->
                    school.addNew();
                case 4 ->
                    school.sortAvr();
                case 5 ->
                    school.stat();
                case 0 -> {
                    System.out.println("See you again...");
                    System.exit(0);
                }
                default ->
                    System.out.println("Invalid choice!...");
            }
        } while (choice != 0);
    }

}
