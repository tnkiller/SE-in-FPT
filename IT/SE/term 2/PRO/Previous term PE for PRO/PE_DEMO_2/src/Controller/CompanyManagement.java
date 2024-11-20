/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import View.Menu;
import java.text.ParseException;

/**
 *
 * @author ADMIN
 */
public class CompanyManagement {

    Company cmp;

    public CompanyManagement() throws ParseException {
        cmp = new Company();
    }

    public void run() throws ParseException {
        String choice[] = {
            "Display all customers",
            "Update homenetwork",
            "Search customer",
            "Sort customer by descending name",
            "Statistical homenetwork",
            "Exit"
        };

        Menu subMenu = new Menu("---TOOL---", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        cmp.displayAllCustomer();
                    case 2 ->
                        cmp.updateHomenetwork(cmp.getListCustomer());
                    case 3 ->
                        cmp.searchCustomer();
                    case 4 ->
                        cmp.sortCustomer();
                    case 5 ->
                        cmp.statis();
                }
            }
        };
        subMenu.run();
    }

    //MAIN
    public static void main(String[] args) throws ParseException {
        CompanyManagement main = new CompanyManagement();
        main.run();

    }

}
