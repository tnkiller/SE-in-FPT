package QUES_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Function {

    //add method
    public static void addEmployee(ArrayList<Employee> employeeArrayList, ArrayList<PartTimeEmployee> partTimeEmployeeArrayList, ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of employee you want to add:  ");
        int numOfEmployee = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter information for employee: ");
        for (int i = 0; i < numOfEmployee; i++) {
            System.out.println("Employee [" + i + "]: ");
            System.out.print("Type of employee(part-time{1} or full-time{2}): ");
            int choose;
            do {
                choose = scanner.nextInt();
                scanner.nextLine();
                if (choose == 1) {
                    PartTimeEmployee p = new PartTimeEmployee();
                    p.input();
                    partTimeEmployeeArrayList.add(p);
                    employeeArrayList.add(p);
                } else if (choose == 2) {
                    FullTimeEmployee f = new FullTimeEmployee();
                    f.input();
                    fullTimeEmployeeArrayList.add(f);
                    employeeArrayList.add(f);
                }
            } while (choose != 1 && choose != 2);
        }
        System.out.println("Added successfully!!");
    }


    //display method
    public static void displayInfor(ArrayList<Employee> employeeArrayList, ArrayList<PartTimeEmployee> partTimeEmployeeArrayList, ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList) {
        if (employeeArrayList.isEmpty()) System.out.println("Empty!");
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.Show all");
            System.out.println("2.Show detail");
            int choose;
            do {
                choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> {
                        System.out.println("\t\t\t~~~All employees in company~~~");
                        System.out.format("%-3s | %-8s | %-10s | %-5s | %-10s | %-10s | %-5s\n", "ID", "Surname", "Name", "Age", "Birthday", "WorkDay", "Salary");
                        for (Employee i : employeeArrayList) {
                            System.out.format("%-3d | %-8s | %-10s | %-5d | %-10s | %-10d | %-5d\n", i.id, i.sur, i.name, i.age, i.birthday, i.workingDay, i.calculateSalary());
                        }
                    }
                    case 2 -> {
                        System.out.println("\t\t\t~~~Full-time employee~~~");
                        System.out.format("%-3s | %-8s | %-10s | %-5s | %-10s | %-5s | %-10s | %-10s\n", "ID", "Surname", "Name", "Age", "Birthday", "WorkDay", "OT time", "Salary");
                        for (FullTimeEmployee i : fullTimeEmployeeArrayList) {
                            System.out.format("%-3d | %-8s | %-10s | %-5d | %-10s | %-5d | %-10d | %-10d\n", i.id, i.sur, i.name, i.age, i.birthday, i.workingDay, i.getOtTime(), i.calculateSalary());
                        }
                        System.out.println("\t\t\t~~~Part-time employee~~~");
                        System.out.format("%-3s | %-8s | %-10s | %-5s | %-10s | %-10s | %-10s\n", "ID", "Surname", "Name", "Age", "Birthday", "WorkDay", "Salary");
                        for (PartTimeEmployee i : partTimeEmployeeArrayList) {
                            System.out.format("%-3d | %-8s | %-10s | %-5d | %-10s | %-10d | %-10d\n", i.id, i.sur, i.name, i.age, i.birthday, i.workingDay, i.calculateSalary());
                        }
                    }
                    default -> System.out.println("Sorry. Choose again...");
                }
            } while (choose != 1 && choose != 2);

        }
    }


    //sorting according to salary method(descending)
    public static void sortSalary(ArrayList<Employee> employeeArrayList) {
        if (!employeeArrayList.isEmpty()) {
            for (int i = 1; i < employeeArrayList.size(); i++) {
                long key = employeeArrayList.get(i).calculateSalary();
                Employee keyEmployee = employeeArrayList.get(i);
                int j = i - 1;
                while (j >= 0 && employeeArrayList.get(j).calculateSalary() < key) {
                    employeeArrayList.set(j + 1, employeeArrayList.get(j));
                    j--;
                }
                employeeArrayList.set(j + 1, keyEmployee);
            }
            System.out.println("\t\t\t~~~After sorted~~~");
            System.out.format("%-3s | %-8s | %-10s | %-5s | %-10s | %-10s | %-5s\n", "ID", "Surname", "Name", "Age", "Birthday", "WorkDay", "Salary");
            for (Employee i : employeeArrayList) {
                System.out.format("%-3d | %-8s | %-10s | %-5d | %-10s | %-10d | %-5d\n", i.id, i.sur, i.name, i.age, i.birthday, i.workingDay, i.calculateSalary());
            }
        } else {
            System.out.println("Empty list...");
        }
    }


    //search and delete method
    public static void deleteEmployee(ArrayList<Employee> employeeArrayList, ArrayList<PartTimeEmployee> partTimeEmployeeArrayList, ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name you want to delete: ");
        String searchingName = sc.nextLine();
        if (!employeeArrayList.isEmpty()) {
            boolean check = false;
            for (int i = 0; i < employeeArrayList.size(); i++) {
                if (employeeArrayList.get(i).getName().equalsIgnoreCase(searchingName)) {
                    check = true;
                    partTimeEmployeeArrayList.remove(employeeArrayList.get(i));
                    fullTimeEmployeeArrayList.remove((employeeArrayList.get(i)));
                    employeeArrayList.remove(i);
                    break;
                }
            }
            if (!check) System.out.println("Do not find requested name...");
            else System.out.println("Removed name successfully!");
        } else {
            System.out.println("Oops! Empty list...");
        }
    }


    //calculate average salary of each type of employee
    public static void exportAvrSalary(ArrayList<PartTimeEmployee> partTimeEmployeeArrayList, ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList) {
        if (!partTimeEmployeeArrayList.isEmpty() && !fullTimeEmployeeArrayList.isEmpty()) {
            float avrPart = 0;
            float avrFull = 0;
            for (int i = 0; i < partTimeEmployeeArrayList.size(); i++) {
                avrPart += (float) partTimeEmployeeArrayList.get(i).calculateSalary() / partTimeEmployeeArrayList.size();
            }
            for (int i = 0; i < fullTimeEmployeeArrayList.size(); i++) {
                avrFull += (float) fullTimeEmployeeArrayList.get(i).calculateSalary() / fullTimeEmployeeArrayList.size();
            }
            System.out.println("-->Average salary of Part-time employee: " + avrPart);
            System.out.println("-->Average salary of Full-time employee: " + avrFull);
        } else {
            System.out.println("There is no employee!");
        }
    }
}
