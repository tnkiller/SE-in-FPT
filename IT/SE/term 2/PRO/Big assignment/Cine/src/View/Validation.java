package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    public static Scanner input = new Scanner(System.in);
    private final static String VALID_USERNAME = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    private final static String VALID_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\\\S+$).{5,}";

    public static String checkInputUsername(String msg) {
        System.out.println("Enter username:");
        while (true) {
            String result = checkInputString(msg);
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.err.println("You must enter least at 5 character alpha, and no space,digit must occur at least once,an upper case letter must occur at least once");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPassword(String msg) {
        System.out.println("Enter password:");
        while (true) {
            String result = checkInputString(msg);
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.err.println("You must enter least at 6 character alpha, and no space");
            System.out.print("Enter again: ");
        }
    }
    public static String checkInputloaighe(String msg) {
        System.out.println(msg);
        while (true) {
            String result = input.nextLine();
            if (result.equalsIgnoreCase("Couple")||result.equalsIgnoreCase("standard")||result.equalsIgnoreCase("vip")) {
                return result;
            }
            System.err.println("please choosen Couple or standard");
            System.out.print("Enter again: ");
        }
    }
    public static String checkInputString(String msg) {
        System.out.println(msg);
        while (true) {
            String result = input.nextLine();
            if (!result.isEmpty()) {
                return result;
            }
            System.err.println("String can't be empty");
            System.out.print("Enter again: ");
        }
    }

    public static int checkInputInt(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine());
                if (result > 0) {
                    return result;
                }
                System.err.println("Can't be a negative number");
                System.out.print("Enter again: ");
            } catch (NumberFormatException e) {
                System.err.println("Please input integer");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                double result = Double.parseDouble(input.nextLine());
                if (result > 0) {
                    return result;
                }
                System.err.println("Can't be a negative number");
                System.out.print("Enter again: ");
            } catch (NumberFormatException e) {
                System.err.println("Please input a double");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputGender(String msg) {
        System.out.println(msg);
        while (true) {
            String result = input.nextLine();
            if (result.equalsIgnoreCase("m")) {
                return "Male";
            }
            if (result.equalsIgnoreCase("f")) {
                return "Female";
            }
            if (result.equalsIgnoreCase("u")) {
                return "Unknown";
            }
            System.err.println("Please enter m/f/u");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputTF(String msg) {
        while (true) {
            String result = checkInputString(msg);
            if (result.equalsIgnoreCase("T")) {
                return true;
            }
            if (result.equalsIgnoreCase("F")) {
                return false;
            }
            System.err.println("Please enter t/T or f/F");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkInputYN(String msg) {
        System.out.println(msg);
        while (true) {
            String result = input.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputCode(String msg) {
        while (true) {
            String result = checkInputString(msg);
            if (result.length() == 4) {
                return result;
            }
            System.err.println("Tour's code must have 4 characters");
            System.out.print("Enter again: ");
        }
    }

    public static Date checkInputDate(String msg) {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        while (true) {
            String result = checkInputString(msg);
            try {
                date = formater.parse(result);
                return date;
            } catch (ParseException e) {
                System.err.println("Please input in format (dd/MM/yyyy)");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String validateUsernameFormat(String username) {
        // Define regular expressions for each format
        String adminPattern = "^ADM\\d{4}$";        // ADM followed by exactly 4 digits
        String employeePattern = "^EMP\\d{6}$";     // EMP followed by exactly 6 digits

        while (true) {
            if (Pattern.matches(adminPattern, username)) {
                return "Admin";
            } else if (Pattern.matches(employeePattern, username)) {
                return "Employee";
            } else {
                return "Invalid format";
            }

        }
    }

    public static Date changeStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateString);
    }

    public static String changeDateToString(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public static String formatEmail(String msg) {
        // Định dạng email chỉ chấp nhận đuôi @gmail.com
        final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        System.out.println(msg);

        while (true) {
            String email = input.nextLine().trim();
            if (email.matches(EMAIL_PATTERN)) {
                return email;
            } else {
                System.err.println("Invalid email format! Please enter a valid email with '@gmail.com' (e.g., example@gmail.com).");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String formatPhoneNumber(String msg) {
        // Định dạng số điện thoại: bắt đầu bằng 0 và tổng cộng 10 chữ số
        final String PHONE_PATTERN = "^(0)\\d{9}$";
        System.out.println(msg);

        while (true) {
            String phoneNumber = input.nextLine().trim();
            if (phoneNumber.matches(PHONE_PATTERN)) {
                return phoneNumber;
            } else {
                System.err.println("Invalid phone number format! Please enter a valid 10-digit phone number starting with 0.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String formatTicketCode(String msg) {
        // Định dạng mã vé: bắt đầu bằng S hoặc COUPLE, theo sau là 3 chữ số
        final String TICKET_PATTERN = "^(ST|CT)\\d{3}$";
        System.out.println(msg);

        while (true) {
            String ticketCode = input.nextLine().trim();
            if (ticketCode.matches(TICKET_PATTERN)) {
                return ticketCode;
            } else {
                System.err.println("Invalid numberOfTicket format! Please enter 'ST' or 'CT' followed by 3 digits (e.g., ST123 or CT456).");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String formatFilmId(String id) {
        // Kiểm tra xem ID có bắt đầu bằng "FILM" và theo sau là 3-5 chữ số không
        if (id.matches("F\\d{3,5}")) {
            return id;
        } else {
            System.err.println("Invalid Film ID format! Expected format: Fxxx (3-5 digits).");
            return null;
        }
    }

}
