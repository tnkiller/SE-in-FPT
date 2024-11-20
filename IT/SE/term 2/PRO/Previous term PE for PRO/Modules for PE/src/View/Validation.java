
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Validation {

    public static String removeLabel(String rawData) {
        String[] temp = rawData.split("=");
        return temp[1];
    }

    public static String checkIdData(String id) {
        try {
            if (!id.matches("KH[0-9]{2}")) {
                throw new Exception("Invalid format...");
            }
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    public static String checkDobData(String dob) {
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


    public static String checkIntData(String data) {
        try {
            int intData = Integer.parseInt(data);
            return data;
        } catch (NumberFormatException nfe) {
            return null;
        }
    }


    public static String checkDoubleData(String data) {
        try {
            double douData = Double.parseDouble(data);
            return data;
        } catch (NumberFormatException nfe) {
            return null;
        }
    }


}
