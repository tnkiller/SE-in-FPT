package controller;

import java.text.ParseException;

public class Run {

    public static void main(String[] args) throws ParseException {
        String[] mc = {
            "Show information of all student",
            "Search information",
            "Add new student",
            "Sort",
            "Show students born before 2000",
            "Exit"
        };
        SchoolManagement mn = new SchoolManagement("STUDENT MANAGEMENT TOOL", mc);
        mn.run();
    }

}
