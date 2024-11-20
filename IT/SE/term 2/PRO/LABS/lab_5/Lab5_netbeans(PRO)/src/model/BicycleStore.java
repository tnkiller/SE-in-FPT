package model;

import view.Menu;
import view.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.function.Predicate;

public class BicycleStore {

    ArrayList<Bicycle> bikeList;

    public BicycleStore() throws ParseException {
        this.bikeList = new ArrayList<>();
        bikeList.add(new Bicycle("EB001", 25, 150, true, "1/1/2000"));
        bikeList.add(new Bicycle("B002", 30, 20, false, "20/06/2021"));
        bikeList.add(new Bicycle("B003", 22, 100, false, "05/05/2023"));
        bikeList.add(new Bicycle("EB004", 28, 80, true, "10/01/2020"));
        bikeList.add(new Bicycle("B005", 30, 20, false, "17/11/2022"));
        bikeList.add(new Bicycle("B015", 30, 20, false, "1/11/2022"));
        bikeList.add(new Bicycle("B025", 30, 20, false, "2/12/2020"));
        bikeList.add(new Bicycle("B035", 30, 20, false, "10/5/2021"));
        bikeList.add(new Bicycle("B055", 24, 120, false, "17/11/2022"));
    }

    //ADD
    public void addNewBike() throws ParseException {
        int quan = Utils.checkInt("Enter number of bicycle to add: ");
        int i = 0;
        Bicycle newBike;
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
            System.out.println("ADDED " + "No." + (i + 1));
            i++;
        }
    }

    private ArrayList<Bicycle> check(Predicate<Bicycle> p) {
        ArrayList<Bicycle> rs = new ArrayList<>();
        for (Bicycle i : bikeList) {
            if (p.test(i)) {
                rs.add(i);
            }
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
        };
        submn.run();
    }

    //DELETE
    public void deleteBike() {
        String id = Utils.getValue("Enter ID to delete: ");
        ArrayList<Bicycle> res = check(p -> p.getBicycleId().equalsIgnoreCase(id));
        if (res.isEmpty()) {
            System.out.println("Non-existent ID in list!");
        } else {
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
        boolean check = false;
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
                check = true;
                System.out.println("#_#Bicycles were produced in " + i);
                formatShow();
                res.forEach(System.out::println);
            } 
        }
        if (check == false) System.out.println("No bicycle has same year production...");
    }
}
