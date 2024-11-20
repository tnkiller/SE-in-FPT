/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Validation {

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

}
