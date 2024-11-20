/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Company;
import View.Menu;
import java.text.ParseException;

/**
 *
 * @author ADMIN
 */
public class EmployeeApp extends Menu<String> {

    Company comp;
    static String[] choice = {
        "List all employee",
        "Income of employee",
        "Employee search",
        "Sort employee by salary",
        "Quit"
    };

    public EmployeeApp() throws ParseException {
        super("---TOOL---", choice);
        comp = new Company();

    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 ->
                comp.listAll();
            case 2 ->
                comp.showIncome();
            case 3 ->
                comp.searchEmp();
            case 4 ->
                comp.sortBySalary();
        }
    }

    public static void main(String[] args) throws ParseException {
        EmployeeApp mgn = new EmployeeApp();
        mgn.run();
    }

}
