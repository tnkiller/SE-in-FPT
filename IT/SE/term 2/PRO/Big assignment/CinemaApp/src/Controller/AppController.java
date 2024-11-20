package Controller;

import Model.Customer;
import Model.Function;
import View.Menu;

import java.text.ParseException;

public class AppController extends Menu {
    Function fn;
    static String[] choice = {
            "Sign in",
            "Sign up",
            "Forget password",
            "Exit",
    };

    public AppController() {
        super("---Xinema App---", choice);
        fn = new Function();
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 -> fn.signIn();
            case 2 -> fn.signUp();
            case 3 -> fn.forgetPassword();
        }

    }


    public static void main(String[] args) throws ParseException {
        AppController app = new AppController();
        app.run();
    }


}
