package controller;

import java.text.ParseException;
import model.*;
import view.*;

public class SchoolManagement extends Menu1 {

    School school;

    public SchoolManagement(String title, String[] mc) throws ParseException {
        super(title, mc);
        String[] searchMenu = {
            "by average",
            "by date of birth",
            "Back"
        };
        school = new School("Search by...", searchMenu);
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 ->
                school.printList();
            case 2 ->
                school.searchList();
            case 3 ->
                school.addNew();
            case 4 ->
                school.sortAvr();
            case 5 ->
                school.stat();
        }
    }

}
