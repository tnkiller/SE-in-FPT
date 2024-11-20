package Controller;

import Model.function.*;
import View.Menu;

import java.text.ParseException;

public class LoginForCustomer extends Menu {
    Function fn;
    static String[] choice = {
            "Sign in",
            "Sign up",
            "Forget password",
            "Show available films in cinema",
            "Book ticket",
            "Exit"
    };
    

    public LoginForCustomer() {
        super("---Xinema Online App---", choice);
        fn = new Function();
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 -> fn.signIn();
            case 2 -> fn.signUp();
            case 3 -> fn.forgetPassword();
            case 4 -> fn.showAvailableFilms();
            case 5 -> fn.bookTicket();
            case 6 -> System.exit(0);
        }

    }


    public static void main(String[] args) throws ParseException {
        LoginForCustomer app = new LoginForCustomer();
        app.run();
    }


}
