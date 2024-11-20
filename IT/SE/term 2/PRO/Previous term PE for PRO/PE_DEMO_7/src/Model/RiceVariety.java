/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class RiceVariety {

    //attributes
    private String name;
    private String origin;
    private Date harvestDate;
    private double yield;
    private String diseaseResistance;
    private String climateSuitablility;
    private String grainType;
    private boolean isHybrid;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//constructor
    public RiceVariety(String name, String origin, String harvestDate, double yield, String diseaseResistance, String climateSuitablility, String grainType, boolean isHybrid) throws ParseException {
        this.name = name;
        this.origin = origin;
        this.harvestDate = setHarvestDate(harvestDate);
        this.yield = yield;
        this.diseaseResistance = diseaseResistance;
        this.climateSuitablility = climateSuitablility;
        this.grainType = grainType;
        this.isHybrid = isHybrid;
    }

    //getAge method
    public int getAge() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(new Date()));
        int d2 = Integer.parseInt(formatter.format(this.harvestDate));
        int age = (d1 - d2) / 10000;
        return age;
    }

    //isHightYield method
    public boolean isHighYield() {
        if (this.yield > 5) {
            return true;
        } else {
            return false;
        }
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHarvestDate() {
        return sdf.format(this.harvestDate);
    }

    public Date setHarvestDate(String harvestDate) throws ParseException {
        return sdf.parse(harvestDate);
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public String getDiseaseResistance() {
        return diseaseResistance;
    }

    public void setDiseaseResistance(String diseaseResistance) {
        this.diseaseResistance = diseaseResistance;
    }

    public String getClimateSuitablility() {
        return climateSuitablility;
    }

    public void setClimateSuitablility(String climateSuitablility) {
        this.climateSuitablility = climateSuitablility;
    }

    public String getGrainType() {
        return grainType;
    }

    public void setGrainType(String grainType) {
        this.grainType = grainType;
    }

    public boolean isIsHybrid() {
        return isHybrid;
    }

    public void setIsHybrid(boolean isHybrid) {
        this.isHybrid = isHybrid;
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10b",
                this.name,
                this.origin,
                sdf.format(this.harvestDate),
                this.yield,
                this.diseaseResistance,
                this.climateSuitablility,
                this.grainType,
                this.isHybrid
        );
    }

}
