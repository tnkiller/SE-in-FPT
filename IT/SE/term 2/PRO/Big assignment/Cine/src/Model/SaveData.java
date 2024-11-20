/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.customer.ListCustomer;
import Model.employee.ListEmployee;
import Model.film.FilmList;
import Model.phongVe.ListLichChieu;
import Model.phongVe.ListPhongChieu;
import Model.ve.ListVe;
import Model.ve.Ve;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SaveData {

    private FilmList fl;
    private ListCustomer lc;
    private ListEmployee le;
    private ListVe lv;
    private ListLichChieu llc;
    private ListPhongChieu lpc;

    public SaveData() throws ParseException {
        this.fl = new FilmList();
        this.lc = new ListCustomer();
        this.le = new ListEmployee();
        this.lv = new ListVe();
        this.llc = new ListLichChieu();
        this.lpc = new ListPhongChieu();
    }

    public void saveData() {
        fl.saveData();
        lc.saveCustomerData();
        le.saveEmployeeData();
        lv.saveTicketData();
        llc.saveLichChieuData();
        lpc.savePhongChieuData();

    }

    

}
