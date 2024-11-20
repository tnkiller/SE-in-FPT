package Model;

import View.Utils;
import View.Validation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import view.Menu;

public class MagazineList {

    //attributes
    private ArrayList<Magazine> magazineList;

    //constructor
    public MagazineList() throws ParseException {
        magazineList = new ArrayList<>();
        loadFile("magazines_input.txt");
    }

    //getter & setter
    public ArrayList<Magazine> getMagazineList() {
        return magazineList;
    }

    public void setMagazineList(ArrayList<Magazine> magazineList) {
        this.magazineList = magazineList;
    }

    //-------------------------------------------------------------
    //LOAD FILE
    public void loadFile(String fname) throws ParseException {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split("\\|");
                if (temp.length == 5) {
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Validation.removeSpace(temp[i]);
                    }
                    if (Validation.checkDobData(temp[2]) != null && Validation.checkIntData(temp[3]) != null && Validation.checkIntData(temp[4]) != null) {
                        magazineList.add(new Magazine(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4])));
                    }
                }
            }
        } catch (FileNotFoundException fne) {
            System.out.println("file not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    //addNew
    public void addNew(Magazine o) {
        magazineList.add(o);
    }

    //SORT
    public void sortByNumberPage() {
        Collections.sort(magazineList, (o1, o2) -> Integer.compare(o1.getPages(), o2.getPages()));
    }

    //SEARCH
    public ArrayList<Magazine> search(Predicate<Magazine> p) {
        ArrayList<Magazine> res = new ArrayList<>();
        for (Magazine i : magazineList) {
            if (p.test(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public void searchMagazine() {
        String[] option = {
            "by title",
            "by publisher",
            "by issue number"
        };

        Menu<String> subMenu = new Menu<String>("Search by...", option) {
            @Override
            public void execute(int n) {
                ArrayList<Magazine> result = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String title = Utils.inputValue("Enter title to search: ");
                        result = search(p -> p.getTitle().equals(title));
                    }
                    case 2 -> {
                        String pub = Utils.inputValue("Enter publisher to search: ");
                        result = search(p -> p.getPublisher().equals(pub));
                    }
                    case 3 -> {
                        int issueNum = Integer.parseInt(Utils.inputValue("Enter issue number to seach: "));
                        result = search(p -> p.getIssueNumber() == issueNum);
                    }
                }
                if (!result.isEmpty()) {
                    result.forEach(System.out::println);
                } else {
                    System.out.println("Can not find!");
                }
            }
        };
        subMenu.run();
    }

    //DELETE
    public void deleteMagazine() {
        magazineList.removeIf(p -> p.getAge() >= 5);
    }

}
