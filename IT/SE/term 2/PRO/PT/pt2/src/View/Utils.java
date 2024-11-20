package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
                if (!id.matches("Emp[0-9]{3}")) {
                    throw new Exception("Try again without space (Ex: Emp101)");
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

    public static String getDob(String msg) {
        while (true) {
            try {
                String dob = getValue(msg);
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

    public static long getSalary(String msg) throws Exception {
        while (true) {
            try {
                long salary = Long.parseLong(getValue(msg));
                return salary;
            } catch (InputMismatchException ime) {
                System.out.println("Please input long...");
            }
        }
    }
}
