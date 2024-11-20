package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {

    public static String inputValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }
    
    
    public static String inputValueInt(String msg) {
        while(true){
            try {
                String data = inputValue(msg);
                int d = Integer.parseInt(data);
                return data;
            } catch (NumberFormatException nfe) {
                System.out.println("Try again...");
            }
        }
    }


    //CHECK ID
    public static String checkInputId(String msg) {
        while (true) {
            try {
                String id = inputValue(msg);
                if (!id.matches("KH[0-9]{2}")) {
                    throw new Exception("Please try again with...");
                }
                return id;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean isOnlyAlphabet(String fullName) {
        if (fullName == null || fullName.equals(" ")) {
            return false;
        }
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                continue;
            }
            if (!Character.isLetter(fullName.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    //CHECK NAME
    public static String checkInputName(String msg) {
        while (true) {
            try {
                String fullName = inputValue(msg);
                if (isOnlyAlphabet(fullName) || (isOnlyAlphabet(fullName) && fullName.contains(" "))) {
                    return fullName;
                } else {
                    throw new Exception("Try again without digit number and special character");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //CHECK DOB
    public static String checkInputDob(String msg) {
        while (true) {
            try {
                String dob = inputValue(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Date tempDob = sdf.parse(dob);
                sdf.format(tempDob);
                return dob;
            } catch (Exception e) {
                System.out.println("Try again with format (dd/MM/yyyy)");
            }
        }
    }

    private static boolean isOnlyDigit(String phone) {
        if (phone == null || phone.equals(" ")) {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //CHECK PHONE
    public static String checkInputPhone(String msg) {
        while (true) {
            try {
                String phone = inputValue(msg);
                if (!isOnlyDigit(phone)) {
                    throw new Exception("Try again with all digit number without whitespace");
                }
                return phone;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
