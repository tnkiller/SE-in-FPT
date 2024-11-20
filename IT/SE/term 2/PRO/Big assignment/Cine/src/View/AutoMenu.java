package View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AutoMenu {
    protected String title; // Menu title
    protected ArrayList<String> menuOptions; // List of menu options
    protected boolean isStop;
    private final Scanner scanner;

    public AutoMenu() {
        this.scanner = new Scanner(System.in);
    }

    public AutoMenu(String title, String[] menuOptions) {
        this();
        this.title = title;
        this.menuOptions = new ArrayList<>();
        Collections.addAll(this.menuOptions, menuOptions);
        this.isStop = false;
    }

    // Display the menu options
    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i));
        }
    }

    // Read the user's selection
    public int getSelected() {
        display();
        int selection;
        while (true) {
            try {
                System.out.print("Choose option: ");
                selection = scanner.nextInt();
                if (selection < 1 || selection > menuOptions.size() + 1) {
                    System.out.println("Invalid option. Try again!!");
                } else {
                    return selection;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid data. Please enter number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    // Abstract method to execute the selected option
    public abstract void execute(int selection) throws ParseException;

    // Set flag to stop the menu loop
    public void stop() {
        this.isStop = true;
    }

    // Run the menu loop
    public void run() throws ParseException {
        while (!isStop) {
            int selection = getSelected();
            if (selection == menuOptions.size() + 1) { // If the "Exit" option is chosen
                break; // Stop the menu
            } else {
                this.execute(selection);
            }
        }
        System.out.println("Exit menu.");
    }
}
