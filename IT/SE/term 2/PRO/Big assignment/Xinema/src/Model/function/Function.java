package Model;

import Model.customer.Customer;
import View.Menu;
import View.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;

public class Function {

    ArrayList<Customer> customers;
    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";
    private String RESET = "\u001B[0m";

    public Function() {
        customers = new ArrayList<>();
        loadFile("customer.txt");
    }

    //LOAD FILE
    public void loadFile(String fname) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                customers.add(new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], Integer.parseInt(temp[7])));
            }
        } catch (Exception e) {
            System.out.println("Can't find the file!");
        }
    }

    public void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customer.txt"))) {
            for (Customer customer : customers) {
                bw.write(customer.toStringFile() + "\n");
            }
            bw.flush();
        } catch (Exception e) {
            System.out.println("Loi ghi file " + e);

        }
    }

    //SIGN IN
    public void signIn() throws ParseException {
        String[] choice = {
            "username",
            "email",
            "Back"
        };
        Menu subMenu = new Menu("Sign in by...", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        signInByUsername();
                    case 2 ->
                        signInByEmail();
                }
            }
        };
        subMenu.run();
    }

    //~~~~~~~~~~~~~~
    public void signInByUsername() throws ParseException {
        String[] rs = new String[2];
        rs[0] = Utils.checkInputUsername("Enter your username: ");
        rs[1] = Utils.checkInputPassword("Enter your password: ");
        boolean isExist = false;
        for (Customer i : customers) {
            if (i.getUserName().equals(rs[0]) && i.getPassword().equals(rs[1])) {
                System.out.println(GREEN + "Signed in successfully" + RESET);
                new SignInMenu(i).run();
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Can't find your account!");
        }
    }

    //~~~~~~~~~~~~~~
    public void signInByEmail() throws ParseException {
        String[] rs = new String[2];
        rs[0] = Utils.checkInputMail("Enter your email: ");
        rs[1] = Utils.checkInputPassword("Enter your password: ");
        boolean isExist = false;
        for (Customer i : customers) {
            if (i.getAddress().equals(rs[0]) && i.getPassword().equals(rs[1])) {
                System.out.println(GREEN + "Signed in successfully" + RESET);
                new SignInMenu(i).run();
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Can't find your account!");
        }
    }


    /*
    -------------------------------------------------------------------------------------------------------------
     */
    //SIGN UP
    public void signUp() throws ParseException {
        String userName;
        while (true) {
            userName = Utils.checkInputUsername("Enter new username: ");
            String finalUserName = userName;
            if (customers.stream().anyMatch(customer -> customer.hasSameUsername(finalUserName))) {
                System.out.println("Your username was used!");
            } else {
                break;
            }
        }
        String password = Utils.checkInputPassword("Enter new password: ");
        String lastName = Utils.checkInputName("Enter your last name: ");
        String firstName = Utils.checkInputName("Enter your first name: ");
        String address = Utils.checkInputMail("Enter your email: ");
        String phoneNum = Utils.checkPhoneNum("Enter your phone number: ");
        String date = Utils.checkInputDate("Enter your birthday: ");
        customers.add(new Customer(userName, password, lastName, firstName, address, phoneNum, date,0));
        saveData();
    }


    /*
    -------------------------------------------------------------------------------------------------------------
     */
    public void forgetPassword() {
        String username;
        while (true) {
            username = Utils.checkInputUsername("Enter your username to set a new password: ");
            boolean isExist = false;
            for (Customer i : customers) {
                if (i.hasSameUsername(username)) {
                    isExist = true;
                    setNewPassword(i);
                    saveData();
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Your account do not exist in our server!");
            } else {
                System.out.println("Set new password successfully!");
                break;
            }
        }
    }

    public void setNewPassword(Customer c) {
        String newPassword = Utils.checkInputPassword("Enter new password: ");
        c.setPassword(newPassword);
    }
}
