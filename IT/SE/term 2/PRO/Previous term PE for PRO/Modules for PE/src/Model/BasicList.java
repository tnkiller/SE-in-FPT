package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicList {

    //attributes





    //constructor


    //LOAD FILE
    public void loadFile(String fname) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {

                //code here

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
