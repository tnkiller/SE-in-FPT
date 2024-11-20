/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import static View.Utils.getValue;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static String checkId(String id) {
        try {
            if (!id.matches("Emp[0-9]{3}")) {
                throw new Exception("Try again without space (Ex: Emp101)");
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
            Date tempDob = sdf.parse(dob);
            sdf.format(tempDob);
            return dob;
        } catch (Exception e) {
            return null;
        }
    }

}
