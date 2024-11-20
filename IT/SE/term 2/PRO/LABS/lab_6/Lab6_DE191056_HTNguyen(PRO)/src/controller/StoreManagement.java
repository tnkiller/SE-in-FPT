package controller;

import model.BicycleStore;
import view.Menu;

import java.io.File;
import java.text.ParseException;

public class StoreManagement extends Menu {

    BicycleStore bicycleStore;
    static String[] choice = {
            "Add new bicycle",
            "Show all existing bicycle in store",
            "Delete an existed bike ",
            "Search for bicycle which takes the least time to move",
            "Show bicycles with the same year production",
            "Exit"
    };

    public StoreManagement() throws ParseException {
        super("---TOOL---", choice);
        bicycleStore = new BicycleStore();
    }

    @Override
    public void execute(int n) throws ParseException {
        switch (n) {
            case 1 -> bicycleStore.addNewBike();
            case 2 -> bicycleStore.showInforBike();
            case 3 -> bicycleStore.deleteBike();
            case 4 -> bicycleStore.searchBike();
            case 5 -> bicycleStore.showSameYearProcBike();
            case 6 ->{}
        }

    }
    //MAIN
    public static void main(String[] args) throws ParseException {
        StoreManagement str = new StoreManagement();
        str.run();
    }
}
