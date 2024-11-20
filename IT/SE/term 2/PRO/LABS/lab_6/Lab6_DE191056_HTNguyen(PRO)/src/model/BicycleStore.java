package model;

import view.Menu;
import view.Utils;
import view.Validation;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BicycleStore {


    ArrayList<Bicycle> bikeList;
    ArrayList<Bicycle> userChange;
    Validation val = new Validation();


    public BicycleStore() throws ParseException {
        this.bikeList = new ArrayList<>();
        loadFile("store.txt");
    }

    //LOAD FILE
    public void loadFile(String fname) {
        String product = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((product = br.readLine()) != null) {
                String[] temp = product.split(",");
                if (val.checkIdFile(temp[0]) != null && val.checkIsElectricFile(temp[3]) != null && val.checkProcDateFile(temp[4]) != null) {
                    bikeList.add(new Bicycle(temp[0], Double.parseDouble(temp[1]), Double.parseDouble(temp[2]), Boolean.parseBoolean(temp[3]), temp[4]));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(BicycleStore.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //SAVE FILE
    public void saveFile(String fname) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("store.txt", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Bicycle i : userChange) {
                bw.write("\n"
                        + i.getBicycleId() + ","
                        + i.getSpeed() + ","
                        + i.getDistance() + ","
                        + i.isElectric() + ","
                        + sdf.format(i.getProductionDate()));
            }
        } catch (IOException e) {
            System.out.println("Not found!");
        }
    }


    //ADD
    public void addNewBike() throws ParseException {
        int quan = Utils.checkInt("Enter number of bicycle to add: ");
        int i = 0;
        Bicycle newBike;
        userChange = new ArrayList<>();
        while (i < quan) {
            System.out.println("No." + (i + 1));
            String id = Utils.checkID("Enter new ID: ");
            int e = 0;
            while (e < bikeList.size()) {
                if (bikeList.get(e).getBicycleId().equals(id)) {
                    System.out.println("ID was already used...");
                    id = Utils.checkID("Enter new ID again: ");
                    e = 0;
                } else {
                    e++;
                }
            }
            double speed = Utils.checkDou("Enter new speed: ");
            double distance = Utils.checkDou("Enter new distance: ");
            boolean isElectric = Utils.checkBool("Is it electricity bike(true/false): ");
            String procDate = Utils.checkProc("Enter new production date: ");
            newBike = new Bicycle(id, speed, distance, isElectric, procDate);
            bikeList.add(newBike);
            userChange.add(newBike);
            System.out.println("ADDED " + "No." + (i + 1));
            i++;
        }
        saveFile("store.txt");
    }

    private ArrayList<Bicycle> check(Predicate<Bicycle> p) {
        ArrayList<Bicycle> rs = new ArrayList<>();
        for (Bicycle i : bikeList) {
            if (p.test(i)) rs.add(i);
        }
        return rs;
    }

    public void formatShow() {
        System.out.format("%-10s | %-5s | %-5s | %-10s | %-26s | %-5s\n",
                "Type",
                "ID",
                "Speed",
                "Distance",
                "Status",
                "Production date"
        );
    }

    //SHOW INFORMATION
    public void showInforBike() throws ParseException {
        String[] subChoice = {
                "Show all bicycle ",
                "Show normal bicycle list",
                "Show electricity bicycle list",
                "Show bicycle list according to speed (ascending)",
                "Back to main menu"
        };
        Menu submn = new Menu("Show...", subChoice) {
            @Override
            public void execute(int n) {
                ArrayList<Bicycle> res;
                if (bikeList.isEmpty()) System.out.println("Empty list...");
                else {
                    switch (n) {
                        case 1 -> {
                            formatShow();
                            bikeList.forEach(System.out::println);

                        }
                        case 2 -> {
                            res = new ArrayList<>();
                            res = check(o -> !o.isElectric());
                            System.out.println("Normal Bicycle");
                            formatShow();
                            res.forEach(System.out::println);

                        }
                        case 3 -> {
                            res = new ArrayList<>();
                            res = check(o -> o.isElectric());
                            System.out.println("Electricity Bicycle");
                            formatShow();
                            res.forEach(System.out::println);
                        }
                        case 4 -> {
                            Collections.sort(bikeList, (p1, p2) -> Double.compare(p1.getSpeed(), p2.getSpeed()));
                            formatShow();
                            bikeList.forEach(System.out::println);
                        }
                        case 5 -> {
                        }
                    }
                }
            }
        };
        submn.run();
    }


    //DELETE
    public void deleteBike() {
        String id = Utils.getValue("Enter ID to delete: ");
        ArrayList<Bicycle> res = check(p -> p.getBicycleId().equalsIgnoreCase(id));
        if (res.isEmpty()) System.out.println("Non-existent ID in list!");
        else {
            bikeList.remove(res.getFirst());
            System.out.println("Deleted successfully!");
        }
    }

    //SEARCH
    public void searchBike() {
        ArrayList<Bicycle> rs = new ArrayList<>();
        double min = Double.MAX_VALUE;
        double timeToMove;
        for (Bicycle i : bikeList) {
            timeToMove = i.getDistance() / i.getSpeed();
            if (timeToMove < min) {
                min = timeToMove;
                rs.clear();
                rs.add(i);
            } else if (timeToMove == min) {
                rs.add(i);
            }
        }
        rs.forEach(System.out::println);
    }

    //SHOW bike with same year production
    public String getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    public void showSameYearProcBike() {
        ArrayList<Bicycle> temp = bikeList;
        ArrayList<String> yearList = new ArrayList<>();
        for (Bicycle i : temp) {
            if (!yearList.contains(getYear(i.getProductionDate()))) {
                String y = getYear(i.getProductionDate());
                yearList.add(y);
            }
        }
        ArrayList<Bicycle> res;
        for (String i : yearList) {
            res = new ArrayList<>();
            int count = 0;
            for (Bicycle j : temp) {
                if (getYear(j.getProductionDate()).equals(i)) {
                    count++;
                    res.add(j);
                }
            }
            if (count > 1) {
                System.out.println("#_#Bicycles were produced in " + i);
                formatShow();
                res.forEach(System.out::println);
            }
        }
    }
}
