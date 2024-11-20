
package Model.employee;

import View.AutoMenu;
import View.Validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListEmployee {
    private ArrayList<Employee> employees;
    private ArrayList<Boss> bosses;

    public ListEmployee() {
        employees = new ArrayList<>();
        bosses = new ArrayList<>();
        loadEmployeeData("employee.txt");
        loadBossData("boss.txt");
    }

    // Đọc dữ liệu nhân viên từ file
    private void loadEmployeeData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 8) {
                    employees.add(new Employee(details[0], details[1], details[2], details[3], details[4], details[5], details[6], Double.parseDouble(details[7])));
                }
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ListEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Đọc dữ liệu quản lý từ file
    private void loadBossData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 7) {
                    bosses.add(new Boss(details[0], details[1], details[2], details[3], details[4], details[5], details[6]));
                }
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ListEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lưu dữ liệu nhân viên vào file
    public void saveEmployeeData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt"))) {
            for (Employee employee : employees) {
                bw.write(employee.toStringFile() + "\n");
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ListEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Lưu dữ liệu quản lý vào file
    public void saveBossData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("boss.txt"))) {
            for (Boss boss : bosses) {
                bw.write(boss.toStringFile() + "\n");
            }
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ListEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Thêm nhân viên mới
    public void addNewEmployee(Employee employee) {
        employees.add(employee);
        saveEmployeeData();
    }

    // Thêm quản lý mới
    public void addNewBoss(Boss boss) {
        bosses.add(boss);
        saveBossData();
    }

    // Cập nhật thông tin nhân viên
    public void updateEmployee(String userName, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getUserName().equals(userName)) {
                employees.set(i, updatedEmployee);
                saveEmployeeData();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Cập nhật thông tin quản lý
    public void updateBoss(String userName, Boss updatedBoss) {
        for (int i = 0; i < bosses.size(); i++) {
            if (bosses.get(i).getUserName().equals(userName)) {
                bosses.set(i, updatedBoss);
                saveBossData();
                return;
            }
        }
        System.out.println("Boss not found.");
    }

    // Xóa nhân viên
    public void deleteEmployee(String userName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getUserName().equals(userName)) {
                employees.remove(i);
                saveEmployeeData();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Xóa quản lý
    public void deleteBoss(String userName) {
        for (int i = 0; i < bosses.size(); i++) {
            if (bosses.get(i).getUserName().equals(userName)) {
                bosses.remove(i);
                saveBossData();
                System.out.println("Boss deleted successfully.");
                return;
            }
        }
        System.out.println("Boss not found.");
    }

    // Tìm kiếm nhân viên
    public Employee searchEmployee(String userName) {
        for (Employee employee : employees) {
            if (employee.getUserName().equals(userName)) {
                return employee;
            }
        }
        return null;
    }

    // Tìm kiếm quản lý
    public Boss searchBoss(String userName) {
        for (Boss boss : bosses) {
            if (boss.getUserName().equals(userName)) {
                return boss;
            }
        }
        return null;
    }

    // Hiển thị danh sách nhân viên
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // Hiển thị danh sách quản lý
    public void displayBosses() {
        if (bosses.isEmpty()) {
            System.out.println("No bosses available.");
        } else {
            System.out.println("Boss List:");
            for (Boss boss : bosses) {
                System.out.println(boss);
            }
        }
    }

    // Thêm chức năng quản lý thông tin nhân viên
    public void manageEmployeeInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Add new staff",
                    "Update staff information",
                    "Delete staff",
                    "Search staff",
                    "Add new manager",
                    "Update management information",
                    "Delete management",
                    "Search management","Back"
            };
            AutoMenu menu = new AutoMenu("Staff information management", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            addNewEmployee();
                            break;
                        case 2:
                            updateEmployeeInfo();
                            break;
                        case 3:
                            deleteEmployee();
                            break;
                        case 4:
                            searchEmployeeByUsername();
                            break;
                        case 5:
                            addNewBoss();
                            break;
                        case 6:
                            updateBossInfo();
                            break;
                        case 7:
                            deleteBoss();
                            break;
                        case 8:
                            searchBossByUsername();
                            break;
                        case 9:
                            stop();
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again..");
                            break;
                    }
                }
            };
            menu.run();
        }


    private void addNewEmployee() {
        String username = Validation.checkInputUsername("Enter username: ");
        String password = Validation.checkInputPassword("Enter password: ");
        String lastName = Validation.checkInputString("Enter Last-name: ");
        String firstName = Validation.checkInputString("Enter First-name: ");
        String address = Validation.checkInputString("Enter E-mail: ");
        String phoneNum = Validation.checkInputString("Enter phone number: ");
        String dob = Validation.checkInputString("Enter date of birth (dd/MM/yyyy): ");
        double salary = Validation.checkInputDouble("Enter salary: ");

        try {
            Employee newEmployee = new Employee(username, password, lastName, firstName, address, phoneNum, dob, salary);
            addNewEmployee(newEmployee);
            System.out.println("New employee added successfully.");
        } catch (ParseException e) {
            System.out.println("Error creating new employee: " + e.getMessage());
        }
    }

    private void addNewBoss() {
        String username = Validation.checkInputUsername("Enter username: ");
        String password = Validation.checkInputPassword("Enter password: ");
        String lastName = Validation.checkInputString("Enter Last-name: ");
        String firstName = Validation.checkInputString("Enter First-name: ");
        String address = Validation.checkInputString("Enter E-mail: ");
        String phoneNum = Validation.checkInputString("Enter phone number: ");
        String dob = Validation.checkInputString("Enter date of birth (dd/MM/yyyy): ");

        try {
            Boss newBoss = new Boss(username, password, lastName, firstName, address, phoneNum, dob);
            addNewBoss(newBoss);
            System.out.println("New manager added successfully.");
        } catch (ParseException e) {
            System.out.println("Error creating new manager: " + e.getMessage());
        }
    }

    private void updateEmployeeInfo() {
        String username = Validation.checkInputString("Enter the username of the employee to be updated: ");
        Employee employee = searchEmployee(username);
        if (employee != null) {
            String newPassword = Validation.checkInputPassword("Enter new password: ");
            String newLastName = Validation.checkInputString("Enter new Last-name: ");
            String newFirstName = Validation.checkInputString("Enter new First-name: ");
            String newAddress = Validation.checkInputString("Enter new E-mail: ");
            String newPhoneNum = Validation.checkInputString("Enter new phone number: ");
            String newDob = Validation.checkInputString("Enter new date of birth (dd/MM/yyyy): ");
            double newSalary = Validation.checkInputDouble("Enter new salary: ");

            try {
                Employee updatedEmployee = new Employee(username, newPassword, newLastName, newFirstName, newAddress, newPhoneNum, newDob, newSalary);
                updateEmployee(username, updatedEmployee);
                System.out.println("Staff information has been updated successfully..");
            } catch (ParseException e) {
                System.out.println("Error updating staff information: " + e.getMessage());
            }
        } else {
            System.out.println("No staff found with this login name.");
        }
    }

    private void updateBossInfo() {
        String username = Validation.checkInputString("Enter the login name of the administrator to be updated: ");
        Boss boss = searchBoss(username);
        if (boss != null) {
            String newPassword = Validation.checkInputPassword("Enter new password: ");
            String newLastName = Validation.checkInputString("Enter new Last-name: ");
            String newFirstName = Validation.checkInputString("Enter new First-name: ");
            String newAddress = Validation.checkInputString("Enter new E-mail: ");
            String newPhoneNum = Validation.checkInputString("Enter new phone number: ");
            String newDob = Validation.checkInputString("Enter new date of birth (dd/MM/yyyy): ");

            try {
                Boss updatedBoss = new Boss(username, newPassword, newLastName, newFirstName, newAddress, newPhoneNum, newDob);
                updateBoss(username, updatedBoss);
                System.out.println("Management information has been updated successfully..");
            } catch (ParseException e) {
                System.out.println("Error updating management information: " + e.getMessage());
            }
        } else {
            System.out.println("No administrator found with this login name.");
        }
    }

    private void deleteEmployee() {
        String username = Validation.checkInputString("Enter the username of the staff to be deleted: ");
        deleteEmployee(username);
    }

    private void deleteBoss() {
        String username = Validation.checkInputString("Enter the login name of the administrator to be deleted: ");
        deleteBoss(username);
    }

    private void searchEmployeeByUsername() {
        String username = Validation.checkInputString("Enter the username of the employee you are looking for: ");
        Employee employee = searchEmployee(username);
        if (employee != null) {
            System.out.println("Staff Information:");
            System.out.println(employee);
        } else {
            System.out.println("No staff found with this login name.");
        }
    }

    private void searchBossByUsername() {
        String username = Validation.checkInputString("Enter the login name of the administrator you are looking for: ");
        Boss boss = searchBoss(username);
        if (boss != null) {
            System.out.println("Management information:");
            System.out.println(boss);
        } else {
            System.out.println("No administrator found with this login name.");
        }
    }
}
