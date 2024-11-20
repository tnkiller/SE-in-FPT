package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public String checkIdFile(String id) {
        try {
            if (!id.matches("B[0-9][0-9][0-9]") || id.contains(" ")) throw new Exception();
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    public String checkIsElectricFile(String isElec) {
        try {
            if (!isElec.equalsIgnoreCase("true") && !isElec.equalsIgnoreCase("false")) {
                throw new Exception("Invalid. Please enter \" TRUE \" or \" FALSE \" ");
            }
            return isElec;
        } catch (Exception e) {
            return null;
        }
    }

    public String checkProcDateFile(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date parsedDate = sdf.parse(date);
            sdf.format(parsedDate);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }


}
