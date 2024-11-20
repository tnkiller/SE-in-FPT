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

    //check username
    public static String checkInputUsername(String msg) {
        while (true) {
            try {
                String userName = getValue(msg);
                if (userName.contains(" ")) throw new Exception("No space in username");
                return userName;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //check password
    public static String checkInputPassword(String msg) {
        while (true) {
            try {
                String password = getValue(msg);
                if (password.contains(" ") || password.length() < 5) {
                    throw new Exception("No space and length must be more than 8 character");
                }
                return password;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //check email
    public static String checkInputMail(String msg) {
        while (true) {
            try {
                String mail = getValue(msg);
                if (!mail.contains("@gmail.com") || mail.contains(" ")) {
                    throw new Exception("Don't forget \"@gmail.com\" and no space");
                }
                return mail;
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

    public static String checkInputName(String msg) {
        while (true) {
            try {
                String name = getValue(msg);
                if (!isOnlyAlphabet(name)) throw new Exception("No digit, no space, no special char");
                return name;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean isOnlyDigit(String phone) {
        if (phone == null || phone.contains(" ")) return false;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return false;
        }
        return true;
    }

    private static boolean beginWithZero(String phone) {
        if (phone.charAt(0) != 0) return false;
        return true;
    }

    public static String checkPhoneNum(String msg) {
        while (true) {
            try {
                String phone = getValue(msg);
                if (!(isOnlyDigit(phone) && beginWithZero(phone) && phone.length() == 10))
                    throw new Exception("Begin with 0, 10 digits and no letter");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkInputDate(String msg) {
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
}
