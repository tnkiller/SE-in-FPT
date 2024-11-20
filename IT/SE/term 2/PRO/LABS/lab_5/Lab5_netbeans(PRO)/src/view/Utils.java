package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {

    public static String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }


    public static int checkInt(String msg) {
        while (true) {
            try {
                int n = Integer.parseInt(getValue(msg));
                return n;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid! Please input an integer value. ");
            }
        }
    }

    public static double checkDou(String msg) throws Exception {
        while (true) {
            try {
                double n = Double.parseDouble(getValue(msg));
                if (n <= 0 ) throw new Exception("Invalid! Please enter positive value");
                return n;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid! Please input an double value");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkID(String msg) {
        while (true) {
            try {
                String n = getValue(msg);
                if (n.isEmpty() || n.contains(" ")) throw new Exception("ID must be string without whitespace");
                return n;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean checkBool(String msg) {
        while (true) {
            try {
                String n = getValue(msg);
                if (!n.equalsIgnoreCase("true") && !n.equalsIgnoreCase("false")) {
                    throw new Exception("Invalid. Please enter \" TRUE \" or \" FALSE \" ");
                }
                return Boolean.parseBoolean(n);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkProc(String msg) {
        while (true) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                String date = getValue(msg);
                Date parsedDate = dateFormat.parse(date);
                dateFormat.format(parsedDate);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid date format. dd/MM/yyyy.");
            }
        }
    }


}
