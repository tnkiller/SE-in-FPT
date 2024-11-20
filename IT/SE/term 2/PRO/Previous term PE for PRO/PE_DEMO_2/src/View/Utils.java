package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {

    public static String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }

    public static String getId(String msg) {
        while (true) {
            try {
                String id = getValue(msg);
                if (!id.matches("KH[0-9]{2}")) {
                    throw new Exception("The CustomerID does not accept the format (fading KH and has 4 keys)");
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

    public static String getName(String msg) {
        while (true) {
            try {
                String fullName = getValue(msg);
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

    public static Date getDob(String msg) {
        while (true) {
            try {
                String dob = getValue(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Date tempDob = sdf.parse(dob);
                sdf.format(tempDob);
                return sdf.parse(dob);
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

    public static String getPhone(String msg) {
        while (true) {
            try {
                String phone = getValue(msg);
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
