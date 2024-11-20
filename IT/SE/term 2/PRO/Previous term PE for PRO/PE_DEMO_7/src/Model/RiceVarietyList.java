/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Menu;
import View.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class RiceVarietyList {

    private List<RiceVariety> riceList;

    //constructor
    public RiceVarietyList() {
        riceList = new ArrayList<>();
        loadFile("rice_varieties.csv");
    }

    //getter & setter
    public List<RiceVariety> getRiceList() {
        return riceList;
    }

    public void setRiceList(List<RiceVariety> riceList) {
        this.riceList = riceList;
    }

    //load file
    public void loadFile(String fname) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 8) {
                    riceList.add(new RiceVariety(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]), temp[4], temp[5], temp[6], Boolean.parseBoolean(temp[7])));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DISPLAY ALL
    public void displayAll() {
        riceList.forEach(System.out::println);
    }

    //ADD NEW
    public void addNew() throws ParseException {
        String name = Utils.checkInputName("Enter a new name: ");
        String origin = Utils.inputValue("Enter origin: ");
        String harvestDate = Utils.checkInputDob("Enter harvest date: ");
        double yield = Double.parseDouble(Utils.inputValue("Enter yield:"));
        String diseaseResistance = Utils.inputValue("Enter disease resistance: ");
        String climateSuit = Utils.inputValue("Enter climate suitability: ");
        String grainType = Utils.inputValue("Enter grain type: ");
        boolean isHybrid = Boolean.parseBoolean(Utils.inputValue("Is this hybrid or not: "));
        riceList.add(new RiceVariety(name, origin, harvestDate, yield, diseaseResistance, climateSuit, grainType, isHybrid));
    }

    //UPDATE
    public void updateRice() throws ParseException {
        String name = Utils.checkInputName("Enter name to update: ");

        for (int i = 0; i < riceList.size(); i++) {
            if (riceList.get(i).getName().equalsIgnoreCase(name)) {
                double yield = Double.parseDouble(Utils.inputValue("Enter yield: "));
                String diseaseResistance = Utils.inputValue("Enter disease resistance: ");
                String climate = Utils.inputValue("Enter climate: ");
                String grainType = Utils.inputValue("Enter grain type: ");
                RiceVariety newRiceVariety = new RiceVariety(
                        name,
                        riceList.get(i).getOrigin(),
                        riceList.get(i).getHarvestDate(),
                        yield,
                        diseaseResistance,
                        climate,
                        riceList.get(i).getGrainType(),
                        riceList.get(i).isHighYield()
                );
                riceList.set(i, newRiceVariety);
            }
        }
    }

    //SEARCH
    public ArrayList<RiceVariety> search(Predicate<RiceVariety> o) {
        ArrayList<RiceVariety> res = new ArrayList<>();
        for (RiceVariety i : riceList) {
            if (o.test(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public void searchRice() throws ParseException {
        String[] choice = {
            "by name",
            "by origin",
            "by disease resistance level",
            "by climate suitability",
            "Back"
        };
        Menu subMenu = new Menu("Search by...", choice) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<RiceVariety> res = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String name = Utils.checkInputName("Enter name to search: ");
                        res = search(o -> o.getName().equals(name));
                    }
                    case 2 -> {
                        String origin = Utils.inputValue("Enter origin to search: ");
                        res = search(o -> o.getOrigin().equals(origin));
                    }
                    case 3 -> {
                        String dis = Utils.inputValue("Enter disease resistance level: ");
                        res = search(o -> o.getDiseaseResistance().equals(dis));
                    }
                    case 4 -> {
                        String climate = Utils.inputValue("Enter climate suitability: ");
                        res = search(o -> o.getClimateSuitablility().equals(climate));
                    }
                }
                if (!res.isEmpty()) {
                    res.forEach(System.out::println);
                }
            }
        };
        subMenu.run();
    }

    //DELETE
    public void deleteRice() {

    }

    //SORT
    private void option(Comparator<RiceVariety> cmp) throws ParseException {
        String[] opt = {
            "with ascending",
            "with descending",
            "Back"
        };

        Menu subMenu = new Menu("ascending or descending", opt) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        Collections.sort(riceList, cmp);
                    case 2 ->
                        Collections.sort(riceList, cmp.reversed());
                }
                System.out.println(riceList);
            }
        };
        subMenu.run();
    }

    public void sortRice() throws ParseException {
        String[] choice = {
            "by yield",
            "by age",
            "Back"
        };

        Menu subMenu = new Menu("Sort by", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        option((o1, o2) -> Double.compare(o1.getYield(), o2.getYield()));
                    case 2 ->
                        option((o1, o2) -> Double.compare(o1.getAge(), o2.getAge()));
                }
            }
        };
        subMenu.run();
    }

    //SUMMARY REPORT
    public void summary() {
        Set<String> riceSet = new HashSet<>();
        for (RiceVariety i : riceList) {
            riceSet.add(i.getOrigin());
        }
        double sum = 0;
        int numOfHybrid = 0;
        for (String i : riceSet) {
            int count = 0;
            for (RiceVariety j : riceList) {
                if (j.getOrigin().equalsIgnoreCase(i)) {
                    sum += j.getYield();
                    count++;
                    if (j.isIsHybrid()) {
                        numOfHybrid++;
                    }
                }
            }
            System.out.println(i + " : " + count);
        }
        System.out.printf("Average yield: %.2f\n", sum / riceList.size());
        System.out.println("Hybrid rice varieties: " + numOfHybrid);
        System.out.println("Not hybrid rice varieties: " + (riceList.size() - numOfHybrid));

    }

    //EXPORT TO FILE
    public void exportToFile() throws IOException {
        String fname = "new_rice_varieties.csv";
        File newFile = new File(fname);
        if (newFile.createNewFile()) {
            System.out.println("Created file " + newFile.getName() + " successfully!");
        } else {
            System.out.println("File already existed");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile.getAbsolutePath()))) {
            for (RiceVariety i : riceList) {
                bw.write(i.getName() + ","
                        + i.getOrigin() + ","
                        + i.getHarvestDate() + ","
                        + i.getYield() + ","
                        + i.getDiseaseResistance() + ","
                        + i.getClimateSuitablility() + ","
                        + i.getGrainType() + ","
                        + i.isIsHybrid() + "\n"
                );
                bw.flush();
            }
            System.out.println("Updated to file successfully!");
        } catch (Exception e) {
            System.out.println("Can not write to file!");
        }
    }

}
