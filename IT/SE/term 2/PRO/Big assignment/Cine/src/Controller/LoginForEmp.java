package Controller;

import Model.customer.Customer;
import Model.customer.ListCustomer;
import Model.employee.Boss;
import Model.employee.Employee;
import Model.employee.ListEmployee;
import View.AutoMenu;
import View.Validation;

import java.text.ParseException;

public class LoginForEmp {

    private ListCustomer listCustomer;
    private ListEmployee listEmployee;

    public LoginForEmp() {
        listCustomer = new ListCustomer();
        listEmployee = new ListEmployee();
    }

    public String login(String username, String password) {

        // Check if the user is an employee
        Employee employee = listEmployee.searchEmployee(username);
        if (employee != null && employee.getPassword().equals(password)) {
            return "employee";
        }

        // Check if the user is a boss
        Boss boss = listEmployee.searchBoss(username);
        if (boss != null && boss.getPassword().equals(password)) {
            return "boss";
        }

        // If the user is not found in any of the lists, return "invalid"
        return "account or password is incorrect";

    }

    public void loginRun() throws ParseException {
        while (true) {
            String username = Validation.checkInputUsername("");
            String paass = Validation.checkInputPassword("");
            if (login(username, paass) == "employee") {
                Staff_CinemaManage StaffManager = new Staff_CinemaManage();
                StaffManager.run();
            } else if (login(username, paass) == "boss") {
                CinemaManage BossManager = new CinemaManage();
                BossManager.run();
            } else {
                System.out.println(login(username, paass));
            }
        }

    }

    public static void main(String[] args) throws ParseException {
        LoginForEmp login = new LoginForEmp();
        AutoMenu autoMenu = new AutoMenu("=======Menu========", new String[]{
            "Login", "Register", "EXIT"
        }) {
            @Override
            public void execute(int selection) throws ParseException {
                switch (selection) {
                    case 1 ->
                        new LoginForEmp().loginRun();
                    case 2 ->
                        new LoginForEmp().listCustomer.addNewCustomer();
                    case 3 ->
                        stop();
                }

            }
        };
        autoMenu.run();
    }
}
