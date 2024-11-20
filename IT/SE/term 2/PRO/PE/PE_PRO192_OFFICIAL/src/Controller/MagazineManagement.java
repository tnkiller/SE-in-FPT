package Controller;

import Model.Magazine;
import Model.MagazineList;
import View.Utils;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Menu;

public class MagazineManagement extends Menu<String> {

    MagazineList magList;
    static String[] choice = {
        "Add a new magazine",
        "Display all magazines",
        "Display sorted magazines by the number of pages",
        "Search magazines",
        "Delete magazines"
    };

    public MagazineManagement() throws ParseException {
        super("---TOOL---", choice);
        magList = new MagazineList();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                try {
                    addNew();
                } catch (ParseException ex) {
                    Logger.getLogger(MagazineManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2 ->
                displayAll();
            case 3 ->
                displaySorted();
            case 4 ->
                searchMagazine();
            case 5 ->
                deleteMagazine();

        }
    }

    //MAIN
    public static void main(String[] args) throws ParseException {
        MagazineManagement mgn = new MagazineManagement();
        mgn.run();
    }

    //------------------METHOD in problem------------
    //ADD
    public void addNew() throws ParseException {
        String title = Utils.inputValue("Enter new title: ");
        String publisher = Utils.inputValue("Enter new publisher: ");
        String publishDate = Utils.checkInputDob("Enter new publish date: ");
        int issue = Integer.parseInt(Utils.inputValueInt("Enter new issue number: "));
        int pages = Integer.parseInt(Utils.inputValueInt("Enter new pages number: "));
        magList.addNew(new Magazine(title, publisher, publishDate, issue, pages));
    }

    //DISPLAY
    public void displayAll() {
        magList.getMagazineList().forEach(System.out::println);
    }

    //DISPLAY SORTED
    public void displaySorted() {
        magList.sortByNumberPage();
        displayAll();
    }

    //SEARCH
    public void searchMagazine() {
        magList.searchMagazine();
    }

    //DELETE
    public void deleteMagazine() {
        magList.deleteMagazine();
    }

}
