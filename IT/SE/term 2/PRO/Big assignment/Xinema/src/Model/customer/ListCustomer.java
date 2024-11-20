/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.customer;

import Model.ve.Ve;
import View.AutoMenu;
import View.Validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListCustomer {
    private ArrayList<Customer> customers;
    private Map<String, Integer> customerPoints;
    private Map<String, CustomerLevel> customerLevels;

    public ListCustomer() {
        customers = new ArrayList<>();
        customerPoints = new HashMap<>();
        customerLevels = new HashMap<>();
        loadCustomerData("customer.txt");
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    // Đọc dữ liệu khách hàng từ file
    private void loadCustomerData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 8) {
                    Customer customer = new Customer(details[0], details[1], details[2], details[3], details[4], details[5], details[6], Integer.parseInt(details[7]));
                    customers.add(customer);
                    customerPoints.put(customer.getUserName(), customer.getPoints());
                    updateCustomerLevel(customer.getUserName());
                }
            }
        } catch (Exception e) {
            System.out.println("Loi doc file "+e);

        }
    }

    // Lưu dữ liệu khách hàng vào file
    public void saveCustomerData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customer.txt"))) {
            for (Customer customer : customers) {
                bw.write(customer.toStringFile() + "\n");
            }
            bw.flush();
        } catch (Exception e) {
            System.out.println("Loi ghi file "+e);

        }
    }

    // Thêm khách hàng mới
    public void addNewCustomer(Customer customer) {
        customers.add(customer);
        customerPoints.put(customer.getUserName(), customer.getPoints());
        updateCustomerLevel(customer.getUserName());
        saveCustomerData();
    }

    // Cập nhật thông tin khách hàng
    public void updateCustomer(String userName, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserName().equals(userName)) {
                int oldPoints = customers.get(i).getPoints();
                customers.set(i, updatedCustomer);
                customerPoints.put(userName, updatedCustomer.getPoints());
                updateCustomerLevel(userName);
                saveCustomerData();
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    // Xóa tài khoản khách hàng
    public void deleteCustomer(String userName) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserName().equals(userName)) {
                customerPoints.remove(userName);
                customerLevels.remove(userName);
                customers.remove(i);
                saveCustomerData();
                System.out.println("Customer account deleted successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    // Tìm kiếm khách hàng
    public static Customer searchCustomer(String userName) {
        ListCustomer listCustomer= new ListCustomer();
        for (Customer customer : listCustomer.customers) {
            if (customer.getUserName().equals(userName)) {
                return customer;
            }
        }

        return null;
    }

    // Hiển thị danh sách khách hàng
    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("Customer List:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Thêm chức năng quản lý thông tin khách hàng
    public void manageCustomerInfo() throws ParseException {
//        boolean running = true;
//        while (running) {
            String[] options = {
                    "Add new customers",
                    "Update customer information",
                    "Delete customer account",
                    "Find customers",
                    "View customer information",
                    "List Customer","Back"

            };
            AutoMenu menu = new AutoMenu("Customer information management", options) {
                @Override
                public void execute(int option) {
                    switch (option) {
                        case 1:
                            addNewCustomer();
                            break;
                        case 2:
                            updateCustomerInfo();
                            break;
                        case 3:
                            deleteCustomerAccount();
                            break;
                        case 4:
                            searchCustomerByUsername();
                            break;
                        case 5:
                            displayCustomerInfo();
                            break;
                        case 6:
                            displayCustomers();
                            break;
                        case 7 :{
                            stop();
                            break;
                        }


                        default:
                            System.out.println("Invalid selection. Please try again..");
                            break;
                    }
                }
            };
            menu.run();
        }


    public void addNewCustomer() {
        String username = Validation.checkInputUsername("Enter username: ");
        String password = Validation.checkInputPassword("Enter Password: ");
        String lastName = Validation.checkInputString("Enter your Last-name: ");
        String firstName = Validation.checkInputString("Enter your First-name: ");
        String address = Validation.checkInputString("Enter E-mail: ");
        String phoneNum = Validation.checkInputString("Enter phone number: ");
        String dob = Validation.checkInputString("Enter DOB (dd/MM/yyyy): ");
        int points = Validation.checkInputInt("Enter member points: ");

        try {
            Customer newCustomer = new Customer(username, password, lastName, firstName, address, phoneNum, dob, points);
            addNewCustomer(newCustomer);
            System.out.println("New customer added successfully.");
        } catch (ParseException e) {
            System.out.println("Error creating new customer: " + e.getMessage());
        }
    }

    private void updateCustomerInfo() {
        String username = Validation.checkInputString("Enter the login name of the customer to be updated: ");
        Customer customer = searchCustomer(username);
        if (customer != null) {
            String newPassword = Validation.checkInputPassword("Enter new password: ");
            String newLastName = Validation.checkInputString("Enter new Last-name: ");
            String newFirstName = Validation.checkInputString("Enter new First-name: ");
            String newAddress = Validation.checkInputString("Enter new E-mail: ");
            String newPhoneNum = Validation.checkInputString("Enter new phone number: ");
            String newDob = Validation.checkInputString("Enter new date of birth (dd/MM/yyyy):");
            int newPoints = Validation.checkInputInt("Enter new member points: ");

            try {
                Customer updatedCustomer = new Customer(username, newPassword, newLastName, newFirstName, newAddress, newPhoneNum, newDob, newPoints);
                updateCustomer(username, updatedCustomer);
                System.out.println("Updated successfully!.");
            } catch (ParseException e) {
                System.out.println("Update error: " + e.getMessage());
            }
        } else {
            System.out.println("Unable to find username.");
        }
    }

    private void deleteCustomerAccount() {
        String username = Validation.checkInputString("Enter the login name of the customer to be deleted: ");
        deleteCustomer(username);
    }

    private void searchCustomerByUsername() {
        String username = Validation.checkInputString("Enter the login name of the customer you are looking for: ");
        Customer customer = searchCustomer(username);
        if (customer != null) {
            System.out.println("Customer information:");
            System.out.println(customer);
        } else {
            System.out.println("No customer found with this login name.");
        }
    }

    private void displayCustomerInfo() {
        String username = Validation.checkInputString("Enter the login name of the customer whose information you want to view.: ");
        Customer customer = searchCustomer(username);
        if (customer != null) {
            System.out.println("Customer information:");
            System.out.println(customer);
            System.out.println("Member points: " + customerPoints.get(username));
            System.out.println("Customer level: " + customerLevels.get(username));
        } else {
            System.out.println("No customer found with this login name!!!");
        }
    }

    private void updateCustomerLevel(String username) {
        int points = customerPoints.get(username);
        if (points >= 10000) {
            customerLevels.put(username, CustomerLevel.PLATINUM);
        } else if (points >= 5000) {
            customerLevels.put(username, CustomerLevel.GOLD);
        } else {
            customerLevels.put(username, CustomerLevel.BRONZE);
        }
    }

}
