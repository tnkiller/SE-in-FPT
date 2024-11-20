package Model;

import View.Menu;
import View.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Function {

    ArrayList<Customer> customers;
    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";
    private String RESET = "\u001B[0m";

    public Function() {
        customers = new ArrayList<>();
        loadFile("C:\\Users\\ADMIN\\Downloads\\Cinema\\customer.txt");
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
                    case 1 -> signInByUsername();
                    case 2 -> signInByEmail();
                }
            }
        };
        subMenu.run();
    }

    //~~~~~~~~~~~~~~
    public void signInByUsername() {
        String[] rs = new String[2];
        rs[0] = Utils.checkInputUsername("Enter your username: ");
        rs[1] = Utils.checkInputPassword("Enter your password: ");
        boolean isExist = false;
        for (Customer i : customers) {
            if (i.getUserName().equals(rs[0]) && i.getPassword().equals(rs[1])) {
                System.out.println(GREEN + "Signed in successfully" + RESET);
                isExist = true;
                break;
            }
        }
        if (!isExist) System.out.println("Can't find your account!");
    }

    //~~~~~~~~~~~~~~
    public void signInByEmail() {
        String[] rs = new String[2];
        rs[0] = Utils.checkInputMail("Enter your email: ");
        rs[1] = Utils.checkInputPassword("Enter your password: ");
        boolean isExist = false;
        for (Customer i : customers) {
            if (i.getMail().equals(rs[0]) && i.getPassword().equals(rs[1])) {
                System.out.println(GREEN + "Signed in successfully" + RESET);
                isExist = true;
                break;
            }
        }
        if (!isExist) System.out.println("Can't find your account!");
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
            } else break;
        }
        String password = Utils.checkInputPassword("Enter new password: ");
        String lastName = Utils.checkInputName("Enter your last name: ");
        String firstName = Utils.checkInputName("Enter your first name: ");
        String mail = Utils.checkInputMail("Enter your first name: ");
        String phoneNum = Utils.checkPhoneNum("Enter your first name: ");
        String date = Utils.checkInputDate("Enter your birthday: ");
        customers.add(new Customer(userName, password, lastName, firstName, mail, phoneNum, date));
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
                    break;
                }
            }
            if (!isExist) System.out.println("Your account do not exist in our server!");
            else {
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
