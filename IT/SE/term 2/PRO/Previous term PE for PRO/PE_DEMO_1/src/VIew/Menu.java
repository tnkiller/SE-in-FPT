package VIew;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {

    protected String title;
    protected ArrayList<String> choice;

    public Menu() {

    }

    public Menu(String title, String[] choice) {
        this.title = title;
        this.choice = new ArrayList<>();
        for (String i : choice) {
            this.choice.add(i);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("-----------------------------");
        for (int i = 0; i < this.choice.size(); i++) {
            System.out.println((i + 1) + ". " + this.choice.get(i));
        }
        System.out.println("-----------------------------");
    }

    public int getSelect() {
        while (true) {
            try {
                display();
                Scanner sc = new Scanner(System.in);
                System.out.print("You choose: ");
                int n = sc.nextInt();
                choice.get(n - 1);
                return n;

            } catch (InputMismatchException ime) {
                System.out.println("Invalid! Try again with digit...");
            } catch (IndexOutOfBoundsException ioe) {
                System.out.println("Please choose exactly index in menu");
            }
        }
    }

    public abstract void execute(int n) throws ParseException;

    public void run() throws ParseException {
        while (true) {
            int n = getSelect();
            execute(n);
            if (n == this.choice.size()) {
                System.out.println("See you soon!");
                break;
            }
        }
    }

}
