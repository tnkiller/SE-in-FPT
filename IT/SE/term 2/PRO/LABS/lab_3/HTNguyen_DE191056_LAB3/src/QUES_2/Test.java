package QUES_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        ArrayList<QUES_2.Employee> employeeArrayList = new ArrayList<>();
        ArrayList<QUES_2.PartTimeEmployee> partTimeEmployeeArrayList = new ArrayList<>();
        ArrayList<QUES_2.FullTimeEmployee> fullTimeEmployeeArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("~~~~~MENU~~~~~~");
            System.out.println("1. Add employee");
            System.out.println("2. Display employee information");

            System.out.println("3. Sort according to salary");
            System.out.println("4. Delete employee according to name");
            System.out.println("5. Export average salary");
            System.out.println("0. Exit");
            System.out.print("You choose: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 ->
                    Function.addEmployee(employeeArrayList, partTimeEmployeeArrayList, fullTimeEmployeeArrayList);
                case 2 ->
                    Function.displayInfor(employeeArrayList, partTimeEmployeeArrayList, fullTimeEmployeeArrayList);
                case 3 ->
                    Function.sortSalary(employeeArrayList);
                case 4 ->
                    Function.deleteEmployee(employeeArrayList, partTimeEmployeeArrayList, fullTimeEmployeeArrayList);
                case 5 ->
                    Function.exportAvrSalary(partTimeEmployeeArrayList, fullTimeEmployeeArrayList);
                case 0 ->
                    System.out.println("See you soon!");
            }
        } while (choice != 0);
    }
}
