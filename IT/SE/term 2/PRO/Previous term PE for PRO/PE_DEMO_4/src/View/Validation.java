package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public static String removeLabel(String rawData) {
        String[] temp = rawData.split("=");
        return temp[1];
    }

    public static String checkId(String id) {
        try {
            if (!id.matches("KH[0-9]{2}")) {
                throw new Exception("The CustomerID does not accept the format (fading KH and has 4 keys)");
            }
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    public static String checkDob(String dob) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date parsedDob = sdf.parse(dob);
            sdf.format(parsedDob);
            return dob;
        } catch (ParseException pe) {
            return null;
        }
    }

    public static String checkIntData(String intData) {
        try {
            int data = Integer.parseInt(intData);
            return intData;
        } catch (NumberFormatException nfe) {
            return null;
        }

    }

    public static String checkDoubleData(String doubleData) {
        try {
            double data = Double.parseDouble(doubleData);
            return doubleData;
        } catch (NumberFormatException nfe) {
            return null;
        }

    }

}
