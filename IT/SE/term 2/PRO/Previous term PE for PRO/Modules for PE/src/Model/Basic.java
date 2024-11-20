package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Basic {


    //attributes
    private String att_1;
    private String att_2;
    private Date att_3;
    private String att_4;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    //constructor


    //getter & setter


    //toString
    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-10s | %-10s | %-10s |",
                this.att_1,
                this.att_2,
                this.att_3,
                this.att_3,
                this.att_4
        );

    }
}
