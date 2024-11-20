package view;

public class Menu {
    
    public static void showMainMenu(){
        System.out.println("\t\t\t---MENU---");
        System.out.println("1. Search");
        System.out.println("2. Show list");
        System.out.println("3. Add new");
        System.out.println("4. Sort list decrease by average");
        System.out.println("5. Statics on students born before 2000");
        System.out.println("0. Exit");
    }
    
    public static void subMenu(){
        System.out.println("1. Search by average");
        System.out.println("2. Search by date of birthday");
    }

}
